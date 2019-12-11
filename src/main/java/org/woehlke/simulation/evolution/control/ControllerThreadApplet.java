package org.woehlke.simulation.evolution.control;

import org.woehlke.simulation.evolution.model.World;
import org.woehlke.simulation.evolution.view.WorldCanvas;

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
public class ControllerThreadApplet extends Thread implements Runnable {

  /**
   * Data Model for the Simulation
   */
  protected final World world;

  /**
   * Canvas, where to paint in the GUI.
   */
  protected final WorldCanvas canvas;

  /**
   * Time to Wait in ms.
   */
  protected final int TIME_TO_WAIT = 100;

  /**
   * Control for Threading
   */
  private Boolean mySemaphore;

  public ControllerThreadApplet(World world, WorldCanvas canvas) {
    this.world = world;
    this.canvas = canvas;
    this.mySemaphore = Boolean.TRUE;
  }

  protected void show(){
  }

  private volatile boolean doMyJob;

  public void run() {
    show();
    do {
      synchronized (mySemaphore) {
        doMyJob = mySemaphore.booleanValue();
      }
      world.letLivePopulation();
      canvas.repaint();
      try {
        sleep(TIME_TO_WAIT);
      } catch (InterruptedException e) {
        System.out.println(e.getLocalizedMessage());
      }
    }
    while (doMyJob);
  }

  public void exit() {
    synchronized (mySemaphore) {
      mySemaphore = Boolean.FALSE;
    }
  }

  public void increaseFoodPerDay(){
    world.getSimulatedEvolutionConfig().getWorldMapFoodConfig().increaseFoodPerDay();
  }

  public void decreaseFoodPerDay(){
    world.getSimulatedEvolutionConfig().getWorldMapFoodConfig().decreaseFoodPerDay();
  }

  public void toggleGardenOfEden(){
    world.getSimulatedEvolutionConfig().getWorldMapFoodConfig().toggleGardenOfEden();
  }
}
