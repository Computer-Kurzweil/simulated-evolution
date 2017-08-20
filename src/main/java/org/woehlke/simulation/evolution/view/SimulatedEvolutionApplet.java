package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.control.ControllerThread;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.model.Point;

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
public class SimulatedEvolutionApplet extends JApplet implements ImageObserver, MenuContainer, Serializable, Accessible {

    static final long serialVersionUID = 242L;

    private Label title = new Label("      Artificial Life Simulation of Bacteria Motion depending on DNA - (C) 2013 Thomas Woehlke");

    /**
     * ControllerThread for Interachtions between Model and View (MVC-Pattern).
     */
    private ControllerThread controllerThread;

    /**
     * The View for the World. Food and Cells are painted to the Canvas.
     */
    private WorldCanvas canvas;

    /**
     * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
     */
    private World world;

    public void init() {
        int scale = 2;
        int width = 320 * scale;
        int height = 234 * scale;
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        controllerThread = new ControllerThread();
        Point worldDimensions = new Point(width,height);
        world = new World(worldDimensions);
        canvas = new WorldCanvas(worldDimensions);
        canvas.setWorld(world);
        this.add(canvas, BorderLayout.CENTER);
        controllerThread.setCanvas(canvas);
        controllerThread.setWorld(world);
        controllerThread.start();
    }

    public void destroy() {
    }

    public void stop() {
    }

    public Point getCanvasDimensions() {
        return canvas.getWorldDimensions();
    }
}
