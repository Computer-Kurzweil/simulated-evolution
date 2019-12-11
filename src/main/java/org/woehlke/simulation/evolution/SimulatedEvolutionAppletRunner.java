package org.woehlke.simulation.evolution;

import org.woehlke.simulation.evolution.config.GuiConfigDefault;
import org.woehlke.simulation.evolution.view.SimulatedEvolutionApplet;

/**
 * TODO write doc.
 */
public class SimulatedEvolutionAppletRunner implements GuiConfigDefault {

  private SimulatedEvolutionAppletRunner() {
  }

  /**
   * Starting the Desktop Application.
   * @param args CLI Parameter.
   */
  public static void main(String[] args) {
    SimulatedEvolutionApplet simulatedEvolutionApplet = new SimulatedEvolutionApplet();
    System.out.println(TITLE + ": Started the AppletRunner");
  }
}
