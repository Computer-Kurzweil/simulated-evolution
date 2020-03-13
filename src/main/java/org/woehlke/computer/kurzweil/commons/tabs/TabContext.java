package org.woehlke.computer.kurzweil.commons.tabs;

import org.woehlke.computer.kurzweil.commons.has.HasTab;
import org.woehlke.computer.kurzweil.commons.has.HasTabCanvas;
import org.woehlke.computer.kurzweil.commons.has.HasTabController;
import org.woehlke.computer.kurzweil.commons.has.HasTabModel;

public interface TabContext extends
    HasTabController,
    HasTabModel,
    HasTabCanvas,
    HasTab {

}
