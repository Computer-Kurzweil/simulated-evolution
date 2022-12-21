package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensusContainer;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticeDimension;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus.*;


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

    private final LatticeDimension canvasdDimensions;

    public CensusCanvas(SimulatedEvolutionModel tabModel) {
        int width = tabModel.getWorldDimensions().getX();
        int height = tabModel.getProperties().getSimulatedevolution().getView().getHeightOfStatisticsCanvas();
        this.container = tabModel.getCensusContainer();
        this.canvasdDimensions = LatticeDimension.of(width,height);
        Dimension preferredSize = new Dimension(width, height);
        this.setSize(preferredSize);
        this.setPreferredSize(preferredSize);
        Color paper = POPULATION.getColorBackground();
        this.setBackground(paper);
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
        int width = this.canvasdDimensions.getWidth();
        int height = this.canvasdDimensions.getHeight();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x,y,width,height);
        g.setColor(Color.RED);
        //g.drawLine(0,0, width, height);
        //g.drawLine(0,height, width,0);
        int xx = 0;
        int youngCells;
        int youngAndFatCells;
        int fullAgeCells;
        int hungryCells;
        int oldCells;
        int all;
        int maxPopulation = 0;
        for(SimulatedEvolutionPopulationCensus o:this.container.getData()){
            maxPopulation = Math.max(o.getPopulation(), maxPopulation);
        }
        double zoom = 100 / maxPopulation;
        for(SimulatedEvolutionPopulationCensus o:this.container.getData()){
            xx++;
            all = height - (int)(o.getPopulation() * zoom);
            youngCells = height - (int)(o.getYoungCells() * zoom);
            youngAndFatCells = height - (int)(o.getYoungAndFatCells() * zoom);
            fullAgeCells = height - (int)(o.getFullAgeCells() * zoom);
            hungryCells = height - (int)(o.getHungryCells() * zoom);
            oldCells = height - (int)(o.getOldCells() * zoom);
            g.setColor(POPULATION.getColorForeground());
            g.drawLine(xx,all,xx,all);
            g.setColor(YOUNG.getColor());
            g.drawLine(xx,youngCells,xx,youngCells);
            g.setColor(YOUNG_AND_FAT.getColor());
            g.drawLine(xx,youngAndFatCells,xx,youngAndFatCells);
            g.setColor(FULL_AGE.getColor());
            g.drawLine(xx,fullAgeCells,xx,fullAgeCells);
            g.setColor(HUNGRY.getColor());
            g.drawLine(xx,hungryCells,xx,hungryCells);
            g.setColor(OLD.getColor());
            g.drawLine(xx,oldCells,xx,oldCells);
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

}
