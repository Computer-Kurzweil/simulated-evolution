package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.world.WorldPoint;

import java.io.Serializable;
import java.util.Random;

/**
 * The Cell of one Bacterium.
 * It's state is position, orientation and LifeCycle.
 * The Cell has a CellCore with the DNA Genome for Moving around.
 *
 * @see CellCore
 * @see LifeCycle
 * @see LifeCycleStatus
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 19:06:43
 */
@Log4j2
@ToString(exclude = {"random"})
@EqualsAndHashCode(exclude = {"random"})
public class Cell implements Serializable {

    private static final long serialVersionUID = 242L;

    /**
     * Contains the DNA for Random based Moving
     */
    private CellCore cellCore;

    /**
     * The Cell's state is position, orientation and LifeCycle
     */
    private WorldPoint position;

    /**
     * The Cell's state is position, orientation and LifeCycle
     */
    private Orientation orientation;

    /**
     * The Cell's state is position, orientation and LifeCycle
     */
    private LifeCycle lifeCycle;

    /**
     * The World Dimensions in which this Cell can move.
     */
    private WorldPoint max;

    /**
     * Random Generator is set from outside by Constructor.
     */
    private Random random;

    public Cell(WorldPoint max, WorldPoint position, Random random) {
        this.max = new WorldPoint(max);
        this.position = new WorldPoint(position);
        this.random = random;
        this.cellCore = new CellCore(random);
        this.max.killNagative();
        this.position.setX(random.nextInt() % max.getX());
        this.position.setY(random.nextInt() % max.getY());
        this.position.killNagative();
        this.orientation = getRandomOrientation();
        this.lifeCycle = new LifeCycle();
    }

    private Cell(int fat, CellCore rna, WorldPoint position, WorldPoint max, Random random) {
        lifeCycle = new LifeCycle(fat);
        this.max = new WorldPoint(max);
        this.position = new WorldPoint(position);
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
        if(lifeCycle.move()){
            getNextOrientation();
            position.add(orientation.getMove());
            position.add(max);
            position.normalize(max);
        }
    }

    /**
     * After performing Reproduction by Cell Division this Cell is one of the two Children this Method returns the other Child.
     *
     * @see CellCore#performMitosis()
     *
     * @return the other Child
     */
    public Cell performReproductionByCellDivision() {
        CellCore rna = cellCore.performMitosis();
        lifeCycle.haveSex();
        Cell child = new Cell(lifeCycle.getFat(), rna, position, max, random);
        return child;
    }

    /**
     * @return The new Position after the last move.
     */
    public WorldPoint getPosition() {
        return position;
    }

    /**
     * @return true, if this Cell is able to perform Reproduction by Cell Division
     */
    public boolean isPregnant() {
        return lifeCycle.isPregnant();
    }

    public boolean isYoungAndFat() {
        return lifeCycle.isYoungAndFat();
    }

    /**
     * Eat the available Food in this Position
     * @param food the available Food in this Position
     */
    public void eat(int food) {
        lifeCycle.eat(food);
    }

    /**
     * @return true, if this Cell died of hunger
     */
    public boolean died() {
        return lifeCycle.isDead();
    }

    /**
     * @return the LifeCycleStatus of this Cell
     */
    public LifeCycleStatus getLifeCycleStatus(){
        return lifeCycle.getLifeCycleStatus();
    }

}
