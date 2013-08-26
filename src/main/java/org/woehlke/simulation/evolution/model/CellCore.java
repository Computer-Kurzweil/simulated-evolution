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
    private int[] dna = new int[Dna.values().length];
    private int MAX_VALUE = 16;
    private int MAX_INITIAL_VALUE = 8;
    private Random random;

    public CellCore(Random random) {
        this.random = random;
        for (i = 0; i < Dna.values().length; i++) {
            dna[i] = random.nextInt() % MAX_INITIAL_VALUE;
        }
    }

    private CellCore(Random random, int[] rna) {
        this.random = random;
        dna=rna;
    }

    private int baseIndex;

    public CellCore mitosisFactory() {
        int[] rna = new int[Dna.values().length];
        for (i = 0; i < Dna.values().length; i++) {
            rna[i]=dna[i];
        }
        CellCore child = new CellCore(random, rna);
        baseIndex = random.nextInt() % Dna.values().length;
        if (baseIndex < 0) {
            baseIndex *= -1;
        }
        this.decrease(Dna.values()[baseIndex]);
        child.increase(Dna.values()[baseIndex]);
        return child;
    }

    private void increase(Dna base) {
        if (dna[base.ordinal()] == MAX_VALUE) {
            for (i = 0; i < dna.length; i++) {
                dna[i]--;
            }
        }
        dna[base.ordinal()]++;
    }

    private void decrease(Dna base) {
        if (dna[base.ordinal()] == -MAX_VALUE) {
            for (i = 0; i < dna.length; i++) {
                dna[i]++;
            }
        }
        dna[base.ordinal()]--;
    }

    private double[] rna = new double[Dna.values().length];
    private int i = 0;
    private double sumDna = 0.0;
    private int newInt = 0;
    private double sumRandom;
    private double val;
    private double sum;
    private Dna orientation = Dna.FORWARD;

    public Dna getRandomOrientation() {
        for (i = 0; i < Dna.values().length; i++) {
            val = dna[i] ^ 2;
            if (val < 0) {
                val *= -1;
            }
            sumDna += val;
        }
        sum = 0.0;
        for (i = 0; i < Dna.values().length; i++) {
            val = dna[1] ^ 2;
            if (val < 0) {
                val *= -1;
            }
            sum += val / sumDna;
            rna[i] = sum / 1;
        }
        if (sumDna != 0) {
            val =  random.nextInt(MAX_VALUE) ^ 2;
            if (val < 0) {
                val *= -1;
            }
            sumRandom = val / (MAX_VALUE ^ 2);
            if (sumRandom < 0) {
                sumRandom *= -1;
            }
            newInt = 0;
            for (int i = 0; i < Dna.values().length; i++) {
                if (sumRandom > rna[i]) {
                    newInt = i;
                }
            }
            orientation = Dna.values()[newInt];
        }
        return orientation;
    }
}
