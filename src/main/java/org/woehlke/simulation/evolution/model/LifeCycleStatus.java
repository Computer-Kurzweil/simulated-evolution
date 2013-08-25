package org.woehlke.simulation.evolution.model;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 25.08.13
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public enum LifeCycleStatus {

    YOUNG(Color.BLUE),
    YOUNG_AND_FAT(Color.YELLOW),
    FULL_AGE(Color.RED),
    HUNGRY(Color.LIGHT_GRAY),
    OLD(Color.DARK_GRAY),
    DEAD(Color.BLACK);

    private Color color;

    private LifeCycleStatus(Color color){
        this.color=color;
    }

    public Color getColor(){
        return color;
    }
}
