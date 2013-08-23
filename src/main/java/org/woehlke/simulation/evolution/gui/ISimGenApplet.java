package org.woehlke.simulation.evolution.gui;

import org.woehlke.simulation.evolution.beans.SimGenPoint;

import javax.accessibility.Accessible;
import java.awt.image.ImageObserver;
import java.awt.*;
import java.io.Serializable;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 01:09:44
 */
public interface ISimGenApplet extends ImageObserver, MenuContainer, Serializable, Accessible {
    void init();

    void destroy();

    void stop();

    SimGenPoint getCanvasDimenensions();

    ISimGenWorldCanvas getCanvas();
}
