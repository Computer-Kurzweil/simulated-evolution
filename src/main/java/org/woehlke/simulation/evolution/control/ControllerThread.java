package org.woehlke.simulation.evolution.control;

import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.view.WorldCanvas;

/**
 * (C) 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class ControllerThread extends Thread
        implements Runnable {
    private World world;
    private WorldCanvas canvas;

    private int THREAD_SLEEP_TIME = 200;
    private Boolean goOn;

    public ControllerThread() {
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
            try { sleep(THREAD_SLEEP_TIME); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        while (doIt);
    }

    public void exit() {
        synchronized (goOn) {
            goOn = Boolean.FALSE;
        }
    }

    public void setCanvas(WorldCanvas canvas) {
        this.canvas = canvas;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
