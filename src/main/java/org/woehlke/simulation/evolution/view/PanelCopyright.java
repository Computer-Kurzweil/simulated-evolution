package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.control.ObjectRegistry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * TODO write doc.
 */
public class PanelCopyright extends JPanel {

  private final FlowLayout layout = new FlowLayout();

  private final JLabel copyrightLabel;

  public PanelCopyright(ObjectRegistry ctx) {
    this.copyrightLabel = new JLabel(ctx.getGuiConfig().getFooter());
    this.setLayout(this.layout);
    this.layout.setAlignment(FlowLayout.CENTER);
    this.add(this.copyrightLabel);
  }
}
