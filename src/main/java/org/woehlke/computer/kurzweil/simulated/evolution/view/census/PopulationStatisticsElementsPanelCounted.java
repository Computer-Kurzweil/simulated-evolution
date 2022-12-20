package org.woehlke.computer.kurzweil.simulated.evolution.view.census;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensusContainer;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.application.layouts.FlowLayoutCenter;
import org.woehlke.computer.kurzweil.simulated.evolution.application.tabs.SubTabImpl;

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
@ToString(callSuper = true,exclude = {"tab","container"})
@EqualsAndHashCode(callSuper=true,exclude = {"tab","container"})
public class PopulationStatisticsElementsPanelCounted extends SubTabImpl implements Serializable {

    static final long serialVersionUID = 242L;

    private final PopulationStatisticsElement worldIteration;
    private final PopulationStatisticsElement generationYoungest;
    private final PopulationStatisticsElement generationOldest;

    //private final SimulatedEvolutionTab tab;
    private final SimulatedEvolutionPopulationCensusContainer container;

    @Deprecated
    public PopulationStatisticsElementsPanelCounted(SimulatedEvolutionTab tab) {
        super(
            tab.getProperties().getSimulatedevolution().getPopulation().getPanelPopulationStatistics(),
            tab.getProperties()
        );
        //this.tab = tab;
        this.container = tab.getModel().getSimulatedEvolutionPopulationCensusContainer();
        FlowLayoutCenter layout = new FlowLayoutCenter();
        this.setLayout(layout);
        ComputerKurzweilProperties.SimulatedEvolution.Population cfg =
            tab.getProperties().getSimulatedevolution().getPopulation();
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

    public synchronized void update(){
        SimulatedEvolutionPopulationCensus census = this.container.peek();
        worldIteration.setText(census.getWorldIteration());
        generationOldest.setText(census.getGenerationOldest());
        generationYoungest.setText(census.getGenerationYoungest());
    }

}
