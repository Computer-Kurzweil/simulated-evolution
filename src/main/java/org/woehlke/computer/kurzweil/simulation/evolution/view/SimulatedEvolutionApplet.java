package org.woehlke.computer.kurzweil.simulation.evolution.view;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulation.evolution.control.ControllerThread;
import org.woehlke.computer.kurzweil.simulation.evolution.model.WorldPoint;
import org.woehlke.computer.kurzweil.simulation.evolution.model.WorldModel;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * The Container for running the Simulation.
 * It containes a World Data Model, a Controller Thread and a WorldCanvas View.
 *
 * (C) 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:33:14
 */
@SuppressWarnings({"deprecation"})
@Log4j2
@ToString
@EqualsAndHashCode(callSuper = false)
public class SimulatedEvolutionApplet extends JApplet implements ImageObserver, MenuContainer, Serializable, Accessible {

    static final long serialVersionUID = 242L;

    private Label title = new Label("      Artificial Life Simulation of Bacteria Motion depending on DNA - (C) 2013 Thomas Woehlke");

    /**
     * ControllerThread for Interachtions between Model and View (MVC-Pattern).
     */
    private ControllerThread controllerThread;

    /**
     * The View for the World. Food and Cells are painted to the Canvas.
     */
    private WorldCanvas canvas;

    /**
     * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
     */
    private WorldModel worldModel;

    public void init() {
        int scale = 2;
        int width = 320 * scale;
        int height = 234 * scale;
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        controllerThread = new ControllerThread();
        WorldPoint worldDimensions = new WorldPoint(width,height);
        worldModel = new WorldModel(worldDimensions);
        canvas = new WorldCanvas(worldDimensions);
        canvas.setWorldModel(worldModel);
        this.add(canvas, BorderLayout.CENTER);
        controllerThread.setCanvas(canvas);
        controllerThread.setWorldModel(worldModel);
        controllerThread.start();
    }

    public void destroy() {
    }

    public void stop() {
    }

    public WorldPoint getCanvasDimensions() {
        return canvas.getWorldDimensions();
    }
}
