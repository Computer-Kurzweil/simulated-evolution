package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.model.SimGenWorld;
import org.woehlke.simulation.evolution.control.SimGenController;
import org.woehlke.simulation.evolution.model.SimGenPoint;

import javax.accessibility.Accessible;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:33:14
 */
public class SimGenApplet extends Applet implements ImageObserver, MenuContainer, Serializable, Accessible {

    private Label title = new Label("SimGen");
    private SimGenController controllerThread;
    private SimGenWorldCanvas canvas;
    private SimGenWorld world;
    private int scale = 2;
    private int width = 320 * scale;
    private int height = 234 * scale;

    public void init() {
        scale = 2;
        width = 320 * scale;
        height = 234 * scale;
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        controllerThread = new SimGenController();
        world = new SimGenWorld(width, height);
        canvas = new SimGenWorldCanvas(width, height);
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

    public SimGenPoint getCanvasDimenensions() {
        return canvas.getDimensions();
    }

    public SimGenWorldCanvas getCanvas() {
        return canvas;
    }

    public SimGenController getControllerThread() {
        return controllerThread;
    }

    public void setControllerThread(SimGenController controllerThread) {
        this.controllerThread = controllerThread;
    }
}
