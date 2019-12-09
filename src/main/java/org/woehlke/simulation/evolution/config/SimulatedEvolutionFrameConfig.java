package org.woehlke.simulation.evolution.config;

import java.io.Serializable;

/**
 * View for
 *
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * &copy; 2006 - 2018 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 17.11.2018
 * Time: 15:38:51
 */
public class SimulatedEvolutionFrameConfig extends SimulatedEvolutionAppletConfig
    implements Serializable, GuiConfig {

    private static final long serialVersionUID = -5570983544014723773L;

    public SimulatedEvolutionFrameConfig() {
        super(TITLE, SUB_TITLE, FOOTER,
                SCALE, WIDTH, HEIGHT,HEIGHT_OF_TITLE,
                START_POSITION_ON_SCREEN_X,START_POSITION_ON_SCREEN_Y
        );
    }

}
