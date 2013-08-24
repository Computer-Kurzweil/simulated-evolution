package org.woehlke.simulation.evolution.control;

import org.woehlke.simulation.evolution.model.Point;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.view.WorldCanvas;

/**
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class Controller extends Thread
        implements Runnable {
    private World world;
    private Boolean goOn;
    private WorldCanvas canvas;
    private Point max;

    public Controller() {
        goOn = Boolean.TRUE;
    }

    public void run() {
        boolean doIt;
        do {
            synchronized (goOn) {
                doIt = goOn.booleanValue();
            }
            world.letLivePopulation();
            canvas.repaint();
            try { sleep(100); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        while (doIt);
    }

    public void exit() {
        synchronized (goOn) {
            goOn = Boolean.FALSE;
        }
    }

    public WorldCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(WorldCanvas canvas) {
        this.canvas = canvas;
    }

    public Point getMax() {
        return max;
    }

    public void setMax(Point max) {
        this.max = max;
    }

    public Boolean getGoOn() {
        return goOn;
    }

    public void setGoOn(Boolean goOn) {
        this.goOn = goOn;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
