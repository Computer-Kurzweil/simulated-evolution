package org.woehlke.simulation.evolution.control;

import org.woehlke.simulation.evolution.config.GuiConfigDefault;
import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.view.SimulatedEvolutionFrame;
import org.woehlke.simulation.evolution.view.WorldCanvas;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.Serializable;

/**
 * The ControllerThreadApplet controls the Interactions between Model and View (MVC-Pattern).
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * &copy; 2006 - 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 *
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class ControllerThreadDesktop extends ControllerThreadApplet implements Runnable,
  Serializable,
  WindowListener,
  WindowFocusListener,
  WindowStateListener,
  GuiConfigDefault {

  private static final long serialVersionUID = -7066881081524661452L;

  private final SimulatedEvolutionFrame simulatedEvolutionFrame;

  public ControllerThreadDesktop(
    WorldCanvas canvas,
    World world,
    SimulatedEvolutionFrame simulatedEvolutionFrame
  ) {
    super(world, canvas);
    this.simulatedEvolutionFrame = simulatedEvolutionFrame;
  }

  protected void show() {
    this.simulatedEvolutionFrame.showMe();
  }

  public void windowOpened(WindowEvent e) {
    show();
  }

  public void windowDeiconified(WindowEvent e) {
    show();
  }

  public void windowActivated(WindowEvent e) {
    show();
  }

  public void windowClosing(WindowEvent e) {
    super.exit();
    System.exit(EXIT_STATUS);
  }

  public void windowClosed(WindowEvent e) {
    super.exit();
    System.exit(EXIT_STATUS);
  }

  public void windowIconified(WindowEvent e) {
  }

  public void windowDeactivated(WindowEvent e) {
  }

  @Override
  public void windowGainedFocus(WindowEvent e) {
    show();
  }

  @Override
  public void windowLostFocus(WindowEvent e) {

  }

  @Override
  public void windowStateChanged(WindowEvent e) {
    if (e.getSource() == this.simulatedEvolutionFrame) {
      switch (e.getNewState()) {
        case Frame.MAXIMIZED_BOTH:
        case Frame.MAXIMIZED_HORIZ:
        case Frame.MAXIMIZED_VERT:
        case Frame.NORMAL:
          show();
          break;
        default:
          break;
      }
    }
  }
}
