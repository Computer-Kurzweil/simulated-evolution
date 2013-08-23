package org.woehlke.simulation.evolution.gui;

import org.woehlke.simulation.evolution.beans.SimGenPoint;
import org.woehlke.simulation.evolution.dom.ISimGenWorld;

import java.awt.*;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:46:08
 */
public interface ISimGenWorldCanvas {
    void paint(Graphics g);

    void repaint();

    SimGenPoint getDimensions();

    void setDimensions(SimGenPoint dimensions);

    void setWorld(ISimGenWorld world);

    ISimGenWorld getWorld();
}
