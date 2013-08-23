package org.woehlke.simulation.evolution.gui;

import org.woehlke.simulation.evolution.dom.ISimGenWorld;
import org.woehlke.simulation.evolution.dom.SimGenWorld;
import org.woehlke.simulation.evolution.activities.ISimGenController;
import org.woehlke.simulation.evolution.activities.SimGenController;
import org.woehlke.simulation.evolution.beans.SimGenPoint;

import java.applet.Applet;
import java.awt.*;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:33:14
 */
public class SimGenApplet extends Applet implements ISimGenApplet {
    private Label title = new Label("SimGen");
    private ISimGenController controllerThread;
    private ISimGenWorldCanvas canvas;
    private ISimGenWorld world;
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
        this.add((Canvas) canvas, BorderLayout.CENTER);
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

    public ISimGenWorldCanvas getCanvas() {
        return canvas;
    }

    public ISimGenController getControllerThread() {
        return controllerThread;
    }

    public void setControllerThread(ISimGenController controllerThread) {
        this.controllerThread = controllerThread;
    }
}
