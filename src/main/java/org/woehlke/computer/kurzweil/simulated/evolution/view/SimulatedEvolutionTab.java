package org.woehlke.computer.kurzweil.simulated.evolution.view;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.world.SimulatedEvolutionParameter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.Serializable;

/**
 * This Frame wraps the SimulatedEvolutionApplet which is the Container for this Simulution.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see SimulatedEvolutionApplet
 * @see javax.swing.JFrame
 * @see java.awt.image.ImageObserver
 * @see java.awt.event.WindowListener
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 04.02.2006
 * Time: 18:47:46
 */
@Log4j2
@Getter
public class SimulatedEvolutionTab extends JFrame
    implements MenuContainer, WindowListener, ActionListener, Serializable {

    static final long serialVersionUID = 242L;

    private final static String TITLE = "Simulated Evolution";

    private final static int EXIT_STATUS = 0;

    private final static String APPLET_POSITION = "Center";

    private final static int HEIGHT_OF_TITLE = 30;

    private final static int HEIGHT_OF_STATISTICS = 60;

    private final static int START_POSITION_ON_SCREEN_X = 100;

    private final static int START_POSITION_ON_SCREEN_Y = 100;

    private final SimulatedEvolutionApplet simulatedEvolutionApplet;

    private final SimulatedEvolutionParameter simulatedEvolutionParameter;

    private final ComputerKurzweilProperties computerKurzweilProperties;

    public SimulatedEvolutionTab(ComputerKurzweilProperties computerKurzweilProperties) {
        super(TITLE);
        this.computerKurzweilProperties = computerKurzweilProperties;
        this.simulatedEvolutionParameter = new SimulatedEvolutionParameter();
        this.simulatedEvolutionApplet = new SimulatedEvolutionApplet(this);
        this.simulatedEvolutionApplet.init();
        this.add(APPLET_POSITION, simulatedEvolutionApplet);
        addWindowListener(this);
        pack();
        showMe();
    }

    public void showMe(){
        setMyBounds();
        setVisible(true);
        toFront();
    }

    public void start(){
        this.simulatedEvolutionApplet.start();
    }

    public void windowOpened(WindowEvent e) {
        showMe();
    }

    private void setMyBounds(){
        int x = START_POSITION_ON_SCREEN_X; //TODO
        int y = START_POSITION_ON_SCREEN_Y; //TODO
        int width = this.simulatedEvolutionApplet.getSimulatedEvolutionModel().getWorldDimensions().getX();
        int height = this.simulatedEvolutionApplet.getSimulatedEvolutionModel().getWorldDimensions().getY()
            + HEIGHT_OF_TITLE
            + HEIGHT_OF_STATISTICS;
        setBounds(x, y, width, height);
    }

    public void windowClosing(WindowEvent e) {
        System.exit(EXIT_STATUS);
    }

    public void windowClosed(WindowEvent e) {
        System.exit(EXIT_STATUS);
    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {
        showMe();
    }

    public void windowActivated(WindowEvent e) {
        toFront();
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void update(){}

    public void actionPerformed(ActionEvent actionEvent) {

    }
}
