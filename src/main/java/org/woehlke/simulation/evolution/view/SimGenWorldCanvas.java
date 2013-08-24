package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.model.SimGenPoint;
import org.woehlke.simulation.evolution.model.SimGenWorld;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:51:51
 */
public class SimGenWorldCanvas extends Canvas {
    private SimGenWorld world;
    private SimGenPoint dimensions;

    private Color water = Color.BLACK;
    private Color food = Color.GREEN;
    private Color bazillus = Color.RED;

    public SimGenWorldCanvas(int x, int y) {
        this.dimensions = new SimGenPoint(x, y);
        this.setBackground(water);
        this.setSize(x, y);
    }

    public SimGenWorldCanvas(SimGenPoint dimensions) {
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
        ArrayList<SimGenPoint> population = world.getPositionsOfAllCells();
        Iterator<SimGenPoint> it = population.iterator();
        while (it.hasNext()) {
            SimGenPoint p = it.next();
            g.fillRect(p.getX() - 1, p.getY() - 1, 3, 3);
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    public SimGenPoint getDimensions() {
        return dimensions;
    }

    public void setDimensions(SimGenPoint dimensions) {
        this.dimensions = dimensions;
    }

    public void setWorld(SimGenWorld world) {
        this.world = world;
    }

    public SimGenWorld getWorld() {
        return world;
    }
}
