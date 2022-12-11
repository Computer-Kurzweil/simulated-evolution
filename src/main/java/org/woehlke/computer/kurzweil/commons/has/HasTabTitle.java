package org.woehlke.computer.kurzweil.commons.has;

import javax.swing.*;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
public interface HasTabTitle {

    String getTitle();
    String getSubTitle();
    String getToolTipText();
    Icon getIcon();
    int getKeyEvent();
}
