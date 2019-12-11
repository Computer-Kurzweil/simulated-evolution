package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.Preparable;
import org.woehlke.simulation.evolution.config.GuiConfig;
import org.woehlke.simulation.evolution.SimulatedEvolutionConfig;
import org.woehlke.simulation.evolution.control.ControllerThreadDesktop;
import org.woehlke.simulation.evolution.model.World;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * This Frame wraps the SimulatedEvolutionApplet which is the Container for this Simulation.
 *
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:47:46
 * @see SimulatedEvolutionApplet
 * @see javax.swing.JFrame
 * @see java.awt.image.ImageObserver
 * @see java.awt.event.WindowListener
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 */
public class SimulatedEvolutionFrame extends JFrame implements ImageObserver,
  MenuContainer,
  Serializable,
  Runnable,
  Preparable,
  GuiConfig {

  private static final long serialVersionUID = -3830377190196972207L;

  private final SimulatedEvolutionConfig simulatedEvolutionConfig;

  /**
   * The View for the World. Food and Cells are painted to the Canvas.
   */
  private final WorldCanvas canvas;

  /**
   * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
   */
  private final World world;

  /**
   * TODO write doc.
   */
  private final ControllerThreadDesktop controller;

  private final PanelNorth panelNorth;
  private final PanelSouth panelSouth;

  private final BorderLayout layoutSimulatedEvolutionFrame = new BorderLayout();

  public void prepareMe() {
    this.setBounds(this.simulatedEvolutionConfig.getFrameRectangle());
  }

  public void prepareAll() {
    this.canvas.prepareMe();
    this.panelNorth.prepareMe();
    this.panelSouth.prepareMe();
    this.prepareMe();
  }

  public void showMe() {
    prepareAll();
    setVisible(true);
    toFront();
  }

  public SimulatedEvolutionFrame(SimulatedEvolutionConfig simulatedEvolutionConfig) {
    super(simulatedEvolutionConfig.getTitle());
    this.simulatedEvolutionConfig = simulatedEvolutionConfig;
    this.panelSouth = new PanelSouth(simulatedEvolutionConfig);
    this.panelNorth = new PanelNorth(simulatedEvolutionConfig);
    this.world = new World(simulatedEvolutionConfig);
    this.canvas = new WorldCanvas(this.world);
    rootPane.setLayout(layoutSimulatedEvolutionFrame);
    rootPane.add(panelNorth, BorderLayout.NORTH);
    rootPane.add(canvas, BorderLayout.CENTER);
    rootPane.add(panelSouth, BorderLayout.SOUTH);
    prepareAll();
    pack();
    controller = new ControllerThreadDesktop(
      this.canvas, this.world, this
    );
    addWindowListener(controller);
  }

  @Override
  public void run() {
    controller.start();
    showMe();
  }
}
