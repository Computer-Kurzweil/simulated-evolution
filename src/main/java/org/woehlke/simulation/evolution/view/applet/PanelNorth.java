package org.woehlke.simulation.evolution.view.applet;

import javax.swing.*;
import java.awt.*;

public class PanelNorth extends JPanel {

    private final BorderLayout layout = new BorderLayout();

    private final JLabel subtitleLabel;

    private final Rectangle panelSouthRectangle;

    private final Dimension preferredSize;

    public final String layoutConstraint  = BorderLayout.CENTER;

    public PanelNorth(SimulatedEvolutionAppletConfig simulatedEvolutionAppletConfig){
        this.subtitleLabel = new JLabel(simulatedEvolutionAppletConfig.getSubtitle());
        this.setLayout(layout);
        this.add(subtitleLabel,layoutConstraint);
        this.preferredSize = simulatedEvolutionAppletConfig.getPreferredSize();
        this.panelSouthRectangle = simulatedEvolutionAppletConfig.getPanelNorthRectangle();
        this.setPreferredSize(this.preferredSize);
    }

    public void prepareMe(){
        this.setPreferredSize(this.preferredSize);
        this.setBounds(this.panelSouthRectangle);
    }
}
