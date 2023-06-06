package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class LifeCycleTest_haveSex {

    private LifeCycle lc;
    private int fatBeforeTest;
    @Before
    public void setup() {
        lc = new LifeCycle();
        fatBeforeTest = lc.getFat();
    }
    @Test
    public void haveSex() {
        lc.haveSex();
    }
    @After
    public void checkValue() {
        Assertions.assertEquals(lc.getFat(), fatBeforeTest / lc.getFAT_DIVISION());
        Assertions.assertEquals(lc.getAge(), 0);
    }
}
