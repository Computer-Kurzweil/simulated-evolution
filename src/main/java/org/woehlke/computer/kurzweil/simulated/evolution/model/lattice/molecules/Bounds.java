package org.woehlke.computer.kurzweil.simulated.evolution.model.lattice.molecules;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

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
@Log4j2
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Deprecated
public class Bounds implements Serializable {

    private static final long serialVersionUID = 242L;

    private final int myStartX;
    private final int myStartY;
    private final int myWidth;
    private final int myHeight;

    @Deprecated
    public Bounds(double height, double width, Dimension screenSize){
        double startX = (screenSize.getWidth() - width) / 2d;
        double startY = (screenSize.getHeight() - height) / 2d;
        myStartX = Double.valueOf(startX).intValue();
        myStartY = Double.valueOf(startY).intValue();
        myWidth = Double.valueOf(width).intValue();
        myHeight = Double.valueOf(height).intValue();
    }

    @Deprecated
    public static Bounds getFrameBounds(JRootPane rootPane){
        double width = rootPane.getWidth();
        double height = rootPane.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new Bounds(height,width,screenSize);
    }

    @Deprecated
    public static Bounds getCanvas(JRootPane rootPane){
        double width = rootPane.getWidth();
        double height = rootPane.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new Bounds(height,width,screenSize);
    }
}
