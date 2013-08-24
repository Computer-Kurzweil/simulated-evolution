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
    private int maxValue = 16;
    private int maxInitialValue = 8;
    private Random random;

    public CellCore(Random random) {
        dna = new ArrayList<Integer>();
        this.random = random;
        birth();
    }

    public CellCore(Random random, int maxValue, int maxInitialValue) {
        dna = new ArrayList<Integer>();
        this.random = random;
        this.maxValue = maxValue;
        this.maxInitialValue = maxInitialValue;
        birth();
    }

    private CellCore(Random random, List<Integer> rna) {
        this.random = random;
        dna = new ArrayList<Integer>();
        dna.addAll(rna);
    }

    private void birth() {
        for (int i = 0; i < Dna.values().length; i++) {
            int gen = random.nextInt() % maxInitialValue;
            dna.add(gen);
        }
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
        if (value == maxValue) {
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
        if (value == -maxValue) {
            for (int i = 0; i < dna.size(); i++) {
                Integer val = dna.get(i);
                val++;
                dna.set(i, val);
            }
        }
        dna.set(base.ordinal(), 0);
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
            //System.out.print("rna:"+rna[i]);
        }
        //System.out.println();
        if (sumDna != 0) {
            double val = new Double(random.nextInt(maxValue) ^ 2);
            if (val < 0) {
                val *= -1;
            }
            double sumRandom = val / new Double(maxValue ^ 2);
            //System.out.println("sumRandom "+sumRandom);
            if (sumRandom < 0) {
                sumRandom *= -1;
            }
            int newInt = 0;
            for (int i = 0; i < dnaLength; i++) {
                if (sumRandom > rna[i]) {
                    //System.out.print(i+":");
                    newInt = i;
                }
            }
            orientation = Dna.values()[newInt];
        }
        //System.out.println(orientation+" "+sumDna);
        return orientation;
    }

    public int getMaxInitialValue() {
        return maxInitialValue;
    }

    public void setMaxInitialValue(int maxInitialValue) {
        this.maxInitialValue = maxInitialValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
}
