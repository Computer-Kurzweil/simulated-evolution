package org.woehlke.computer.kurzweil.simulated.evolution.view.widgets;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.application.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.view.layouts.FlowLayoutCenter;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
@Log4j2
@Getter
public class PanelWithTitleBorder extends JPanel {

    private static final long serialVersionUID = 242L;

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
