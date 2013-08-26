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
    private Point neighbourhood[] = new Point[9];

    public Point(final int x, final int y) {
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

    private int i=0;

    public Point[] getNeighbourhood(Point max){
        int maxX = max.getX();
        int maxY = max.getY();

        for(i=0; i<neighbourhood.length;i++){
            if(neighbourhood[i]==null){
                neighbourhood[i]=new Point(0,0);
            }
        }

        neighbourhood[0].setX((this.x+maxX-1) % maxX);
        neighbourhood[0].setY((this.y+maxY-1) % maxY);

        neighbourhood[1].setX((this.x+maxX-1) % maxX);
        neighbourhood[1].setY(this.y);

        neighbourhood[2].setX((this.x+maxX-1) % maxX);
        neighbourhood[2].setY((this.y+maxY+1) % maxY);

        neighbourhood[3].setX(this.x);
        neighbourhood[3].setX((this.y+maxY-1) % maxY);

        neighbourhood[4].setX(this.x);
        neighbourhood[4].setY(this.y);

        neighbourhood[5].setX(this.x);
        neighbourhood[5].setY((this.y+maxY+1) % maxY);

        neighbourhood[6].setX((this.x+maxX+1) % maxX);
        neighbourhood[6].setY((this.y+maxY-1) % maxY);

        neighbourhood[7].setX((this.x+maxX+1) % maxX);
        neighbourhood[7].setY(this.y);

        neighbourhood[8].setX((this.x+maxX+1) % maxX);
        neighbourhood[8].setY((this.y+maxY+1) % maxY);

        return neighbourhood;
    }
}
