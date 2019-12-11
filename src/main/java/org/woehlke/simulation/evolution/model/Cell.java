package org.woehlke.simulation.evolution.model;

import java.io.Serializable;
import java.util.Random;

/**
 * The Cell of one Bacterium.
 * It's state is position, orientation and LifeCycle.
 * The Cell has a CellCore with the DNA Genome for Moving around.
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 19:06:43
 * @see org.woehlke.simulation.evolution.model.CellCore
 * @see org.woehlke.simulation.evolution.model.LifeCycle
 * @see org.woehlke.simulation.evolution.model.LifeCycleStatus
 * <p>
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 */
public class Cell {

  private static final long serialVersionUID = -7194182402841173981L;

  /**
   * Contains the DNA for Random based Moving.
   */
  private CellCore cellCore;

  /**
   * The Cell's state is position, orientation and LifeCycle.
   */
  private Point position;

  /**
   * The Cell's state is position, orientation and LifeCycle.
   */
  private Orientation orientation;

  /**
   * The Cell's state is position, orientation and LifeCycle.
   */
  private LifeCycle lifeCycle;

  /**
   * The World Dimensions in which this Cell can move.
   */
  private final Point worldDimensions;

  /**
   * Random Generator is set from outside by Constructor.
   */
  private Random random;

  public Cell(Point worldDimensions, Point position, Random random) {
    this.worldDimensions = new Point(worldDimensions);
    this.position = new Point(position);
    this.random = random;
    this.cellCore = new CellCore(random);
    this.worldDimensions.absoluteValue();
    this.position.setX(random.nextInt() % worldDimensions.getX());
    this.position.setY(random.nextInt() % worldDimensions.getY());
    this.position.absoluteValue();
    this.orientation = getRandomOrientation();
    this.lifeCycle = new LifeCycle();
  }

  private Cell(int fat, CellCore rna, Point position, Point worldDimensions, Random random) {
    lifeCycle = new LifeCycle(fat);
    this.worldDimensions = new Point(worldDimensions);
    this.position = new Point(position);
    this.random = random;
    this.cellCore = rna;
    orientation = getRandomOrientation();
  }

  private Orientation getRandomOrientation() {
    int dnaLength = Orientation.values().length;
    int dnaBase = random.nextInt(dnaLength);
    if (dnaBase < 0) {
      dnaBase *= -1;
    }
    return Orientation.values()[dnaBase];
  }

  private void getNextOrientation() {
    Orientation randomOrientation = cellCore.getRandomOrientation();
    int iOrientation = orientation.ordinal();
    int iRandomOrientation = randomOrientation.ordinal();
    int newOrientation = (iOrientation + iRandomOrientation) % Orientation.values().length;
    orientation = Orientation.values()[newOrientation];
  }

  /**
   * The Cell moves on the Step in a Direction choosen by Random and DNA.
   */
  public void move() {
    if (lifeCycle.move()) {
      getNextOrientation();
      position.add(orientation.getMove());
      position.add(worldDimensions);
      position.normalize(worldDimensions);
    }
  }

  /**
   * After performing Reproduction by Cell Division this Cell is one of the two Children this Method
   * returns the other Child.
   *
   * @return the other Child
   * @see CellCore#performMitosis()
   */
  public Cell performReproductionByCellDivision() {
    CellCore rna = cellCore.performMitosis();
    lifeCycle.haveSex();
    Cell child = new Cell(lifeCycle.getFat(), rna, position, worldDimensions, random);
    return child;
  }

  /**
   * @return The new Position after the last move.
   */
  public Point getPosition() {
    return position;
  }

  /**
   * @return true, if this Cell is able to perform Reproduction by Cell Division.
   */
  public boolean isPregnant() {
    return lifeCycle.isPregnant();
  }

  /**
   * Eat the available Food in this Position.
   *
   * @param food the available Food in this Position
   */
  public void eat(int food) {
    lifeCycle.eat(food);
  }

  /**
   * @return true, if this Cell died of hunger.
   */
  public boolean died() {
    return lifeCycle.isDead();
  }

  /**
   * @return the LifeCycleStatus of this Cell.
   */
  public LifeCycleStatus getLifeCycleStatus() {
    return lifeCycle.getLifeCycleStatus();
  }

}
