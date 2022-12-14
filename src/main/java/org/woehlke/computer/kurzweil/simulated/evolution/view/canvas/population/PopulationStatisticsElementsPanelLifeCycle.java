package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.population;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.view.layouts.FlowLayoutCenter;
import org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.SubTabImpl;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionContext;
import org.woehlke.computer.kurzweil.simulated.evolution.model.population.SimulatedEvolutionPopulationCensus;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.io.Serializable;

import static org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus.*;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
@Getter
@ToString(callSuper = true,exclude = {"tabCtx","border","layout","layoutSubPanel"})
@EqualsAndHashCode(callSuper=true,exclude = {"tabCtx","border","layout","layoutSubPanel"})
public class PopulationStatisticsElementsPanelLifeCycle extends SubTabImpl implements Serializable {

    private static final long serialVersionUID = 242L;

    private final PopulationStatisticsElement youngCellsElement;
    private final PopulationStatisticsElement youngAndFatCellsElement;
    private final PopulationStatisticsElement fullAgeCellsElement;
    private final PopulationStatisticsElement hungryCellsElement;
    private final PopulationStatisticsElement oldCellsElement;

    private final String borderLabel;

    private final int initialPopulation;
    private final String youngCellsLabel;
    private final String youngAndFatCellsLabel;
    private final String fullAgeCellsLabel;
    private final String hungryCellsLabel;
    private final String oldCellsLabel;

    private final CompoundBorder border;
    private final FlowLayoutCenter layout;
    private final FlowLayout layoutSubPanel;

    /**
     * Data Model for the Simulation. The World contains the Bacteria Cells and the Food.
     */
    private SimulatedEvolutionModel simulatedEvolutionModel;

    public PopulationStatisticsElementsPanelLifeCycle(
        String panelPopulationStatistics,
        SimulatedEvolutionModel simulatedEvolutionModel
    ) {
        super(
            panelPopulationStatistics,
            simulatedEvolutionModel.getComputerKurzweilProperties()
            //tabCtx.getCtx().getProperties().getSimulatedevolution().getPopulation().getPanelPopulationStatistics(),
            //tabCtx.getCtx().getProperties()
        );
        //this.tabCtx = tabCtx;
        this.simulatedEvolutionModel = simulatedEvolutionModel;
        this.layoutSubPanel = new FlowLayout();
        this.setLayout(this.layoutSubPanel);
        this.borderLabel = this.simulatedEvolutionModel.getComputerKurzweilProperties()
            .getSimulatedevolution().getPopulation().getPanelPopulationStatistics();
        this.layout = new FlowLayoutCenter();
        this.border = this.getDoubleBorder(this.borderLabel);
        this.setLayout(this.layout);
        this.setBorder(this.border);
        ComputerKurzweilProperties.SimulatedEvolution.Population cfg =
            this.simulatedEvolutionModel.getComputerKurzweilProperties().getSimulatedevolution().getPopulation();
        initialPopulation = cfg.getInitialPopulation();
        youngCellsLabel = cfg.getYoungCellsLabel();
        youngAndFatCellsLabel = cfg.getYoungAndFatCellsLabel();
        fullAgeCellsLabel = cfg.getFullAgeCellsLabel();
        hungryCellsLabel = cfg.getHungryCellsLabel();
        oldCellsLabel = cfg.getOldCellsLabel();
        youngCellsElement = new PopulationStatisticsElement(youngCellsLabel,YOUNG);
        youngAndFatCellsElement = new PopulationStatisticsElement(youngAndFatCellsLabel,YOUNG_AND_FAT);
        fullAgeCellsElement = new PopulationStatisticsElement(fullAgeCellsLabel,FULL_AGE);
        hungryCellsElement = new PopulationStatisticsElement(hungryCellsLabel,HUNGRY);
        oldCellsElement = new PopulationStatisticsElement(oldCellsLabel,OLD);
        this.add(youngCellsElement);
        this.add(youngAndFatCellsElement);
        this.add(fullAgeCellsElement);
        this.add(hungryCellsElement);
        this.add(oldCellsElement);
        update();
    }

    public void update() {
        SimulatedEvolutionPopulationCensus population =
            this.simulatedEvolutionModel.getSimulatedEvolutionPopulationCensusContainer().getCurrentGeneration();
        youngCellsElement.setText(population.getYoungCells());
        youngAndFatCellsElement.setText(population.getYoungAndFatCells());
        fullAgeCellsElement.setText(population.getFullAgeCells());
        hungryCellsElement.setText(population.getHungryCells());
        oldCellsElement.setText(population.getOldCells());
    }

    private CompoundBorder getDoubleBorder(String label){
        int left = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int right = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int top = this.getProperties().getAllinone().getView().getBorderPaddingY();
        int bottom = this.getProperties().getAllinone().getView().getBorderPaddingY();
        return BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(left,right,top,bottom),
            BorderFactory.createEmptyBorder(left,right,top,bottom)
        );
    }
}