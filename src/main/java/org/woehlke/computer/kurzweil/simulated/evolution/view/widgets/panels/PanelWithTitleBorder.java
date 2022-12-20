package org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.panels;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.view.layouts.FlowLayoutCenter;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
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
@Deprecated
public class PanelWithTitleBorder extends JPanel implements Serializable {

    static final long serialVersionUID = 242L;

    private final FlowLayoutCenter panelStartStopButtonsLayout;
    private final CompoundBorder panelStartStopButtonsBorder;

    public PanelWithTitleBorder(String label, ComputerKurzweilProperties p) {
        panelStartStopButtonsLayout = new FlowLayoutCenter();
        int top = p.getAllinone().getView().getBorderPaddingY();
        int left = p.getAllinone().getView().getBorderPaddingX();
        int bottom = p.getAllinone().getView().getBorderPaddingY();
        int right = p.getAllinone().getView().getBorderPaddingX();
        panelStartStopButtonsBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(label),
            BorderFactory.createEmptyBorder(top,left,bottom,right)
        );
        this.setLayout(panelStartStopButtonsLayout);
        this.setBorder(panelStartStopButtonsBorder);
    }
}
