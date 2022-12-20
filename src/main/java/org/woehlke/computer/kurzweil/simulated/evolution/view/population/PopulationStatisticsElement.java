package org.woehlke.computer.kurzweil.simulated.evolution.view.population;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus;

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
public class PopulationStatisticsElement extends JPanel implements Serializable {

    static final long serialVersionUID = 242L;

    private final JLabel statisticsElementLabel;
    private final JTextField statisticsElementTextField;
    private final LifeCycleStatus lifeCycleStatus;
    private final int cols;
    private final String statisticsElementTextFieldDefault = "0";

    public PopulationStatisticsElement(String statisticsElementLabel, LifeCycleStatus lifeCycleStatus) {
        this.cols = 4;
        this.statisticsElementLabel = new JLabel(statisticsElementLabel);
        this.lifeCycleStatus = lifeCycleStatus;
        this.statisticsElementTextField = new JTextField(statisticsElementTextFieldDefault,cols);
        this.statisticsElementTextField.setHorizontalAlignment(JTextField.RIGHT);
        statisticsElementTextField.setBackground(this.lifeCycleStatus.getColorBackground());
        statisticsElementTextField.setForeground(this.lifeCycleStatus.getColorForeground());
        this.add(this.statisticsElementLabel);
        this.add(this.statisticsElementTextField);
    }

    public PopulationStatisticsElement(String statisticsElementLabel, LifeCycleStatus lifeCycleStatus, int cols) {
        this.cols = cols;
        this.statisticsElementLabel = new JLabel(statisticsElementLabel);
        this.lifeCycleStatus = lifeCycleStatus;
        this.statisticsElementTextField = new JTextField(statisticsElementTextFieldDefault,cols);
        this.statisticsElementTextField.setHorizontalAlignment(JTextField.RIGHT);
        statisticsElementTextField.setBackground(this.lifeCycleStatus.getColorBackground());
        statisticsElementTextField.setForeground(this.lifeCycleStatus.getColorForeground());
        this.add(this.statisticsElementLabel);
        this.add(this.statisticsElementTextField);
    }

    public void setText(int value){
        String text = String.valueOf(value);
        this.statisticsElementTextField.setText(text);
    }

    public void setText(long value){
        String text = String.valueOf(value);
        this.statisticsElementTextField.setText(text);
    }
}
