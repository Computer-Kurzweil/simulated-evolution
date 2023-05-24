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
        for (int i = 0; i < getDnaLength(); i++) {
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
        List<Integer> rna = generateRNA();
        CellCoreOriginal childCore = generateChildCore(rna);
        positionDNAHeader(childCore);
        return childCore;
    }

    private List<Integer> generateRNA() {
        List<Integer> rna = new ArrayList<Integer>();
        for (Integer dnaBase:dna) {
            rna.add(dnaBase);
        }
        return rna;
    }

    private CellCoreOriginal generateChildCore(List<Integer> rna) {
        return new CellCoreOriginal(random, rna);
    }

    private void positionDNAHeader(CellCoreOriginal childCore) {
        int baseIndex = getBaseIndexOfDNA();
        if (baseIndex < MIN_VALUE) {
            baseIndex *= -1;
        }
        Orientation base[] = Orientation.values();
        this.decrease(base[baseIndex]);
        childCore.increase(base[baseIndex]);
    }

    private int getBaseIndexOfDNA() {
        return random.nextInt() % getDnaLength();
    }

    private int getDnaLength() {
        return Orientation.values().length;
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
    @Override
    public Orientation getRandomOrientation() {
        Orientation orientation = Orientation.FORWARD;
        int dnaLength = getDnaLength();
        double massOfDNA = 0.0;
        double sum = 0.0;
        double[] rna = new double[dnaLength];

        for (int i = 0; i < dnaLength; i++) {
            double base = Math.abs(dna.get(i).longValue() ^ 2);
            massOfDNA += base;
        }
        for (int i = 0; i < dnaLength; i++) {
            double base = Math.abs(dna.get(i).longValue() ^ 2);
            sum += base / massOfDNA;
            rna[i] = sum;
        }
        return getRandomOrientation(orientation, dnaLength, massOfDNA, rna);
    }

    private Orientation getRandomOrientation(Orientation orientation, int dnaLength, double massOfDNA, double[] rna) {
        boolean DNAexist = (massOfDNA != 0);
        if (DNAexist) {
            double val = Math.abs(Double.valueOf(random.nextInt(MAX_VALUE) ^ 2));
            double sumRandom = Math.abs(val / Double.valueOf(MAX_VALUE ^ 2));
            int nextOrientationIndex = 0;
            for (int i = 0; i < dnaLength; i++) {
                if (sumRandom > rna[i]) {
                    nextOrientationIndex = i;
                }
            }
            orientation = Orientation.values()[nextOrientationIndex];
        }
        return orientation;
    }
}
