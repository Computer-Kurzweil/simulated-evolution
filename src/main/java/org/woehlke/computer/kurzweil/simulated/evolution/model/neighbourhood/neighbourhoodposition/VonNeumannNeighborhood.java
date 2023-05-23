package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.neighbourhoodposition;

import org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition.*;

public class VonNeumannNeighborhood extends Neighbourhoods {
    @Override
    public LatticePointNeighbourhoodPosition[] getNeighbourhoodPositions() {
        LatticePointNeighbourhoodPosition[] result = new LatticePointNeighbourhoodPosition[4];
        result[0] = NORTH;
        result[1] = EAST;
        result[2] = SOUTH;
        result[3] = WEST;
        return result;
    }
}
