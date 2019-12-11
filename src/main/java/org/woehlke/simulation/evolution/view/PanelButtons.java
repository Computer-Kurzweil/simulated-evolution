package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfig;

import javax.swing.*;
import java.awt.*;

import static org.woehlke.simulation.evolution.config.GuiConfigDefault.*;

public class PanelButtons extends JPanel {

  private final JButton button1;
  private final JButton button2;
  private final JButton button3;
  private final JButton button4;

  public PanelButtons(GuiConfig guiConfig) {
    this.button1 = new  JButton(BUTTON_FOOD_INCREASE);
    this.button2 = new  JButton(BUTTON_FOOD_DECREASE);
    this.button3 = new  JButton(BUTTON_TOGGLE_GARDEN_OF_EDEN);
    this.button4 = new  JButton(BUTTON_SHOW_STATISTICS);
    FlowLayout layout = new FlowLayout();
    this.setLayout(layout);
    this.add( this.button1 );
    this.add( this.button2 );
    this.add( this.button3 );
    this.add( this.button4 );
  }

}
