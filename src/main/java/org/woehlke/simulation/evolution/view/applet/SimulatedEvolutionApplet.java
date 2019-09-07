package org.woehlke.simulation.evolution.view.applet;

import org.woehlke.simulation.evolution.SimulatedEvolution;
import org.woehlke.simulation.evolution.control.ControllerThreadApplet;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.model.Point;
import org.woehlke.simulation.evolution.view.WorldCanvas;

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

    private SimulatedEvolutionAppletConfig simulatedEvolutionAppletConfig;

    public void init() {
        int scale = 2;
        int width = 320;
        int height = 234;
        String subtitle = SUB_TITLE;
        this.simulatedEvolutionAppletConfig = new SimulatedEvolutionAppletConfig(
            subtitle, scale, width, height
        );
        //
        Label titleLabel = new Label(this.simulatedEvolutionAppletConfig.getTitle());
        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH);
        Point worldDimensions = new Point(
            this.simulatedEvolutionAppletConfig.getWidth(),
            this.simulatedEvolutionAppletConfig.getHeight()
        );
        world = new World(worldDimensions);
        canvas = new WorldCanvas(worldDimensions);
        canvas.setWorld(world);
        this.add(canvas, BorderLayout.CENTER);
        controllerThreadApplet = new ControllerThreadApplet(world, canvas);
        controllerThreadApplet.start();
    }

    public void destroy() {
    }

    public void stop() {
    }

    public Point getCanvasDimensions() {
        return canvas.getWorldDimensions();
    }
}
