package org.woehlke.simulation.evolution.model;

import org.woehlke.simulation.evolution.config.WorldMapFoodConf;

import java.io.Serializable;
import java.util.Random;

/**
 * Map of World where every Place can have food needed by the Bacteria Cells for eating.
 *
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * &copy; 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 24.08.13
 * Time: 12:37
 */
public class WorldMapFood implements Serializable, WorldMapFoodConf {

    private static final long serialVersionUID = 7206903832639173306L;

    /**
     * Grid of World where every Place can have food.
     */
    private int[][] worldMapFood;

    /**
     * Random Generator used for placing food, coming from another Object.
     */
    private Random random;

    /**
     * Dimension for the Grid inside the WorldMapFood which is the Same as in World Data Model and in the View.
     */
    private final Point worldDimensions;

    public WorldMapFood(Point worldDimensions, Random random){
        this.worldDimensions = worldDimensions;
        worldMapFood = new int[this.worldDimensions.getX()][this.worldDimensions.getY()];
        this.random=random;
    }

    /**
     * Delivers new food to random positions.
     */
    public void letFoodGrow() {
        int f = 0;
        while (f < FOOD_PER_DAY) {
            f++;
            int x = random.nextInt(this.worldDimensions.getX());
            int y = random.nextInt(this.worldDimensions.getY());
            if (x < 0) {
                x *= -1;
            }
            if (y < 0) {
                y *= -1;
            }
            worldMapFood[x][y]++;
        }
        if(EABLE_GARDEN_OF_EDEN){
            f = 0;
            int startx = this.worldDimensions.getX() / 5;
            int starty = this.worldDimensions.getY() / 5;
            while (f < FOOD_PER_DAY*4) {
                f++;
                int x = random.nextInt(startx);
                int y = random.nextInt(starty);
                if (x < 0) {
                    x *= -1;
                }
                if (y < 0) {
                    y *= -1;
                }
                worldMapFood[x+startx*2][y+starty*2]++;
            }
        }
    }

  /**
   * TODO write doc.
   */
    public boolean hasFood(int x, int y) {
        return worldMapFood[x][y] > 0;
    }

    /**
     * Reduces Food in the Grid by eating and delivers the food energy to the eating Cell.
     *
     * @see LifeCycle
     *
     * @param position where is the food and the eating cell
     * @return the engergy of the food, will be added to cell's fat.
     */
    public int eat(Point position) {
        Point[] neighbourhood = position.getNeighbourhood(this.worldDimensions);
        int food=0;
        for (Point neighbourhoodPosition:neighbourhood){
            food += worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()];
            worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()]=0;
        }
        return food;
    }
}
