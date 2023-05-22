package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.Getter;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticePoint;

import java.io.Serializable;
import java.util.Random;

public abstract class Cell implements Serializable {

    public static CellOriginal createCell(LatticePoint max, LatticePoint position, Random random) {
        return new CellOriginal(max, position, random);
    }

    /**
     * Contains the DNA for Random based Moving
     */
    protected CellCore cellCore;

    /**
     * The Cell's state is position, orientation and LifeCycle
     */
    protected LatticePoint position;

    /**
     * The Cell's state is position, orientation and LifeCycle
     */
    protected Orientation orientation;

    /**
     * The Cell's state is position, orientation and LifeCycle
     */
    protected LifeCycle lifeCycle;

    /**
     * The World Dimensions in which this Cell can move.
     */
    protected LatticePoint max;

    /**
     * Random Generator is set from outside by Constructor.
     */
    protected Random random;

    @Getter
    protected long generation;

    public abstract void move();

    public abstract CellOriginal performReproductionByCellDivision();

    /**
     * @return The new Position after the last move.
     */
    public LatticePoint getPosition() {
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
