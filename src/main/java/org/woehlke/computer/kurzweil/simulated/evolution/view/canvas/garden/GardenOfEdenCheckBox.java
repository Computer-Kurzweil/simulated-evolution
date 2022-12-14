package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.garden;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionContext;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;

import javax.swing.*;

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
public class GardenOfEdenCheckBox extends JCheckBox {

    private static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final SimulatedEvolutionTab tab;
    private final String gardenOfEdenEnabledString;
    private final boolean gardenOfEdenEnabledSelected;

    public GardenOfEdenCheckBox(SimulatedEvolutionTab tab) {
        super(
            tab.getComputerKurzweilProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabledString(),
            tab.getComputerKurzweilProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabled()
        );
        this.gardenOfEdenEnabledSelected =
            tab.getComputerKurzweilProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabled();
        this.gardenOfEdenEnabledString =
            tab.getComputerKurzweilProperties().getSimulatedevolution().getGardenOfEden().getGardenOfEdenEnabledString();
        this.tab = tab;
    }
}
