package org.woehlke.simulation.evolution.model;

import java.util.Random;

/**
 * (C) 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 19:06:43
 */
public class Cell {

    private Point position;
    private Dna orientation;
    private Point max;
    private Random random;
    private CellCore core;

    private LifeCycle lifeCycle;

    public Cell(Point max, Point position, Random random) {
        this.max = new Point(max);
        this.position = new Point(position);
        this.random = random;
        this.core = new CellCore(random);
        this.max.killNagative();
        this.position.setX(random.nextInt() % max.getX());
        this.position.setY(random.nextInt() % max.getY());
        this.position.killNagative();
        this.orientation = getRandomOrientation();
        this.lifeCycle = new LifeCycle();
    }

    private Cell(int fat, CellCore rna, Point position, Point max, Random random) {
        lifeCycle = new LifeCycle(fat);
        this.max = new Point(max);
        this.position = new Point(position);
        this.random = random;
        this.core = rna;
        orientation = getRandomOrientation();
    }

    private Dna getRandomOrientation() {
        int dnaLength = Dna.values().length;
        int dnaBase = random.nextInt(dnaLength);
        if (dnaBase < 0) {
            dnaBase *= -1;
        }
        return Dna.values()[dnaBase];
    }

    private void getNextOrientation() {
        Dna randomOrientation = core.getRandomOrientation();
        int iOrientation = orientation.ordinal();
        int iRandomOrientation = randomOrientation.ordinal();
        int newOrientation = (iOrientation + iRandomOrientation) % Dna.values().length;
        orientation = Dna.values()[newOrientation];
    }

    public void move() {
            if(lifeCycle.move()){
            getNextOrientation();
            Point move = new Point(0, 0);
            switch (orientation) {
                case FORWARD:
                    move = new Point(0, 2);
                    break;
                case HARD_RIGHT:
                    move = new Point(2, 1);
                    break;
                case SOFT_RIGHT:
                    move = new Point(2, -1);
                    break;
                case BACKWARDS:
                    move = new Point(0, -2);
                    break;
                case SOFT_LEFT:
                    move = new Point(-2, -1);
                    break;
                case HARD_LEFT:
                    move = new Point(-2, 1);
                    break;
            }
            position.add(move);
            position.add(max);
            position.normalize(max);
        }
    }

    public Cell cellDivisionFactory() {
        CellCore rna = core.mitosisFactory();
        lifeCycle.haveSex();
        Cell child = new Cell(lifeCycle.getFat(), rna, position, max, random);
        return child;
    }

    public Point getPosition() {
        return position;
    }

    public boolean isPregnant() {
        return lifeCycle.isPregnant();
    }

    public void eat(int food) {
        lifeCycle.eat(food);
    }

    public boolean died() {
        return lifeCycle.isDead();
    }

}
