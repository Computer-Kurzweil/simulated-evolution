package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import jakarta.validation.Valid;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

import static java.awt.Color.RED;
import static java.awt.Color.WHITE;

public class AdultAgeStatus implements CensusCellStatus{
    @Override
    public void countStatus(SimulatedEvolutionPopulationCensus census) {
        census.incrementFullAgeCells();
    }

    @Override
    public Color getColor() {
        return RED;
    }

    @Override
    public Color getColorForeground() {
        return WHITE;
    }

    @Override
    public Color getColorBackground() {
        return RED;
    }

    @Override
    public int getCellsNumber(SimulatedEvolutionPopulationCensus census){
        return census.getFullAgeCells();
    }

}
