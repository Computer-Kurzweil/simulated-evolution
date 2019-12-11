package org.woehlke.simulation.evolution.statistics;

import org.woehlke.simulation.evolution.model.LifeCycleStatus;

import java.io.Serializable;

/**
 * TODO write doc.
 */
public class LifeCycleCount {

  /**
   * TODO write doc.
   */
  private int youngCells;

  /**
   * TODO write doc.
   */
  private int youngAndFatCells;

  /**
   * TODO write doc.
   */
  private int fullAgeCells;

  /**
   * TODO write doc.
   */
  private int hungryCells;

  /**
   * TODO write doc.
   */
  private int oldCells;

  /**
   * TODO write doc.
   */
  private int deadCells;

  /**
   * TODO write doc.
   */
  private int population;

  /**
   * TODO write doc.
   */
  public void countStatusOfOneCell(LifeCycleStatus status) {
    population++;
    switch (status) {
      case YOUNG:
        youngCells++;
        break;
      case YOUNG_AND_FAT:
        youngAndFatCells++;
        break;
      case FULL_AGE:
        fullAgeCells++;
        break;
      case HUNGRY:
        hungryCells++;
        break;
      case OLD:
        oldCells++;
        break;
      case DEAD:
        deadCells++;
        break;
    }
  }

  public int getYoungCells() {
    return youngCells;
  }

  public void setYoungCells(int youngCells) {
    this.youngCells = youngCells;
  }

  public int getYoungAndFatCells() {
    return youngAndFatCells;
  }

  public void setYoungAndFatCells(int youngAndFatCells) {
    this.youngAndFatCells = youngAndFatCells;
  }

  public int getFullAgeCells() {
    return fullAgeCells;
  }

  public void setFullAgeCells(int fullAgeCells) {
    this.fullAgeCells = fullAgeCells;
  }

  public int getHungryCells() {
    return hungryCells;
  }

  public void setHungryCells(int hungryCells) {
    this.hungryCells = hungryCells;
  }

  public int getOldCells() {
    return oldCells;
  }

  public void setOldCells(int oldCells) {
    this.oldCells = oldCells;
  }

  public int getDeadCells() {
    return deadCells;
  }

  public void setDeadCells(int deadCells) {
    this.deadCells = deadCells;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  @Override
  public String toString() {
    return "LifeCycleCount{" +
      "young=" + youngCells +
      ", youngAndFat=" + youngAndFatCells +
      ", fullAge=" + fullAgeCells +
      ", hungry=" + hungryCells +
      ", old=" + oldCells +
      ", total=" + population +
      '}';
  }
}
