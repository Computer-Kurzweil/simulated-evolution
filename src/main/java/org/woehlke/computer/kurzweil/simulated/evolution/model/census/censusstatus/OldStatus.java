package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

import static java.awt.Color.DARK_GRAY;
import static java.awt.Color.WHITE;

public class OldStatus implements CensusCellStatus{
    @Override
    public void countStatus(SimulatedEvolutionPopulationCensus census) {
        census.incrementOldCells();
    }

    @Override
    public Color getColor() {
        return DARK_GRAY;
    }

    @Override
    public Color getColorForeground() {
        return WHITE;
    }

    @Override
    public Color getColorBackground() {
        return DARK_GRAY;
    }

    @Override
    public int getCellsNumber(SimulatedEvolutionPopulationCensus census){
        return census.getOldCells();
    }
}
