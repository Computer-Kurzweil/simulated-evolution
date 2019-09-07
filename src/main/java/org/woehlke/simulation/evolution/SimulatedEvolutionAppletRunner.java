package org.woehlke.simulation.evolution;


import org.woehlke.simulation.evolution.view.applet.SimulatedEvolutionApplet;

public class SimulatedEvolutionAppletRunner implements SimulatedEvolution {

    /**
     * Starting the Desktop Application
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        SimulatedEvolutionApplet simulatedEvolutionApplet = new SimulatedEvolutionApplet();
        System.out.println("Hello, World!");
    }
}
