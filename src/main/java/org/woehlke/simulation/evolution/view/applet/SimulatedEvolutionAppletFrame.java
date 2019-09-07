package org.woehlke.simulation.evolution.view.applet;


import org.woehlke.simulation.evolution.SimulatedEvolution;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * The Config for running the Simulation.
 *
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * (C) 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 17.11.2018
 * Time: 16:33:14
 */
public class SimulatedEvolutionAppletFrame extends JFrame implements ImageObserver,
    MenuContainer,
    Serializable,
    SimulatedEvolution {

    private static final long serialVersionUID = 7150458408439002782L;
}
