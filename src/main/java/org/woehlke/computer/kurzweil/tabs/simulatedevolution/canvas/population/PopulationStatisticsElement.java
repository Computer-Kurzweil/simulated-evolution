package org.woehlke.computer.kurzweil.tabs.simulatedevolution.canvas.population;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolution;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.model.LifeCycleStatus;

import javax.swing.*;

@Log4j2
@Getter
@ToString(callSuper = true)
public class PopulationStatisticsElement extends JPanel implements SimulatedEvolution {

    private static final long serialVersionUID = 242L;

    private final JLabel label;
    private final JTextField statistics;
    private final LifeCycleStatus lifeCycleStatus;
    private final int cols = 3;
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
