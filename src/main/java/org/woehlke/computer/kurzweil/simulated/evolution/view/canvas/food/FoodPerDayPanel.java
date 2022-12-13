package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.food;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.SubTabImpl;
import org.woehlke.computer.kurzweil.simulated.evolution.view.tabs.TabPanel;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionContext;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;

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
public class FoodPerDayPanel extends SubTabImpl {

    private static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final SimulatedEvolutionContext tabCtx;
    private final String foodPerDayBorderLabel;
    private final FoodPerDayLabel foodPerDayLabel;
    private final FoodPerDayTextField foodPerDayTextField;
    private final FoodPerDayIncreaseButton foodPerDayIncreaseButton;
    private final FoodPerDayDecreaseButton foodPerDayDecreaseButton;
    private final SimulatedEvolutionModel tabModel;

    public FoodPerDayPanel(SimulatedEvolutionContext tabCtx) {
        super(tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayLabel(),tabCtx.getCtx().getProperties());
        this.tabCtx = tabCtx;
        this.tabModel = this.tabCtx.getTabModel();
        this.foodPerDayLabel = new FoodPerDayLabel(this.tabCtx);
        this.foodPerDayTextField = new FoodPerDayTextField(this.tabCtx);
        this.foodPerDayIncreaseButton = new FoodPerDayIncreaseButton(this.tabCtx);
        this.foodPerDayDecreaseButton = new FoodPerDayDecreaseButton(this.tabCtx);
        this.foodPerDayBorderLabel = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayLabel();
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
