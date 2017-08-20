package org.woehlke.simulation.evolution.model;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * (C) 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 19:55:23
 */
public class CellCore {

    private List<Integer> dna;
    private int MAX_VALUE = 16;
    private int MAX_INITIAL_VALUE = 8;
    private Random random;

    public CellCore(Random random) {
        dna = new ArrayList<Integer>();
        this.random = random;
        for (int i = 0; i < Dna.values().length; i++) {
            int gen = random.nextInt() % MAX_INITIAL_VALUE;
            dna.add(gen);
        }
    }

    private CellCore(Random random, List<Integer> rna) {
        this.random = random;
        dna = new ArrayList<Integer>();
        dna.addAll(rna);
    }

    public CellCore mitosisFactory() {
        List<Integer> rna = new ArrayList<Integer>();
        for (Integer dnaBase:dna) {
            rna.add(dnaBase);
        }
        CellCore child = new CellCore(random, rna);
        int baseIndex = random.nextInt() % Dna.values().length;
        if (baseIndex < 0) {
            baseIndex *= -1;
        }
        Dna base[] = Dna.values();
        this.decrease(base[baseIndex]);
        child.increase(base[baseIndex]);
        return child;
    }

    private void increase(Dna base) {
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

    private void decrease(Dna base) {
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

    public Dna getRandomOrientation() {
        Dna orientation = Dna.FORWARD;
        int dnaLength = Dna.values().length;
        double sumDna = 0.0;
        for (int i = 0; i < dnaLength; i++) {
            double val = dna.get(i).longValue() ^ 2;
            if (val < 0) {
                val *= -1;
            }
            sumDna += val;
        }
        double sum = 0.0;
        double[] rna = new double[dnaLength];
        for (int i = 0; i < dnaLength; i++) {
            double val = dna.get(i).longValue() ^ 2;
            if (val < 0) {
                val *= -1;
            }
            sum += val / sumDna;
            rna[i] = sum;
        }
        if (sumDna != 0) {
            double val = new Double(random.nextInt(MAX_VALUE) ^ 2);
            if (val < 0) {
                val *= -1;
            }
            double sumRandom = val / new Double(MAX_VALUE ^ 2);
            if (sumRandom < 0) {
                sumRandom *= -1;
            }
            int newInt = 0;
            for (int i = 0; i < dnaLength; i++) {
                if (sumRandom > rna[i]) {
                    newInt = i;
                }
            }
            orientation = Dna.values()[newInt];
        }
        return orientation;
    }
}
