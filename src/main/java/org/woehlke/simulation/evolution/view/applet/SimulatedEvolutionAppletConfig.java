package org.woehlke.simulation.evolution.view.applet;

import org.woehlke.simulation.evolution.SimulatedEvolution;

import java.io.Serializable;

/**
 * The Config for running the Simulation.
 *
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * (C) 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 17.11.2018
 * Time: 16:33:14
 */
public class SimulatedEvolutionAppletConfig implements Serializable, SimulatedEvolution {

    private static final long serialVersionUID = -4370382255481437491L;

    private String title;
    private int scale;
    private int width;
    private int height;


    public SimulatedEvolutionAppletConfig(String title, int scale, int width, int height) {
        this.title = title;
        this.scale = scale;
        this.width = width * scale;
        this.height = height * scale;
    }

    public String getTitle() {
        return title;
    }

    public int getScale() {
        return scale;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
