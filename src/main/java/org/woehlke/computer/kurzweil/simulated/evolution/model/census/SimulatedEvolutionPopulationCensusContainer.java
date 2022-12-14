package org.woehlke.computer.kurzweil.simulated.evolution.model.census;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;

import java.io.Serializable;
import java.util.ListIterator;
import java.util.Stack;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
@ToString(callSuper = true, exclude={"statistics"})
@EqualsAndHashCode(exclude={"statistics"})
public class SimulatedEvolutionPopulationCensusContainer implements Serializable {

    private static final long serialVersionUID = 242L;

    @Getter
    private volatile long worldIteration;

    private volatile Stack<SimulatedEvolutionPopulationCensus> statistics =
        new Stack<>();

    private final int queueMaxLength;

    public SimulatedEvolutionPopulationCensusContainer(
        ComputerKurzweilProperties p
    ) {
        this.queueMaxLength = p.getSimulatedevolution().getControl().getQueueMaxLength();
        this.worldIteration = 0L;
    }

    public void push(SimulatedEvolutionPopulationCensus populationCensus) {
        this.worldIteration++;
        populationCensus.setWorldIteration(worldIteration);
        statistics.push(populationCensus);
        if (statistics.size() > queueMaxLength) {
            statistics.removeElementAt(0);
        }
        log.info(worldIteration + " : " + populationCensus);
    }

    public SimulatedEvolutionPopulationCensus getCurrentGeneration() {
        if(this.statistics.isEmpty()) {
            return new SimulatedEvolutionPopulationCensus();
        } else {
            return this.statistics.peek();
        }
    }
}
