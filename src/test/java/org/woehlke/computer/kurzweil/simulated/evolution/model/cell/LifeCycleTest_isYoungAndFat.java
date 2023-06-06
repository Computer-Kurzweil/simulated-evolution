package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class LifeCycleTest_isYoungAndFat {

    private LifeCycle lc1;
    private LifeCycle lc2;
    private LifeCycle lc3;
    private LifeCycle lc4;
    private int fatBeforeTest;

    @Before
    public void setup() {
        lc1 = new LifeCycle();
        lc1.setAge(lc1.getADULT_AGE() - 1);
        lc1.setFat(lc1.getFAT_MINIMUM_FOR_SEX() - 1);

        lc2 = new LifeCycle();
        lc2.setAge(lc2.getADULT_AGE() - 1);
        lc2.setFat(lc2.getFAT_MINIMUM_FOR_SEX() + 1);

        lc3 = new LifeCycle();
        lc3.setAge(lc3.getADULT_AGE() + 1);
        lc3.setFat(lc3.getFAT_MINIMUM_FOR_SEX() - 1);

        lc4 = new LifeCycle();
        lc4.setAge(lc4.getADULT_AGE() + 1);
        lc4.setFat(lc4.getFAT_MINIMUM_FOR_SEX() + 1);

    }
    @Test
    public void isYoungAndFat() {
        Assertions.assertTrue(!lc1.isYoungAndFat());
        Assertions.assertTrue(lc2.isYoungAndFat());
        Assertions.assertTrue(!lc3.isYoungAndFat());
        Assertions.assertTrue(!lc4.isYoungAndFat());
    }

}
