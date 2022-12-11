package org.woehlke.computer.kurzweil.tabs.simulatedevolution.canvas.garden;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolution;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolutionContext;

import javax.swing.*;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
@Log4j2
@Getter
@ToString(callSuper = true)
public class GardenOfEdenToggleButton extends JToggleButton implements SimulatedEvolution {

    private static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final SimulatedEvolutionContext tabCtx;
    private final String buttonToggleGardenOfEdenString;

    public GardenOfEdenToggleButton(SimulatedEvolutionContext tabCtx) {
        super(tabCtx.getCtx().getProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabledToggleButton());
        this.tabCtx = tabCtx;
        this.buttonToggleGardenOfEdenString = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabledToggleButton();
    }
}
