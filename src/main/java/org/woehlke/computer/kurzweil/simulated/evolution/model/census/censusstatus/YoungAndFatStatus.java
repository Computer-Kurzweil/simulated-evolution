package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.YELLOW;

public class YoungAndFatStatus implements CensusCellStatus{
    @Override
    public void countStatus(SimulatedEvolutionPopulationCensus census) {
        census.incrementYoungAndFatCells();
    }

    @Override
    public Color getColor() {
        return YELLOW;
    }

    @Override
    public Color getColorForeground() {
        return BLACK;
    }

    @Override
    public Color getColorBackground() {
        return YELLOW;
    }
}
