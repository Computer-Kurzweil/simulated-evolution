package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensusContainer;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus;
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

    private final Color paper;

    private final LatticeDimension canvasDimensions;

    public CensusCanvas(SimulatedEvolutionModel tabModel) {
        int width = tabModel.getWorldDimensions().getX();
        int height = tabModel.getProperties().getSimulatedevolution().getView().getHeightOfStatisticsCanvas();
        this.container = tabModel.getCensusContainer();
        this.canvasDimensions = LatticeDimension.of(width, height);
        Dimension preferredSize = new Dimension(width, height);
        this.setSize(preferredSize);
        this.setPreferredSize(preferredSize);
        this.paper = POPULATION.getColorBackground();
        this.setBackground(this.paper);
        this.setVisible(true);
    }

    public void showMe() {
        int width = canvasDimensions.getWidth();
        int height = canvasDimensions.getHeight();
        Dimension preferredSize = new Dimension(width, height);
        this.setSize(preferredSize);
        this.setBackground(this.paper);
        this.setVisible(true);
    }

    /**
     * Paint the World on the Canvas and show Food and Bacteria Cells.
     * @param g Graphics Context with the Tools for Painting.
     */
    public void paint(Graphics g) {
        super.paintComponent(g);
        int width = this.canvasDimensions.getWidth();
        int height = this.canvasDimensions.getHeight();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);
        paintPopulationCensus(g, LifeCycleStatus.YOUNG);
        paintPopulationCensus(g, LifeCycleStatus.YOUNG_AND_FAT);
        paintPopulationCensus(g, LifeCycleStatus.ADULT_AGE);
        paintPopulationCensus(g, LifeCycleStatus.OLD);
    }

    private void paintPopulationCensus(Graphics g, LifeCycleStatus status) {
        int height = this.canvasDimensions.getHeight();
        double zoom = getZoom();
        int xx = 0;
        for (SimulatedEvolutionPopulationCensus census : this.container.getData()) {
            xx++;
            int value = getValueByStatus(census, status);
            int cellHeight = height - (int) (value * zoom);
            Color color = status.getColor();
            g.setColor(color);
            g.drawLine(xx, cellHeight, xx, cellHeight);
        }
    }    

    private int getValueByStatus(SimulatedEvolutionPopulationCensus census, LifeCycleStatus status) {
        switch (status) {
            case YOUNG:
                return census.getYoungCells();
            case YOUNG_AND_FAT:
                return census.getYoungAndFatCells();
            case ADULT_AGE:
                return census.getFullAgeCells();
            case OLD:
                return census.getOldCells();
            default:
                return 0;
        }
    }

    private Color getColorByStatus(LifeCycleStatus status) {
        switch (status) {
            case YOUNG:
                return YOUNG.getColor();
            case YOUNG_AND_FAT:
                return YOUNG_AND_FAT.getColor();
            case ADULT_AGE:
                return ADULT_AGE.getColor();
            case OLD:
                return OLD.getColor();
            default:
                return Color.BLACK;
        }
    }

    public double getZoom() {
        int maxPopulation = 0;
        for (SimulatedEvolutionPopulationCensus census : this.container.getData()) {
            maxPopulation = Math.max(census.getPopulation(), maxPopulation);
        }
        return 100.0d / maxPopulation;
    }

    public void update(Graphics g) {
        paint(g);
    }

}
