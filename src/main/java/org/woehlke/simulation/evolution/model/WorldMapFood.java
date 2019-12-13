package org.woehlke.simulation.evolution.model;

import org.woehlke.simulation.evolution.config.WorldMapFoodConfigDefault;
import org.woehlke.simulation.evolution.control.ObjectRegistry;


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

  /**
   * Grid of World where every Place can have food.
   */
  private int[][] worldMapFood;

  private final ObjectRegistry ctx;

  public WorldMapFood(ObjectRegistry ctx) {
    this.ctx = ctx;
    worldMapFood = new int[ctx.getWorldConfig().getWorldDimensions().getX()]
      [ctx.getWorldConfig().getWorldDimensions().getY()];
  }

  /**
   * Delivers new food to random positions.
   */
  public void letFoodGrow() {
    int food = 0;
    while (food < ctx.getWorldMapFoodConfig().getFoodPerDay()) {
      food++;
      int posX = ctx.getRandom().nextInt(ctx.getWorldConfig().getWorldDimensions().getX());
      int posY = ctx.getRandom().nextInt(ctx.getWorldConfig().getWorldDimensions().getY());
      posX *= Integer.signum(posX);
      posY *= Integer.signum(posY);
      worldMapFood[posX][posY]++;
    }
    if (ctx.getWorldMapFoodConfig().isEableGardenOfEden()) {
      food = 0;
      int startX = ctx.getWorldConfig().getWorldDimensions().getX() / 5;
      int startY = ctx.getWorldConfig().getWorldDimensions().getY() / 5;
      while (food < FOOD_PER_DAY * 4) {
        food++;
        int posX = ctx.getRandom().nextInt(startX);
        int posY = ctx.getRandom().nextInt(startY);
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
    Point[] neighbourhood = position.getNeighbourhood(ctx.getWorldConfig().getWorldDimensions());
    int food = 0;
    for (Point neighbourhoodPosition : neighbourhood) {
      food += worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()];
      worldMapFood[neighbourhoodPosition.getX()][neighbourhoodPosition.getY()] = 0;
    }
    return food;
  }

  public void toggleGardenOfEden() {
    if (!ctx.getWorldMapFoodConfig().isEableGardenOfEden()) {
      int startx = ctx.getWorldConfig().getWorldDimensions().getX() / 5;
      int starty = ctx.getWorldConfig().getWorldDimensions().getY() / 5;
      for (int posX = 0; posX < startx; posX++) {
        for (int posY = 0; posY < starty; posY++) {
          worldMapFood[posX + startx * 2][posY + starty * 2] = 0;
        }
      }
    }
  }
}
