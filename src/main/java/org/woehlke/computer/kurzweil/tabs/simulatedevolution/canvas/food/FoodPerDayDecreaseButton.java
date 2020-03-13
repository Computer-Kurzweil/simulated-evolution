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
public class FoodPerDayDecreaseButton extends JButton implements SimulatedEvolution {

    @ToString.Exclude
    private final SimulatedEvolutionContext tabCtx;
    private final String labelFoodPerDayDecrease;

    public FoodPerDayDecreaseButton(SimulatedEvolutionContext tabCtx) {
        super(tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getButtonFoodPerDayDecrease());
        this.tabCtx = tabCtx;
        this.labelFoodPerDayDecrease = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getButtonFoodPerDayDecrease();
    }
}
