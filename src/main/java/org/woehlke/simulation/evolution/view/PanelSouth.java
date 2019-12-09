package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.view.config.SimulatedEvolutionFrameConfig;

import javax.swing.*;
import java.awt.*;

public class PanelSouth extends JPanel {

    private final FlowLayout layout = new FlowLayout();

    private final JLabel footerLabel;

    private final Rectangle panelSouthRectangle;

    private final Dimension preferredSize;

    public final String layoutConstraint  = BorderLayout.CENTER;

    public PanelSouth(SimulatedEvolutionFrameConfig simulatedEvolutionFrameConfig){
        this.footerLabel = new JLabel(simulatedEvolutionFrameConfig.getFooter());
        this.layout.setAlignment(FlowLayout.CENTER);
        this.setLayout(this.layout);
        this.add(this.footerLabel, this.layoutConstraint);
        this.preferredSize = simulatedEvolutionFrameConfig.getPreferredSize();
        this.panelSouthRectangle = simulatedEvolutionFrameConfig.getPanelSouthRectangle();
        this.setPreferredSize(this.preferredSize);
    }

    public void prepareMe(){
        this.setPreferredSize(this.preferredSize);
        this.setBounds( this.panelSouthRectangle );
    }
}
