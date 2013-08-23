package org.woehlke.simulation.evolution.dom;

import org.woehlke.simulation.evolution.beans.SimGenPoint;

import java.util.ArrayList;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 22:51:49
 */
public interface ISimGenWorld {
    void letLivePopulation();

    void letFoodGrow();

    ArrayList<SimGenPoint> getPositionsOfAllCells();

    boolean hasFood(int x, int y);

    int getWidth();

    int getHeight();

    int getFoodPerDay();

    void setFoodPerDay(int foodPerDay);

    int getY();

    void setY(int y);

    int getX();

    void setX(int x);

    int getInitialPopulation();

    void setInitialPopulation(int initialPopulation);
}
