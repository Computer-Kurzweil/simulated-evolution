package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.Preparable;
import org.woehlke.simulation.evolution.config.GuiConfig;
import org.woehlke.simulation.evolution.model.*;
import org.woehlke.simulation.evolution.model.Point;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;


/**
 * View for the World Data Model for Displaying Food and Bacteria Cells.
 *
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * &copy; 2006 - 2018 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:51:51
 */
public class WorldCanvas extends JComponent implements GuiConfig, Serializable, Preparable {

    private static final long serialVersionUID = -27002509360079509L;

    /**
     * Reference to the Data Model.
     */
    private World world;

    private final Color WATER = Color.BLACK;
    private final Color FOOD = Color.GREEN;

    public WorldCanvas(World world) {
        this.world = world;
        this.setBackground(WATER);
    }

    /**
     * Paint the World on the Canvas and show Food and Bacteria Cells.
     * @param g Graphics Context with the Tools for Painting.
     */
    public void paint(Graphics g) {
        super.paintComponent(g);
        int width = world.getWorldDimensions().getX();
        int height = world.getWorldDimensions().getY();
        g.setColor(WATER);
        g.fillRect(0,0,width,height);
        g.setColor(FOOD);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (world.hasFood(x, y)) {
                    g.drawLine(x,y,x,y);
                }
            }
        }
        List<Cell> population = world.getAllCells();
        for (Cell p:population) {
            Point[] square = p.getPosition().getNeighbourhood(world.getWorldDimensions());
            g.setColor(p.getLifeCycleStatus().getColor());
            for(Point pixel:square){
                g.drawLine(pixel.getX(),pixel.getY(),pixel.getX(),pixel.getY());
            }
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void prepareMe(){
        this.setBounds(this.world.getSimulatedEvolutionConfig().getCanvasRectangle());
    }
}
