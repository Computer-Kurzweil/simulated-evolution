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
public class FoodPerDayLabel extends JLabel implements SimulatedEvolution {

    private static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final SimulatedEvolutionContext tabCtx;
    private final String foodPerDayLabelString;

    public FoodPerDayLabel(SimulatedEvolutionContext tabCtx) {
        super(tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayLabel());
        this.tabCtx = tabCtx;
        this.foodPerDayLabelString = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayLabel();
    }
}
