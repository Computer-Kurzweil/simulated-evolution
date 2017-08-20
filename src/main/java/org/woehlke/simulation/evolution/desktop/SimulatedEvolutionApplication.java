package org.woehlke.simulation.evolution.desktop;

import org.woehlke.simulation.evolution.view.SimulatedEvolutionFrame;

/**
 * Class with main Method for Starting the Desktop Application.
 *
 * @see org.woehlke.simulation.evolution.view.SimulatedEvolutionFrame
 * @see org.woehlke.simulation.evolution.view.SimulatedEvolutionApplet
 *
 * Simulated Evolution. Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * Green food appears in a world with red moving cells.
 * These cells eat the food if it is on their position.
 * Movement of the cells depends on random and their DNA.
 * A fit cell moves around and eats enough to reproduce.
 * Reproduction is done by splitting the cell and randomly changing the DNA of the two new Cells.
 * If a cell doesn't eat enough, it will first stand still and after a while it dies.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 *
 * @author Thomas Woehlke
 *
 * http://thomas-woehlke.de/p/simulated-evolution/
 */
public class SimulatedEvolutionApplication {

    private SimulatedEvolutionApplication() { }

    /**
     * Starting the Desktop Application
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        SimulatedEvolutionFrame simulatedEvolutionFrame = new SimulatedEvolutionFrame();
    }
}
