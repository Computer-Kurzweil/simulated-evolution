package org.woehlke.simulation.evolution.dom;

import org.woehlke.simulation.evolution.beans.SimGenPoint;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 22:24:35
 */
public interface ISimGenCell {
    void move();

    ISimGenCell cellDivisionFactory();

    SimGenPoint getPos();

    boolean isPregnant();

    void eat();

    void died();


    void setMax(SimGenPoint max);

    SimGenPoint getMax();
}
