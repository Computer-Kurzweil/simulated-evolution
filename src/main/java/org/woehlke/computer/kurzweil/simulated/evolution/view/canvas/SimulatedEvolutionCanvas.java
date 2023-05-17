package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.Cell;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;


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
public abstract class SimulatedEvolutionCanvas extends JComponent implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Reference to the Data Model.
     */
    protected final SimulatedEvolutionModel tabModel;
    protected final LatticePoint worldDimensions;



    public SimulatedEvolutionCanvas(SimulatedEvolutionModel tabModel) {
        this.tabModel = tabModel;
        this.worldDimensions = this.tabModel.getWorldDimensions();
        //this.setBackground(WATER);
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
        int width = this.worldDimensions.getX();
        int height = this.worldDimensions.getY();
        paintWater(g, width, height);
        paintFood(g, width, height);
        paintCells(g);
    }

    protected abstract void paintCells(Graphics g);
    protected abstract void paintFood(Graphics g, int width, int height);
    protected abstract void paintWater(Graphics g, int width, int height);

    public void update(Graphics g) {
        paint(g);
    }

}
