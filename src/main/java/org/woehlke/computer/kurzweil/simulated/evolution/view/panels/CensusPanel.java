package org.woehlke.computer.kurzweil.simulated.evolution.view.panels;

import lombok.Getter;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.CensusCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.view.census.CensusElementsPanelCounted;
import org.woehlke.computer.kurzweil.simulated.evolution.view.census.CensusElementsPanelLifeCycle;
import org.woehlke.computer.kurzweil.simulated.evolution.application.layouts.BoxLayoutVertical;

import javax.swing.*;
import java.io.Serializable;

/**
 * @see CensusElementsPanelLifeCycle
 * @see CensusElementsPanelCounted
 */
@Getter
public class CensusPanel extends JPanel implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Display how many Cells per LifeCycleStatus and how many Cells in the whole Population for this Generation.
     */
    private final CensusElementsPanelLifeCycle panelLifeCycle;

    /**
     * Display the age of the generation and the world.
     */
    private final CensusElementsPanelCounted panelCounter;

    /**
     * Plot Census data.
     */
    private final CensusCanvas censusCanvas;

    public CensusPanel(SimulatedEvolutionTab tab) {
        this.panelLifeCycle = new CensusElementsPanelLifeCycle(tab);
        this.panelCounter = new CensusElementsPanelCounted(tab);
        this.censusCanvas = new CensusCanvas(tab.getModel());
        BoxLayoutVertical layout = new BoxLayoutVertical(this);
        this.setLayout(layout);
        this.add(this.censusCanvas);
        this.add(new JSeparator());
        this.add(this.panelLifeCycle);
        this.add(new JSeparator());
        this.add(this.panelCounter);
    }

    public synchronized void update(){
        this.panelLifeCycle.update();
        this.panelCounter.update();
    }
}
