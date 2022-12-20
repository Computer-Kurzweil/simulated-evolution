package org.woehlke.computer.kurzweil.simulated.evolution.view.widgets;

import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.view.census.PopulationStatisticsElementsPanelCounted;
import org.woehlke.computer.kurzweil.simulated.evolution.view.census.PopulationStatisticsElementsPanelLifeCycle;

import javax.swing.*;

/**
 * @see PopulationStatisticsElementsPanelLifeCycle
 * @see PopulationStatisticsElementsPanelCounted
 */
public class CensusPanel extends JPanel {

    /**
     * Display how many Cells per LifeCycleStatus and how many Cells in the whole Population for this Generation.
     */
    private final PopulationStatisticsElementsPanelLifeCycle panelLifeCycle;

    /**
     * Display the age of the generation and the world.
     */
    private final PopulationStatisticsElementsPanelCounted panelCounter;

    public CensusPanel(SimulatedEvolutionTab tab) {
        this.panelLifeCycle = new PopulationStatisticsElementsPanelLifeCycle(
            tab
        );
        this.panelCounter = new PopulationStatisticsElementsPanelCounted(
            tab,
            tab.getModel().getSimulatedEvolutionPopulationCensusContainer()
        );
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(layout);
        this.add(this.panelLifeCycle);
        this.add(new JSeparator());
        this.add(this.panelCounter);
    }

    public synchronized void update(){
        this.panelLifeCycle.update();
        this.panelCounter.update();
    }
}
