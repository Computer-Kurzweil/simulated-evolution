package org.woehlke.simulation.evolution.statistics;

import org.woehlke.simulation.evolution.SimulatedEvolutionConfig;

import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * TODO write doc.
 */
public class LifeCycleCountContainer {

  /**
   * TODO write doc.
   */
  private final ConcurrentLinkedQueue<LifeCycleCount> count;

  /**
   * TODO write doc.
   */
  private final SimulatedEvolutionConfig simulatedEvolutionConfig;

  private long worldIteration;

  public LifeCycleCountContainer(SimulatedEvolutionConfig simulatedEvolutionConfig) {
    this.simulatedEvolutionConfig = simulatedEvolutionConfig;
    count = new ConcurrentLinkedQueue<>();
    worldIteration = 0L;
  }

  public void add(LifeCycleCount lifeCycleCount) {
    count.add(lifeCycleCount);
    if (count.size() > simulatedEvolutionConfig.getStatisticsConfig().getQueueMaxLength()) {
      count.poll();
    }
    worldIteration++;
    System.out.println(worldIteration + " : " + lifeCycleCount);
  }

  public long getWorldIteration() {
    return worldIteration;
  }
}
