package org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycle;

import static org.junit.Assert.*;

public class LifeCycleTest_eat {
    private LifeCycle lc1;
    private LifeCycle lc2;
    private int fatBeforeTest_1;
    private int food_1;
    private int food_2;
    @Before
    public void setup() {
        lc1 = new LifeCycle();
        lc1.setFat(0);
        fatBeforeTest_1 = lc1.getFat();
        food_1 = 0;

        lc2 = new LifeCycle();
        food_2 = 1000;
    }

    @Test
    public void eat() {
        lc1.eat(food_1);
        lc2.eat(food_2);
    }

    @After
    public void checkValue() {
        Assertions.assertEquals(lc1.getFat(), fatBeforeTest_1 + food_1 * lc1.getFAT_PER_FOOD());
        Assertions.assertEquals(lc2.getFat(), lc2.getMAX_FAT());
    }
}
