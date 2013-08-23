package org.woehlke.simulation.evolution.dom;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 22:13:47
 */
public interface ISimGenCore {
    ISimGenCore mitosisFactory();

    ESimGenDna getRandomOrientation();


    int getMaxInitialValue();

    void setMaxInitialValue(int maxInitialValue);

    int getMaxValue();

    void setMaxValue(int maxValue);
}
