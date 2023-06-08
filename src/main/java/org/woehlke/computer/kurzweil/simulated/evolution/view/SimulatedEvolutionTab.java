package org.woehlke.computer.kurzweil.simulated.evolution.view;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionController;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.application.SimulatedEvolutionParameter;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticeRectangle;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.ConcreteSimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.SimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.view.census.CensusElementsPanelCounted;
import org.woehlke.computer.kurzweil.simulated.evolution.view.census.CensusElementsPanelLifeCycle;
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
 * @see CensusElementsPanelLifeCycle
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
    WindowListener, ActionListener, ImageObserver, Accessible, Serializable {

    static final long serialVersionUID = 242L;

    private final static int SYSTEM_EXIT_STATUS_OK = 0;

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
     * @see CensusElementsPanelLifeCycle
     * @see CensusElementsPanelCounted
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
     * @see LatticePoint
     */
    @Deprecated
    private volatile LatticeRectangle rectangleBounds;

    public SimulatedEvolutionTab(ComputerKurzweilProperties properties) {
        super(properties.getSimulatedevolution().getView().getTitle());
        this.properties = properties;
        this.parameter = new SimulatedEvolutionParameter();
        this.model = new SimulatedEvolutionModel(
            properties
        );
        this.canvas = new ConcreteSimulatedEvolutionCanvas(this.model);
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
        int heightOfTitle = properties.getSimulatedevolution().getView().getHeightOfTitle();
        int heightOfStatistics = properties.getSimulatedevolution().getView().getHeightOfStatistics();
        int heightOfStatisticsCanvas = properties.getSimulatedevolution().getView().getHeightOfStatisticsCanvas();
        int titleHeight = heightOfTitle + heightOfStatistics + heightOfStatisticsCanvas;
        int width = this.getModel().getWorldDimensions().getX();
        int height  = this.getModel().getWorldDimensions().getY() + titleHeight;
        double dStartX = (screenSize.getWidth() - width) / 2d;
        double dStartY = (screenSize.getHeight() - height) / 2d;
        int iStartX = Double.valueOf(dStartX).intValue();
        int iStartY = Double.valueOf(dStartY).intValue();
        int iWidth = Double.valueOf(width).intValue();
        int iHeight = Double.valueOf(height).intValue();
        this.rectangleBounds = LatticeRectangle.of(iStartX, iStartY, iWidth, iHeight);
        showMe();
    }

    /**
     * Things to do, to show the Application Window again.
     */
    public void showMe(){
        int x = this.rectangleBounds.getStart().getX();
        int y = this.rectangleBounds.getStart().getY();
        int width = this.rectangleBounds.getDimension().getWidth();
        int height = this.rectangleBounds.getDimension().getHeight();
        Rectangle r = new Rectangle(x,y,width,height);
        Dimension d = new Dimension(width,height);
        this.setBounds(r);
        this.setSize(d);
        this.setPreferredSize(d);
        setVisible(true);
        toFront();
        this.censusPanel.getCensusCanvas().showMe();
        this.censusPanel.getCensusCanvas().setVisible(true);
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

    private void shutdown(){
        System.exit(SYSTEM_EXIT_STATUS_OK);
    }

    public void windowOpened(WindowEvent e) {
        showMe();
    }

    public void windowClosing(WindowEvent e) {
        shutdown();
    }

    public void windowClosed(WindowEvent e) {
        shutdown();
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
        showMe();
    }

    public void windowActivated(WindowEvent e) {
        toFront();
        this.censusPanel.getCensusCanvas().setVisible(true);
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void actionPerformed(ActionEvent actionEvent) {
    }
}
