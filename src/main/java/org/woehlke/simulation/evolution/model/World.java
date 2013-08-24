package org.woehlke.simulation.evolution.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * (C) 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * User: thomas
 * Date: 04.02.2006
 * Time: 19:06:20
 */
public class World {
    private List<Cell> cells;
    private int initialPopulation = 20;
    private long seed;
    private Random random;
    private int X = 320;
    private int Y = 234;
    private int foodPerDay = 1;
    private int worldMapFood[][];
    private List<Point> positions;
    private Point max;

    public World() {
        worldMapFood = new int[X][Y];
        max = new Point(X, Y);
        createPopulation();
    }

    public World(int x, int y) {
        X = x;
        Y = y;
        worldMapFood = new int[X][Y];
        max = new Point(X, Y);
        createPopulation();
    }

    private void createPopulation() {
        positions = new ArrayList<Point>();
        cells = new ArrayList<Cell>();
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
            Point pos = new Point(x, y);
            Cell cell = new Cell(max, pos, random);
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
        Point pos;
        List<Cell> children = new ArrayList<Cell>();
        for (Cell cell:cells) {
            cell.move();
            pos = cell.getPosition();
            int x = pos.getX();
            int y = pos.getY();
            if (hasFood(x, y)) {
                cell.eat();
                worldMapFood[x][y]--;
            }
            if (cell.isPregnant()) {
                Cell child = cell.cellDivisionFactory();
                children.add(child);
            }
        }
        cells.addAll(children);
        positions = new ArrayList<Point>();
        for (Cell cell:cells) {
            Point p = cell.getPosition();
            positions.add(p);
        }
    }

    public List<Point> getPositionsOfAllCells() {
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
