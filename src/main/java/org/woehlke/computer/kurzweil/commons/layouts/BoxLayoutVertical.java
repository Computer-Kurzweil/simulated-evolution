package org.woehlke.computer.kurzweil.commons.layouts;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutVertical extends BoxLayout {

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
