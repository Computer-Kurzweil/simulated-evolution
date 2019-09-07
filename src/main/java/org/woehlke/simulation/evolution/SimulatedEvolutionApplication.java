package org.woehlke.simulation.evolution;

import org.woehlke.simulation.evolution.view.applet.SimulatedEvolutionApplet;
import org.woehlke.simulation.evolution.view.desktop.SimulatedEvolutionFrame;
import org.woehlke.simulation.evolution.view.desktop.SimulatedEvolutionFrameConfig;

/**
 * Class with main Method for Starting the Desktop Application.
 *
 * @see SimulatedEvolutionFrame
 * @see SimulatedEvolutionApplet
 *
 * Simulated Evolution. Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * Green food appears in a world with red moving cells.
 * These cells eat the food if it is on their position.
 * Movement of the cells depends on random and their DNA.
 * A fit cell moves around and eats enough to reproduce.
 * Reproduction is done by splitting the cell and randomly changing the DNA of the two new Cells.
 * If a cell doesn't eat enough, it will first stand still and after a while it dies.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 *
 * @author Thomas Woehlke
 *
 * http://thomas-woehlke.de/p/simulated-evolution/
 */
public class SimulatedEvolutionApplication implements SimulatedEvolution {

    private SimulatedEvolutionApplication() { }

    /**
     * Starting the Desktop Application
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        String title = TITLE;
        String subtitle = SUB_TITLE;
        String footer = FOOTER;
        int startPositionOnScreenX = START_POSITION_ON_SCREEN_X;
        int startPositionOnScreenY  = START_POSITION_ON_SCREEN_Y;
        int heightOfTitle = HEIGHT_OF_TITLE;
        int scale = SCALE;
        int width = WIDTH;
        int height = HEIGHT;
        SimulatedEvolutionFrameConfig config = new SimulatedEvolutionFrameConfig(
            title, subtitle ,footer,
            startPositionOnScreenX,startPositionOnScreenY,heightOfTitle,
            scale, width, height
        );
        SimulatedEvolutionFrame simulatedEvolutionFrame = new SimulatedEvolutionFrame(config);
        System.out.println("Hello, World!");
    }
}
