package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfig;

import javax.swing.*;
import java.awt.*;

/**
 * TODO write doc.
 */
public class PanelSubtitle extends JPanel {

  private final JLabel subtitleLabel;

  public PanelSubtitle(GuiConfig guiConfig) {
    this.subtitleLabel = new JLabel(guiConfig.getSubtitle());
    FlowLayout layout = new FlowLayout();
    this.setLayout(layout);
    this.add(subtitleLabel);
  }

}
