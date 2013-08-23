package org.woehlke.simulation.evolution.dom;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 23:26:09
 */
public interface ISimGenLifeCycle {
    boolean move();

    boolean isNotDyingForHunger();

    boolean isFatEnoughForSex();

    boolean isPregnant();

    void haveSex();

    boolean isOldEnoughForSex();

    boolean isDead();

    void eat();

    int getFat();


    int getFatPerFood();

    void setFatPerFood(int fatPerFood);

    int getFatMinimumForPregnancy();

    void setFatMinimumForPregnancy(int fatMinimumForPregnancy);

    int getFullAge();

    void setFullAge(int fullAge);

    int getMaxHunger();

    void setMaxHunger(int maxHunger);

    int getMaxFat();

    void setMaxFat(int maxFat);

    int getFatAtBirthDefault();

    void setFatAtBirthDefault(int fatAtBirthDefault);
}
