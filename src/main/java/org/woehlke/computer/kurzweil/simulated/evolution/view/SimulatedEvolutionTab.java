package org.woehlke.computer.kurzweil.simulated.evolution.view;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionController;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.model.world.SimulatedEvolutionParameter;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.SimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.population.PopulationStatisticsElementsPanelLifeCycle;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

import static javax.swing.SwingConstants.CENTER;

/**
 * This Frame is the Container for running the Simulation.
 * It containes a World Data Model, a Controller Thread and a WorldCanvas View.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see SimulatedEvolutionModel
 * @see SimulatedEvolutionController
 * @see SimulatedEvolutionCanvas
 * @see PopulationStatisticsElementsPanelLifeCycle
 *
 * @see ComputerKurzweilProperties
 * @see SimulatedEvolutionParameter
 *
 * @see javax.swing.JFrame
 * @see java.awt.image.ImageObserver
 * @see java.awt.event.WindowListener
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 04.02.2006
 * Time: 18:47:46
 */
@Log4j2
@Getter
public class SimulatedEvolutionTab extends JFrame implements MenuContainer,
    WindowListener, ActionListener, Serializable, ImageObserver, Accessible {

    static final long serialVersionUID = 242L;

    private final static String TITLE = "Simulated Evolution";

    private final static int EXIT_STATUS = 0;

    private final static String APPLET_POSITION = "Center";

    private final static int HEIGHT_OF_TITLE = 30;

    private final static int HEIGHT_OF_STATISTICS = 60;

    private final static int START_POSITION_ON_SCREEN_X = 100;

    private final static int START_POSITION_ON_SCREEN_Y = 100;

    private final SimulatedEvolutionParameter simulatedEvolutionParameter;

    private final ComputerKurzweilProperties computerKurzweilProperties;

    /**
     * Subtitle Label for DesktopApp and Title Label for Applet.
     */
    private final JLabel subTitleLabel;

    /**
     * Copyright Label
     */
    private final JLabel copyrightLabel;

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

    public SimulatedEvolutionTab(ComputerKurzweilProperties computerKurzweilProperties) {
        super(TITLE);
        this.computerKurzweilProperties = computerKurzweilProperties;
        this.simulatedEvolutionModel = new SimulatedEvolutionModel(
            computerKurzweilProperties
        );
        this.canvas = new SimulatedEvolutionCanvas(this.simulatedEvolutionModel);
        this.panelLifeCycle = new PopulationStatisticsElementsPanelLifeCycle(
            this,
            this.simulatedEvolutionModel.getSimulatedEvolutionPopulationCensusContainer()
        );
        this.simulatedEvolutionController = new SimulatedEvolutionController(
            this.simulatedEvolutionModel, this.canvas, this.panelLifeCycle, this
        );
        String subTitle =  computerKurzweilProperties.getSimulatedevolution().getView().getSubtitle();
        String copyright =  computerKurzweilProperties.getSimulatedevolution().getView().getCopyright();
        this.subTitleLabel = new JLabel(subTitle, CENTER);
        this.copyrightLabel = new JLabel(copyright, CENTER);
        this.simulatedEvolutionParameter = new SimulatedEvolutionParameter();
        //this.simulatedEvolutionApplet = new SimulatedEvolutionApplet(this);
        //this.simulatedEvolutionApplet.init();
        //this.add(APPLET_POSITION, simulatedEvolutionApplet);
        this.setLayout(new BorderLayout());
        this.add(this.subTitleLabel, BorderLayout.NORTH);
        this.add(this.canvas, BorderLayout.CENTER);
        this.add(this.panelLifeCycle, BorderLayout.SOUTH);
        addWindowListener(this);
        pack();
        showMe();
    }

    public void showMe(){
        setMyBounds();
        setVisible(true);
        toFront();
    }

    public void start() {
        simulatedEvolutionController.start();
    }

    public void windowOpened(WindowEvent e) {
        showMe();
    }

    private void setMyBounds(){
        int x = START_POSITION_ON_SCREEN_X; //TODO
        int y = START_POSITION_ON_SCREEN_Y; //TODO
        int width = this.simulatedEvolutionModel.getWorldDimensions().getX();
        int height = this.simulatedEvolutionModel.getWorldDimensions().getY()
            + HEIGHT_OF_TITLE
            + HEIGHT_OF_STATISTICS;
        setBounds(x, y, width, height);
    }

    public void windowClosing(WindowEvent e) {
        System.exit(EXIT_STATUS);
    }

    public void windowClosed(WindowEvent e) {
        System.exit(EXIT_STATUS);
    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {
        showMe();
    }

    public void windowActivated(WindowEvent e) {
        toFront();
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void update(){}

    public void actionPerformed(ActionEvent actionEvent) {

    }
}
