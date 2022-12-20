package org.woehlke.computer.kurzweil.simulated.evolution.view.census;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensusContainer;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.layouts.FlowLayoutCenter;
import org.woehlke.computer.kurzweil.simulated.evolution.view.tabs.SubTabImpl;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.io.Serializable;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus.GENERATION;


/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
@Getter
@ToString(callSuper = true,exclude = {"tab","simulatedEvolutionPopulationCensusContainer"})
@EqualsAndHashCode(callSuper=true,exclude = {"tab","simulatedEvolutionPopulationCensusContainer"})
public class PopulationStatisticsElementsPanelCounted extends SubTabImpl implements Serializable {

    static final long serialVersionUID = 242L;

    private final PopulationStatisticsElement worldIteration;
    private final PopulationStatisticsElement generationYoungest;
    private final PopulationStatisticsElement generationOldest;

    private final SimulatedEvolutionTab tab;
    private final SimulatedEvolutionPopulationCensusContainer simulatedEvolutionPopulationCensusContainer;

    @Deprecated
    public PopulationStatisticsElementsPanelCounted(
        SimulatedEvolutionTab tab,
        SimulatedEvolutionPopulationCensusContainer simulatedEvolutionPopulationCensusContainer
    ) {
        super(
            tab.getComputerKurzweilProperties().getSimulatedevolution().getPopulation().getPanelPopulationStatistics(),
            tab.getComputerKurzweilProperties()
        );
        this.tab = tab;
        this.simulatedEvolutionPopulationCensusContainer = simulatedEvolutionPopulationCensusContainer;
        FlowLayout layoutSubPanel = new FlowLayout();
        this.setLayout(layoutSubPanel);
        String borderLabel = tab.getComputerKurzweilProperties().getSimulatedevolution()
            .getPopulation().getPanelPopulationStatistics();
        FlowLayoutCenter layout = new FlowLayoutCenter();
        CompoundBorder border =this.getDoubleBorder();
        this.setLayout(layout);
        this.setBorder(border);
        ComputerKurzweilProperties.SimulatedEvolution.Population cfg =
            tab.getComputerKurzweilProperties().getSimulatedevolution().getPopulation();
        String worldIterationLabel = cfg.getPopulationLabel();
        String generationOldestLabel = cfg.getGenerationOldestLabel();
        String generationYoungestLabel = cfg.getGenerationYoungestLabel();
        worldIteration = new PopulationStatisticsElement(worldIterationLabel, GENERATION,8);
        generationOldest = new PopulationStatisticsElement(generationOldestLabel, GENERATION,8);
        generationYoungest = new PopulationStatisticsElement(generationYoungestLabel, GENERATION,8);
        this.add(worldIteration);
        this.add(generationOldest);
        this.add(generationYoungest);
        update();
    }


    @Deprecated
    public void update() {
        SimulatedEvolutionPopulationCensus population = this.simulatedEvolutionPopulationCensusContainer.peek();
        worldIteration.setText(population.getPopulation());
        generationOldest.setText(population.getGenerationOldest());
        generationYoungest.setText(population.getGenerationYoungest());
    }

    @Deprecated
    private CompoundBorder getDoubleBorder(){
        int top = this.getProperties().getAllinone().getView().getBorderPaddingY();
        int left = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int bottom = this.getProperties().getAllinone().getView().getBorderPaddingY();
        int right = this.getProperties().getAllinone().getView().getBorderPaddingX();
        return BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(top, left, bottom, right),
            BorderFactory.createEmptyBorder(top, left, bottom, right)
        );
    }
}
