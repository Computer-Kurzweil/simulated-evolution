package org.woehlke.computer.kurzweil.tabs.simulatedevolution.canvas.garden;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolution;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolutionContext;

import javax.swing.*;

@Log4j2
@Getter
@ToString(callSuper = true)
public class GardenOfEdenCheckBox extends JCheckBox implements SimulatedEvolution {

    @ToString.Exclude
    private final SimulatedEvolutionContext tabCtx;
    private final String gardenOfEdenEnabledString;
    private final boolean gardenOfEdenEnabledSelected;

    public GardenOfEdenCheckBox(SimulatedEvolutionContext tabCtx) {
        super(
            tabCtx.getCtx().getProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabledString(),
            tabCtx.getCtx().getProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabled()
        );

        this.gardenOfEdenEnabledSelected = tabCtx.getCtx().getProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabled();
        this.gardenOfEdenEnabledString = tabCtx.getCtx().getProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabledString();
        this.tabCtx = tabCtx;
    }
}
