package org.woehlke.computer.kurzweil.simulated.evolution.view;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionController;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.model.world.SimulatedEvolutionParameter;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.SimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.population.PopulationStatisticsElementsPanelCounted;
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

    private final static int SYSTEM_EXIT_STATUS_OK = 0;

    private final static int HEIGHT_OF_TITLE = 30;

    private final static int HEIGHT_OF_STATISTICS = 60;

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

    /**
    * Display the age of the generation and the world.
    */
    private final PopulationStatisticsElementsPanelCounted panelCounter;

    private volatile Rectangle rectangleBounds;
    private volatile Dimension dimensionSize;

    public SimulatedEvolutionTab(ComputerKurzweilProperties computerKurzweilProperties) {
        super(computerKurzweilProperties.getSimulatedevolution().getView().getTitle());
        this.computerKurzweilProperties = computerKurzweilProperties;
        this.simulatedEvolutionParameter = new SimulatedEvolutionParameter();
        this.simulatedEvolutionModel = new SimulatedEvolutionModel(
            computerKurzweilProperties
        );
        this.canvas = new SimulatedEvolutionCanvas(this.simulatedEvolutionModel);
        this.panelLifeCycle = new PopulationStatisticsElementsPanelLifeCycle(
            this,
            this.simulatedEvolutionModel.getSimulatedEvolutionPopulationCensusContainer()
        );
        this.panelCounter = new PopulationStatisticsElementsPanelCounted(
            this,
            this.simulatedEvolutionModel.getSimulatedEvolutionPopulationCensusContainer()
        );
        this.simulatedEvolutionController = new SimulatedEvolutionController(
            this.simulatedEvolutionModel,
            this.canvas,
            this
        );
        String subTitle =  computerKurzweilProperties.getSimulatedevolution().getView().getSubtitle();
        String copyright =  computerKurzweilProperties.getSimulatedevolution().getView().getCopyright();
        this.subTitleLabel = new JLabel(subTitle, CENTER);
        this.copyrightLabel = new JLabel(copyright, CENTER);
        BoxLayout layout = new BoxLayout(rootPane, BoxLayout.PAGE_AXIS);
        rootPane.setLayout(layout);
        rootPane.add(subTitleLabel);
        rootPane.add(canvas);
        rootPane.add(panelLifeCycle);
        rootPane.add(new JSeparator());
        rootPane.add(panelCounter);
        addWindowListener(this);
        pack();
        showMeInit();
    }

    public void showMeInit() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int titleHeight = HEIGHT_OF_TITLE + HEIGHT_OF_STATISTICS;
        int width = this.simulatedEvolutionModel.getWorldDimensions().getX();
        int height = this.simulatedEvolutionModel.getWorldDimensions().getY() + titleHeight;
        double dStartX = (screenSize.getWidth() - width) / 2d;
        double dStartY = (screenSize.getHeight() - height) / 2d;
        int iStartX = Double.valueOf(dStartX).intValue();
        int iStartY = Double.valueOf(dStartY).intValue();
        int iWidth = Double.valueOf(width).intValue();
        int iHeight = Double.valueOf(height).intValue();
        this.rectangleBounds = new Rectangle(iStartX, iStartY, iWidth, iHeight);
        this.dimensionSize = new Dimension(iWidth, iHeight);
        showMe();
    }

    /**
     * Things to do, to show the Application Window again.
     */

    public void showMe(){
        this.setBounds(this.rectangleBounds);
        this.setSize(this.dimensionSize);
        this.setPreferredSize(this.dimensionSize);
        setVisible(true);
        toFront();
    }

    public void start() {
        simulatedEvolutionController.start();
    }

    public void windowOpened(WindowEvent e) {
        showMe();
    }

    public void windowClosing(WindowEvent e) {
        System.exit(SYSTEM_EXIT_STATUS_OK);
    }

    public void windowClosed(WindowEvent e) {
        System.exit(SYSTEM_EXIT_STATUS_OK);
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

    public synchronized void update(){
        this.panelLifeCycle.update();
        this.panelCounter.update();
    }

    public void actionPerformed(ActionEvent actionEvent) {

    }
}
