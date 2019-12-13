package org.woehlke.simulation.evolution.model;


import org.woehlke.simulation.evolution.control.ObjectRegistry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The World contains Water, Cells and Food.
 * It is the Data Model of the Simulation in a MVC Pattern.
 *
 * @author Thomas Woehlke
 * User: thomas
 * Date: 04.02.2006
 * Time: 19:06:20
 * @see Cell
 * @see WorldMapFood
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 */
public class World {

  /**
   * List of the Simulated Bacteria Cells.
   */
  private List<Cell> cells;

  private final ObjectRegistry ctx;

  /**
   * TODO write doc.
   */
  public World(ObjectRegistry ctx) {
    this.ctx = ctx;
    cells = new ArrayList<>();
    createPopulation();
  }

  /**
   * Create the initial Population of Bacteria Cells and give them their position in the World.
   */
  private void createPopulation() {
    LifeCycleCount lifeCycleCount = new LifeCycleCount();
    for (int i = 0; i < ctx.getWorldConfig().getInitialPopulation(); i++) {
      int worldMapFoodX = ctx.getRandom().nextInt(ctx.getWorldConfig().getWidth());
      int worldMapFoodY = ctx.getRandom().nextInt(ctx.getWorldConfig().getHeight());
      worldMapFoodX *= Integer.signum(worldMapFoodX);
      worldMapFoodY *= Integer.signum(worldMapFoodY);
      Point position = new Point(worldMapFoodX, worldMapFoodY);
      Cell cell = new Cell(ctx.getWorldConfig().getWorldDimensions(), position, ctx.getRandom());
      cells.add(cell);
    }
    for (Cell cell : cells) {
      lifeCycleCount.countStatusOfOneCell(cell.getLifeCycleStatus());
    }
    System.out.println(lifeCycleCount);
    ctx.getStatistics().add(lifeCycleCount);
  }

  /**
   * One Step of Time in the World in which the Population of Bacteria Cell perform Life.
   * Every Cell moves, eats, dies of hunger, and it has sex. splitting into two children with changed DNA.
   */
  public void letLivePopulation() {
    LifeCycleCount lifeCycleCount = new LifeCycleCount();
    ctx.getWorldMapFood().letFoodGrow();
    Point pos;
    List<Cell> children = new ArrayList<>();
    List<Cell> died = new ArrayList<>();
    for (Cell cell : cells) {
      cell.move();
      if (cell.died()) {
        died.add(cell);
      } else {
        pos = cell.getPosition();
        int food = ctx.getWorldMapFood().eat(pos);
        cell.eat(food);
        if (cell.isPregnant()) {
          Cell child = cell.performReproductionByCellDivision();
          children.add(child);
        }
      }
    }
    for (Cell dead : died) {
      cells.remove(dead);
    }
    cells.addAll(children);
    for (Cell cell : cells) {
      lifeCycleCount.countStatusOfOneCell(cell.getLifeCycleStatus());
    }
    ctx.getStatistics().add(lifeCycleCount);
  }

  public List<Cell> getAllCells() {
    return cells;
  }

  public boolean hasFood(int x, int y) {
    return ctx.getWorldMapFood().hasFood(x, y);
  }

}
