package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas;


import org.junit.*;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class CensusCanvasTest {
    private static CensusCanvas canvas;
    private static SimulatedEvolutionModel tab;
    private static SimulatedEvolutionPopulationCensus census;
    static int YOUNGCELL = 10;
    static int YOUNGANDFATCELLS = 20;
    static int ADULTCELLS = 30;
    static int HUNGRYCELLS = 40;
    static int OLDCELLS = 50;
    static int DEADCELLS = 60;
    static int POPULATION = 70;

    public static void setUpCensus()
    {
        census = new SimulatedEvolutionPopulationCensus(0);
        census.setYoungCells(YOUNGCELL);
        census.setYoungAndFatCells(YOUNGANDFATCELLS);
        census.setFullAgeCells(ADULTCELLS);
        census.setHungryCells(HUNGRYCELLS);
        census.setOldCells(OLDCELLS);
        census.setDeadCells(DEADCELLS);
        census.setPopulation(POPULATION);
    }
    public static void setUpTab()
    {
        String configFileName = "application.yml";
        String jarFilePath = "target/simulatedevolution.jar";
        ComputerKurzweilProperties properties =ComputerKurzweilProperties.propertiesFactory(
            configFileName, jarFilePath);
        tab = new SimulatedEvolutionModel(properties);
    }

    public void getValueByStatusTesting(LifeCycleStatus real_status, int statusNumber){
        try{
            Method method = canvas.getClass().getDeclaredMethod("getValueByStatus", SimulatedEvolutionPopulationCensus.class, LifeCycleStatus.class);
            method.setAccessible(true);
            int result = (int) method.invoke(canvas, census, LifeCycleStatus.YOUNG);
            Assert.assertEquals(YOUNGCELL, result);
        } catch(NoSuchMethodException e){
            e.printStackTrace();
        } catch(IllegalAccessException e){
            e.printStackTrace();
        } catch(InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void setup()
    {
        setUpCensus();
        setUpTab();
        canvas = new CensusCanvas(tab);
    }
    @Test
    public void checkYoungCellValue()
    {
        getValueByStatusTesting(LifeCycleStatus.YOUNG, YOUNGCELL);
    }
    @Test
    public void checkYoungAndFatCellValue()
    {
        getValueByStatusTesting(LifeCycleStatus.YOUNG_AND_FAT, YOUNGANDFATCELLS);
    }

    @Test
    public void checkAdultCell()
    {
        getValueByStatusTesting(LifeCycleStatus.ADULT_AGE, ADULTCELLS);
    }

    @Test
    public void checkHungryCellValue()
    {
        getValueByStatusTesting(LifeCycleStatus.HUNGRY, HUNGRYCELLS);
    }

    @Test
    public void checkOldCellValue()
    {
        getValueByStatusTesting(LifeCycleStatus.OLD, OLDCELLS);
    }

    @Test
    public void checkDeadCellValue()
    {
        getValueByStatusTesting(LifeCycleStatus.DEAD, DEADCELLS);
    }

    @Test
    public void checkPopulationValue()
    {
        getValueByStatusTesting(LifeCycleStatus.POPULATION, POPULATION);
    }
    @Test
    public void getZoomTesting(){
        double zoom = canvas.getZoom();
        Assert.assertEquals(5, zoom, 2);
    }

    @Test
    public void getterTest(){
        Color paperColor = canvas.getPaper();
        Assert.assertSame(paperColor, Color.WHITE);

        int width = canvas.getWidth();
        Assert.assertEquals(width, 960);

        int height = canvas.getHeight();
        Assert.assertEquals(height ,120);
    }
}
