package org.woehlke.computer.kurzweil.simulated.evolution.view;

import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;

import javax.swing.*;

public class CopyrightLabel extends JLabel {

    public CopyrightLabel(ComputerKurzweilProperties computerKurzweilProperties) {
        super(computerKurzweilProperties.getSimulatedevolution().getView().getCopyright(), CENTER);
    }
}
