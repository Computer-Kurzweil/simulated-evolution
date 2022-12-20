package org.woehlke.computer.kurzweil.simulated.evolution.application.tmp.tabs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import javax.swing.*;
import java.awt.event.ActionListener;
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
@EqualsAndHashCode(callSuper=false)
@Deprecated
public abstract class TabPanel extends JPanel implements ActionListener, Serializable {
    static final long serialVersionUID = 242L;
}
