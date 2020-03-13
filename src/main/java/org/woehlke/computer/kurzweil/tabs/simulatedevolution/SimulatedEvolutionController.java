package org.woehlke.computer.kurzweil.tabs.simulatedevolution;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.commons.tabs.TabController;

/**
 * The ControllerThread controls the Interactions between Model and View (MVC-Pattern).
 *
 * &copy; 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:36:20
 */
@Log4j2
public class SimulatedEvolutionController extends Thread implements Runnable, TabController, SimulatedEvolution {

    /**
     * Data Model for the Simulation
     */
    @Setter
    private SimulatedEvolutionModel simulatedEvolutionModel;

    /**
     * Canvas, where to paint in the GUI.
     */
    @Setter
    private SimulatedEvolutionCanvas canvas;

    /**
     * Time to Wait in ms.
     */
    private final int TIME_TO_WAIT = 100;

    /**
     * Control for Threading
     */
    private Boolean mySemaphore;

    public SimulatedEvolutionController() {
        mySemaphore = Boolean.TRUE;
    }

    public void run() {
        boolean doMyJob;
        do {
            synchronized (mySemaphore) {
                doMyJob = mySemaphore.booleanValue();
            }
            simulatedEvolutionModel.letLivePopulation();
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
}
