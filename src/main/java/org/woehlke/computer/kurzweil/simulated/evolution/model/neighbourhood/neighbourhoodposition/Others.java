package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.neighbourhoodposition;

import org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition.CENTER;

public class Others extends NeighbourhoodFactory {
    @Override
    public LatticePointNeighbourhoodPosition[] getNeighbourhoodPositions() {
        LatticePointNeighbourhoodPosition[] result = new LatticePointNeighbourhoodPosition[1];
        result[0] = CENTER;
        return result;
    }
}
