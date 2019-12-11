package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfig;

import javax.swing.*;
import java.awt.*;

/**
 * TODO write doc.
 */
public class PanelSubtitle extends JPanel implements Preparable {

  private final JLabel subtitleLabel;

  private final GuiConfig guiConfig;

  private final FlowLayout layout = new FlowLayout();

  public final String layoutConstraint = BorderLayout.CENTER;

  public PanelSubtitle(GuiConfig guiConfig) {
    this.subtitleLabel = new JLabel(guiConfig.getSubtitle());
    this.layout.setAlignment(FlowLayout.CENTER);
    this.setLayout(layout);
    this.add(subtitleLabel, layoutConstraint);
    this.guiConfig = guiConfig;
    this.setPreferredSize(this.guiConfig.getPanelNorthRectangle().getSize());
  }

  public void prepareMe() {
    this.setPreferredSize(this.guiConfig.getPanelNorthRectangle().getSize());
    this.setBounds(this.guiConfig.getPanelNorthRectangle());
  }
}
