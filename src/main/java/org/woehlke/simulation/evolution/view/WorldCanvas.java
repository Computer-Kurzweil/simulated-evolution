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
    private Point dimensions;

    private Color water = Color.BLACK;
    private Color food = Color.GREEN;
    private Color bazillus = Color.RED;

    public WorldCanvas(int x, int y) {
        this.dimensions = new org.woehlke.simulation.evolution.model.Point(x, y);
        this.setBackground(water);
        this.setSize(x, y);
    }

    public WorldCanvas(Point dimensions) {
        this.dimensions = dimensions;
        this.setBackground(water);
    }

    public void paint(Graphics g) {
        int width = dimensions.getX();
        int height = dimensions.getY();
        g.clearRect(0, 0, width, height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (world.hasFood(x, y)) {
                    g.setColor(food);
                    g.drawLine(x, y, x, y);
                }
            }
        }
        g.setColor(bazillus);
        List<Point> population = world.getPositionsOfAllCells();
        for (Point p:population) {
            g.fillRect(p.getX() - 1, p.getY() - 1, 3, 3);
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    public Point getDimensions() {
        return dimensions;
    }

    public void setDimensions(Point dimensions) {
        this.dimensions = dimensions;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }
}
