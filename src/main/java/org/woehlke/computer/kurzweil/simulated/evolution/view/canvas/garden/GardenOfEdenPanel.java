package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.garden;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionContext;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;

import javax.swing.*;
import java.awt.*;

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
public class GardenOfEdenPanel extends JPanel {

    private static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final SimulatedEvolutionTab tab;
    private final String gardenOfEdenPanelBorderLabel;
    //private final CompoundBorder gardenOfEdenPanelBorder;

    public GardenOfEdenPanel(SimulatedEvolutionTab tab) {
        super(new FlowLayout());
        this.tab = tab;
        this.gardenOfEdenPanelBorderLabel =
            tab.getComputerKurzweilProperties().getSimulatedevolution().getGardenOfEden().getPanelGardenOfEden();
        //this.gardenOfEdenPanelBorder = this.tabCtx.getCtx().getBorder(gardenOfEdenPanelBorderLabel);
        //this.setBorder(gardenOfEdenPanelBorder);
    }
}
