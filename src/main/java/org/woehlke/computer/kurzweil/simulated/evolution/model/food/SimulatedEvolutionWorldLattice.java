package org.woehlke.computer.kurzweil.simulated.evolution.model.food;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycle;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticePoint;

import java.lang.Math;
import java.io.Serializable;
import java.util.Random;

/**
 * Map of World where every Place can have food needed by the Bacteria Cells for eating.
 *
 * &copy; 2006 - 2013 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 24.08.13
 * Time: 12:37
 */
@Log4j2
@ToString(exclude = {"random"})
@EqualsAndHashCode(exclude = {"random"})
public class SimulatedEvolutionWorldLattice implements Serializable {

    private static final long serialVersionUID = 242L;

    /**
     * Grid of World where every Place can have food.
     */
    private int worldMapFood[][];

    /**
     * How much food per Time Step (a day) shall be placed in this World.
     */
    private final int FOOD_PER_DAY = 10;

    /**
     * A Garden of Eden is an Area where much more Food grows within the same time.
     * As a Result of Evolution you will find sucessful Bacteria Cells
     * with a different DNA and Motion as outside the Garden of Eden.
     */
    private final boolean EABLE_GARDEN_OF_EDEN = true;

    /**
     * Random Generator used for placing food, coming from another Object.
     */
    private Random random;

    /**
     * Dimension for the Grid inside the WorldMapFood which is the Same as in World Data Model and in the View.
     */
    private LatticePoint dimensions;

    public SimulatedEvolutionWorldLattice(LatticePoint dimensions, Random random){
        this.dimensions=dimensions;
        worldMapFood = new int[this.dimensions.getX()][this.dimensions.getY()];
        this.random=random;
    }

    private void generateFood(int foodLimit, int startX, int startY, int limitX, int limitY) {
        int food = 0;
        while (food < foodLimit) {
            food++;
            int x = Math.abs(random.nextInt(limitX));
            int y = Math.abs(random.nextInt(limitY));
        
            worldMapFood[startX*2+x][startY*2+y]++;
        }
    }

    /**
     * Delivers new food to random positions.
     */
    public void letFoodGrow() {
        int limitX = this.dimensions.getX();
        int limitY = this.dimensions.getY();
        generateFood(FOOD_PER_DAY, 0, 0, limitX, limitY);
        if (EABLE_GARDEN_OF_EDEN) {
            generateFood(FOOD_PER_DAY*4, limitX / 5, limitY / 5, limitX / 5, limitY / 5);
        }
    }

    public boolean hasFood(int x, int y) {
        return worldMapFood[x][y] > 0;
    }

    /**
     * Reduces Food in the Grid by eating and delivers the food energy to the eating Cell.
     *
     * @see LifeCycle
     * @see LatticePoint
     *
     * @param position where is the food and the eating cell
     * @return the engergy of the food, will be added to cell's fat.
     */
    public int eat(LatticePoint position) {
        LatticePoint neighbourhood[] = position.getNeighbourhood(this.dimensions);
        int food=0;
        for (LatticePoint neighbourhoodPosition:neighbourhood){
            food += worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()];
            worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()]=0;
        }
        return food;
    }
}
