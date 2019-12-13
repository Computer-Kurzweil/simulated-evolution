package org.woehlke.simulation.evolution.control;

import org.woehlke.simulation.evolution.config.GuiConfig;
import org.woehlke.simulation.evolution.config.StatisticsConfig;
import org.woehlke.simulation.evolution.config.WorldConfig;
import org.woehlke.simulation.evolution.config.WorldMapFoodConfig;
import org.woehlke.simulation.evolution.model.LifeCycleCountContainer;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.model.WorldMapFood;
import org.woehlke.simulation.evolution.view.*;

import java.util.Date;
import java.util.Random;

public class ObjectRegistry {

  private World world;
  private WorldCanvas canvas;
  private SimulatedEvolutionFrame frame;
  private ControllerThreadDesktop controller;
  private LifeCycleCountContainer statistics;
  private WorldMapFood worldMapFood;

  private final PanelSubtitle panelSubtitle;
  private final PanelCopyright panelCopyright;
  private final PanelButtons panelButtons;
  private final PanelLifeCycleStatus panelLifeCycleStatus;

  private final GuiConfig guiConfig;
  private final StatisticsConfig statisticsConfig;
  private final WorldConfig worldConfig;
  private final WorldMapFoodConfig worldMapFoodConfig;

  /**
   * Random Generator used for placing food, coming from another Object.
   */
  private Random random;

  public ObjectRegistry() {
    long seed = new Date().getTime();
    random = new Random(seed);
    worldConfig = new WorldConfig();
    guiConfig = new GuiConfig();
    statisticsConfig = new StatisticsConfig();
    worldMapFoodConfig = new WorldMapFoodConfig();
    panelSubtitle = new PanelSubtitle(this);
    panelCopyright = new PanelCopyright(this);
    panelButtons = new PanelButtons(this);
    statistics = new LifeCycleCountContainer(this);
    panelLifeCycleStatus = new PanelLifeCycleStatus(this);
    world = new World(this);
    worldMapFood = new WorldMapFood(this);
    canvas = new WorldCanvas(this);
    frame = new SimulatedEvolutionFrame(this);
    controller = new ControllerThreadDesktop(this);
    controller.start();
  }

  public String getFoodPerDay() {
    return "" + worldMapFoodConfig.getFoodPerDay();
  }

  public World getWorld() {
    return world;
  }

  public WorldCanvas getCanvas() {
    return canvas;
  }

  public SimulatedEvolutionFrame getFrame() {
    return frame;
  }

  public ControllerThreadDesktop getController() {
    return controller;
  }

  public LifeCycleCountContainer getStatistics() {
    return statistics;
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

  public WorldMapFood getWorldMapFood() {
    return worldMapFood;
  }

  public PanelSubtitle getPanelSubtitle() {
    return panelSubtitle;
  }

  public PanelCopyright getPanelCopyright() {
    return panelCopyright;
  }

  public PanelButtons getPanelButtons() {
    return panelButtons;
  }

  public PanelLifeCycleStatus getPanelLifeCycleStatus() {
    return panelLifeCycleStatus;
  }

  public void setFrame(SimulatedEvolutionFrame frame) {
    this.frame = frame;
  }

  public Random getRandom() {
    return random;
  }
}
