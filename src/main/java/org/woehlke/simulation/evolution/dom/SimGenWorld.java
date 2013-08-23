package org.woehlke.simulation.evolution.dom;

import org.woehlke.simulation.evolution.beans.SimGenPoint;

import java.util.*;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * User: thomas
 * Date: 04.02.2006
 * Time: 19:06:20
 */
public class SimGenWorld implements ISimGenWorld {
    private ArrayList<ISimGenCell> cells;
    private int initialPopulation = 20;
    private long seed;
    private Random random;
    private int X = 320;
    private int Y = 234;
    private int foodPerDay = 1;
    private int worldMapFood[][];
    private ArrayList<SimGenPoint> positions;
    SimGenPoint max;

    public SimGenWorld() {
        worldMapFood = new int[X][Y];
        max = new SimGenPoint(X, Y);
        createPopulation();
    }

    public SimGenWorld(int x, int y) {
        X = x;
        Y = y;
        worldMapFood = new int[X][Y];
        max = new SimGenPoint(X, Y);
        createPopulation();
    }

    private void createPopulation() {
        positions = new ArrayList<SimGenPoint>();
        cells = new ArrayList<ISimGenCell>();
        seed = new Date().getTime();
        random = new Random(seed);
        for (int i = 0; i < initialPopulation; i++) {
            int x = random.nextInt(X);
            int y = random.nextInt(Y);
            if (x < 0) {
                x *= -1;
            }
            if (y < 0) {
                y *= -1;
            }
            SimGenPoint pos = new SimGenPoint(x, y);
            ISimGenCell cell = new SimGenCell(max, pos, random);
            cells.add(cell);
        }
    }

    public void letFoodGrow() {
        int f = 0;
        while (f < foodPerDay) {
            f++;
            int x = random.nextInt(X);
            int y = random.nextInt(Y);
            if (x < 0) {
                x *= -1;
            }
            if (y < 0) {
                y *= -1;
            }
            worldMapFood[x][y]++;
        }
    }

    public void letLivePopulation() {
        letFoodGrow();
        SimGenPoint pos;
        ArrayList<ISimGenCell> children = new ArrayList<ISimGenCell>();
        Iterator<ISimGenCell> i = cells.iterator();
        while (i.hasNext()) {
            ISimGenCell cell = i.next();
            cell.move();
            pos = cell.getPos();
            int x = pos.getX();
            int y = pos.getY();
            if (hasFood(x, y)) {
                cell.eat();
                worldMapFood[x][y]--;
            }
            if (cell.isPregnant()) {
                ISimGenCell child = cell.cellDivisionFactory();
                children.add(child);
            }
        }
        cells.addAll(children);
        positions = new ArrayList<SimGenPoint>();
        i = cells.iterator();
        while (i.hasNext()) {
            ISimGenCell cell = i.next();
            SimGenPoint p = cell.getPos();
            positions.add(p);
        }
    }

    public ArrayList<SimGenPoint> getPositionsOfAllCells() {
        return positions;
    }

    public boolean hasFood(int x, int y) {
        return worldMapFood[x][y] > 0;
    }

    public int getWidth() {
        return X;
    }

    public void setWidth(int x) {
        X = x;
    }

    public int getHeight() {
        return Y;
    }

    public void setHeight(int y) {
        Y = y;
    }

    public int getFoodPerDay() {
        return foodPerDay;
    }

    public void setFoodPerDay(int foodPerDay) {
        this.foodPerDay = foodPerDay;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getInitialPopulation() {
        return initialPopulation;
    }

    public void setInitialPopulation(int initialPopulation) {
        this.initialPopulation = initialPopulation;
    }

}
