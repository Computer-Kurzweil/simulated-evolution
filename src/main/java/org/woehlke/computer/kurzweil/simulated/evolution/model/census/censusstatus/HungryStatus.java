package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.LIGHT_GRAY;

public class HungryStatus implements CensusCellStatus{
    @Override
    public void countStatus(SimulatedEvolutionPopulationCensus census) {
        census.incrementHungryCells();
    }

    @Override
    public Color getColor() {
        return LIGHT_GRAY;
    }

    @Override
    public Color getColorForeground() {
        return BLACK;
    }

    @Override
    public Color getColorBackground() {
        return LIGHT_GRAY;
    }

    @Override
    public int getCellsNumber(SimulatedEvolutionPopulationCensus census){
        return census.getHungryCells();
    }
}
