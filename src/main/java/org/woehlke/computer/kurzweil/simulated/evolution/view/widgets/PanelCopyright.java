package org.woehlke.computer.kurzweil.simulated.evolution.view.widgets;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilContext;
import org.woehlke.computer.kurzweil.simulated.evolution.view.layouts.FlowLayoutCenter;

import javax.swing.*;
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
@ToString
@EqualsAndHashCode(callSuper=true)
public class PanelCopyright extends JPanel implements Serializable {

    private static final long serialVersionUID = 242L;

    public PanelCopyright(ComputerKurzweilContext ctx) {
        this.setLayout(new FlowLayoutCenter());
        String copyright = ctx.getProperties().getAllinone().getView().getCopyright();
        this.add(new JLabel(copyright));
    }

    public void showMe() {
        this.setVisible(true);
    }

}
