package org.woehlke.computer.kurzweil.simulated.evolution.view.tabs;

import org.woehlke.computer.kurzweil.simulated.evolution.commons.has.HasContextApplication;

import javax.accessibility.Accessible;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;


/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
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
