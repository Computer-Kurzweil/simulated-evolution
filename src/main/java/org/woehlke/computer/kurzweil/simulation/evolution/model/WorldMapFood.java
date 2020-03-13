package org.woehlke.computer.kurzweil.simulation.evolution.model;

import java.util.Random;

/**
 * Map of World where every Place can have food needed by the Bacteria Cells for eating.
 *
 * &copy; 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 24.08.13
 * Time: 12:37
 */
public class WorldMapFood {

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
     * As a Result of Evolution you will find sucessful Bacteria Cells with a different DNA and Motion as outside the Garden of Eden.
     */
    private final boolean EABLE_GARDEN_OF_EDEN = true;

    /**
     * Random Generator used for placing food, coming from another Object.
     */
    private Random random;

    /**
     * Dimension for the Grid inside the WorldMapFood which is the Same as in World Data Model and in the View.
     */
    private Point dimensions;

    public WorldMapFood(Point dimensions,Random random){
        this.dimensions=dimensions;
        worldMapFood = new int[this.dimensions.getX()][this.dimensions.getY()];
        this.random=random;
    }

    /**
     * Delivers new food to random positions.
     */
    public void letFoodGrow() {
        int f = 0;
        while (f < FOOD_PER_DAY) {
            f++;
            int x = random.nextInt(this.dimensions.getX());
            int y = random.nextInt(this.dimensions.getY());
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
            int startx = this.dimensions.getX() / 5;
            int starty = this.dimensions.getY() / 5;
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
        Point neighbourhood[] = position.getNeighbourhood(this.dimensions);
        int food=0;
        for (Point neighbourhoodPosition:neighbourhood){
            food += worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()];
            worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()]=0;
        }
        return food;
    }
}
