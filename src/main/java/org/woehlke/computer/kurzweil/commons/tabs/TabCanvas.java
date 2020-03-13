package org.woehlke.computer.kurzweil.commons.tabs;

import org.woehlke.computer.kurzweil.commons.gui.GuiComponent;

import java.awt.*;

public interface TabCanvas extends GuiComponent {

    void paint(Graphics g);
    void update(Graphics g);

}
