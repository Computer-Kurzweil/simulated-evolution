package org.woehlke.computer.kurzweil.simulated.evolution.view;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.SimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionController;
import org.woehlke.computer.kurzweil.simulated.evolution.model.world.WorldPoint;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;

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
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 04.02.2006
 * Time: 18:33:14
 */
@SuppressWarnings({"deprecation"})
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

    private Label title = new Label(
        "      Artificial Life Simulation of Bacteria Motion depending on DNA - (C) 2022 Thomas Woehlke"
    );

    /**
     * ControllerThread for Interachtions between Model and View (MVC-Pattern).
     */
    private SimulatedEvolutionController simulatedEvolutionController;

    /**
     * The View for the World. Food and Cells are painted to the Canvas.
     */
    private SimulatedEvolutionCanvas canvas;

    /**
     * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
     */
    private SimulatedEvolutionModel simulatedEvolutionModel;

    private final ComputerKurzweilProperties computerKurzweilProperties;

    public void init() {
        int scale = 2;
        int width = 320 * scale;
        int height = 234 * scale;
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        simulatedEvolutionController = new SimulatedEvolutionController();
        WorldPoint worldDimensions = new WorldPoint(width,height);
        simulatedEvolutionModel = new SimulatedEvolutionModel(worldDimensions, this.computerKurzweilProperties);
        canvas = new SimulatedEvolutionCanvas(worldDimensions);
        canvas.setTabModel(simulatedEvolutionModel);
        this.add(canvas, BorderLayout.CENTER);
        simulatedEvolutionController.setCanvas(canvas);
        simulatedEvolutionController.setSimulatedEvolutionModel(simulatedEvolutionModel);
        simulatedEvolutionController.start();
    }

    public SimulatedEvolutionApplet(ComputerKurzweilProperties computerKurzweilProperties) {
        super();
        this.computerKurzweilProperties = computerKurzweilProperties;
    }

    public void destroy() {
    }

    public void stop() {
    }

    public WorldPoint getCanvasDimensions() {
        return canvas.getWorldDimensions();
    }
}
