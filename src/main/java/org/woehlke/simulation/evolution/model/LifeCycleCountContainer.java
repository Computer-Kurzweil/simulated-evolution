package org.woehlke.simulation.evolution.model;

import org.woehlke.simulation.evolution.control.ObjectRegistry;

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
  private volatile LifeCycleCount lifeCycleCount;


  /**
   * TODO write doc.
   */
  private volatile long worldIteration;

  private ObjectRegistry ctx;

  public LifeCycleCountContainer(ObjectRegistry ctx) {
    this.ctx = ctx;
    count = new ConcurrentLinkedQueue<>();
    worldIteration = 0L;
  }

  /**
   * TODO write doc.
   */
  public synchronized void add(LifeCycleCount lifeCycleCount) {
    this.lifeCycleCount = lifeCycleCount;
    count.add(lifeCycleCount);
    if (count.size() > ctx.getStatisticsConfig().getQueueMaxLength()) {
      count.poll();
    }
    worldIteration++;
    if(ctx.getController()!=null){
      ctx.getController().updateLifeCycleCount();
    }
    //System.out.println(worldIteration + " : " + lifeCycleCount);
  }

  public LifeCycleCount getLifeCycleCount() {
    if(lifeCycleCount==null){
      lifeCycleCount = new LifeCycleCount();
    }
    return lifeCycleCount;
  }

}
