package org.woehlke.computer.kurzweil.simulated.evolution.view.layouts;

import java.awt.*;
import java.io.Serializable;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
public class FlowLayoutCenter extends FlowLayout implements Serializable {

    private static final long serialVersionUID = 242L;

    public FlowLayoutCenter() {
        setAlignment(FlowLayout.CENTER);
    }
}
