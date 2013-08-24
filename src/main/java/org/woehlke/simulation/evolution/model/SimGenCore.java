package org.woehlke.simulation.evolution.model;

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 19:55:23
 */
public class SimGenCore {
    private ArrayList<Integer> dna;
    private int maxValue = 16;
    private int maxInitialValue = 8;
    private Random random;

    public SimGenCore(Random random) {
        dna = new ArrayList<Integer>();
        //this.random=new Random();
        //this.random.setSeed(random.nextLong());
        this.random = random;
        birth();
    }

    public SimGenCore(Random random, int maxValue, int maxInitialValue) {
        dna = new ArrayList<Integer>();
        //this.random=new Random();
        //this.random.setSeed(random.nextLong());
        this.random = random;
        this.maxValue = maxValue;
        this.maxInitialValue = maxInitialValue;
        birth();
    }

    private SimGenCore(Random random, ArrayList<Integer> rna) {
        //this.random=new Random();
        //this.random.setSeed(random.nextLong());
        this.random = random;
        dna = new ArrayList<Integer>();
        dna.addAll(rna);
    }

    private void birth() {
        for (int i = 0; i < SimGenDna.values().length; i++) {
            int gen = random.nextInt() % maxInitialValue;
            //System.out.println("Gen:"+gen);
            dna.add(gen);
        }
    }

    public SimGenCore mitosisFactory() {
        ArrayList<Integer> rna = new ArrayList<Integer>();
        Iterator<Integer> it = dna.iterator();
        while (it.hasNext()) {
            rna.add(it.next());
        }
        SimGenCore child = new SimGenCore(random, rna);
        int baseIndex = random.nextInt() % SimGenDna.values().length;
        if (baseIndex < 0) {
            baseIndex *= -1;
        }
        SimGenDna base[] = SimGenDna.values();
        this.decrease(base[baseIndex]);
        child.increase(base[baseIndex]);
        return child;
    }

    private void increase(SimGenDna base) {
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

    private void decrease(SimGenDna base) {
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

    public SimGenDna getRandomOrientation() {
        SimGenDna orientation = SimGenDna.FORWARD;
        int dnaLength = SimGenDna.values().length;
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
            orientation = SimGenDna.values()[newInt];
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
