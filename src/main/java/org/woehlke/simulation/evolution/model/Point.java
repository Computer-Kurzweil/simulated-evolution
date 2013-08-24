package org.woehlke.simulation.evolution.model;

import java.io.Serializable;

/**
 * (C) 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 23:47:05
 */
public class Point implements Serializable {

    private int x = 0;
    private int y = 0;

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void killNagative() {
        if (y < 0) {
            y *= -1;
        }
        if (x < 0) {
            x *= -1;
        }
    }

    public void add(Point p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    public void normalize(Point p) {
        this.x %= p.getX();
        this.y %= p.getY();
    }
}
