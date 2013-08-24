package org.woehlke.simulation.evolution.control;

import org.woehlke.simulation.evolution.model.SimGenPoint;
import org.woehlke.simulation.evolution.model.SimGenWorld;
import org.woehlke.simulation.evolution.view.SimGenWorldCanvas;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class SimGenController extends Thread
        implements Runnable {
    private SimGenWorld world;
    private Boolean goOn;
    private SimGenWorldCanvas canvas;
    private SimGenPoint max;

    public SimGenController() {
        goOn = new Boolean(true);
    }

    public void run() {
        boolean doIt;
        int daytime = 0;
        do {
            synchronized (goOn) {
                doIt = goOn.booleanValue();
            }
            world.letLivePopulation();
            canvas.repaint();
            try {
                sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        while (doIt);
    }

    public void exit() {
        synchronized (goOn) {
            goOn = new Boolean(false);
        }
    }

    public SimGenWorldCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(SimGenWorldCanvas canvas) {
        this.canvas = canvas;
    }

    public SimGenPoint getMax() {
        return max;
    }

    public void setMax(SimGenPoint max) {
        this.max = max;
    }

    public Boolean getGoOn() {
        return goOn;
    }

    public void setGoOn(Boolean goOn) {
        this.goOn = goOn;
    }

    public SimGenWorld getWorld() {
        return world;
    }

    public void setWorld(SimGenWorld world) {
        this.world = world;
    }
}
