package org.woehlke.simulation.evolution.view;


import org.woehlke.simulation.evolution.config.GuiConfig;

public class SimulatedEvolutionAppletRunner implements GuiConfig {

    /**
     * Starting the Desktop Application
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        SimulatedEvolutionApplet simulatedEvolutionApplet = new SimulatedEvolutionApplet();
        System.out.println("Hello, World!");
    }
}
