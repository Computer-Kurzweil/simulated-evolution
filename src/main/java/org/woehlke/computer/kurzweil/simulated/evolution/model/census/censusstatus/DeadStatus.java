package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class DeadStatus implements CensusCellStatus{
    @Override
    public void countStatus(SimulatedEvolutionPopulationCensus census) {
        census.incrementDeadCells();
    }

    @Override
    public Color getColor() {
        return BLACK;
    }

    @Override
    public Color getColorForeground() {
        return WHITE;
    }

    @Override
    public Color getColorBackground() {
        return BLACK;
    }
}
