package org.woehlke.simulation.evolution.model;

/**
 * (C) 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 19:50:51
 */
public enum Dna {

    FORWARD(0, 2),
    HARD_RIGHT(2, 1),
    SOFT_RIGHT(2, -1),
    BACKWARDS(0, -2),
    SOFT_LEFT(-2, -1),
    HARD_LEFT(-2, 1);

    private Point move;

    public Point getMove() {
        return move;
    }

    private Dna(int x,int y){
        move = new Point(x,y);
    }

}
