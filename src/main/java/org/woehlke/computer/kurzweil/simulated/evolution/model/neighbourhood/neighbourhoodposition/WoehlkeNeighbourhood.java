package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.neighbourhoodposition;

import org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition.*;

public class WoehlkeNeighbourhood extends NeighbourhoodFactory {
    @Override
    public LatticePointNeighbourhoodPosition[] getNeighbourhoodPositions() {
        LatticePointNeighbourhoodPosition[] result = new LatticePointNeighbourhoodPosition[6];
        result[0]= NORTH_WEST;
        result[1]= NORTH;
        result[2] = NORTH_EAST;
        result[3] = EAST;
        result[4] = SOUTH_WEST;
        result[5] = WEST;
        return result;
    }
}
