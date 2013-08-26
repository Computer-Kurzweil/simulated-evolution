package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.control.ControllerThread;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.model.Point;

import javax.accessibility.Accessible;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * (C) 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:33:14
 */
public class SimulatedEvolutionApplet extends Applet implements ImageObserver, MenuContainer, Serializable, Accessible {

    private Label title = new Label("Simulated Evolution");
    private ControllerThread controllerThread;
    private WorldCanvas canvas;
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
