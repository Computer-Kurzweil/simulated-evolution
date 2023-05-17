package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.neighbourhoodposition;

import org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition.*;

public class MooreNeighborhood extends Neighbourhoods {
    @Override
    public LatticePointNeighbourhoodPosition[] getNeighbourhoodPositions() {
        LatticePointNeighbourhoodPosition[] result = new LatticePointNeighbourhoodPosition[8];
        result[0] = NORTH_WEST;
        result[1] = NORTH;
        result[2] = NORTH_EAST;
        result[3] = EAST;
        result[4] = SOUTH_EAST;
        result[5] = SOUTH;
        result[6] = SOUTH_WEST;
        result[7] = WEST;
        return result;
    }
}
