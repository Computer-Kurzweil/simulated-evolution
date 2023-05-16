package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.Cell;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;

import java.awt.*;


/**
 * View for the World Data Model for Displaying Food and Bacteria Cells.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 05.02.2006
 * Time: 00:51:51
 */
@Log4j2
@Getter
public class ConcreteSimulatedEvolutionCanvas extends SimulatedEvolutionCanvas {
    static final long serialVersionUID = 242L;
    private Color WATER = Color.BLACK;
    private Color FOOD = Color.GREEN;

    public ConcreteSimulatedEvolutionCanvas(SimulatedEvolutionModel tabModel) {
        super(tabModel);
    }

    /**
     * Paint the World on the Canvas and show Food and Bacteria Cells.
     * @param g Graphics Context with the Tools for Painting.
     */

    protected void paintCells(Graphics g) {
        for (Cell p:tabModel.getAllCells()) {
            LatticePoint[] square = p.getPosition().getNeighbourhood(this.tabModel.getWorldDimensions());
            g.setColor(p.getLifeCycleStatus().getColor());
            for(LatticePoint pixel:square){
                g.drawLine(pixel.getX(),pixel.getY(),pixel.getX(),pixel.getY());
            }
        }
    }

    protected void paintFood(Graphics g, int width, int height) {
        g.setColor(FOOD);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (tabModel.hasFood(x, y)) {
                    g.drawLine(x,y,x,y);
                }
            }
        }
    }

    protected void paintWater(Graphics g, int width, int height) {
        g.setColor(WATER);
        g.fillRect(0,0, width, height);
    }

}
