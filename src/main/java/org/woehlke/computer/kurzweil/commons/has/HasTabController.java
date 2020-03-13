package org.woehlke.computer.kurzweil.commons.has;

import org.woehlke.computer.kurzweil.commons.tabs.TabController;

public interface HasTabController {

    TabController getController();
    void startController();
    void stopController();
}
