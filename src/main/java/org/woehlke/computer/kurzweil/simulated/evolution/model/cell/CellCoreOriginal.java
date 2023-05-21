package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * The CellCore contains the DNA which has influence on orientation at moving.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 04.02.2006
 * Time: 19:55:23
 */
@Log4j2
@ToString(exclude = {"random"})
@EqualsAndHashCode(exclude = {"random"})
public class CellCoreOriginal extends CellCore implements Serializable{

    static final long serialVersionUID = 242L;

    /**
     * The DNA Values of the Genome.
     */

    /**
     * Random Generator is set from outside by Constructor.
     */

    public CellCoreOriginal(Random random) {
        dna = new ArrayList<Integer>();
        this.random = random;
        for (int i = 0; i < Orientation.values().length; i++) {
            int gen = random.nextInt() % MAX_INITIAL_VALUE;
            dna.add(gen);
        }
    }

    private CellCoreOriginal(Random random, List<Integer> rna) {
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
    @Override
    public CellCoreOriginal performMitosis() {
        List<Integer> rna = new ArrayList<Integer>();
        for (Integer dnaBase:dna) {
            rna.add(dnaBase);
        }
        CellCoreOriginal child = new CellCoreOriginal(random, rna);
        int baseIndex = random.nextInt() % Orientation.values().length;
        if (baseIndex < MIN_VALUE) {
            baseIndex *= -1;
        }
        Orientation base[] = Orientation.values();
        this.decrease(base[baseIndex]);
        child.increase(base[baseIndex]);
        return child;
    }

    /**
     * @return gives a new Orientation based on the Combinition of Random and DNA.
     */
    @Override
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
}
