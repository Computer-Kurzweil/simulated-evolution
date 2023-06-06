package org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycle;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus;

import static org.junit.Assert.*;

public class LifeCycleTest_getLifeCycleStatus {
    private LifeCycle lc1;
    private LifeCycle lc2;

    private LifeCycle lc3;

    private LifeCycle lc4;

    private LifeCycle lc5;

    private LifeCycle lc6;

    @Before
    public void setup() {
        lc1 = new LifeCycle();
        lc1.setFat(0);
        lc1.setHunger(0);

        lc2 = new LifeCycle();
        Assertions.assertTrue(1 <= lc2.getFAT_MINIMUM_FOR_SEX());
        lc2.setFat(1);
        Assertions.assertTrue(0 <= lc2.getADULT_AGE());
        lc2.setAge(0);

        lc3 = new LifeCycle();
        lc3.setFat(lc3.getFAT_MINIMUM_FOR_SEX());
        Assertions.assertTrue(0 <= lc3.getADULT_AGE());
        lc3.setAge(0);

        lc4 = new LifeCycle();
        Assertions.assertTrue(lc4.getADULT_AGE() < lc4.getOLD_AGE());
        lc4.setAge(lc4.getADULT_AGE());

        lc5 = new LifeCycle();
        Assertions.assertTrue(lc5.getADULT_AGE() < lc5.getOLD_AGE());
        Assertions.assertTrue(lc5.getOLD_AGE() < lc5.getMAX_AGE());
        lc5.setAge(lc5.getOLD_AGE());

        lc6 = new LifeCycle();
        lc6.setAge(lc6.getMAX_AGE() + 1);
    }

    @Test
    public void getLifeCycleStatus() {
        Assertions.assertEquals(LifeCycleStatus.HUNGRY, lc1.getLifeCycleStatus());
        Assertions.assertEquals(LifeCycleStatus.YOUNG, lc2.getLifeCycleStatus());
        Assertions.assertEquals(LifeCycleStatus.YOUNG_AND_FAT, lc3.getLifeCycleStatus());
        Assertions.assertEquals(LifeCycleStatus.ADULT_AGE, lc4.getLifeCycleStatus());
        Assertions.assertEquals(LifeCycleStatus.OLD, lc5.getLifeCycleStatus());
        Assertions.assertEquals(LifeCycleStatus.DEAD, lc6.getLifeCycleStatus());
    }
}
