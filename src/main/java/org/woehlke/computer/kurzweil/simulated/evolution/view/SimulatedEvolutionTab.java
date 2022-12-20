package org.woehlke.computer.kurzweil.simulated.evolution.view;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionController;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.application.SimulatedEvolutionParameter;
import org.woehlke.computer.kurzweil.simulated.evolution.model.food.molecules.LatticePoint;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.SimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.view.census.PopulationStatisticsElementsPanelCounted;
import org.woehlke.computer.kurzweil.simulated.evolution.view.census.PopulationStatisticsElementsPanelLifeCycle;
import org.woehlke.computer.kurzweil.simulated.evolution.view.panels.CensusPanel;
import org.woehlke.computer.kurzweil.simulated.evolution.view.panels.CopyrightLabel;
import org.woehlke.computer.kurzweil.simulated.evolution.view.panels.SubTitleLabel;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

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

    /**
     * Subtitle Label for DesktopApp and Title Label for Applet.
     */
    private final SubTitleLabel subTitleLabel;

    /**
     * Copyright Label
     */
    private final CopyrightLabel copyrightLabel;

    /**
     * ControllerThread for Interachtions between Model and View (MVC-Pattern).
     */
    private final SimulatedEvolutionController controller;

    /**
     * The View for the World. Food and Cells are painted to the Canvas.
     */
    private final SimulatedEvolutionCanvas canvas;

    /**
     * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
     */
    private final SimulatedEvolutionModel model;

    /**
     * @see PopulationStatisticsElementsPanelLifeCycle
     * @see PopulationStatisticsElementsPanelCounted
     */
    private final CensusPanel censusPanel;

    /**
     *
     */
    private final SimulatedEvolutionParameter parameter;

    /**
     *
     */
    private final ComputerKurzweilProperties properties;

    /**
     * TODO: refactor, replace Rectangle with a class based on LatticePoint
     * @see java.awt.Rectangle
     * @see LatticePoint
     */
    @Deprecated
    private volatile Rectangle rectangleBounds;

    /**
     * TODO: refactor, replace Dimension with a class based on LatticePoint
     * @see java.awt.Dimension
     * @see LatticePoint
     */
    @Deprecated
    private volatile Dimension dimensionSize;

    public SimulatedEvolutionTab(ComputerKurzweilProperties properties) {
        super(properties.getSimulatedevolution().getView().getTitle());
        this.properties = properties;
        this.parameter = new SimulatedEvolutionParameter();
        this.model = new SimulatedEvolutionModel(
            properties
        );
        this.canvas = new SimulatedEvolutionCanvas(this.model);
        this.controller = new SimulatedEvolutionController(
            this.model,
            this.canvas,
            this
        );
        this.subTitleLabel = new SubTitleLabel(properties);
        this.copyrightLabel = new CopyrightLabel(properties);
        this.censusPanel = new CensusPanel(this);
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        this.add(subTitleLabel,BorderLayout.NORTH);
        this.add(canvas,BorderLayout.CENTER);
        this.add(censusPanel,BorderLayout.SOUTH);
        addWindowListener(this);
        showMeInit();
    }

    public void showMeInit() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int titleHeight = HEIGHT_OF_TITLE + HEIGHT_OF_STATISTICS;
        int width = this.getModel().getWorldDimensions().getWidth();
        int height  = this.getModel().getWorldDimensions().getHeight() + titleHeight;
        //int height  = this.canvas.getHeight() + titleHeight;
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

    /**
     * @see org.woehlke.computer.kurzweil.simulated.evolution.SimulatedEvolutionApplication
     */
    public void start() {
        controller.start();
    }

    /**
     * @see SimulatedEvolutionController
     */
    public synchronized void update(){
        this.censusPanel.update();
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

    public void actionPerformed(ActionEvent actionEvent) {
    }
}
