package org.woehlke.simulation.evolution.dom;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 23:12:31
 */
public class SimGenLifeCycle implements ISimGenLifeCycle {
    private int fat;
    private int age;
    private int hunger;
    private int maxFat = 1500;
    private int maxHunger = 200;
    private int fullAge = 800;
    private int fatMinimumForPregnancy = 1000;
    private int fatAtBirthDefault = 50;
    private int fatPerFood = 5;

    public SimGenLifeCycle() {
        hunger = 0;
        age = 0;
        fat = fatAtBirthDefault;
    }

    public SimGenLifeCycle(int fatAtBirth) {
        hunger = 0;
        age = 0;
        fat = fatAtBirth;
    }

    public boolean move() {
        age++;
        if (fat > 0) {
            fat--;
            return true;
        } else {
            hunger++;
            return false;
        }
    }

    public void haveSex() {
        fat /= 2;
        age = 0;
    }

    public int getFatPerFood() {
        return fatPerFood;
    }

    public void setFatPerFood(int fatPerFood) {
        this.fatPerFood = fatPerFood;
    }

    public int getFatMinimumForPregnancy() {
        return fatMinimumForPregnancy;
    }

    public void setFatMinimumForPregnancy(int fatMinimumForPregnancy) {
        this.fatMinimumForPregnancy = fatMinimumForPregnancy;
    }

    public int getFullAge() {
        return fullAge;
    }

    public void setFullAge(int fullAge) {
        this.fullAge = fullAge;
    }

    public int getMaxHunger() {
        return maxHunger;
    }

    public void setMaxHunger(int maxHunger) {
        this.maxHunger = maxHunger;
    }

    public int getMaxFat() {
        return maxFat;
    }

    public void setMaxFat(int maxFat) {
        this.maxFat = maxFat;
    }


    public boolean isFatEnoughForSex() {
        return fat >= fatMinimumForPregnancy;
    }

    public boolean isPregnant() {
        return isOldEnoughForSex() && isFatEnoughForSex();
    }

    public boolean isOldEnoughForSex() {
        return age >= fullAge;
    }

    public boolean isDead() {
        return hunger >= maxHunger;
    }

    public void eat() {
        if (fat + fatPerFood <= maxFat) {
            fat += fatPerFood;
        }
    }

    public boolean isNotDyingForHunger() {
        return fat > 0;
    }

    public int getFat() {
        return fat;
    }

    public int getFatAtBirthDefault() {
        return fatAtBirthDefault;
    }

    public void setFatAtBirthDefault(int fatAtBirthDefault) {
        this.fatAtBirthDefault = fatAtBirthDefault;
    }
}
