package org.woehlke.simulation.evolution.view.desktop;

import org.woehlke.simulation.evolution.view.config.Preparable;
import org.woehlke.simulation.evolution.view.config.SimulatedEvolution;
import org.woehlke.simulation.evolution.control.ControllerThreadDesktop;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.view.WorldCanvas;
import org.woehlke.simulation.evolution.view.PanelNorth;
import org.woehlke.simulation.evolution.view.PanelSouth;
import org.woehlke.simulation.evolution.view.applet.SimulatedEvolutionApplet;
import org.woehlke.simulation.evolution.view.config.SimulatedEvolutionFrameConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * This Frame wraps the SimulatedEvolutionApplet which is the Container for this Simulation.
 *
 * @see SimulatedEvolutionApplet
 * @see javax.swing.JFrame
 * @see java.awt.image.ImageObserver
 * @see java.awt.event.WindowListener
 *
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:47:46
 */
public class SimulatedEvolutionFrame extends JFrame implements ImageObserver,
        MenuContainer,
        Serializable,
        Preparable,
    SimulatedEvolution {

    private static final long serialVersionUID = -3830377190196972207L;

    private SimulatedEvolutionFrameConfig simulatedEvolutionFrameConfig;

    /**
     * The View for the World. Food and Cells are painted to the Canvas.
     */
    private final WorldCanvas canvas;

    /**
     * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
     */
    private final World world;

    private final PanelNorth panelNorth;
    private final PanelSouth panelSouth;

    private final BorderLayout layout = new BorderLayout();

    public void prepareMe(){
        this.setBounds(this.simulatedEvolutionFrameConfig.getFrameRectangle());
    }

    public void prepareAll(){
        this.canvas.prepareMe();
        this.panelNorth.prepareMe();
        this.panelSouth.prepareMe();
        this.prepareMe();
    }

    public void showMe(){
        prepareAll();
        setVisible(true);
        toFront();
    }

    public SimulatedEvolutionFrame(SimulatedEvolutionFrameConfig simulatedEvolutionFrameConfig) {
        super(simulatedEvolutionFrameConfig.getTitle());
        this.simulatedEvolutionFrameConfig = simulatedEvolutionFrameConfig;
        this.panelSouth = new PanelSouth(simulatedEvolutionFrameConfig);
        this.panelNorth = new PanelNorth(simulatedEvolutionFrameConfig);
        this.world = new World(simulatedEvolutionFrameConfig);
        this.canvas = new WorldCanvas(this.world);
        rootPane.setLayout(layout);
        rootPane.add(panelNorth, BorderLayout.NORTH);
        rootPane.add(canvas,BorderLayout.CENTER);
        rootPane.add(panelSouth,BorderLayout.SOUTH);
        prepareAll();
        pack();
        ControllerThreadDesktop control = new ControllerThreadDesktop(
            this.canvas, this.world,this
        );
        addWindowListener(control);
        control.start();
        showMe();
    }

}
