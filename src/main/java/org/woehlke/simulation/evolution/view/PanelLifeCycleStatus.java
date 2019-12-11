package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.control.ControllerThreadDesktop;
import org.woehlke.simulation.evolution.statistics.LifeCycleCount;
import org.woehlke.simulation.evolution.statistics.LifeCycleCountContainer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

/**
 * TODO write doc.
 */
public class PanelLifeCycleStatus extends JPanel {

  private JTextField youngCells;
  private JTextField youngAndFatCells;
  private JTextField fullAgeCells;
  private JTextField hungryCells;
  private JTextField oldCells;
  private JTextField population;

  private LifeCycleCountContainer count;

  public PanelLifeCycleStatus(LifeCycleCountContainer count) {
    this.count = count;
    LifeCycleCount lifeCycleCount = count.getLifeCycleCount();
    int cols = 3;
    JLabel youngCellsLabel = new JLabel("young");
    youngCells = new JTextField(""+lifeCycleCount.getDeadCells(),cols);
    JLabel youngAndFatCellsLabel = new JLabel("young and Fat");
    youngAndFatCells = new JTextField(""+lifeCycleCount.getYoungAndFatCells(),cols);
    JLabel fullAgeCellsLabel = new JLabel("full Age");
    fullAgeCells = new JTextField(""+lifeCycleCount.getFullAgeCells(),cols);
    JLabel hungryCellsLabel = new JLabel("hungry");
    hungryCells = new JTextField(""+lifeCycleCount.getHungryCells(),cols);
    JLabel oldCellsLabel = new JLabel("old");
    oldCells = new JTextField(""+lifeCycleCount.getOldCells(),cols);
    JLabel populationLabel = new JLabel("population");
    population = new JTextField(""+lifeCycleCount.getPopulation(),cols);
    FlowLayout layout = new FlowLayout();
    this.setLayout(layout);
    this.add(youngCellsLabel);
    this.add(youngCells);
    this.add(youngAndFatCellsLabel);
    this.add(youngAndFatCells);
    this.add(fullAgeCellsLabel);
    this.add(fullAgeCells);
    this.add(hungryCellsLabel);
    this.add(hungryCells);
    this.add(oldCellsLabel);
    this.add(oldCells);
    this.add(populationLabel);
    this.add(population);
  }

  /**
   * TODO write doc.
   */
  public void updateLifeCycleCount() {
    LifeCycleCount lifeCycleCount = count.getLifeCycleCount();
    youngCells.setText(""+lifeCycleCount.getYoungCells());
    youngAndFatCells.setText(""+lifeCycleCount.getYoungAndFatCells());
    fullAgeCells.setText(""+lifeCycleCount.getFullAgeCells());
    hungryCells.setText(""+lifeCycleCount.getHungryCells());
    oldCells.setText(""+lifeCycleCount.getOldCells());
    population.setText(""+lifeCycleCount.getPopulation());
  }

  public void addController(ControllerThreadDesktop controller) {
    count.addController(controller);
  }
}
