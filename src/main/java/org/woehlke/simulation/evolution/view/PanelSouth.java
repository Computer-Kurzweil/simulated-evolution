package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfig;

import javax.swing.*;

public class PanelSouth extends JPanel implements Preparable {

  private final PanelCopyright panelCopyright;

  private final PanelButtons panelButtons;

  private final GuiConfig guiConfig;

  public PanelSouth(GuiConfig guiConfig){
    this.guiConfig = guiConfig;
    this.panelCopyright = new PanelCopyright(guiConfig);
    this.panelButtons = new PanelButtons(guiConfig);
    BoxLayout layout = new BoxLayout(this,BoxLayout.PAGE_AXIS);
    JSeparator separator = new JSeparator();
    this.setLayout(layout);
    this.add(this.panelCopyright);
    this.add(separator);
    this.add(this.panelButtons);
    //this.setPreferredSize(this.guiConfig.getPanelSouthRectangle().getSize());
  }

  @Override
  public void prepareMe() {
   //this.setPreferredSize(this.guiConfig.getPanelSouthRectangle().getSize());
    //this.setBounds(this.guiConfig.getPanelSouthRectangle());
  }
}
