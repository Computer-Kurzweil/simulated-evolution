package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood;

import lombok.Getter;

import java.io.Serializable;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.neighbourhoodposition.NeighbourhoodFactory.NeighbourhoodFactory;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Getter
public enum LatticePointNeighbourhoodPosition implements Serializable {

    CENTER(0,0),
    NORTH(0,-1),
    EAST(1,0),
    SOUTH(0,1),
    WEST(-1,0),
    NORTH_EAST(1,-1),
    SOUTH_EAST(1,1),
    SOUTH_WEST(-1,1),
    NORTH_WEST(-1,-1);

    private final int x;
    private final int y;

    LatticePointNeighbourhoodPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static LatticePointNeighbourhoodPosition[] getNeighbourhoodFor(LatticePointNeighbourhoodType neighbourhoodType){
        return NeighbourhoodFactory(neighbourhoodType);
    }

}
