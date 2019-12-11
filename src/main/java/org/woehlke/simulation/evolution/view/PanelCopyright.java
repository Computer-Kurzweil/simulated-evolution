package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfig;

import javax.swing.*;
import java.awt.*;

/**
 * TODO write doc.
 */
public class PanelCopyright extends JPanel implements Preparable {

  private final FlowLayout layout = new FlowLayout();

  private final JLabel footerLabel;

  private final GuiConfig guiConfig;

  public final String layoutConstraint = BorderLayout.CENTER;

  public PanelCopyright(GuiConfig guiConfig) {
    this.footerLabel = new JLabel(guiConfig.getFooter());
    this.setLayout(this.layout);
    this.layout.setAlignment(FlowLayout.CENTER);
    this.add(this.footerLabel, this.layoutConstraint);
    this.guiConfig = guiConfig;
    //this.setPreferredSize(this.guiConfig.getPanelSouthRectangle().getSize());
  }

  public void prepareMe() {
    //this.setPreferredSize(this.guiConfig.getPanelSouthRectangle().getSize());
    //this.setBounds(this.guiConfig.getPanelSouthRectangle());
  }
}
