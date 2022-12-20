package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.food;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.tabs.SubTabImpl;
import org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.tabs.TabPanel;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;

import java.io.Serializable;

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
@ToString(callSuper = true)
@Deprecated
public class FoodPerDayPanel extends SubTabImpl implements Serializable {

    static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final SimulatedEvolutionTab tab;
    private final String foodPerDayBorderLabel;
    private final FoodPerDayLabel foodPerDayLabel;
    private final FoodPerDayTextField foodPerDayTextField;
    private final FoodPerDayIncreaseButton foodPerDayIncreaseButton;
    private final FoodPerDayDecreaseButton foodPerDayDecreaseButton;
    private final SimulatedEvolutionModel tabModel;

    public FoodPerDayPanel(SimulatedEvolutionTab tab) {
        super(
            tab.getComputerKurzweilProperties().getSimulatedevolution().getFood().getFoodPerDayLabel(),
            tab.getComputerKurzweilProperties()
        );
        this.tab = tab;
        this.tabModel = this.tab.getSimulatedEvolutionModel();
        this.foodPerDayLabel = new FoodPerDayLabel(this.tab);
        this.foodPerDayTextField = new FoodPerDayTextField(this.tab);
        this.foodPerDayIncreaseButton = new FoodPerDayIncreaseButton(this.tab);
        this.foodPerDayDecreaseButton = new FoodPerDayDecreaseButton(this.tab);
        this.foodPerDayBorderLabel =
            tab.getComputerKurzweilProperties().getSimulatedevolution().getFood().getFoodPerDayLabel();
        //this.foodPerDayBorder = this.tabCtx.getCtx().getBorder(this.foodPerDayBorderLabel);
        //this.setBorder(this.foodPerDayBorder);
        this.add(this.foodPerDayLabel);
        this.add(this.foodPerDayTextField);
        this.add(this.foodPerDayIncreaseButton);
        this.add(this.foodPerDayDecreaseButton);
    }

    public void addActionListener(TabPanel myTabPanel) {
        this.foodPerDayIncreaseButton.addActionListener(myTabPanel);
        this.foodPerDayDecreaseButton.addActionListener(myTabPanel);
    }

    public void update() {
        //int foodPerDay = tabModel.getSimulatedEvolutionParameter().getFoodPerDay();
        //this.foodPerDayTextField.setFoodPerDay(foodPerDay);
    }
}
