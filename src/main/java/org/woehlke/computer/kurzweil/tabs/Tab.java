package org.woehlke.computer.kurzweil.tabs;

import org.woehlke.computer.kurzweil.commons.Startable;
import org.woehlke.computer.kurzweil.commons.has.HasContextApplication;
import org.woehlke.computer.kurzweil.commons.has.HasTabContext;
import org.woehlke.computer.kurzweil.commons.has.HasTabTitle;

import javax.accessibility.Accessible;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

public interface Tab extends
    ImageObserver,
    Accessible,
    ActionListener,
   // Startable,
    HasContextApplication,
   // HasTabContext,
//    HasTabTitle,
    Serializable {

}
