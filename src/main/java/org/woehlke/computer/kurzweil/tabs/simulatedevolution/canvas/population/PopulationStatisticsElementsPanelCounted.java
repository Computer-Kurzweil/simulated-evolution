package org.woehlke.computer.kurzweil.tabs.simulatedevolution.canvas.population;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.application.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.commons.Updateable;
import org.woehlke.computer.kurzweil.commons.layouts.FlowLayoutCenter;
import org.woehlke.computer.kurzweil.commons.widgets.SubTab;
import org.woehlke.computer.kurzweil.commons.widgets.SubTabImpl;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolution;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolutionContext;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.model.population.SimulatedEvolutionPopulation;

import javax.swing.border.CompoundBorder;
import java.awt.*;

import static org.woehlke.computer.kurzweil.tabs.simulatedevolution.model.LifeCycleStatus.POPULATION;


@Log4j2
@Getter
@ToString(callSuper = true,exclude = {"tabCtx","border","layout","layoutSubPanel"})
@EqualsAndHashCode(callSuper=true,exclude = {"tabCtx","border","layout","layoutSubPanel"})
public class PopulationStatisticsElementsPanelCounted extends SubTabImpl implements SimulatedEvolution, SubTab, Updateable {

    private final PopulationStatisticsElement populationElement;
    private final PopulationStatisticsElement generationOldestElement;
    private final PopulationStatisticsElement generationYoungestElement;
    private final String borderLabel;

    private final int initialPopulation;
    private final String populationLabel;
    private final String generationOldestLabel;
    private final String generationYoungestLabel;

    private final SimulatedEvolutionContext tabCtx;
    private final CompoundBorder border;
    private final FlowLayoutCenter layout;
    private final FlowLayout layoutSubPanel;

    private SimulatedEvolutionPopulation population;

    public PopulationStatisticsElementsPanelCounted(
        SimulatedEvolutionContext tabCtx
    ) {
        super(tabCtx.getCtx().getProperties().getSimulatedevolution().getPopulation().getPanelPopulationStatistics(),tabCtx.getCtx().getProperties());
        this.tabCtx = tabCtx;
        layoutSubPanel = new FlowLayout();
        this.setLayout(layoutSubPanel);
        borderLabel = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getPopulation().getPanelPopulationStatistics();
        layout = new FlowLayoutCenter();
        border = tabCtx.getCtx().getBottomButtonsPanelBorder(borderLabel);
        this.setLayout(layout);
        this.setBorder(border);
        ComputerKurzweilProperties.SimulatedEvolution.Population cfg = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getPopulation();
        initialPopulation = cfg.getInitialPopulation();
        populationLabel = cfg.getPopulationLabel();
        generationOldestLabel = cfg.getGenerationOldestLabel();
        generationYoungestLabel = cfg.getGenerationYoungestLabel();
        populationElement = new PopulationStatisticsElement(populationLabel,POPULATION);
        generationYoungestElement = new PopulationStatisticsElement(generationYoungestLabel,POPULATION);
        generationOldestElement = new PopulationStatisticsElement(generationOldestLabel,POPULATION);
        PopulationStatisticsElement[] elements = {
            populationElement,
            generationYoungestElement,
            generationOldestElement
        };
        for(PopulationStatisticsElement ps : elements){
            this.add(ps);
        }
        update();
    }

    public void update() {
        /*
        population = this.tabCtx.getTabModel().getPopulationContainer().getCurrentGeneration();
        populationElement.setText(population.getPopulation());
        generationYoungestElement.setText(population.getGenerationYoungest());
        generationOldestElement.setText(population.getGenerationOldest());
        */
    }
}
