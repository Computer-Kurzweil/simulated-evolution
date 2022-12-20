package org.woehlke.computer.kurzweil.simulated.evolution.control;

import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.SimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;

import java.io.Serializable;

/**
 * The ControllerThread controls the Interactions between Model and View (MVC-Pattern).
 *
 * &copy; 2006 - 2013 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 05.02.2006
 * Time: 00:36:20
 */
@Log4j2
public class SimulatedEvolutionController extends Thread implements Runnable, Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Data Model for the Simulation
     */
    private final SimulatedEvolutionModel simulatedEvolutionModel;

    /**
     * Canvas, where to paint in the GUI.
     */
    private final SimulatedEvolutionCanvas canvas;
    private final SimulatedEvolutionTab tab;

    /**
     * Time to Wait in ms.
     */
    private final int timeToWait;

    /**
     * Control for Threading
     */
    private boolean doMyJob;

    public SimulatedEvolutionController(
        SimulatedEvolutionModel simulatedEvolutionModel,
        SimulatedEvolutionCanvas canvas,
        SimulatedEvolutionTab simulatedEvolutionTab
    ) {
        this.simulatedEvolutionModel = simulatedEvolutionModel;
        this.canvas = canvas;
        this.tab = simulatedEvolutionTab;
        this.timeToWait = this.tab.getComputerKurzweilProperties().getSimulatedevolution()
            .getControl().getThreadSleepTime();
        doMyJob = Boolean.TRUE;
    }

    public void run() {
        do {
            setDoMyJob( simulatedEvolutionModel.letLivePopulation() );
            tab.update();
            canvas.repaint();
            tab.repaint();
            try {
                sleep(timeToWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (doMyJob);
    }

    public void setDoMyJob( boolean doMyJob ){
        this.doMyJob = doMyJob;
    }

    public synchronized void exit() {
        this.doMyJob = Boolean.FALSE;
    }
}
