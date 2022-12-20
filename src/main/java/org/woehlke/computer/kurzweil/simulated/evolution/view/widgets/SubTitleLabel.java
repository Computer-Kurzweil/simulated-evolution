package org.woehlke.computer.kurzweil.simulated.evolution.view.widgets;

import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;

import javax.swing.*;

public class SubTitleLabel extends JLabel {

    public SubTitleLabel(ComputerKurzweilProperties computerKurzweilProperties) {
        super(computerKurzweilProperties.getSimulatedevolution().getView().getSubtitle(), CENTER);
    }
}
