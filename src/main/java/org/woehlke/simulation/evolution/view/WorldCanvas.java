package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.model.*;
import org.woehlke.simulation.evolution.model.Point;

import java.awt.*;
import java.util.List;


/**
 * (C) 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:51:51
 */
public class WorldCanvas extends Canvas {

    private World world;
    private Point worldDimensions;

    private final Color WATER = Color.BLACK;
    private final Color FOOD = Color.GREEN;

    public WorldCanvas(Point worldDimensions) {
        this.worldDimensions = worldDimensions;
        this.setBackground(WATER);
        this.setSize(this.worldDimensions.getX(), this.worldDimensions.getY());
    }

    private int width;
    private int height;

    private int x;
    private int y;

    public void paint(Graphics g) {
        g.setColor(FOOD);
        width = worldDimensions.getX();
        height = worldDimensions.getY();
        g.clearRect(0, 0, width, height);
        for (y = 0; y < height; y++) {
            for (x = 0; x < width; x++) {
                if (world.hasFood(x, y)) {
                    g.drawLine(x, y, x, y);
                }
            }
        }
        List<Cell> population = world.getAllCells();
        for (Cell p:population) {
            Point[] square = p.getPosition().getNeighbourhood(worldDimensions);
            g.setColor(p.getLifeCycleStatus().getColor());
            for(Point pixel:square){
                g.drawLine(pixel.getX(), pixel.getY(), pixel.getX(), pixel.getY());
            }
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    public Point getWorldDimensions() {
        return worldDimensions;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
