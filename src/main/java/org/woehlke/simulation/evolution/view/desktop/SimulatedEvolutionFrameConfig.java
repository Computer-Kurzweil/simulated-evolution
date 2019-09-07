package org.woehlke.simulation.evolution.view.desktop;

import org.woehlke.simulation.evolution.SimulatedEvolution;
import org.woehlke.simulation.evolution.view.applet.SimulatedEvolutionAppletConfig;

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
    implements Serializable, SimulatedEvolution {

    private static final long serialVersionUID = -5570983544014723773L;

    private int startPositionOnScreenX;

    private int startPositionOnScreenY;

    private int heightOfTitle;

    private final String subtitle;

    private final String footer;

    public SimulatedEvolutionFrameConfig(String title,
                                         String subtitle,
                                         String footer,
                                         int startPositionOnScreenX,
                                         int startPositionOnScreenY,
                                         int heightOfTitle,
                                         int scale,
                                         int width,
                                         int height) {
        super(title, scale, width, height);
        this.subtitle = subtitle;
        this.footer = footer;
        this.startPositionOnScreenX = startPositionOnScreenX;
        this.startPositionOnScreenY = startPositionOnScreenY;
        this.heightOfTitle = heightOfTitle;
    }

    public int getStartPositionOnScreenX() {
        return startPositionOnScreenX;
    }

    public int getStartPositionOnScreenY() {
        return startPositionOnScreenY;
    }

    public int getHeightOfTitle() {
        return heightOfTitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getFooter() {
        return footer;
    }
}
