package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

public class PopulationStatusTest {
    private static CensusCellStatus status;
    private static SimulatedEvolutionPopulationCensus census;
    @BeforeClass
    public static void setup(){
        status = new PopulationStatus();
        census = new SimulatedEvolutionPopulationCensus(0);
    }

    @Test
    public void countStatus() {
        int beforeAdultCells = status.getCellsNumber(census);
        status.countStatus(census);
        Assert.assertEquals(beforeAdultCells + 1,  status.getCellsNumber(census));
    }
    @Test
    public void getColor() {
        Assert.assertSame(status.getColor(),Color.WHITE);
    }

    @Test
    public void getColorForeground() {
        Assert.assertSame(status.getColorForeground(),Color.BLACK);
    }

    @Test
    public void getColorBackground() {
        Assert.assertSame(status.getColorBackground(),Color.WHITE);
    }
}
