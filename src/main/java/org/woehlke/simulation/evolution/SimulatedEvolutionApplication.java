package org.woehlke.simulation.evolution;

import org.woehlke.simulation.evolution.config.GuiConfig;
import org.woehlke.simulation.evolution.view.SimulatedEvolutionApplet;
import org.woehlke.simulation.evolution.view.SimulatedEvolutionFrame;

/**
 * Class with main Method for Starting the Desktop Application.
 *
 * @author Thomas Woehlke
 * <p>
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @see SimulatedEvolutionFrame
 * @see SimulatedEvolutionApplet
 * <p>
 * Simulated Evolution. Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * Green food appears in a world with red moving cells.
 * These cells eat the food if it is on their position.
 * Movement of the cells depends on random and their DNA.
 * A fit cell moves around and eats enough to reproduce.
 * Reproduction is done by splitting the cell and randomly changing the DNA of the two new Cells.
 * If a cell doesn't eat enough, it will first stand still and after a while it dies.
 * <p>
 * &copy; 2006 - 2008 Thomas Woehlke.
 */
public class SimulatedEvolutionApplication implements GuiConfig {

  private SimulatedEvolutionApplication() {
  }

  /**
   * Starting the Desktop Application
   *
   * @param args CLI Parameter
   */
  public static void main(String[] args) {
    SimulatedEvolutionConfig config = new SimulatedEvolutionConfig();
    SimulatedEvolutionFrame simulatedEvolutionFrame = new SimulatedEvolutionFrame(config);
    System.out.println(TITLE +": Started the Desktop Application");
  }
}