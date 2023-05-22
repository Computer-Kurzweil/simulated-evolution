package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticePoint;

import java.io.Serializable;
import java.util.Random;

/**
 * The Cell of one Bacterium.
 * It's state is position, orientation and LifeCycle.
 * The Cell has a CellCore with the DNA Genome for Moving around.
 *
 * @see CellCoreOriginal
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
public class CellOriginal extends Cell implements Serializable {

    static final long serialVersionUID = 242L;

    public CellOriginal(LatticePoint max, LatticePoint position, Random random) {
        this.max = new LatticePoint(max);
        this.position = new LatticePoint(position);
        this.random = random;
        this.cellCore = CellCore.createCellCore(random);
        this.max.makePositive();
        this.position.setX(random.nextInt() % max.getX());
        this.position.setY(random.nextInt() % max.getY());
        this.position.makePositive();
        this.orientation = getRandomOrientation();
        this.lifeCycle = new LifeCycle();
        this.generation = 1L;
    }

    private CellOriginal(int fat, long generation, CellCore rna, LatticePoint position, LatticePoint max, Random random) {
        this.generation = generation;
        this.lifeCycle = new LifeCycle(fat);
        this.max = new LatticePoint(max);
        this.position = new LatticePoint(position);
        this.random = random;
        this.cellCore = rna;
        this.orientation = getRandomOrientation();
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
    @Override
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
     * @see CellCoreOriginal#performMitosis()
     *
     * @return the other Child
     */
    @Override
    public CellOriginal performReproductionByCellDivision() {
        CellCore rna = cellCore.performMitosis();
        lifeCycle.haveSex();
        long newGeneration = this.generation + 1L;
        CellOriginal child = new CellOriginal(lifeCycle.getFat(), newGeneration, rna, position, max, random);
        return child;
    }
}
