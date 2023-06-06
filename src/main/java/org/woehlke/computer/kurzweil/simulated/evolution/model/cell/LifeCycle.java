package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus.YOUNG_AND_FAT;

/**
 * State of the Cell which monitors age and getting enough food.
 * After a minimum age and at a minimum af eaten food,
 * the cell becomes able to reproduce by cell division.
 * If there is not enough food, the cell will not move, later it will die.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 04.02.2006
 * Time: 23:12:31
 */
@Log4j2
@ToString
@EqualsAndHashCode
public class LifeCycle implements Serializable {

    static final long serialVersionUID = 242L;

    static GeneticInfo geneticInformation = new ConcreteGeneticInfo1();

    /**
     * Status of the LifeCycle is fat, age and hunger.
     */
    @Getter
    private int fat;

    /**
     * Status of the LifeCycle is fat, age and hunger.
     */
    @Getter
    private int age;

    /**
     * Status of the LifeCycle is fat, age and hunger.
     */
    @Getter
    private int hunger;

    /**
     * LifeCycle Threshold Parameter
     */
    @Getter
    private static int MAX_FAT = geneticInformation.getMAX_FAT();

    /**
     * LifeCycle Threshold Parameter
     */
    @Getter
    private static int MAX_HUNGER = geneticInformation.getMAX_HUNGER();

    /**
     * LifeCycle Threshold Parameter
     */
    @Getter
    private static int ADULT_AGE = geneticInformation.getADULT_AGE();

    /**
     * LifeCycle Threshold Parameter
     */
    @Getter
    private static int FAT_MINIMUM_FOR_SEX = geneticInformation.getFAT_MINIMUM_FOR_SEX();

    /**
     * LifeCycle Threshold Parameter
     */
    @Getter
    private static int FAT_AT_BIRTH = geneticInformation.getFAT_AT_BIRTH();

    /**
     * LifeCycle Threshold Parameter
     */
    @Getter
    private static int FAT_PER_FOOD = geneticInformation.getFAT_PER_FOOD();

    /**
     * LifeCycle Threshold Parameter
     */

    @Getter
    private static int OLD_AGE = geneticInformation.getOLD_AGE();

    /** LifeCycle Threshold Parameter */
    @Getter
    private static int MAX_AGE = geneticInformation.getMAX_AGE();

    @Getter
    private static int AGE_INC = geneticInformation.getAGE_INC();

    @Getter
    private static int FAT_DEC = geneticInformation.getFAT_DEC();

    @Getter
    private static int HUNGER_INC = geneticInformation.getHUNGER_INC();

    @Getter
    private static int FAT_DIVISION = geneticInformation.getFAT_DIVISION();
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
        age += AGE_INC;
        if (fat > 0) {
            fat -= FAT_DEC;
            return true;
        } else {
            hunger += HUNGER_INC;
            return false;
        }
    }

    /**
     * having sex by cell division changes age and fat.
     */
    public void haveSex() {
        fat /= FAT_DIVISION;
        age = 0;
    }

    /**
     * @return has enough age and fat for having sex.
     */
    public boolean isYoungAndFat() {
        return (age < ADULT_AGE) && (fat >= FAT_MINIMUM_FOR_SEX);
    }

    /**
     * @return has enough age and fat for having sex.
     */
    public boolean isPregnant() {
        return (age >= ADULT_AGE) && (fat >= FAT_MINIMUM_FOR_SEX);
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

    public boolean isYoung() {
        return (age < ADULT_AGE) && (fat < FAT_MINIMUM_FOR_SEX);
    }

    public boolean isAdult() {
        return (age >= ADULT_AGE) && (age < OLD_AGE);
    }

    public boolean isOld() {
        return (age >= ADULT_AGE) && (age >= OLD_AGE) && (age < MAX_AGE);
    }

    public boolean isHungry() {
        return (fat == 0) && (hunger >= 0);
    }


    public LifeCycleStatus getLifeCycleStatus(){
        if(isHungry()) return LifeCycleStatus.HUNGRY;
        if (isYoung()) return LifeCycleStatus.YOUNG;
        if (isYoungAndFat()) return LifeCycleStatus.YOUNG_AND_FAT;
        if (isAdult()) return LifeCycleStatus.ADULT_AGE;
        if (isOld()) return LifeCycleStatus.OLD;
        else return LifeCycleStatus.DEAD;
    }
}
