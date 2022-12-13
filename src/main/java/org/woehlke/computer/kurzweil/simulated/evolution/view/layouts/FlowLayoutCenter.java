package org.woehlke.computer.kurzweil.simulated.evolution.view.layouts;

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
public class FlowLayoutCenter extends FlowLayout implements Serializable {

    private static final long serialVersionUID = 242L;

    public FlowLayoutCenter() {
        setAlignment(FlowLayout.CENTER);
    }
}
