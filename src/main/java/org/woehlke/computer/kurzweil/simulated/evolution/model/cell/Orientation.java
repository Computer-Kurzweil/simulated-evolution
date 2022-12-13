package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.world.WorldPoint;

/**
 * Orientation defines the new position after next move.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 19:50:51
 */
@Log4j2
public enum Orientation {

    FORWARD(0, 2),
    HARD_RIGHT(2, 1),
    SOFT_RIGHT(2, -1),
    BACKWARDS(0, -2),
    SOFT_LEFT(-2, -1),
    HARD_LEFT(-2, 1);

    private WorldPoint move;

    public WorldPoint getMove() {
        return move;
    }

    private Orientation(int x, int y){
        move = new WorldPoint(x,y);
    }

}
