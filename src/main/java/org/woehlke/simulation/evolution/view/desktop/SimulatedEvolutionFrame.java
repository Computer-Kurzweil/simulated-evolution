package org.woehlke.simulation.evolution.view.desktop;

import org.woehlke.simulation.evolution.SimulatedEvolution;
import org.woehlke.simulation.evolution.control.ControllerThreadDesktop;
import org.woehlke.simulation.evolution.model.Point;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.view.WorldCanvas;
import org.woehlke.simulation.evolution.view.applet.SimulatedEvolutionApplet;

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

    public void prepareMe(){
        int x = simulatedEvolutionFrameConfig.getStartPositionOnScreenX();
        int y = simulatedEvolutionFrameConfig.getStartPositionOnScreenY();
        int width = this.simulatedEvolutionFrameConfig.getWidth();
        int height = this.simulatedEvolutionFrameConfig.getHeight() +
            ( 2 * simulatedEvolutionFrameConfig.getHeightOfTitle());
        int startX = x;
        int startY = y + simulatedEvolutionFrameConfig.getHeightOfTitle();
        this.canvas.setBounds(
            startX,
            startY,
            width,
            this.simulatedEvolutionFrameConfig.getHeight());
        this.setBounds(x, y, width, height);
    }

    public void showMe(){
        prepareMe();
        setVisible(true);
        toFront();
    }

    public SimulatedEvolutionFrame(SimulatedEvolutionFrameConfig simulatedEvolutionFrameConfig) {
        super(simulatedEvolutionFrameConfig.getTitle());
        this.simulatedEvolutionFrameConfig = simulatedEvolutionFrameConfig;
        Label subtitleLabel = new Label(this.simulatedEvolutionFrameConfig.getSubtitle());
        Label footerLabel = new Label(this.simulatedEvolutionFrameConfig.getFooter());
        this.setLayout(new BorderLayout());
        this.add(subtitleLabel, BorderLayout.PAGE_START);
        Point worldDimensions = new Point(
            this.simulatedEvolutionFrameConfig.getWidth(),
            this.simulatedEvolutionFrameConfig.getHeight()
        );
        this.world = new World(worldDimensions);
        this.canvas = new WorldCanvas(worldDimensions);
        canvas.setWorld(world);
        this.add(canvas,BorderLayout.CENTER);
        this.add(footerLabel,BorderLayout.PAGE_END);
        prepareMe();
        pack();
        ControllerThreadDesktop control = new ControllerThreadDesktop(
            this.canvas, this.world,this);
        addWindowListener(control);
        control.start();
        showMe();
    }

}
