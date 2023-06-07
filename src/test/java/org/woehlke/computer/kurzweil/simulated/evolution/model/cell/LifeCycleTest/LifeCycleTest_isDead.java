package org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycle;

public class LifeCycleTest_isDead {
    private LifeCycle lc1;
    private LifeCycle lc2;
    private LifeCycle lc3;
    private LifeCycle lc4;

    @Before
    public void setup() {
        lc1 = new LifeCycle();
        lc1.setHunger(lc1.getMAX_HUNGER() - 1);
        lc1.setAge(lc1.getMAX_AGE() - 1);

        lc2 = new LifeCycle();
        lc2.setHunger(lc2.getMAX_HUNGER() - 1);
        lc2.setAge(lc2.getMAX_AGE() + 1);

        lc3 = new LifeCycle();
        lc3.setHunger(lc3.getMAX_HUNGER() + 1);
        lc3.setAge(lc3.getMAX_AGE() - 1);

        lc4 = new LifeCycle();
        lc4.setHunger(lc4.getMAX_HUNGER() + 1);
        lc4.setAge(lc4.getMAX_AGE() + 1);
    }
    @Test
    public void isDead() {
        Assertions.assertTrue(!lc1.isDead());
        Assertions.assertTrue(lc2.isDead());
        Assertions.assertTrue(lc3.isDead());
        Assertions.assertTrue(lc4.isDead());
    }
}
