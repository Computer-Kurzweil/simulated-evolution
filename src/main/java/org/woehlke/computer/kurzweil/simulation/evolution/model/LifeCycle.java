package org.woehlke.computer.kurzweil.simulation.evolution.model;

/**
 * State of the Cell which monitors age and getting enough food.
 * After an minimum age and at a minimum af eaten food,
 * the cell becomes able to reproduce by cell division.
 * If there is not enough food, the cell will not move and later it will die.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 23:12:31
 */
public class LifeCycle {

    /**
     * Status of the LifeCycle is fat, age and hunger.
     */
    private int fat;

    /**
     * Status of the LifeCycle is fat, age and hunger.
     */
    private int age;

    /**
     * Status of the LifeCycle is fat, age and hunger.
     */
    private int hunger;


    /**
     * LifeCycle Threshold Parameter
     */
    private final static int MAX_FAT = 2000;

    /**
     * LifeCycle Threshold Parameter
     */
    private final static int MAX_HUNGER = 1000;

    /**
     * LifeCycle Threshold Parameter
     */
    private final static int FULL_AGE = 200;

    /**
     * LifeCycle Threshold Parameter
     */
    private final static int FAT_MINIMUM_FOR_SEX = 800;

    /**
     * LifeCycle Threshold Parameter
     */
    private final static int FAT_AT_BIRTH = 500;

    /**
     * LifeCycle Threshold Parameter
     */
    private final static int FAT_PER_FOOD = 25;

    /**
     * LifeCycle Threshold Parameter
     */
    private final static int OLD_AGE = 800;

    /** LifeCycle Threshold Parameter */
    private final static int MAX_AGE = 1000;

    public LifeCycle() {
        hunger = 0;
        age = 0;
        fat = FAT_AT_BIRTH;
    }

    public LifeCycle(int fatAtBirth) {
        hunger = 0;
        age = 0;
        fat = fatAtBirth;
    }

    /**
     * moving consumes food energy
     * @return true, if cell has enough energy to move.
     */
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

    /**
     * having sex by cell division changes age and fat.
     */
    public void haveSex() {
        fat /= 2;
        age = 0;
    }

    /**
     * @return has enough age and fat for having sex.
     */
    public boolean isPregnant() {
        return (age >= FULL_AGE) && (fat >= FAT_MINIMUM_FOR_SEX);
    }

    /**
     * @return died by hunger. found and eaten too few food and so too few fat.
     */
    public boolean isDead() {
        return (hunger >= MAX_HUNGER) || (age >= MAX_AGE);
    }

    /**
     * @param food eat the found food and add the energy to the cells fat.
     */
    public void eat(int food) {
        if (fat + food* FAT_PER_FOOD <= MAX_FAT) {
            fat += food* FAT_PER_FOOD;
        }  else {
            fat = MAX_FAT;
        }
    }

    public int getFat() {
        return fat;
    }

    public LifeCycleStatus getLifeCycleStatus(){
        if(fat==0 && hunger>=0){
            return LifeCycleStatus.HUNGRY;
        }
        if(age<FULL_AGE){
            if(fat< FAT_MINIMUM_FOR_SEX){
                return LifeCycleStatus.YOUNG;
            } else {
                return LifeCycleStatus.YOUNG_AND_FAT;
            }
        } else {
            if (age<OLD_AGE) {
                return LifeCycleStatus.FULL_AGE;
            } else {
                if (age < MAX_AGE) {
                    return LifeCycleStatus.OLD;
                } else {
                    return LifeCycleStatus.DEAD;
                }
            }
        }
    }
}
