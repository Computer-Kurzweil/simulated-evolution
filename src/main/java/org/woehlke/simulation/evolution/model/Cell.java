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
        this.max = max;
        this.position = position;
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
        this.max = max;
        this.position = position;
        this.random = random;
        this.core = rna;
        orientation = getRandomOrientation();
    }

    private int dnaBase;

    private Dna getRandomOrientation() {
        dnaBase = random.nextInt(Dna.values().length);
        if (dnaBase < 0) {
            dnaBase *= -1;
        }
        return Dna.values()[dnaBase];
    }

    private int iOrientation;
    private int iRandomOrientation;
    private int newOrientation;
    private Dna randomOrientation;

    private void getNextOrientation() {
        randomOrientation = core.getRandomOrientation();
        iOrientation = orientation.ordinal();
        iRandomOrientation = randomOrientation.ordinal();
        newOrientation = (iOrientation + iRandomOrientation) % Dna.values().length;
        orientation = Dna.values()[newOrientation];
    }

    private final Point MOVE_FORWARD = new Point(0, 2);
    private final Point MOVE_HARD_RIGHT = new Point(2, 1);
    private final Point MOVE_SOFT_RIGHT = new Point(2, -1);
    private final Point MOVE_BACKWARDS = new Point(0, -2);
    private final Point MOVE_SOFT_LEFT = new Point(-2, -1);
    private final Point MOVE_HARD_LEFT = new Point(-2, 1);

    public void move() {
            if(lifeCycle.move()){
            getNextOrientation();
            switch (orientation) {
                case FORWARD:
                    position.add(MOVE_FORWARD);
                    break;
                case HARD_RIGHT:
                    position.add(MOVE_HARD_RIGHT);
                    break;
                case SOFT_RIGHT:
                    position.add(MOVE_SOFT_RIGHT);
                    break;
                case BACKWARDS:
                    position.add(MOVE_BACKWARDS);
                    break;
                case SOFT_LEFT:
                    position.add(MOVE_SOFT_LEFT);
                    break;
                case HARD_LEFT:
                    position.add(MOVE_HARD_LEFT);
                    break;
            }
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

    public LifeCycleStatus getLifeCycleStatus(){
        return lifeCycle.getLifeCycleStatus();
    }

}
