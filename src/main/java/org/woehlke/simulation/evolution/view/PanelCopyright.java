package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfig;

import javax.swing.*;
import java.awt.*;

/**
 * TODO write doc.
 */
public class PanelCopyright extends JPanel {

  private final FlowLayout layout = new FlowLayout();

  private final JLabel copyrightLabel;

  public PanelCopyright(GuiConfig guiConfig) {
    this.copyrightLabel = new JLabel(guiConfig.getFooter());
    this.setLayout(this.layout);
    this.layout.setAlignment(FlowLayout.CENTER);
    this.add(this.copyrightLabel);
  }
}
