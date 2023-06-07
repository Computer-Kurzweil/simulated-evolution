package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GeneticInfoTest {

    GeneticInfo gi = new ConcreteGeneticInfo1();
    private boolean paramRangeCheck(int param, int minLimit, int maxLimit) {
        if(param >= minLimit && param <= maxLimit) return true;
        return false;
    }
    @Test
    public void getMAX_FAT() {
        int MAX_FAT = gi.getMAX_FAT();
        Assertions.assertTrue(paramRangeCheck(MAX_FAT, 0, 10000));
    }

    @Test
    public void getMAX_HUNGER() {
        int FAT_LIMIT = gi.getMAX_FAT();
        Assertions.assertTrue(paramRangeCheck(FAT_LIMIT, 0, 10000));
    }

    @Test
    public void getADULT_AGE() {
        int ADULT_AGE = gi.getADULT_AGE();
        Assertions.assertTrue(paramRangeCheck(ADULT_AGE, 1, 10000));
    }

    @Test
    public void getFAT_MINIMUM_FOR_SEX() {
        int FAT_MINIMUM_FOR_SEX = gi.getFAT_MINIMUM_FOR_SEX();
        Assertions.assertTrue(paramRangeCheck(FAT_MINIMUM_FOR_SEX, 0, 10000));
    }

    @Test
    public void getFAT_AT_BIRTH() {
        int FAT_AT_BIRTH = gi.getFAT_AT_BIRTH();
        Assertions.assertTrue(paramRangeCheck(FAT_AT_BIRTH, 0, 10000));
    }

    @Test
    public void getFAT_PER_FOOD() {
        int FAT_PER_FOOD = gi.getFAT_PER_FOOD();
        Assertions.assertTrue(paramRangeCheck(FAT_PER_FOOD, 0, 10000));
    }

    @Test
    public void getOLD_AGE() {
        int OLD_AGE = gi.getOLD_AGE();
        Assertions.assertTrue(paramRangeCheck(OLD_AGE, 1, 10000));
    }

    @Test
    public void getMAX_AGE() {
        int MAX_AGE = gi.getMAX_AGE();
        Assertions.assertTrue(paramRangeCheck(MAX_AGE, 1, 10000));
    }

    @Test
    public void getAGE_INC() {
        int AGE_INC = gi.getAGE_INC();
        Assertions.assertTrue(paramRangeCheck(AGE_INC, 1, 10000));
    }

    @Test
    public void getFAT_DEC() {
        int FAT_DEC = gi.getFAT_DEC();
        Assertions.assertTrue(paramRangeCheck(FAT_DEC, 1, 10000));
    }

    @Test
    public void getHUNGER_INC() {
        int HUNGER_INC = gi.getHUNGER_INC();
        Assertions.assertTrue(paramRangeCheck(HUNGER_INC, 0, 10000));
    }

    @Test
    public void getFAT_DIVISION() {
        int FAT_DIVISION = gi.getFAT_DIVISION();
        Assertions.assertTrue(paramRangeCheck(FAT_DIVISION, 1, 10000));
    }
}
