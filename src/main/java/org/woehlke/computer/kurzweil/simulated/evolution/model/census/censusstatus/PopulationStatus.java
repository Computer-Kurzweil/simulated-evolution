package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class PopulationStatus implements CensusCellStatus{
    @Override
    public void countStatus(SimulatedEvolutionPopulationCensus census) {
        census.incrementPopulation();
    }

    @Override
    public Color getColor() {
        return WHITE;
    }

    @Override
    public Color getColorForeground() {
        return BLACK;
    }

    @Override
    public Color getColorBackground() {
        return WHITE;
    }
}
