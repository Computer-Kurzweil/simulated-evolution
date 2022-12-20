package org.woehlke.computer.kurzweil.simulated.evolution.view.layouts;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
public class BoxLayoutVertical extends BoxLayout implements Serializable {

    static final long serialVersionUID = 242L;

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
