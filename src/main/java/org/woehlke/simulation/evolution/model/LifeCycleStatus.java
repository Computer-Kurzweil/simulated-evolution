package org.woehlke.simulation.evolution.model;

import java.awt.Color;

import static org.woehlke.simulation.evolution.config.GuiConfigColors.*;

/**
 * The Status of the Cell's LifeCycle.
 * It is Displayed as Color of the Cell.
 *
 * @author Thomas Woehlke
 * Date: 25.08.13
 * Time: 12:40
 * @see LifeCycle
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 */
public enum LifeCycleStatus {

  YOUNG(COLOR_YOUNG),
  YOUNG_AND_FAT(COLOR_YOUNG_AND_FAT),
  FULL_AGE(COLOR_FULL_AGE),
  HUNGRY(COLOR_HUNGRY),
  OLD(COLOR_OLD),
  DEAD(COLOR_DEAD);

  private Color color;

  LifeCycleStatus(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
}
