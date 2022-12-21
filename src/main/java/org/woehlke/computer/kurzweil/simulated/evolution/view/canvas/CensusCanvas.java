package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensusContainer;
import org.woehlke.computer.kurzweil.simulated.evolution.model.food.geometry.LatticeDimension;
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
public class CensusCanvas extends JComponent implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Reference to the Data Model.
     */
    private final SimulatedEvolutionPopulationCensusContainer container;

    private final LatticeDimension worldDimensions;

    private final Color PAPER = Color.WHITE;

    public CensusCanvas(SimulatedEvolutionModel tabModel) {
        this.container = tabModel.getCensusContainer();
        int heightOfStatisticsCanvas = tabModel.getProperties()
            .getSimulatedevolution().getView().getHeightOfStatisticsCanvas();
        this.worldDimensions = LatticeDimension.of(
            tabModel.getWorldDimensions().getX(),
            heightOfStatisticsCanvas
        );
        this.setBackground(PAPER);
        int width = this.worldDimensions.getWidth();
        int height = this.worldDimensions.getHeight();
        this.setSize(width,height);
        this.setVisible(true);
    }

    /**
     * Paint the World on the Canvas and show Food and Bacteria Cells.
     * @param g Graphics Context with the Tools for Painting.
     */
    public void paint(Graphics g) {
        super.paintComponent(g);
        int x = 0;
        int y = 0;
        int width = this.worldDimensions.getWidth();
        int height = this.worldDimensions.getHeight();
        //paint background
        g.setColor(PAPER);
        g.fillRect(x,y,width,height);
        //paint data graph
        /*
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
         */
    }

    public void update(Graphics g) {
        paint(g);
    }

}