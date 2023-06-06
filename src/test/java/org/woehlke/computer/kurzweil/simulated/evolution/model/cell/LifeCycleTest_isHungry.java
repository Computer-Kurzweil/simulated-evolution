package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class LifeCycleTest_isHungry {
    private LifeCycle lc1;
    private LifeCycle lc2;
    private LifeCycle lc3;
    private LifeCycle lc4;

    @Before
    public void setup(){
        lc1 = new LifeCycle();
        lc1.setFat(1);
        lc1.setHunger(1);

        lc2 = new LifeCycle();
        lc2.setFat(1);
        lc2.setHunger(-1);

        lc3 = new LifeCycle();
        lc3.setFat(0);
        lc3.setHunger(1);

        lc4 = new LifeCycle();
        lc4.setFat(0);
        lc4.setHunger(-1);
    }

    @Test
    public void isHungry() {
        Assertions.assertTrue(!lc1.isHungry());
        Assertions.assertTrue(!lc2.isHungry());
        Assertions.assertTrue(lc3.isHungry());
        Assertions.assertTrue(!lc4.isHungry());
    }
}
