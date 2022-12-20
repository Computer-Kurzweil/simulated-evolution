package org.woehlke.computer.kurzweil.simulated.evolution.view.panels;

import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;

import javax.swing.*;
import java.io.Serializable;

public class CopyrightLabel extends JLabel implements Serializable {

    static final long serialVersionUID = 242L;

    public CopyrightLabel(ComputerKurzweilProperties computerKurzweilProperties) {
        super(computerKurzweilProperties.getSimulatedevolution().getView().getCopyright(), CENTER);
    }
}
