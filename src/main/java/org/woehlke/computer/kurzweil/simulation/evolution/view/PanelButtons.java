package org.woehlke.computer.kurzweil.simulation.evolution.view;

import org.woehlke.computer.kurzweil.simulation.evolution.control.ObjectRegistry;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.woehlke.computer.kurzweil.simulation.evolution.config.GuiConfigDefault.BUTTON_FOOD_DECREASE;
import static org.woehlke.computer.kurzweil.simulation.evolution.config.GuiConfigDefault.BUTTON_FOOD_INCREASE;
import static org.woehlke.computer.kurzweil.simulation.evolution.config.GuiConfigDefault.BUTTON_TOGGLE_GARDEN_OF_EDEN;

/**
 * TODO write doc.
 */
public class PanelButtons extends JPanel implements ActionListener {

  private final JButton buttonFoodPerDayIncrease;
  private final JButton buttonFoodPerDayDecrease;
  private final JButton buttonToggleGardenOfEden;
  private JCheckBox gardenOfEdenEnabled;
  private JTextField foodPerDayField;
  private ObjectRegistry ctx;

  public PanelButtons(ObjectRegistry ctx) {
    this.ctx=ctx;
    JLabel foodPerDayLabel = new JLabel("Food per Day: ");
    foodPerDayField = new JTextField(ctx.getFoodPerDay(), 3);
    boolean selected = ctx.getWorldMapFoodConfig().isEableGardenOfEden();
    this.gardenOfEdenEnabled = new JCheckBox("Garden of Eden enabled", selected);
    this.buttonFoodPerDayIncrease = new JButton(BUTTON_FOOD_INCREASE);
    this.buttonFoodPerDayDecrease = new JButton(BUTTON_FOOD_DECREASE);
    this.buttonToggleGardenOfEden = new JButton(BUTTON_TOGGLE_GARDEN_OF_EDEN);
    FlowLayout layout = new FlowLayout();
    this.setLayout(layout);
    this.add(foodPerDayLabel);
    this.add(foodPerDayField);
    this.add(this.buttonFoodPerDayIncrease);
    this.add(this.buttonFoodPerDayDecrease);
    this.add(gardenOfEdenEnabled);
    this.add(this.buttonToggleGardenOfEden);
    this.buttonFoodPerDayIncrease.addActionListener(this);
    this.buttonFoodPerDayDecrease.addActionListener(this);
    this.buttonToggleGardenOfEden.addActionListener(this);
  }

  /**
   * TODO write doc.
   */
  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == this.buttonFoodPerDayIncrease) {
      ctx.getController().increaseFoodPerDay();
      this.foodPerDayField.setText(ctx.getFoodPerDay());
    } else if (ae.getSource() == this.buttonFoodPerDayDecrease) {
      ctx.getController().decreaseFoodPerDay();
      this.foodPerDayField.setText(ctx.getFoodPerDay());
    } else if (ae.getSource() == this.buttonToggleGardenOfEden) {
      ctx.getController().toggleGardenOfEden();
      boolean selected = ctx.getWorldMapFoodConfig().isEableGardenOfEden();
      gardenOfEdenEnabled.setSelected(selected);
    }
  }
}
