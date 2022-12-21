package org.woehlke.computer.kurzweil.simulated.evolution.view.census;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensusContainer;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.application.layouts.FlowLayoutCenter;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus.*;

/**
 * Display how many Cells per LifeCycleStatus and how many Cells in the whole Population for this Generation.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
@Getter
@ToString(callSuper = true,exclude = {"container"})
@EqualsAndHashCode(callSuper=true,exclude = {"container"})
public class CensusElementsPanelLifeCycle extends JPanel implements Serializable {

    static final long serialVersionUID = 242L;

    private final CensusElement youngCellsElement;
    private final CensusElement youngAndFatCellsElement;
    private final CensusElement fullAgeCellsElement;
    private final CensusElement hungryCellsElement;
    private final CensusElement oldCellsElement;
    private final CensusElement wholeGeneration;

    private final SimulatedEvolutionPopulationCensusContainer container;

    public CensusElementsPanelLifeCycle(SimulatedEvolutionTab tab) {
        this.container = tab.getModel().getCensusContainer();
        FlowLayout layoutSubPanel = new FlowLayout();
        this.setLayout(layoutSubPanel);
        FlowLayoutCenter layout = new FlowLayoutCenter();
        this.setLayout(layout);
        ComputerKurzweilProperties.SimulatedEvolution.Population cfg =
            tab.getProperties().getSimulatedevolution().getPopulation();
        String youngCellsLabel = cfg.getYoungCellsLabel();
        String youngAndFatCellsLabel = cfg.getYoungAndFatCellsLabel();
        String fullAgeCellsLabel = cfg.getFullAgeCellsLabel();
        String hungryCellsLabel = cfg.getHungryCellsLabel();
        String oldCellsLabel = cfg.getOldCellsLabel();
        String wholeGenerationLabel = cfg.getPopulationLabel();
        youngCellsElement = new CensusElement(youngCellsLabel,YOUNG);
        youngAndFatCellsElement = new CensusElement(youngAndFatCellsLabel,YOUNG_AND_FAT);
        fullAgeCellsElement = new CensusElement(fullAgeCellsLabel,FULL_AGE);
        hungryCellsElement = new CensusElement(hungryCellsLabel,HUNGRY);
        oldCellsElement = new CensusElement(oldCellsLabel,OLD);
        wholeGeneration = new CensusElement(wholeGenerationLabel,POPULATION);
        this.add(youngCellsElement);
        this.add(youngAndFatCellsElement);
        this.add(fullAgeCellsElement);
        this.add(hungryCellsElement);
        this.add(oldCellsElement);
        this.add(wholeGeneration);
        update();
    }

    public synchronized void update(){
        SimulatedEvolutionPopulationCensus population = this.container.peek();
        youngCellsElement.setText(population.getYoungCells());
        youngAndFatCellsElement.setText(population.getYoungAndFatCells());
        fullAgeCellsElement.setText(population.getFullAgeCells());
        hungryCellsElement.setText(population.getHungryCells());
        oldCellsElement.setText(population.getOldCells());
        wholeGeneration.setText(population.getPopulation());
    }
}
