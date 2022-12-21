package org.woehlke.computer.kurzweil.simulated.evolution.model.food.geometry;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

/**
 * A Point is used to define the Position of Cell or as a Vector for defining Dimensions.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 04.02.2006
 * Time: 23:47:05
 */
@Log4j2
@ToString
@EqualsAndHashCode
@Deprecated
public class WorldPoint implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Horizontal X-Coordinate. Also used as Width;
     */
    private int x = 0;

    /**
     * Vertical Y-Coordinate. Also used as Height;
     */
    private int y = 0;

    public WorldPoint(WorldPoint p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public WorldPoint(int x, int y) {
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

    public void add(WorldPoint p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    public void normalize(WorldPoint p) {
        this.x %= p.getX();
        this.y %= p.getY();
    }


    /**
     * Get Neighbourhood.
     * @param max - limit the dimensions of the world around
     * @return The Set of Points belonging to the Neighbourhood of the position given by this Point Object.
     */
    public WorldPoint[] getNeighbourhood(LatticePoint max){
        WorldPoint neighbourhood[] = new WorldPoint[9];
        int maxX = max.getX();
        int maxY = max.getY();
        neighbourhood[0]= new WorldPoint((this.x+maxX-1) % maxX,(this.y+maxY-1) % maxY);
        neighbourhood[1]= new WorldPoint((this.x+maxX-1) % maxX,this.y);
        neighbourhood[2]= new WorldPoint((this.x+maxX-1) % maxX,(this.y+maxY+1) % maxY);
        neighbourhood[3]= new WorldPoint(this.x,(this.y+maxY-1) % maxY);
        neighbourhood[4]= new WorldPoint(this.x,this.y);
        neighbourhood[5]= new WorldPoint(this.x,(this.y+maxY+1) % maxY);
        neighbourhood[6]= new WorldPoint((this.x+maxX+1) % maxX,(this.y+maxY-1) % maxY);
        neighbourhood[7]= new WorldPoint((this.x+maxX+1) % maxX,this.y);
        neighbourhood[8]= new WorldPoint((this.x+maxX+1) % maxX,(this.y+maxY+1) % maxY);
        return neighbourhood;
    }
}
