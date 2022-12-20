package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.lattice.LatticePoint;

import java.io.Serializable;

/**
 * Orientation defines the new position after next move.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 04.02.2006
 * Time: 19:50:51
 */
@Log4j2
public enum Orientation implements Serializable {

    FORWARD(0, 2),
    HARD_RIGHT(2, 1),
    SOFT_RIGHT(2, -1),
    BACKWARDS(0, -2),
    SOFT_LEFT(-2, -1),
    HARD_LEFT(-2, 1);

    private final LatticePoint move;

    Orientation(final int x,final int y){
        move = new LatticePoint(x,y);
    }

    public LatticePoint getMove() {
        return move;
    }

}
