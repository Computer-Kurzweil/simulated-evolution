package org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.panels;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.view.tabs.SubTabImpl;

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
@ToString(exclude={"startButton","stopButton"})
@Deprecated
public class PanelStartStopButtons extends SubTabImpl implements Serializable {

    static final long serialVersionUID = 242L;

    private final String labelStart;
    private final String labelStop;
    @Getter
    private final JButton startButton;
    @Getter
    private final JButton stopButton;

    public PanelStartStopButtons(SimulatedEvolutionTab tab){
        super(
            tab.getComputerKurzweilProperties().getAllinone().getView().getStartStopp(),
            tab.getComputerKurzweilProperties()
        );
        labelStart = tab.getComputerKurzweilProperties().getAllinone().getView().getStart();
        labelStop = tab.getComputerKurzweilProperties().getAllinone().getView().getStop();
        this.startButton = new JButton(labelStart);
        this.stopButton = new JButton(labelStop);
        this.startButton.setEnabled(true);
        this.stopButton.setEnabled(false);
        this.add(this.startButton);
        this.add(this.stopButton);
        this.startButton.addActionListener(tab);
        this.stopButton.addActionListener(tab);
    }

    public void start() {
        log.info("start");
        this.startButton.setEnabled(false);
        this.stopButton.setEnabled(true);
        log.info("started");
    }

    public void stop() {
        log.info("stop");
        this.startButton.setEnabled(true);
        this.stopButton.setEnabled(false);
        log.info("stopped");
    }

}
