package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

public interface CensusCellStatus {
    void countStatus(SimulatedEvolutionPopulationCensus census);
    Color getColor();
    Color getColorForeground();
    Color getColorBackground();
    int getCellsNumber(SimulatedEvolutionPopulationCensus census);

}
