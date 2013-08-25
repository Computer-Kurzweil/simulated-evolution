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
    private int INITIAL_POPULATION = 20;
    private Random random;
    private Point worldDimensions;
    private WorldMapFood worldMapFood;

    public World(Point worldDimensions) {
        long seed = new Date().getTime();
        random = new Random(seed);
        this.worldDimensions = worldDimensions;
        worldMapFood = new WorldMapFood(this.worldDimensions,random);
        createPopulation();
    }

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
            Point pos = new Point(x, y);
            Cell cell = new Cell(worldDimensions, pos, random);
            cells.add(cell);
        }
    }

    public void letLivePopulation() {
        worldMapFood.letFoodGrow();
        Point pos;
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
                    Cell child = cell.cellDivisionFactory();
                    children.add(child);
                }
            }
        }
        for(Cell dead:died){
            cells.remove(dead);
        }
        cells.addAll(children);

    }

    public List<Point> getPositionsOfAllCells(){
        List<Point> positions = new ArrayList<Point>();
        for (Cell cell:cells) {
            Point p = cell.getPosition();
            positions.add(p);
        }
        return positions;
    }

    public boolean hasFood(int x, int y) {
        return worldMapFood.hasFood(x,y);
    }
}
