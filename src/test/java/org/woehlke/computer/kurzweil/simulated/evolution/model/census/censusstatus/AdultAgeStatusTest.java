package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.junit.BeforeClass;
import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

import org.junit.*;

public class AdultAgeStatusTest {
    private static CensusCellStatus status;
    private static SimulatedEvolutionPopulationCensus census;
    @BeforeClass
    public static void setup(){
        status = new AdultAgeStatus();
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
        Assert.assertSame(status.getColor(),Color.RED);
    }

    @Test
    public void getColorForeground() {
        Assert.assertSame(status.getColorForeground(),Color.WHITE);
    }

    @Test
    public void getColorBackground() {
        Assert.assertSame(status.getColorBackground(),Color.RED);
    }
}
