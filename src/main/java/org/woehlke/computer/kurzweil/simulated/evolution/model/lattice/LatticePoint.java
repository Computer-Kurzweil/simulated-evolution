package org.woehlke.computer.kurzweil.simulated.evolution.model.lattice;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

/**
 * A Point is used to define the Position of Cell or as a Vector for defining Dimensions.
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LatticePoint implements Serializable {

    private static final long serialVersionUID = 242L;

  /**
   * Horizontal X-Coordinate. Also used as Width;
   */
  private int x = 0;

  /**
   * Vertical Y-Coordinate. Also used as Height;
   */
  private int y = 0;

    public LatticePoint(LatticePoint other) {
        this.x = other.getX();
        this.y = other.getY();
    }

  public int getWidth() {
    return x;
  }

  public int getHeight() {
    return y;
  }

  public void absoluteValue() {
      x *= Integer.signum(x);
      y *= Integer.signum(y);
  }

  public void killNegative() {
        absoluteValue();
    }

  public void plus(LatticePoint p) {
    this.x += p.getX();
    this.y += p.getY();
    absoluteValue();
  }

    public void moveBy(LatticePoint p) {
        this.x += p.getX();
        this.y += p.getY();
    }

  public void normalize(LatticePoint p) {
    this.x %= p.getX();
    this.y %= p.getY();
  }

    public void moveUp() {
        y--;
    }

    public void moveRight() {
        x++;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public LatticePoint copy() {
        return new LatticePoint(this);
    }

    public static LatticePoint start(LatticePoint worldDimensions){
        return new LatticePoint(
            (worldDimensions.getX()-2),
            ((worldDimensions.getY()/2)+11)
        );
    }

}
