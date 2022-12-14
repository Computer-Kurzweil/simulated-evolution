package org.woehlke.computer.kurzweil.simulated.evolution.model.lattice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
@Getter
@ToString
@EqualsAndHashCode
public class LatticeNeighbourhood implements Serializable {

    static final long serialVersionUID = 242L;

    private final LatticeNeighbourhoodType neighbourhoodType;
    private final int maxX;
    private final int maxY;
    private final int x;
    private final int y;

    private LatticePoint[] neighbourhood;

    public LatticeNeighbourhood(
        int maxX,  int maxY, int x,  int y,
        LatticeNeighbourhoodType neighbourhoodType
    ) {
        this.neighbourhoodType = neighbourhoodType;
        this.maxX = maxX;
        this.maxY = maxY;
        this.x = x;
        this.y = y;
        this.neighbourhood = getNeighbourhoodPoints();
    }

    /**
     * Get Neighbourhood.
     *
     * @return The Set of Points belonging to the Neighbourhood of the position given by this Point Object.
     */
    private LatticePoint[] getNeighbourhoodPoints() {
        LatticePointNeighbourhoodPosition[] positions = LatticePointNeighbourhoodPosition.getNeighbourhoodFor(neighbourhoodType);
        this.neighbourhood = new LatticePoint[positions.length];
        for(int i = 0; i < positions.length; i++){
            this.neighbourhood[i] = new LatticePoint(
                (x + maxX + positions[i].getX()) % maxX,
                (y + maxY + positions[i].getY()) % maxY
            );
        }
        return this.neighbourhood;
    }

    public static LatticePoint[] get(int worldX, int worldY, int myX, int myY) {
        LatticeNeighbourhoodType neighbourhoodType = LatticeNeighbourhoodType.MOORE_NEIGHBORHOOD;
        LatticeNeighbourhood n = new LatticeNeighbourhood(worldX, worldY, myX, myY, neighbourhoodType);
        return n.getNeighbourhoodPoints();
    }

    public static LatticePoint[] getMoore(int worldX, int worldY, int myX, int myY) {
        LatticeNeighbourhoodType neighbourhoodType = LatticeNeighbourhoodType.MOORE_NEIGHBORHOOD;
        LatticeNeighbourhood n = new LatticeNeighbourhood(worldX, worldY, myX, myY, neighbourhoodType);
        return n.getNeighbourhoodPoints();
    }

    public static LatticePoint[] getVonNeumann(int worldX, int worldY, int myX, int myY) {
        LatticeNeighbourhoodType neighbourhoodType = LatticeNeighbourhoodType.VON_NEUMANN_NEIGHBORHOOD;
        LatticeNeighbourhood n = new LatticeNeighbourhood(worldX, worldY, myX, myY, neighbourhoodType);
        return n.getNeighbourhoodPoints();
    }

    public static LatticePoint[] getWoehlke(int worldX, int worldY, int myX, int myY) {
        LatticeNeighbourhoodType neighbourhoodType = LatticeNeighbourhoodType.WOEHLKE_NEIGHBORHOOD;
        LatticeNeighbourhood n = new LatticeNeighbourhood(worldX, worldY, myX, myY, neighbourhoodType);
        return n.getNeighbourhoodPoints();
    }

}
