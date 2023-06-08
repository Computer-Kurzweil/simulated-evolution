package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus.*;


import java.awt.*;
import java.io.Serializable;

/**
 * The Status of the Cell's LifeCycle.
 * It is Displayed as Color of the Cell.
 *
 * @see LifeCycle
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 25.08.13
 * Time: 12:40
 */
@Log4j2
@Getter
@ToString
public enum LifeCycleStatus implements Serializable {

    YOUNG(new YoungStatus()),
    YOUNG_AND_FAT(new YoungAndFatStatus()),

    ADULT_AGE(new AdultAgeStatus()),
    HUNGRY(new HungryStatus()),
    OLD(new OldStatus()),
    DEAD(new DeadStatus()),
    POPULATION(new PopulationStatus());

    private final CensusCellStatus cellStatus;
    LifeCycleStatus(CensusCellStatus cellStatus){
        this.cellStatus = cellStatus;
    }

    public void countStatus(SimulatedEvolutionPopulationCensus census){
        cellStatus.countStatus(census);
    }
    public Color getColor() { return cellStatus.getColor(); }
    public Color getColorForeground() {
        return cellStatus.getColorForeground();
    }
    public Color getColorBackground() {
        return cellStatus.getColorBackground();
    }
}
