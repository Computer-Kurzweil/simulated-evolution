package org.woehlke.computer.kurzweil.simulated.evolution.view;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.SimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionController;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.population.PopulationStatisticsElementsPanelLifeCycle;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

import static javax.swing.SwingConstants.CENTER;


/**
 * The Container for running the Simulation.
 * It containes a World Data Model, a Controller Thread and a WorldCanvas View.
 *
 * (C) 2013 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 04.02.2006
 * Time: 18:33:14
 */
@Log4j2
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class SimulatedEvolutionApplet extends JApplet implements
    ImageObserver,
    MenuContainer,
    Serializable,
    Accessible {

    private static final long serialVersionUID = 242L;

    /**
     * Subtitle for DesktopApp and Title for Applet.
     */
    private final JLabel titleLabel;

    /**
     * ControllerThread for Interachtions between Model and View (MVC-Pattern).
     */
    private final SimulatedEvolutionController simulatedEvolutionController;

    /**
     * The View for the World. Food and Cells are painted to the Canvas.
     */
    private final SimulatedEvolutionCanvas canvas;

    /**
     * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
     */
    private final SimulatedEvolutionModel simulatedEvolutionModel;

    /**
     * Display how many Cells per LifeCycleStatus and how many Cells in the whole Population for this Generation.
     */
    private final PopulationStatisticsElementsPanelLifeCycle panelLifeCycle;

    private final SimulatedEvolutionTab tab;

    public void init() {
        this.setLayout(new BorderLayout());
        this.add(this.titleLabel, BorderLayout.NORTH);
        this.add(this.canvas, BorderLayout.CENTER);
        this.add(this.panelLifeCycle, BorderLayout.SOUTH);
    }

    public SimulatedEvolutionApplet(SimulatedEvolutionTab simulatedEvolutionTab) {
        super();
        this.tab = simulatedEvolutionTab;
        ComputerKurzweilProperties computerKurzweilProperties = this.tab.getComputerKurzweilProperties();
        this.simulatedEvolutionModel = new SimulatedEvolutionModel(
            computerKurzweilProperties
        );
        this.canvas = new SimulatedEvolutionCanvas(this.simulatedEvolutionModel);
        this.panelLifeCycle = new PopulationStatisticsElementsPanelLifeCycle(this.tab);
        this.simulatedEvolutionController = new SimulatedEvolutionController(
            this.simulatedEvolutionModel, this.canvas, this.panelLifeCycle, this.tab
        );
        String subTitle =  computerKurzweilProperties.getSimulatedevolution().getView().getSubtitle();
        String copyright =  computerKurzweilProperties.getSimulatedevolution().getView().getCopyright();
        String title = subTitle +" - "+ copyright;
        this.titleLabel = new JLabel(title, CENTER);
    }

    public void destroy() {
    }

    public void stop() {
    }

    public void start() {
        simulatedEvolutionController.start();
    }
}
