package org.woehlke.computer.kurzweil.simulated.evolution.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.Cell;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.CellOriginal;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensusContainer;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.simulated.evolution.application.SimulatedEvolutionParameter;
import org.woehlke.computer.kurzweil.simulated.evolution.model.food.SimulatedEvolutionWorldLattice;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The World contains Water, Cells and Food.
 * It is the Data Model of the Simulation in a MVC Pattern.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see Cell
 * @see SimulatedEvolutionWorldLattice
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * User: thomas
 * Date: 04.02.2006
 * Time: 19:06:20
 */
@Log4j2
@ToString(exclude = {"random"})
@EqualsAndHashCode(exclude = {"random"})
public class SimulatedEvolutionModel implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Start with 20 Cells.
     */
    private final int initialPopulation;

    /**
     * Definition of the World's Size in Pixel Width and Height.
     */
    @Getter
    private final LatticePoint worldDimensions;

    /**
     * Map of the World monitoring growth and eating food.
     */
    private final SimulatedEvolutionWorldLattice worldLattice;

    @Getter
    private final SimulatedEvolutionPopulationCensusContainer censusContainer;

    @Getter
    private final SimulatedEvolutionParameter parameter;

    @Getter
    private final ComputerKurzweilProperties properties;

    /**
     * List of the Simulated Bacteria Cells.
     */
    private List<Cell> cells;

    /**
     * Random Generator used for Bacteria Motion.
     */
    private Random random;

    public SimulatedEvolutionModel(ComputerKurzweilProperties properties) {
        this.properties = properties;
        this.initialPopulation =  this.properties.getSimulatedevolution().getPopulation().getInitialPopulation();
        int scale = this.properties.getSimulatedevolution().getView().getScale();
        int width = scale * this.properties.getSimulatedevolution().getView().getWidth();
        int height = scale * this.properties.getSimulatedevolution().getView().getHeight();
        this.worldDimensions = new LatticePoint(width,height);
        long seed = new Date().getTime();
        this.random = new Random(seed);
        this.worldLattice = new SimulatedEvolutionWorldLattice(
            this.worldDimensions, this.random
        );
        this.censusContainer = new SimulatedEvolutionPopulationCensusContainer(
            properties
        );
        this.parameter = new SimulatedEvolutionParameter();
        this.createPopulation();
    }

    /**
     * Create the initial Population of Bacteria Cells and give them their position in the World.
     */
    private void createPopulation() {
        SimulatedEvolutionPopulationCensus populationCensus = new SimulatedEvolutionPopulationCensus(
            this.censusContainer.getWorldIteration()
        );
        cells = new ArrayList<Cell>();
        for (int i = 0; i < initialPopulation; i++) {
            int x = Math.abs(random.nextInt(worldDimensions.getX()));
            int y = Math.abs(random.nextInt(worldDimensions.getY()));

            LatticePoint pos = new LatticePoint(x, y);
            Cell cell = new CellOriginal(worldDimensions, pos, random);
            cells.add(cell);
            populationCensus.countStatusOfOneCell(cell.getLifeCycleStatus(), cell.getGeneration());
        }
        this.censusContainer.push(populationCensus);
    }

    /**
     * One Step of Time in the World in which the Population of Bacteria Cell perform Life:
     * Every Cell moves, eats, dies of hunger, and it has sex: splitting into two children with changed DNA.
     */
    public boolean letLivePopulation() {
        SimulatedEvolutionPopulationCensus census = new SimulatedEvolutionPopulationCensus(
            this.censusContainer.getWorldIteration()
        );
        worldLattice.letFoodGrow();
        LatticePoint pos;
        List<Cell> children = new ArrayList<Cell>();
        List<Cell> died = new ArrayList<Cell>();
        for (Cell cell:cells) {
            cell.move();
            if(cell.died()){
                died.add(cell);
            } else {
                pos = cell.getPosition();
                int food = worldLattice.eat(pos);
                cell.eat(food);
                if (cell.isPregnant()) {
                    Cell child = cell.performReproductionByCellDivision();
                    children.add(child);
                }
            }
        }
        return populationCensus(census, children, died);
    }

    private boolean populationCensus(SimulatedEvolutionPopulationCensus census, List<Cell> children, List<Cell> died) {
        for(Cell dead: died){
            cells.remove(dead);
        }
        cells.addAll(children);
        for (Cell cell:cells) {
            census.countStatusOfOneCell(cell.getLifeCycleStatus(), cell.getGeneration());
        }
        this.censusContainer.push(census);
        return !cells.isEmpty();
    }

    public List<Cell> getAllCells(){
        return cells;
    }

    public boolean hasFood(int x, int y) {
        return worldLattice.hasFood(x,y);
    }

    public boolean isPopulationAlive() {
        return !cells.isEmpty();
    }
}
