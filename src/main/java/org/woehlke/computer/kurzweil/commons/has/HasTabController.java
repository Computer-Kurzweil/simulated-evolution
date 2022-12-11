package org.woehlke.computer.kurzweil.commons.has;

import org.woehlke.computer.kurzweil.commons.tabs.TabController;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
public interface HasTabController {

    TabController getController();
    void startController();
    void stopController();
}
