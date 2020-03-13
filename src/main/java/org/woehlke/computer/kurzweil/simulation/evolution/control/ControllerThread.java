package org.woehlke.computer.kurzweil.simulation.evolution.control;

import org.woehlke.computer.kurzweil.simulation.evolution.model.WorldModel;
import org.woehlke.computer.kurzweil.simulation.evolution.view.WorldCanvas;

/**
 * The ControllerThread controls the Interactions between Model and View (MVC-Pattern).
 *
 * &copy; 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class ControllerThread extends Thread implements Runnable {

    /**
     * Data Model for the Simulation
     */
    private WorldModel worldModel;

    /**
     * Canvas, where to paint in the GUI.
     */
    private WorldCanvas canvas;

    /**
     * Time to Wait in ms.
     */
    private final int TIME_TO_WAIT = 100;

    /**
     * Control for Threading
     */
    private Boolean mySemaphore;

    public ControllerThread() {
        mySemaphore = Boolean.TRUE;
    }

    public void run() {
        boolean doMyJob;
        do {
            synchronized (mySemaphore) {
                doMyJob = mySemaphore.booleanValue();
            }
            worldModel.letLivePopulation();
            canvas.repaint();
            try {
                sleep(TIME_TO_WAIT);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (doMyJob);
    }

    public void exit() {
        synchronized (mySemaphore) {
            mySemaphore = Boolean.FALSE;
        }
    }

    public void setCanvas(WorldCanvas canvas) {
        this.canvas = canvas;
    }

    public void setWorldModel(WorldModel worldModel) {
        this.worldModel = worldModel;
    }
}
