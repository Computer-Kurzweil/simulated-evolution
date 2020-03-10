package org.woehlke.computer.kurzweil.simulation.evolution.view;

import org.woehlke.computer.kurzweil.simulation.evolution.control.ObjectRegistry;
import org.woehlke.computer.kurzweil.simulation.evolution.model.LifeCycleCount;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

import static org.woehlke.computer.kurzweil.simulation.evolution.config.GuiConfigColors.*;

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

  private ObjectRegistry ctx;

  public PanelLifeCycleStatus(ObjectRegistry ctx) {
    this.ctx=ctx;
    LifeCycleCount lifeCycleCount = ctx.getStatistics().getLifeCycleCount();
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
    youngCells.setForeground(Color.WHITE);
    youngCells.setBackground(COLOR_YOUNG);
    youngAndFatCells.setBackground(COLOR_YOUNG_AND_FAT);
    fullAgeCells.setBackground(COLOR_FULL_AGE);
    hungryCells.setBackground(COLOR_HUNGRY);
    oldCells.setBackground(COLOR_OLD);
    oldCells.setForeground(Color.WHITE);
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
    LifeCycleCount lifeCycleCount = ctx.getStatistics().getLifeCycleCount();
    youngCells.setText(""+lifeCycleCount.getYoungCells());
    youngAndFatCells.setText(""+lifeCycleCount.getYoungAndFatCells());
    fullAgeCells.setText(""+lifeCycleCount.getFullAgeCells());
    hungryCells.setText(""+lifeCycleCount.getHungryCells());
    oldCells.setText(""+lifeCycleCount.getOldCells());
    population.setText(""+lifeCycleCount.getPopulation());
  }

}
