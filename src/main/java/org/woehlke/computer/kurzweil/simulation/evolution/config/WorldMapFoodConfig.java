package org.woehlke.computer.kurzweil.simulation.evolution.config;

/**
 * TODO write doc.
 */
public class WorldMapFoodConfig implements WorldMapFoodConfigDefault {

  /**
   * How much food per Time Step (a day) shall be placed in this World.
   */
  private volatile int foodPerDay;

  /**
   * A Garden of Eden is an Area where much more Food grows within the same time.
   * As a Result of Evolution you will find sucessful Bacteria Cells with a different DNA and Motion as outside the Garden of Eden.
   */
  private volatile boolean eableGardenOfEden;

  public WorldMapFoodConfig() {
    this.foodPerDay = FOOD_PER_DAY;
    this.eableGardenOfEden = EABLE_GARDEN_OF_EDEN;
  }

  public int getFoodPerDay() {
    return foodPerDay;
  }

  public void setFoodPerDay(int foodPerDay) {
    this.foodPerDay = foodPerDay;
  }

  public boolean isEableGardenOfEden() {
    return eableGardenOfEden;
  }

  public void setEableGardenOfEden(boolean eableGardenOfEden) {
    this.eableGardenOfEden = eableGardenOfEden;
  }

  public synchronized void increaseFoodPerDay() {
    this.foodPerDay++;
  }

  public synchronized void decreaseFoodPerDay() {
    this.foodPerDay--;
  }

  public synchronized void resetFoodPerDay() {
    this.foodPerDay = FOOD_PER_DAY;
  }

  public synchronized void toggleGardenOfEden() {
    this.eableGardenOfEden = !this.eableGardenOfEden;
  }

}
