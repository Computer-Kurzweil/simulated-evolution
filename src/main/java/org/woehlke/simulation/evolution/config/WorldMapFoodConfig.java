package org.woehlke.simulation.evolution.config;

/**
 * TODO write doc.
 */
public class WorldMapFoodConfig implements WorldMapFoodConfigDefault {

  /**
   * TODO write doc.
   */
  private final int initialPopulation;

  public WorldMapFoodConfig(){
    this.initialPopulation = INITIAL_POPULATION;
  }

  public int getInitialPopulation() {
    return initialPopulation;
  }
}
