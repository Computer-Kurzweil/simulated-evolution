package org.woehlke.simulation.evolution.statistics;

import org.woehlke.simulation.evolution.SimulatedEvolutionConfig;
import org.woehlke.simulation.evolution.control.ControllerThreadDesktop;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * TODO write doc.
 */
public class LifeCycleCountContainer {

  /**
   * TODO write doc.
   */
  private volatile ConcurrentLinkedQueue<LifeCycleCount> count;

  /**
   * TODO write doc.
   */
  private volatile SimulatedEvolutionConfig simulatedEvolutionConfig;

  /**
   * TODO write doc.
   */
  private volatile LifeCycleCount lifeCycleCount;

  /**
   * TODO write doc.
   */
  private volatile ControllerThreadDesktop controller;

  /**
   * TODO write doc.
   */
  private volatile long worldIteration;

  public LifeCycleCountContainer(SimulatedEvolutionConfig simulatedEvolutionConfig) {
    this.simulatedEvolutionConfig = simulatedEvolutionConfig;
    count = new ConcurrentLinkedQueue<>();
    worldIteration = 0L;
  }

  /**
   * TODO write doc.
   */
  public void addController(ControllerThreadDesktop controller) {
    this.controller = controller;
  }

  /**
   * TODO write doc.
   */
  public synchronized void add(LifeCycleCount lifeCycleCount) {
    this.lifeCycleCount = lifeCycleCount;
    count.add(lifeCycleCount);
    if (count.size() > simulatedEvolutionConfig.getStatisticsConfig().getQueueMaxLength()) {
      count.poll();
    }
    worldIteration++;
    if(controller!=null){
      controller.updateLifeCycleCount();
    }
    //System.out.println(worldIteration + " : " + lifeCycleCount);
  }

  public long getWorldIteration() {
    return worldIteration;
  }

  public LifeCycleCount getLifeCycleCount() {
    if(lifeCycleCount==null){
      lifeCycleCount = new LifeCycleCount();
    }
    return lifeCycleCount;
  }

  public ControllerThreadDesktop getController() {
    return controller;
  }
}
