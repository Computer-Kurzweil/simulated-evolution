package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.food;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;

import javax.swing.*;
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
public class FoodPerDayDecreaseButton extends JButton implements Serializable {

    static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final SimulatedEvolutionTab tab;
    private final String labelFoodPerDayDecrease;

    public FoodPerDayDecreaseButton(SimulatedEvolutionTab tab) {
        super(
            tab.getComputerKurzweilProperties().getSimulatedevolution().getFood().getButtonFoodPerDayDecrease()
        );
        this.tab = tab;
        this.labelFoodPerDayDecrease =
            tab.getComputerKurzweilProperties().getSimulatedevolution().getFood().getButtonFoodPerDayDecrease();
    }
}
