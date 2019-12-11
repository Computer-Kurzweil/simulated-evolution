package org.woehlke.simulation.evolution.model;

import org.woehlke.simulation.evolution.SimulatedEvolutionConfig;
import org.woehlke.simulation.evolution.config.WorldMapFoodConfigDefault;

import java.io.Serializable;
import java.util.Random;

/**
 * Map of World where every Place can have food needed by the Bacteria Cells for eating.
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * &copy; 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 *
 * @author Thomas Woehlke
 * Date: 24.08.13
 * Time: 12:37
 */
public class WorldMapFood implements WorldMapFoodConfigDefault {

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

  private final SimulatedEvolutionConfig config;

  public WorldMapFood(SimulatedEvolutionConfig simulatedEvolutionConfig, Random random) {
    this.config = simulatedEvolutionConfig;
    this.worldDimensions = simulatedEvolutionConfig.getWorldConfig().getWorldDimensions();
    worldMapFood = new int[this.worldDimensions.getX()][this.worldDimensions.getY()];
    this.random = random;
  }

  /**
   * Delivers new food to random positions.
   */
  public void letFoodGrow() {
    int food = 0;
    while (food < this.config.getWorldMapFoodConfig().getFoodPerDay()) {
      food++;
      int posX = random.nextInt(this.worldDimensions.getX());
      int posY = random.nextInt(this.worldDimensions.getY());
      posX *= Integer.signum(posX);
      posY *= Integer.signum(posY);
      worldMapFood[posX][posY]++;
    }
    if (this.config.getWorldMapFoodConfig().isEableGardenOfEden()) {
      food = 0;
      int startX = this.worldDimensions.getX() / 5;
      int startY = this.worldDimensions.getY() / 5;
      while (food < FOOD_PER_DAY * 4) {
        food++;
        int posX = random.nextInt(startX);
        int posY = random.nextInt(startY);
        posX *= Integer.signum(posX);
        posY *= Integer.signum(posY);
        worldMapFood[posX + startX * 2][posY + startY * 2]++;
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
   * @param position where is the food and the eating cell
   * @return the engergy of the food, will be added to cell's fat.
   * @see LifeCycle
   */
  public int eat(Point position) {
    Point[] neighbourhood = position.getNeighbourhood(this.worldDimensions);
    int food = 0;
    for (Point neighbourhoodPosition : neighbourhood) {
      food += worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()];
      worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()] = 0;
    }
    return food;
  }

  public void toggleGardenOfEden() {
    if (!this.config.getWorldMapFoodConfig().isEableGardenOfEden()) {
      int startx = this.worldDimensions.getX() / 5;
      int starty = this.worldDimensions.getY() / 5;
      for (int posX = 0; posX < startx; posX++) {
        for (int posY = 0; posY < starty; posY++) {
          worldMapFood[posX + startx * 2][posY + starty * 2] = 0;
        }
      }
    }
  }
}
