package org.woehlke.computer.kurzweil.simulation.evolution.view;

import org.woehlke.computer.kurzweil.simulation.evolution.control.ObjectRegistry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * TODO write doc.
 */
public class PanelSubtitle extends JPanel {

  private final JLabel subtitleLabel;

  public PanelSubtitle(ObjectRegistry ctx) {
    this.subtitleLabel = new JLabel(ctx.getGuiConfig().getSubtitle());
    FlowLayout layout = new FlowLayout();
    this.setLayout(layout);
    this.add(subtitleLabel);
  }

}
