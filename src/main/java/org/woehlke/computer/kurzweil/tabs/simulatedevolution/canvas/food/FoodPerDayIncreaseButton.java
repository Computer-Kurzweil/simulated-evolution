package org.woehlke.computer.kurzweil.tabs.simulatedevolution.canvas.food;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolution;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolutionContext;

import javax.swing.*;

@Log4j2
@Getter
@ToString(callSuper = true)
public class FoodPerDayIncreaseButton extends JButton implements SimulatedEvolution {

    private static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final SimulatedEvolutionContext tabCtx;
    private final String labelFoodPerDayIncrease;

    public FoodPerDayIncreaseButton(SimulatedEvolutionContext tabCtx) {
        super(tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getButtonFoodPerDayIncrease());
        this.tabCtx = tabCtx;
        this.labelFoodPerDayIncrease = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getButtonFoodPerDayIncrease();
    }
}
