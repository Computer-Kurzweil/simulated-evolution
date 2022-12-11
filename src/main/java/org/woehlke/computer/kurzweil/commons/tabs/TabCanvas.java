package org.woehlke.computer.kurzweil.commons.tabs;

import org.woehlke.computer.kurzweil.commons.gui.GuiComponent;

import java.awt.*;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
public interface TabCanvas extends GuiComponent {

    void paint(Graphics g);
    void update(Graphics g);

}
