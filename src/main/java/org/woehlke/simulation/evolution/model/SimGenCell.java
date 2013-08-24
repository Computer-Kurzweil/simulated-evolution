package org.woehlke.simulation.evolution.model;

import java.util.Random;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 19:06:43
 */
public class SimGenCell {
    private SimGenPoint pos;
    private SimGenPoint max;
    private Random random;
    private SimGenCore core;
    private SimGenDna orientation;

    private SimGenLifeCycle lifeCycle;

    public SimGenCell(SimGenPoint max, SimGenPoint pos, Random random) {
        this.max = new SimGenPoint(max);
        this.pos = new SimGenPoint(pos);
        //this.random = new Random();
        //this.random.setSeed(random.nextLong());
        this.random = random;
        this.core = new SimGenCore(random);
        this.max.killNagative();
        this.pos.setX(random.nextInt() % max.getX());
        this.pos.setY(random.nextInt() % max.getY());
        this.pos.killNagative();
        this.orientation = getRandomOrientation();
        this.lifeCycle = new SimGenLifeCycle();
    }

    private SimGenDna getRandomOrientation() {
        int dnaLength = SimGenDna.values().length;
        int dnaBase = random.nextInt(dnaLength);
        if (dnaBase < 0) {
            dnaBase *= -1;
        }
        return SimGenDna.values()[dnaBase];
    }

    private void getNextOrientation() {
        SimGenDna randomOrientation = core.getRandomOrientation();
        int iOrientation = orientation.ordinal();
        int iRandomOrientation = randomOrientation.ordinal();
        int newOrientation = (iOrientation + iRandomOrientation) % SimGenDna.values().length;
        orientation = SimGenDna.values()[newOrientation];
    }

    public void move() {
        //if(!lifeCycle.isNotDyingForHunger())
        //{
        lifeCycle.move();
        getNextOrientation();
        SimGenPoint move = new SimGenPoint(0, 0);
        switch (orientation) {
            case FORWARD:
                move = new SimGenPoint(0, 2);
                break;
            case RIGHT:
                move = new SimGenPoint(2, 1);
                break;
            case RIGHT_RIGHT:
                move = new SimGenPoint(2, -1);
                break;
            case BACKWARDS:
                move = new SimGenPoint(0, -2);
                break;
            case LEFT_LEFT:
                move = new SimGenPoint(-2, -1);
                break;
            case LEFT:
                move = new SimGenPoint(-2, 1);
                break;
        }
        pos.add(move);
        pos.add(max);
        pos.normalize(max);
        //int x = pos.getX()+move.getX() % max.getX();
        //int y = pos.getY()+move.getY() % max.getY();
        //pos = new SimGenPoint(x,y);
        //pos.add(move).normalize(max);
        //}
    }

    public SimGenCell cellDivisionFactory() {
        SimGenCore rna = core.mitosisFactory();
        lifeCycle.haveSex();
        SimGenCell child = new SimGenCell(lifeCycle.getFat(), rna, pos, max, random);
        return child;
    }

    private SimGenCell(int fat, SimGenCore rna, SimGenPoint pos, SimGenPoint max, Random random) {
        lifeCycle = new SimGenLifeCycle(fat);
        this.max = new SimGenPoint(max);
        this.pos = new SimGenPoint(pos);
        this.random = random;
        this.core = rna;
        orientation = getRandomOrientation();
    }

    public SimGenPoint getPos() {
        return pos;
    }

    public boolean isPregnant() {
        return lifeCycle.isPregnant();
    }

    public void eat() {
        lifeCycle.eat();
    }

    public void died() {
        lifeCycle.isDead();
    }

    public SimGenPoint getMax() {
        return max;
    }

    public void setMax(SimGenPoint max) {
        this.max = max;
    }

}
