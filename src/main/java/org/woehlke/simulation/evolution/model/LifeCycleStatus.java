package org.woehlke.simulation.evolution.model;

import java.awt.*;

/**
 * The Status of the Cell's LifeCycle.
 * It is Displayed as Color of the Cell.
 *
 * @see LifeCycle
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 25.08.13
 * Time: 12:40
 */
public enum LifeCycleStatus {

    YOUNG(Color.BLUE),
    YOUNG_AND_FAT(Color.YELLOW),
    FULL_AGE(Color.RED),
    HUNGRY(Color.LIGHT_GRAY),
    OLD(Color.DARK_GRAY),
    DEAD(Color.BLACK);

    private Color color;

    LifeCycleStatus(Color color){
        this.color=color;
    }

    public Color getColor(){
        return color;
    }
}
