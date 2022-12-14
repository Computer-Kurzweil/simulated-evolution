package org.woehlke.computer.kurzweil.simulated.evolution.model.population;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;

import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;

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
public class SimulatedEvolutionPopulationContainer implements Serializable {

    private static final long serialVersionUID = 242L;

    @Getter
    private long worldIteration;

    private final ConcurrentLinkedQueue<SimulatedEvolutionPopulationCensus> statistics = new ConcurrentLinkedQueue<>();

    private final int queueMaxLength;

    public SimulatedEvolutionPopulationContainer(
        SimulatedEvolutionModel simulatedEvolutionModel
    ) {
        ComputerKurzweilProperties p = simulatedEvolutionModel.getComputerKurzweilProperties();
        this.queueMaxLength = p.getSimulatedevolution().getControl().getQueueMaxLength();
        this.worldIteration = 0L;
    }

    public void push(SimulatedEvolutionPopulationCensus populationCensus) {
        worldIteration++;
        populationCensus.setWorldIteration(worldIteration);
        statistics.add(populationCensus);
        if (statistics.size() > queueMaxLength) {
            statistics.poll();
        }
        log.info(worldIteration + " : " + populationCensus);
    }

    public SimulatedEvolutionPopulationCensus getCurrentGeneration() {
        if(this.worldIteration>0L) {
            return this.statistics.peek();
        } else {
            return new SimulatedEvolutionPopulationCensus();
        }
    }
}
