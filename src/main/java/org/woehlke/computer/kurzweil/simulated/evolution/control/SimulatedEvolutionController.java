package org.woehlke.computer.kurzweil.simulated.evolution.control;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.SimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.population.PopulationStatisticsElementsPanelLifeCycle;

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

    private static final long serialVersionUID = 242L;

    /**
     * Data Model for the Simulation
     */
    private final SimulatedEvolutionModel simulatedEvolutionModel;

    /**
     * Canvas, where to paint in the GUI.
     */
    private final SimulatedEvolutionCanvas canvas;
    private final PopulationStatisticsElementsPanelLifeCycle panelLifeCycle;
    private final SimulatedEvolutionTab simulatedEvolutionTab;

    /**
     * Time to Wait in ms.
     */
    private final int TIME_TO_WAIT = 100;

    /**
     * Control for Threading
     */
    private Boolean mySemaphore;

    public SimulatedEvolutionController(
        SimulatedEvolutionModel simulatedEvolutionModel,
        SimulatedEvolutionCanvas canvas,
        PopulationStatisticsElementsPanelLifeCycle panelLifeCycle,
        SimulatedEvolutionTab simulatedEvolutionTab
    ) {
        this.simulatedEvolutionModel = simulatedEvolutionModel;
        this.canvas = canvas;
        this.panelLifeCycle = panelLifeCycle;
        this.simulatedEvolutionTab = simulatedEvolutionTab;
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
            panelLifeCycle.update();
            panelLifeCycle.repaint();
            simulatedEvolutionTab.repaint();
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
