package org.woehlke.simulation.evolution.control;

import org.woehlke.simulation.evolution.config.GuiConfigDefault;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

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
public class ControllerThreadDesktop extends Thread implements Runnable,
  WindowListener,
  WindowFocusListener,
  WindowStateListener,
  GuiConfigDefault {

  /**
   * Time to Wait in ms.
   */
  protected final int TIME_TO_WAIT = 100;

  /**
   * Control for Threading.
   */
  private Boolean mySemaphore;

  private final ObjectRegistry ctx;

  public ControllerThreadDesktop(ObjectRegistry ctx) {
    this.ctx = ctx;
    this.mySemaphore = Boolean.TRUE;
  }

  public void run() {
    show();
    boolean doMyJob = true;
    do {
      synchronized (mySemaphore) {
        doMyJob = mySemaphore.booleanValue();
      }
      ctx.getWorld().letLivePopulation();
      ctx.getCanvas().repaint();
      try {
        sleep(TIME_TO_WAIT);
      } catch (InterruptedException e) {
        System.out.println(e.getLocalizedMessage());
      }
    }
    while (doMyJob);
  }

  protected void show() {
    this.ctx.getFrame().showMe();
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
    this.exit();
    System.exit(EXIT_STATUS);
  }

  public void windowClosed(WindowEvent e) {
    this.exit();
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
    if (e.getSource() == ctx.getFrame()) {
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

  public void updateLifeCycleCount() {
    ctx.getPanelLifeCycleStatus().updateLifeCycleCount();
  }

  public void exit() {
    synchronized (mySemaphore) {
      mySemaphore = Boolean.FALSE;
    }
  }

  public void increaseFoodPerDay() {
    ctx.getWorldMapFoodConfig().increaseFoodPerDay();
  }

  public void decreaseFoodPerDay() {
    ctx.getWorldMapFoodConfig().decreaseFoodPerDay();
  }

  public void toggleGardenOfEden() {
    ctx.getWorldMapFoodConfig().toggleGardenOfEden();
    ctx.getWorldMapFood().toggleGardenOfEden();
  }

  public void showStatistic() {

  }

}
