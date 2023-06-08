package org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycle;

public class LifeCycleTest_move {

    private LifeCycle lc1;
    private LifeCycle lc2;
    private int ageBeforeTest;
    private int fatBeforeTest;
    private int hungerBeforeTest;
    @Before
    public void setup() {
        lc1 = new LifeCycle(500);
        lc2 = new LifeCycle(-5);
        ageBeforeTest = lc1.getAge();
        fatBeforeTest = lc1.getFat();
        hungerBeforeTest = lc2.getHunger();
    }
    @Test
    public void move() {
        Assertions.assertTrue(lc1.move());
        Assertions.assertTrue(!lc2.move());
    }

    @After
    public void checkValue() {
        Assertions.assertEquals(lc1.getAge(), ageBeforeTest + lc1.getAGE_INC());
        Assertions.assertEquals(lc1.getFat(), fatBeforeTest - lc1.getFAT_DEC());
        Assertions.assertEquals(lc2.getHunger(), hungerBeforeTest + lc2.getHUNGER_INC());
    }
}
