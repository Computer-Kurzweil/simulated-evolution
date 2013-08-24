package org.woehlke.simulation.evolution.model;

import java.util.Random;

/**
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * User: thomas
 * Date: 24.08.13
 * Time: 12:37
 */
public class WorldMapFood {

    private int worldMapFood[][];
    private Random random;
    private final int FOOD_PER_DAY = 10;
    private Point dimensions;

    public WorldMapFood(Point dimensions,Random random){
        this.dimensions=dimensions;
        worldMapFood = new int[this.dimensions.getX()][this.dimensions.getY()];
        this.random=random;
    }

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
    }

    public boolean hasFood(int x, int y) {
        return worldMapFood[x][y] > 0;
    }

    public int eat(Point pos) {
        Point neighbourhood[] = pos.getNeighbourhood(this.dimensions);
        int food=0;
        for (Point position:neighbourhood){
            food += worldMapFood[position.getX()][position.getY()];
            worldMapFood[position.getX()][position.getY()]=0;
        }
        return food;
    }
}
