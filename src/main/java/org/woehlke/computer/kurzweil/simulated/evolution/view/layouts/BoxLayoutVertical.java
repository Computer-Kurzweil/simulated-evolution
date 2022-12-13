package org.woehlke.computer.kurzweil.simulated.evolution.view.layouts;

import javax.swing.*;
import java.awt.*;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
public class BoxLayoutVertical extends BoxLayout {

    private static final long serialVersionUID = 242L;

    /**
     * Creates a layout manager that will lay out components along the
     * given axis.
     *
     * @param target the container that needs to be laid out
     * @throws AWTError if the value of {@code axis} is invalid
     */
    public BoxLayoutVertical(Container target) {
        super(target, BoxLayout.PAGE_AXIS);
    }
}
