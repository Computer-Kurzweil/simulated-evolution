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
public class FoodPerDayTextField extends JTextField implements SimulatedEvolution {

    @ToString.Exclude
    private final SimulatedEvolutionContext tabCtx;
    private final String foodPerDayTextFieldString;
    private final int foodPerDayTextFieldCols;

    public FoodPerDayTextField(SimulatedEvolutionContext tabCtx) {
        super(
            tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDay()+"",
            tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayFieldColumns()
        );
        this.tabCtx = tabCtx;
        this.foodPerDayTextFieldString = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDay()+"";
        this.foodPerDayTextFieldCols = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayFieldColumns();
    }

    public void setFoodPerDay(int foodPerDay){
        this.setText(""+foodPerDay);
    }
}
