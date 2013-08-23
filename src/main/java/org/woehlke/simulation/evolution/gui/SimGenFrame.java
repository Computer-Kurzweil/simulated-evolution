package org.woehlke.simulation.evolution.gui;

import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:47:46
 */
public class SimGenFrame extends Frame
        implements ISimGenFrame {
    SimGenApplet exe;

    public SimGenFrame() {
        super("SimGen");
        exe = new SimGenApplet();
        exe.init();
        add("Center", exe);
        setBounds(100, 100, exe.getCanvasDimenensions().getX() + 30, exe.getCanvasDimenensions().getY() + 30);
        setVisible(true);
        toFront();
        addWindowListener(this);
    }

    public void windowOpened(WindowEvent e) {
        setBounds(100, 100, exe.getCanvasDimenensions().getX() + 30, exe.getCanvasDimenensions().getY() + 30);
        setVisible(true);
        toFront();
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {
        setBounds(100, 100, exe.getCanvasDimenensions().getX() + 30, exe.getCanvasDimenensions().getY() + 30);
        setVisible(true);
        toFront();
    }

    public void windowActivated(WindowEvent e) {
        toFront();
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
