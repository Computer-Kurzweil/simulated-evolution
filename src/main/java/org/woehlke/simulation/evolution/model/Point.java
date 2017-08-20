package org.woehlke.simulation.evolution.model;

import java.io.Serializable;

/**
 * A Point is used to define the Position of Cell or as a Vector for defining Dimensions.
 *
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 23:47:05
 */
public class Point implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Horizontal X-Coordinate. Also used as Width;
     */
    private int x = 0;

    /**
     * Vertical Y-Coordinate. Also used as Height;
     */
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

    public int getWidth() {
        return x;
    }

    public void setWidth(int width) {
        this.x = width;
    }

    public int getHeight() {
        return y;
    }

    public void setHeight(int height) {
        this.y = height;
    }

    public void absoluteValue() {
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


    /**
     * Get Neighbourhood.
     * @param max - limit the dimensions of the world around
     * @return The Set of Points belonging to the Neighbourhood of the position given by this Point Object.
     */
    public Point[] getNeighbourhood(Point max){
        Point neighbourhood[] = new Point[9];
        int maxX = max.getX();
        int maxY = max.getY();
        neighbourhood[0]= new Point((this.x+maxX-1) % maxX,(this.y+maxY-1) % maxY);
        neighbourhood[1]= new Point((this.x+maxX-1) % maxX,this.y);
        neighbourhood[2]= new Point((this.x+maxX-1) % maxX,(this.y+maxY+1) % maxY);
        neighbourhood[3]= new Point(this.x,(this.y+maxY-1) % maxY);
        neighbourhood[4]= new Point(this.x,this.y);
        neighbourhood[5]= new Point(this.x,(this.y+maxY+1) % maxY);
        neighbourhood[6]= new Point((this.x+maxX+1) % maxX,(this.y+maxY-1) % maxY);
        neighbourhood[7]= new Point((this.x+maxX+1) % maxX,this.y);
        neighbourhood[8]= new Point((this.x+maxX+1) % maxX,(this.y+maxY+1) % maxY);
        return neighbourhood;
    }
}
