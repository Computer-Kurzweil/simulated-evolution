package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood;

import lombok.Getter;

import java.io.Serializable;

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

    public static LatticePointNeighbourhoodPosition[] getNeighbourhoodFor(
        LatticePointNeighbourhoodType neighbourhoodType
    ){
        LatticePointNeighbourhoodPosition[] result;
        switch (neighbourhoodType) {
            case VON_NEUMANN_NEIGHBORHOOD:
                result = new LatticePointNeighbourhoodPosition[4];
                result[0]=NORTH;
                result[1]=EAST;
                result[2]=SOUTH;
                result[3]=WEST;
                break;
            case MOORE_NEIGHBORHOOD:
                result = new LatticePointNeighbourhoodPosition[8];
                result[0]=NORTH_WEST;
                result[1]=NORTH;
                result[2]=NORTH_EAST;
                result[3]=EAST;
                result[4]=SOUTH_EAST;
                result[5]=SOUTH;
                result[6]=SOUTH_WEST;
                result[7]=WEST;
                break;
            case WOEHLKE_NEIGHBORHOOD:
                result = new LatticePointNeighbourhoodPosition[6];
                result[0]=NORTH_WEST;
                result[1]=NORTH;
                result[2]=NORTH_EAST;
                result[3]=EAST;
                result[4]=SOUTH_WEST;
                result[5]=WEST;
                break;
            default:
                result = new LatticePointNeighbourhoodPosition[1];
                result[0]=CENTER;
                break;
        }
        return result;
    }

}
