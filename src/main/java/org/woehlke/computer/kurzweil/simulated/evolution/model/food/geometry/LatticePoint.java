package org.woehlke.computer.kurzweil.simulated.evolution.model.food.geometry;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

/**
 * A Point is used to define the Position of Cell or as a Vector for defining Dimensions.
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * <p>
 * &copy; 2006 - 2008 Thomas Woehlke.
 *
 * @author Thomas Woehlke
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 * <p>
 * Date: 04.02.2006
 * Time: 23:47:05
 */
@Log4j2
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LatticePoint implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Horizontal X-Coordinate. Also used as Width;
     */
    private int x;

    /**
     * Vertical Y-Coordinate. Also used as Height;
     */
    private int y;

    public LatticePoint(LatticePoint other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    public void absoluteValue() {
        x *= Integer.signum(x);
        y *= Integer.signum(y);
    }

    public void killNagative() {
        absoluteValue();
    }

    public void plus(LatticePoint p) {
        this.x += p.getX();
        this.y += p.getY();
        absoluteValue();
    }

    public void add(LatticePoint p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    public void normalize(LatticePoint p) {
        this.x %= p.getX();
        this.y %= p.getY();
    }

    public LatticePoint copy() {
        return new LatticePoint(this);
    }

    public LatticeDimension toLatticePoint() {
        return new LatticeDimension(
            this.getX(),
            this.getY()
        );
    }

    public static LatticePoint of(LatticeDimension p) {
        return new LatticePoint(p.getWidth(), p.getHeight());
    }

    /**
     * Get Neighbourhood.
     * @param max - limit the dimensions of the world around
     * @return The Set of Points belonging to the Neighbourhood of the position given by this Point Object.
     */
    public LatticePoint[] getNeighbourhood(LatticePoint max){
        LatticePoint neighbourhood[] = new LatticePoint[9];
        int maxX = max.getX();
        int maxY = max.getY();
        neighbourhood[0]= new LatticePoint((this.x+maxX-1) % maxX,(this.y+maxY-1) % maxY);
        neighbourhood[1]= new LatticePoint((this.x+maxX-1) % maxX,this.y);
        neighbourhood[2]= new LatticePoint((this.x+maxX-1) % maxX,(this.y+maxY+1) % maxY);
        neighbourhood[3]= new LatticePoint(this.x,(this.y+maxY-1) % maxY);
        neighbourhood[4]= new LatticePoint(this.x,this.y);
        neighbourhood[5]= new LatticePoint(this.x,(this.y+maxY+1) % maxY);
        neighbourhood[6]= new LatticePoint((this.x+maxX+1) % maxX,(this.y+maxY-1) % maxY);
        neighbourhood[7]= new LatticePoint((this.x+maxX+1) % maxX,this.y);
        neighbourhood[8]= new LatticePoint((this.x+maxX+1) % maxX,(this.y+maxY+1) % maxY);
        return neighbourhood;
    }
}
