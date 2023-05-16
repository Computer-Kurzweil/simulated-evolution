package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

abstract public class GeneticInfo {
    /**
     * LifeCycle Threshold Parameter
     */
    protected static int MAX_FAT;

    public int getMAX_FAT() { return MAX_FAT; }

    /**
     * LifeCycle Threshold Parameter
     */
    protected static int MAX_HUNGER;

    public int getMAX_HUNGER() { return MAX_HUNGER; }

    /**
     * LifeCycle Threshold Parameter
     */
    protected static int FULL_AGE;

    public int getFULL_AGE() { return FULL_AGE; }

    /**
     * LifeCycle Threshold Parameter
     */
    protected static int FAT_MINIMUM_FOR_SEX;

    public int getFAT_MINIMUM_FOR_SEX() { return FAT_MINIMUM_FOR_SEX; }

    /**
     * LifeCycle Threshold Parameter
     */
    protected static int FAT_AT_BIRTH;

    public int getFAT_AT_BIRTH() { return FAT_AT_BIRTH; }

    /**
     * LifeCycle Threshold Parameter
     */
    protected static int FAT_PER_FOOD;

    public int getFAT_PER_FOOD() { return FAT_PER_FOOD; }

    /**
     * LifeCycle Threshold Parameter
     */
    protected static int OLD_AGE;

    public int getOLD_AGE() { return OLD_AGE; }

    /** LifeCycle Threshold Parameter */
    protected static int MAX_AGE;

    public int getMAX_AGE() { return MAX_AGE; }

    protected static int AGE_INC;

    public int getAGE_INC() { return AGE_INC; }

    protected static int FAT_DEC;

    public int getFAT_DEC() { return FAT_DEC; }

    protected static int HUNGER_INC;

    public int getHUNGER_INC() { return HUNGER_INC; }

    protected static int FAT_DIVISION;

    public int getFAT_DIVISION() { return FAT_DIVISION; }
}
