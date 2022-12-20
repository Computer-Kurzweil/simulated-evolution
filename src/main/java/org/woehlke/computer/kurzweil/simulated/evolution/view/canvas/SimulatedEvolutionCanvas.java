package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.Cell;
import org.woehlke.computer.kurzweil.simulated.evolution.model.lattice.LatticePoint;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;

import javax.swing.*;
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
public class SimulatedEvolutionCanvas extends JComponent {

    static final long serialVersionUID = 242L;

    /**
     * Reference to the Data Model.
     */
    private final SimulatedEvolutionModel tabModel;
    private final LatticePoint worldDimensions;

    private final Color WATER = Color.BLACK;
    private final Color FOOD = Color.GREEN;

    public SimulatedEvolutionCanvas(SimulatedEvolutionModel tabModel) {
        this.tabModel = tabModel;
        this.worldDimensions = this.tabModel.getWorldDimensions();
        this.setBackground(WATER);
        int x = this.worldDimensions.getX();
        int y = this.worldDimensions.getY();
        this.setSize(x,y);
        this.setVisible(true);
    }

    /**
     * Paint the World on the Canvas and show Food and Bacteria Cells.
     * @param g Graphics Context with the Tools for Painting.
     */
    public void paint(Graphics g) {
        super.paintComponent(g);
        int xx = this.worldDimensions.getX();
        int yy = this.worldDimensions.getY();
        //paint water
        g.setColor(WATER);
        g.fillRect(0,0,xx,yy);
        //paint food
        g.setColor(FOOD);
        for (int y = 0; y < yy; y++) {
            for (int x = 0; x < xx; x++) {
                if (tabModel.hasFood(x, y)) {
                    g.drawLine(x,y,x,y);
                }
            }
        }
        //paint all Cells
        for (Cell p:tabModel.getAllCells()) {
            LatticePoint[] square = p.getPosition().getNeighbourhood(this.tabModel.getWorldDimensions());
            g.setColor(p.getLifeCycleStatus().getColor());
            for(LatticePoint pixel:square){
                g.drawLine(pixel.getX(),pixel.getY(),pixel.getX(),pixel.getY());
            }
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

}
