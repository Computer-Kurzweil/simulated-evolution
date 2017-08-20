package org.woehlke.simulation.evolution.view;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * This Frame wraps the SimulatedEvolutionApplet which is the Container for this Simulution.
 *
 * @see org.woehlke.simulation.evolution.view.SimulatedEvolutionApplet
 * @see javax.swing.JFrame
 * @see java.awt.image.ImageObserver
 * @see java.awt.event.WindowListener
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:47:46
 */
public class SimulatedEvolutionFrame extends JFrame implements ImageObserver,
        MenuContainer,
        Serializable,
        Accessible,
        WindowListener {

    private final static String TITLE = "Simulated Evolution";

    private final static int EXIT_STATUS = 0;

    private final static String APPLET_POSITION = "Center";

    private final static int HEIGHT_OF_TITLE = 30;

    private final static int START_POSITION_ON_SCREEN_X = 100;

    private final static int START_POSITION_ON_SCREEN_Y = 100;

    private SimulatedEvolutionApplet simulatedEvolutionApplet;

    private void setMyBounds(){
        int x = START_POSITION_ON_SCREEN_X;
        int y = START_POSITION_ON_SCREEN_Y;
        int width = simulatedEvolutionApplet.getCanvasDimensions().getX();
        int height = simulatedEvolutionApplet.getCanvasDimensions().getY() + HEIGHT_OF_TITLE;
        setBounds(x, y, width, height);
    }

    public SimulatedEvolutionFrame() {
        super(TITLE);
        simulatedEvolutionApplet = new SimulatedEvolutionApplet();
        simulatedEvolutionApplet.init();
        add(APPLET_POSITION, simulatedEvolutionApplet);
        setMyBounds();
        pack();
        setVisible(true);
        toFront();
        addWindowListener(this);
    }

    public void windowOpened(WindowEvent e) {
        setMyBounds();
        setVisible(true);
        toFront();
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
        setMyBounds();
        setVisible(true);
        toFront();
    }

    public void windowActivated(WindowEvent e) {
        toFront();
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
