package org.woehlke.computer.kurzweil.simulated.evolution.view.population;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensusContainer;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.view.layouts.FlowLayoutCenter;
import org.woehlke.computer.kurzweil.simulated.evolution.view.tabs.SubTabImpl;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
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
@ToString(callSuper = true,exclude = {"tab","border","layout","layoutSubPanel"})
@EqualsAndHashCode(callSuper=true,exclude = {"tab","border","layout","layoutSubPanel"})
public class PopulationStatisticsElementsPanelLifeCycle extends SubTabImpl implements Serializable {

    static final long serialVersionUID = 242L;

    private final PopulationStatisticsElement youngCellsElement;
    private final PopulationStatisticsElement youngAndFatCellsElement;
    private final PopulationStatisticsElement fullAgeCellsElement;
    private final PopulationStatisticsElement hungryCellsElement;
    private final PopulationStatisticsElement oldCellsElement;
    private final PopulationStatisticsElement wholeGeneration;

    private final String borderLabel;

    private final CompoundBorder border;
    private final FlowLayoutCenter layout;
    private final FlowLayout layoutSubPanel;

    private final SimulatedEvolutionTab tab;

    private final SimulatedEvolutionPopulationCensusContainer simulatedEvolutionPopulationCensusContainer;

    public PopulationStatisticsElementsPanelLifeCycle(
        SimulatedEvolutionTab tab,
        SimulatedEvolutionPopulationCensusContainer simulatedEvolutionPopulationCensusContainer
    ) {
        super(
            tab.getComputerKurzweilProperties().getSimulatedevolution().getPopulation().getPanelPopulationStatistics(),
            tab.getComputerKurzweilProperties()
        );
        this.tab = tab;
        this.simulatedEvolutionPopulationCensusContainer = simulatedEvolutionPopulationCensusContainer;
        this.layoutSubPanel = new FlowLayout();
        this.setLayout(this.layoutSubPanel);
        this.borderLabel = this.tab.getComputerKurzweilProperties()
            .getSimulatedevolution().getPopulation().getPanelPopulationStatistics();
        this.layout = new FlowLayoutCenter();
        this.border = this.getDoubleBorder();
        this.setLayout(this.layout);
        this.setBorder(this.border);
        ComputerKurzweilProperties.SimulatedEvolution.Population cfg =
            this.tab.getComputerKurzweilProperties().getSimulatedevolution().getPopulation();
        String youngCellsLabel = cfg.getYoungCellsLabel();
        String youngAndFatCellsLabel = cfg.getYoungAndFatCellsLabel();
        String fullAgeCellsLabel = cfg.getFullAgeCellsLabel();
        String hungryCellsLabel = cfg.getHungryCellsLabel();
        String oldCellsLabel = cfg.getOldCellsLabel();
        String wholeGenerationLabel = cfg.getPopulationLabel();
        youngCellsElement = new PopulationStatisticsElement(youngCellsLabel,YOUNG);
        youngAndFatCellsElement = new PopulationStatisticsElement(youngAndFatCellsLabel,YOUNG_AND_FAT);
        fullAgeCellsElement = new PopulationStatisticsElement(fullAgeCellsLabel,FULL_AGE);
        hungryCellsElement = new PopulationStatisticsElement(hungryCellsLabel,HUNGRY);
        oldCellsElement = new PopulationStatisticsElement(oldCellsLabel,OLD);
        wholeGeneration = new PopulationStatisticsElement(wholeGenerationLabel,POPULATION);
        this.add(youngCellsElement);
        this.add(youngAndFatCellsElement);
        this.add(fullAgeCellsElement);
        this.add(hungryCellsElement);
        this.add(oldCellsElement);
        this.add(wholeGeneration);
        update();
    }

    public void update() {
        SimulatedEvolutionPopulationCensus population = this.simulatedEvolutionPopulationCensusContainer.peek();
        youngCellsElement.setText(population.getYoungCells());
        youngAndFatCellsElement.setText(population.getYoungAndFatCells());
        fullAgeCellsElement.setText(population.getFullAgeCells());
        hungryCellsElement.setText(population.getHungryCells());
        oldCellsElement.setText(population.getOldCells());
        wholeGeneration.setText(population.getPopulation());
    }

    private CompoundBorder getDoubleBorder(){
        int left = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int right = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int top = this.getProperties().getAllinone().getView().getBorderPaddingY();
        int bottom = this.getProperties().getAllinone().getView().getBorderPaddingY();
        return BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(left,right,top,bottom),
            BorderFactory.createEmptyBorder(left,right,top,bottom)
        );
    }
}
