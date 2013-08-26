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
        random = new Random(new Date().getTime());
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
            Point position = new Point(x, y);
            Cell cell = new Cell(worldDimensions, position, random);
            cells.add(cell);
        }
    }

    private Point position;

    public void letLivePopulation() {
        worldMapFood.letFoodGrow();
        List<Cell> children = new ArrayList<Cell>();
        List<Cell> died = new ArrayList<Cell>();
        for (Cell cell:cells) {
            cell.move();
            if(cell.died()){
                died.add(cell);
            } else {
                position = cell.getPosition();
                int food = worldMapFood.eat(position);
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
        died.clear();
        children.clear();
    }

    public List<Cell> getAllCells(){
        return cells;
    }

    public boolean hasFood(int x, int y) {
        return worldMapFood.hasFood(x,y);
    }
}
