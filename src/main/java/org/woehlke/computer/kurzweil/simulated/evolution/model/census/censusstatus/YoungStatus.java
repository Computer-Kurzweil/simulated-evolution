package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;

public class YoungStatus implements CensusCellStatus{
    @Override
    public void countStatus(SimulatedEvolutionPopulationCensus census) {
        census.incrementYoungCells();
    }

    @Override
    public Color getColor() {
        return BLUE;
    }

    @Override
    public Color getColorForeground() {
        return WHITE;
    }

    @Override
    public Color getColorBackground() {
        return BLUE;
    }
}
