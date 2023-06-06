package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class LifeCycleTest_isAdult {
    private LifeCycle lc1;
    private LifeCycle lc2;
    private LifeCycle lc3;

    @Before
    public void setup() {
        lc1 = new LifeCycle();
        lc1.setAge(lc1.getADULT_AGE() - 1);

        lc2 = new LifeCycle();
        Assertions.assertTrue(lc2.getADULT_AGE() + 1 <= lc2.getOLD_AGE());
        lc2.setAge(lc2.getADULT_AGE() + 1);

        lc3 = new LifeCycle();
        lc3.setAge(lc3.getOLD_AGE());
    }

    @Test
    public void isAdult() {
        Assertions.assertTrue(!lc1.isAdult());
        Assertions.assertTrue((lc2.isAdult()));
        Assertions.assertTrue(!lc3.isAdult());
    }
}
