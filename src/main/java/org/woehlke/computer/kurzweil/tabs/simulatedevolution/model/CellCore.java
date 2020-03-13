package org.woehlke.computer.kurzweil.tabs.simulatedevolution.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * The CellCore contains the DNA which has influence on orientation at moving.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 19:55:23
 */
@Log4j2
@ToString(exclude = {"random"})
@EqualsAndHashCode(exclude = {"random"})
public class CellCore {

    /**
     * The DNA Values of the Genome.
     */
    private List<Integer> dna;

    private final static int MIN_VALUE = 0;
    private final static int MAX_VALUE = 16;
    private final static int MAX_INITIAL_VALUE = 8;

    /**
     * Random Generator is set from outside by Constructor.
     */
    private Random random;

    public CellCore(Random random) {
        dna = new ArrayList<Integer>();
        this.random = random;
        for (int i = 0; i < Orientation.values().length; i++) {
            int gen = random.nextInt() % MAX_INITIAL_VALUE;
            dna.add(gen);
        }
    }

    private CellCore(Random random, List<Integer> rna) {
        this.random = random;
        dna = new ArrayList<Integer>();
        dna.addAll(rna);
    }

    /**
     * Mitosis is the Cell Core Division where the DNA changes for Evolution.
     * After Mitosis this Cell Core is one of the two Children.
     *
     * @see Cell#performReproductionByCellDivision()
     *
     * @return the other Child CellCore.
     */
    public CellCore performMitosis() {
        List<Integer> rna = new ArrayList<Integer>();
        for (Integer dnaBase:dna) {
            rna.add(dnaBase);
        }
        CellCore child = new CellCore(random, rna);
        int baseIndex = random.nextInt() % Orientation.values().length;
        if (baseIndex < MIN_VALUE) {
            baseIndex *= -1;
        }
        Orientation base[] = Orientation.values();
        this.decrease(base[baseIndex]);
        child.increase(base[baseIndex]);
        return child;
    }

    private void increase(Orientation base) {
        int value = dna.get(base.ordinal());
        if (value == MAX_VALUE) {
            for (int i = 0; i < dna.size(); i++) {
                Integer val = dna.get(i);
                val--;
                dna.set(i, val);
            }
        }
        Integer val = dna.get(base.ordinal());
        val++;
        dna.set(base.ordinal(), val);
    }

    private void decrease(Orientation base) {
        int value = dna.get(base.ordinal());
        if (value == -MAX_VALUE) {
            for (int i = 0; i < dna.size(); i++) {
                Integer val = dna.get(i);
                val++;
                dna.set(i, val);
            }
            dna.set(base.ordinal(), 0);
        } else {
            dna.set(base.ordinal(), value-1);
        }
    }

    /**
     * @return gives a new Orientation based on the Combinition of Random and DNA.
     */
    public Orientation getRandomOrientation() {
        Orientation orientation = Orientation.FORWARD;
        int dnaLength = Orientation.values().length;
        double sumDna = 0.0;
        for (int i = 0; i < dnaLength; i++) {
            double val = dna.get(i).longValue() ^ 2;
            if (val < MIN_VALUE) {
                val *= -1;
            }
            sumDna += val;
        }
        double sum = 0.0;
        double[] rna = new double[dnaLength];
        for (int i = 0; i < dnaLength; i++) {
            double val = dna.get(i).longValue() ^ 2;
            if (val < MIN_VALUE) {
                val *= -1;
            }
            sum += val / sumDna;
            rna[i] = sum;
        }
        if (sumDna != 0) {
            double val = Double.valueOf(random.nextInt(MAX_VALUE) ^ 2);
            if (val < MIN_VALUE) {
                val *= -1;
            }
            double sumRandom = val / Double.valueOf(MAX_VALUE ^ 2);
            if (sumRandom < MIN_VALUE) {
                sumRandom *= -1;
            }
            int newInt = 0;
            for (int i = 0; i < dnaLength; i++) {
                if (sumRandom > rna[i]) {
                    newInt = i;
                }
            }
            orientation = Orientation.values()[newInt];
        }
        return orientation;
    }
}
