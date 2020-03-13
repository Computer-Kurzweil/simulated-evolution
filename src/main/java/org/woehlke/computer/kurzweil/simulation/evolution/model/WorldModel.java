package org.woehlke.computer.kurzweil.simulation.evolution.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The World contains Water, Cells and Food.
 * It is the Data Model of the Simulation in a MVC Pattern.
 *
 * @see Cell
 * @see WorldMapFood
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * User: thomas
 * Date: 04.02.2006
 * Time: 19:06:20
 */
public class WorldModel implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * List of the Simulated Bacteria Cells.
     */
    private List<Cell> cells;

    /**
     * Start with 20 Cells.
     */
    private final int INITIAL_POPULATION = 20;

    /**
     * Random Generator used for Bacteria Motion.
     */
    private Random random;

    /**
     * Definition of the World's Size in Pixel Width and Height.
     */
    private WorldPoint worldDimensions;

    /**
     * Map of the World monitoring growth and eating food.
     */
    private WorldMapFood worldMapFood;

    public WorldModel(WorldPoint worldDimensions) {
        long seed = new Date().getTime();
        random = new Random(seed);
        this.worldDimensions = worldDimensions;
        worldMapFood = new WorldMapFood(this.worldDimensions,random);
        createPopulation();
    }

    /**
     * Create the initial Population of Bacteria Cells and give them their position in the World.
     */
    private void createPopulation() {
        cells = new ArrayList<Cell>();
        for (int i = 0; i < INITIAL_POPULATION; i++) {
            int x = random.nextInt(worldDimensions.getX());
            int y = random.nextInt(worldDimensions.getY());
            if (x < 0) {
                x *= -1;
            }
            if (y < 0) {
                y *= -1;
            }
            WorldPoint pos = new WorldPoint(x, y);
            Cell cell = new Cell(worldDimensions, pos, random);
            cells.add(cell);
        }
    }

    /**
     * One Step of Time in the World in which the Population of Bacteria Cell perform Life:
     * Every Cell moves, eats, dies of hunger, and it has sex: splitting into two children with changed DNA.
     */
    public void letLivePopulation() {
        worldMapFood.letFoodGrow();
        WorldPoint pos;
        List<Cell> children = new ArrayList<Cell>();
        List<Cell> died = new ArrayList<Cell>();
        for (Cell cell:cells) {
            cell.move();
            if(cell.died()){
                died.add(cell);
            } else {
                pos = cell.getPosition();
                int food = worldMapFood.eat(pos);
                cell.eat(food);
                if (cell.isPregnant()) {
                    Cell child = cell.performReproductionByCellDivision();
                    children.add(child);
                }
            }
        }
        for(Cell dead:died){
            cells.remove(dead);
        }
        cells.addAll(children);
    }

    public List<Cell> getAllCells(){
        return cells;
    }

    public boolean hasFood(int x, int y) {
        return worldMapFood.hasFood(x,y);
    }
}
