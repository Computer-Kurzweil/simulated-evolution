package org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycle;

import static org.junit.Assert.*;

public class LifeCycleTest_isOld {
    private LifeCycle lc1;
    private LifeCycle lc2;
    private LifeCycle lc3;
    private LifeCycle lc4;

    @Before
    public void setup() {
        lc1 = new LifeCycle();
        lc1.setAge(lc1.getADULT_AGE() - 1);

        lc2 = new LifeCycle();
        Assertions.assertTrue(lc2.getADULT_AGE() + 1 < lc2.getOLD_AGE());
        lc2.setAge(lc2.getADULT_AGE() + 1);

        lc3 = new LifeCycle();
        Assertions.assertTrue(lc3.getOLD_AGE() + 1 < lc3.getMAX_AGE());
        lc3.setAge(lc3.getOLD_AGE() + 1);

        lc4 = new LifeCycle();
        lc4.setAge(lc4.getMAX_AGE() + 1);
    }

    @Test
    public void isOld() {
        Assertions.assertTrue(!lc1.isOld());
        Assertions.assertTrue(!lc2.isOld());
        Assertions.assertTrue(lc3.isOld());
        Assertions.assertTrue(!lc4.isOld());
    }
}
