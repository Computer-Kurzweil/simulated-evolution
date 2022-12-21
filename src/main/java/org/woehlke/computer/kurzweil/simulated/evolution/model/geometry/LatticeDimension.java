package org.woehlke.computer.kurzweil.simulated.evolution.model.geometry;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Log4j2
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LatticeDimension implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Horizontal X-Coordinate. Also used as Width;
     */
    private int width;

    /**
     * Vertical Y-Coordinate. Also used as Height;
     */
    private int height;

    public void absoluteValue() {
        width *= Integer.signum(width);
        height *= Integer.signum(height);
    }

    public void plus(LatticeDimension p) {
        this.width += p.getWidth();
        this.height += p.getHeight();
        absoluteValue();
    }

    public LatticeDimension copy() {
        return new LatticeDimension(
            this.getWidth(),
            this.getHeight()
        );
    }

    public LatticePoint toLatticePoint() {
        return new LatticePoint(
            this.getWidth(),
            this.getHeight()
        );
    }

    public static LatticeDimension of(LatticePoint p) {
        return new LatticeDimension(p.getX(), p.getY());
    }

    public static LatticeDimension of(LatticeDimension p) {
        return LatticeDimension.of(p.toLatticePoint());
    }

    public static LatticeDimension of(int width, int height) {
        return new LatticeDimension(width, height);
    }
}
