package org.woehlke.simulation.evolution;


import org.woehlke.simulation.evolution.config.GuiConfig;
import org.woehlke.simulation.evolution.config.StatisticsConfig;
import org.woehlke.simulation.evolution.config.WorldConfig;
import org.woehlke.simulation.evolution.config.WorldMapFoodConfig;

/**
 * The Config for running the Simulation.
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * (C) 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 *
 * @author Thomas Woehlke
 * Date: 17.11.2018
 * Time: 16:33:14
 */
public class SimulatedEvolutionConfig {

  private final GuiConfig guiConfig;

  private final StatisticsConfig statisticsConfig;

  private final WorldConfig worldConfig;

  private final WorldMapFoodConfig worldMapFoodConfig;

  /**
   * TODO write doc.
   */
  public SimulatedEvolutionConfig() {
    this.guiConfig = new GuiConfig();
    this.statisticsConfig = new StatisticsConfig();
    this.worldConfig = new WorldConfig();
    this.worldMapFoodConfig = new WorldMapFoodConfig();
  }

  public GuiConfig getGuiConfig() {
    return guiConfig;
  }

  public StatisticsConfig getStatisticsConfig() {
    return statisticsConfig;
  }

  public WorldConfig getWorldConfig() {
    return worldConfig;
  }

  public WorldMapFoodConfig getWorldMapFoodConfig() {
    return worldMapFoodConfig;
  }

  public String getFoodPerDay() {
    return "" + worldMapFoodConfig.getFoodPerDay();
  }
}
