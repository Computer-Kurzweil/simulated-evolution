package org.woehlke.simulation.evolution;

import org.woehlke.simulation.evolution.config.*;

import java.awt.*;
import java.io.Serializable;

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
public class SimulatedEvolutionConfig implements Serializable {

  private static final long serialVersionUID = -4370382255481437491L;

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
