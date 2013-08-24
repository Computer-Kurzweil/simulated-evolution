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

    private final Color WATER = Color.BLACK;
    private final Color FOOD = Color.GREEN;
    private final Color BAZILLUS = Color.RED;

    public WorldCanvas(int x, int y) {
        this.dimensions = new Point(x, y);
        this.setBackground(WATER);
        this.setSize(x, y);
    }

    public void paint(Graphics g) {
        int width = dimensions.getX();
        int height = dimensions.getY();
        g.clearRect(0, 0, width, height);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (world.hasFood(x, y)) {
                    g.setColor(FOOD);
                    g.drawLine(x, y, x, y);
                }
            }
        }
        g.setColor(BAZILLUS);
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

    public void setWorld(World world) {
        this.world = world;
    }
}
