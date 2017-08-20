package org.woehlke.simulation.evolution.desktop;

import org.woehlke.simulation.evolution.view.SimulatedEvolutionFrame;

/**
 * (C) 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 */
public class SimulatedEvolutionApplication {

    private SimulatedEvolutionApplication() { }

    /**
     * Starting the App.
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        SimulatedEvolutionFrame simGen = new SimulatedEvolutionFrame();
    }
}
