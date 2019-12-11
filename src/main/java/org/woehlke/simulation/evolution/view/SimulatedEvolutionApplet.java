package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfig;
import org.woehlke.simulation.evolution.control.ControllerThreadApplet;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.SimulatedEvolutionConfig;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * The Container for running the Simulation.
 * It containes a World Data Model, a Controller Thread and a WorldCanvas View.
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * (C) 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 *
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:33:14
 */
public class SimulatedEvolutionApplet extends JApplet
  implements ImageObserver, MenuContainer, Serializable, Accessible, GuiConfig {

  private static final long serialVersionUID = -8586633326682669768L;

  /**
   * ControllerThreadApplet for Interachtions between Model and View (MVC-Pattern).
   */
  private ControllerThreadApplet controllerThreadApplet;

  /**
   * The View for the World. Food and Cells are painted to the Canvas.
   */
  private WorldCanvas canvas;

  /**
   * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
   */
  private World world;

  /**
   * TODO: write doc.
   */
  private SimulatedEvolutionConfig simulatedEvolutionConfig = new SimulatedEvolutionConfig();

  private BorderLayout layout = new BorderLayout();

  private JLabel titleLabel;

  public void init() {
    this.titleLabel = new JLabel(this.simulatedEvolutionConfig.getTitle());
    this.rootPane.setLayout(layout);
    this.rootPane.add(titleLabel, BorderLayout.NORTH);
    this.world = new World(this.simulatedEvolutionConfig);
    this.canvas = new WorldCanvas(world);
    this.rootPane.add(canvas, BorderLayout.CENTER);
    this.controllerThreadApplet = new ControllerThreadApplet(world, canvas);
    this.controllerThreadApplet.start();
  }

  public void destroy() {
  }

  public void stop() {
  }

}
