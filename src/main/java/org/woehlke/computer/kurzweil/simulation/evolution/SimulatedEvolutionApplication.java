package org.woehlke.computer.kurzweil.simulation.evolution;

import org.woehlke.computer.kurzweil.simulation.evolution.view.SimulatedEvolutionFrame;

/**
 * Class with main Method for Starting the Desktop Application.
 *
 * @see SimulatedEvolutionFrame
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
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
