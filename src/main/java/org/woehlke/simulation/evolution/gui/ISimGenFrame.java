package org.woehlke.simulation.evolution.gui;

import javax.accessibility.Accessible;
import java.awt.image.ImageObserver;
import java.awt.*;
import java.awt.event.WindowListener;
import java.io.Serializable;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 01:13:15
 */
public interface ISimGenFrame
        extends ImageObserver,
        MenuContainer,
        Serializable,
        Accessible,
        WindowListener {
}
