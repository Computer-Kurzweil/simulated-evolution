package org.woehlke.simulation.evolution.activities;

import org.woehlke.simulation.evolution.gui.ISimGenWorldCanvas;
import org.woehlke.simulation.evolution.beans.SimGenPoint;
import org.woehlke.simulation.evolution.dom.ISimGenWorld;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 01:02:38
 */
public interface ISimGenController
        extends Runnable {
    void run();

    void start();

    void exit();


    ISimGenWorldCanvas getCanvas();

    void setCanvas(ISimGenWorldCanvas canvas);

    SimGenPoint getMax();

    void setMax(SimGenPoint max);

    Boolean getGoOn();

    void setGoOn(Boolean goOn);

    ISimGenWorld getWorld();

    void setWorld(ISimGenWorld world);
}
