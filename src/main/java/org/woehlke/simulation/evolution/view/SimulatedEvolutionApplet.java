package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.control.Controller;
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

    private Label title = new Label("SimGen");
    private Controller controllerThread;
    private WorldCanvas canvas;
    private World world;

    public void init() {
        int scale = 2;
        int width = 320 * scale;
        int height = 234 * scale;
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        controllerThread = new Controller();
        world = new World(width, height);
        canvas = new WorldCanvas(width, height);
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
        return canvas.getDimensions();
    }
}
