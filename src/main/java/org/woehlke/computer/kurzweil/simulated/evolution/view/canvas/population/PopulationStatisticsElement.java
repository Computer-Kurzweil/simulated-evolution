package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.population;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus;

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
public class PopulationStatisticsElement extends JPanel {

    private static final long serialVersionUID = 242L;

    private final JLabel label;
    private final JTextField statistics;
    private final LifeCycleStatus lifeCycleStatus;
    private final int cols = 4;
    private final String defaultTextField = "0";

    public PopulationStatisticsElement(String label, LifeCycleStatus lifeCycleStatus) {
        this.label = new JLabel(label);
        this.lifeCycleStatus = lifeCycleStatus;
        this.statistics = new JTextField(defaultTextField,cols);
        this.add(this.label);
        this.add(this.statistics);
        statistics.setBackground(this.lifeCycleStatus.getColorBackground());
        statistics.setForeground(this.lifeCycleStatus.getColorForeground());
    }

    public void setText(int value){
        this.statistics.setText(""+value);
    }

    public void setText(long value){
        this.statistics.setText(""+value);
    }
}
