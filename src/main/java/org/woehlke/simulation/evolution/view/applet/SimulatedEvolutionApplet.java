package org.woehlke.simulation.evolution.view.applet;

import org.woehlke.simulation.evolution.view.config.SimulatedEvolution;
import org.woehlke.simulation.evolution.control.ControllerThreadApplet;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.view.WorldCanvas;
import org.woehlke.simulation.evolution.view.config.SimulatedEvolutionAppletConfig;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * The Container for running the Simulation.
 * It containes a World Data Model, a Controller Thread and a WorldCanvas View.
 *
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * (C) 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:33:14
 */
public class SimulatedEvolutionApplet extends JApplet
    implements ImageObserver, MenuContainer, Serializable, Accessible, SimulatedEvolution {

    private static final long serialVersionUID = -8586633326682669768L;

    /**
     * ControllerThreadApplet for Interachtions between Model and View (MVC-Pattern).
     */
    private ControllerThreadApplet controllerThreadApplet;

    /**
     * The View for the World. Food and Cells are painted to the Canvas.
     */
    private WorldCanvas canvas;

    /**
     * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
     */
    private World world;

    private SimulatedEvolutionAppletConfig simulatedEvolutionAppletConfig = new SimulatedEvolutionAppletConfig();

    private BorderLayout layout = new BorderLayout();

    private JLabel titleLabel;

    public void init() {
        this.titleLabel = new JLabel(this.simulatedEvolutionAppletConfig.getTitle());
        this.rootPane.setLayout(layout);
        this.rootPane.add(titleLabel, BorderLayout.NORTH);
        this.world = new World(this.simulatedEvolutionAppletConfig);
        this.canvas = new WorldCanvas(world);
        this.rootPane.add(canvas, BorderLayout.CENTER);
        this.controllerThreadApplet = new ControllerThreadApplet(world, canvas);
        this.controllerThreadApplet.start();
    }

    public void destroy() {
    }

    public void stop() {
    }

}
