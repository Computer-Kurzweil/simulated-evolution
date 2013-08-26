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
    private final boolean EABLE_GARDEN_OF_EDEN = true;
    private Point dimensions;

    public WorldMapFood(Point dimensions,Random random){
        this.dimensions=dimensions;
        worldMapFood = new int[this.dimensions.getX()][this.dimensions.getY()];
        this.random=random;
    }

    private int f;
    private int x;
    private int y;
    private int startx;
    private int starty;

    public void letFoodGrow() {
        f = 0;
        while (f < FOOD_PER_DAY) {
            f++;
            x = random.nextInt(this.dimensions.getX());
            y = random.nextInt(this.dimensions.getY());
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
            startx = this.dimensions.getX() / 5;
            starty = this.dimensions.getY() / 5;
            while (f < FOOD_PER_DAY*4) {
                f++;
                x = random.nextInt(startx);
                y = random.nextInt(starty);
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

    int food=0;
    private Point[] neighbourhood;

    public int eat(Point position) {
        neighbourhood = position.getNeighbourhood(this.dimensions);
        food=0;
        for (Point neighbourhoodPosition:neighbourhood){
            food += worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()];
            worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()]=0;
        }
        return food;
    }
}
