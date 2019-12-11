package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.SimulatedEvolutionConfig;
import org.woehlke.simulation.evolution.control.ControllerThreadDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.woehlke.simulation.evolution.config.GuiConfigDefault.*;

public class PanelButtons extends JPanel implements ActionListener {

  private final JButton buttonFoodPerDayIncrease;
  private final JButton buttonFoodPerDayDecrease;
  private final JButton buttonToggleGardenOfEden;
  private JCheckBox gardenOfEdenEnabled;
  private JTextField foodPerDayField;
  private SimulatedEvolutionConfig config;
  private ControllerThreadDesktop controller;

  public PanelButtons(SimulatedEvolutionConfig config) {
    this.config = config;
    JLabel foodPerDayLabel = new JLabel("Food per Day: ");
    foodPerDayField = new JTextField(config.getFoodPerDay(), 3);
    boolean selected = config.getWorldMapFoodConfig().isEableGardenOfEden();
    this.gardenOfEdenEnabled = new JCheckBox("Garden of Eden enabled", selected);
    this.buttonFoodPerDayIncrease = new JButton(BUTTON_FOOD_INCREASE);
    this.buttonFoodPerDayDecrease = new JButton(BUTTON_FOOD_DECREASE);
    this.buttonToggleGardenOfEden = new JButton(BUTTON_TOGGLE_GARDEN_OF_EDEN);
    FlowLayout layout = new FlowLayout();
    this.setLayout(layout);
    this.add(foodPerDayLabel);
    this.add(foodPerDayField);
    this.add(gardenOfEdenEnabled);
    this.add(this.buttonFoodPerDayIncrease);
    this.add(this.buttonFoodPerDayDecrease);
    this.add(this.buttonToggleGardenOfEden);
  }

  public void addController(ControllerThreadDesktop controller) {
    this.controller = controller;
    this.buttonFoodPerDayIncrease.addActionListener(this);
    this.buttonFoodPerDayDecrease.addActionListener(this);
    this.buttonToggleGardenOfEden.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == this.buttonFoodPerDayIncrease) {
      this.controller.increaseFoodPerDay();
      this.foodPerDayField.setText(config.getFoodPerDay());
    } else if (ae.getSource() == this.buttonFoodPerDayDecrease) {
      this.controller.decreaseFoodPerDay();
      this.foodPerDayField.setText(config.getFoodPerDay());
    } else if (ae.getSource() == this.buttonToggleGardenOfEden) {
      this.controller.toggleGardenOfEden();
      boolean selected = config.getWorldMapFoodConfig().isEableGardenOfEden();
      gardenOfEdenEnabled.setSelected(selected);
    }
  }
}
