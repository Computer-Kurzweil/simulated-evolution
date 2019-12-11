package org.woehlke.simulation.evolution.model;


import org.woehlke.simulation.evolution.SimulatedEvolutionConfig;
import org.woehlke.simulation.evolution.statistics.LifeCycleCount;
import org.woehlke.simulation.evolution.statistics.LifeCycleCountContainer;

import java.io.Serializable;
import java.util.*;
import java.util.List;

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
public class World implements Serializable {

  private static final long serialVersionUID = -3323914357940044359L;

  /**
   * List of the Simulated Bacteria Cells.
   */
  private List<Cell> cells;

  /**
   * Random Generator used for Bacteria Motion.
   */
  private Random random;

  /**
   * Map of the World monitoring growth and eating food.
   */
  private final WorldMapFood worldMapFood;

  /**
   * TODO write doc.
   */
  private final LifeCycleCountContainer count;

  /**
   * TODO write doc.
   */
  private SimulatedEvolutionConfig simulatedEvolutionConfig;

  /**
   * TODO write doc.
   */
  public World(SimulatedEvolutionConfig simulatedEvolutionConfig) {
    this.simulatedEvolutionConfig = simulatedEvolutionConfig;
    long seed = new Date().getTime();
    random = new Random(seed);
    worldMapFood = new WorldMapFood(simulatedEvolutionConfig, random);
    cells = new ArrayList<>();
    count = new LifeCycleCountContainer(simulatedEvolutionConfig);
    createPopulation();
  }

  /**
   * Create the initial Population of Bacteria Cells and give them their position in the World.
   */
  private void createPopulation() {
    LifeCycleCount lifeCycleCount = new LifeCycleCount();
    for (int i = 0; i < simulatedEvolutionConfig.getWorldConfig().getInitialPopulation(); i++) {
      int worldMapFoodX = random.nextInt(simulatedEvolutionConfig.getWorldConfig().getWidth());
      int worldMapFoodY = random.nextInt(simulatedEvolutionConfig.getWorldConfig().getHeight());
      worldMapFoodX *= Integer.signum(worldMapFoodX);
      worldMapFoodY *= Integer.signum(worldMapFoodY);
      Point position = new Point(worldMapFoodX, worldMapFoodY);
      Cell cell = new Cell(simulatedEvolutionConfig.getWorldConfig().getWorldDimensions(), position, random);
      cells.add(cell);
    }
    for (Cell cell : cells) {
      lifeCycleCount.countStatusOfOneCell(cell.getLifeCycleStatus());
    }
    System.out.println(lifeCycleCount);
    count.add(lifeCycleCount);
  }

  /**
   * One Step of Time in the World in which the Population of Bacteria Cell perform Life:
   * Every Cell moves, eats, dies of hunger, and it has sex: splitting into two children with changed DNA.
   */
  public void letLivePopulation() {
    LifeCycleCount lifeCycleCount = new LifeCycleCount();
    worldMapFood.letFoodGrow();
    Point pos;
    List<Cell> children = new ArrayList<>();
    List<Cell> died = new ArrayList<>();
    for (Cell cell : cells) {
      cell.move();
      if (cell.died()) {
        died.add(cell);
      } else {
        pos = cell.getPosition();
        int food = worldMapFood.eat(pos);
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
    count.add(lifeCycleCount);
  }

  public List<Cell> getAllCells() {
    return cells;
  }

  public boolean hasFood(int x, int y) {
    return worldMapFood.hasFood(x, y);
  }

  public SimulatedEvolutionConfig getSimulatedEvolutionConfig() {
    return simulatedEvolutionConfig;
  }

  public Point getWorldDimensions() {
    return this.simulatedEvolutionConfig.getWorldConfig().getWorldDimensions();
  }

  public WorldMapFood getWorldMapFood() {
    return worldMapFood;
  }

  public LifeCycleCountContainer getCount() {
    return count;
  }
}
