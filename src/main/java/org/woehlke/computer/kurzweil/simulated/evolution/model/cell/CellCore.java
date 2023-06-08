package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import java.util.List;
import java.util.Random;

abstract public class CellCore {
    public static CellCoreOriginal createCellCore(Random random) {
        return new CellCoreOriginal(random);
    }

    protected Random random;

    protected List<Integer> dna;

    protected int MIN_VALUE = 0;
    protected int MAX_VALUE = 16;
    protected int MAX_INITIAL_VALUE = 8;

    public abstract CellCore performMitosis();

    public abstract Orientation getRandomOrientation();

}
