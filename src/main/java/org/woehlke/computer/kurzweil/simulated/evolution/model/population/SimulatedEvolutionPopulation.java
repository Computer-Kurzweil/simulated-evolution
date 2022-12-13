package org.woehlke.computer.kurzweil.simulated.evolution.model.population;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SimulatedEvolutionPopulation {

   private static final long serialVersionUID = 242L;

   private int youngCells;
   private int youngAndFatCells;
   private int fullAgeCells;
   private int hungryCells;
   private int oldCells;
   private int deadCells;
   private int population;
   private long generationYoungest;
   private long generationOldest;
   private long worldIteration;

    /**
   * TODO write doc.
   */
  public void countStatusOfOneCell(LifeCycleStatus status) {
    population++;
    switch (status) {
      case YOUNG:
        youngCells++;
        break;
      case YOUNG_AND_FAT:
        youngAndFatCells++;
        break;
      case FULL_AGE:
        fullAgeCells++;
        break;
      case HUNGRY:
        hungryCells++;
        break;
      case OLD:
        oldCells++;
        break;
      case DEAD:
        deadCells++;
        break;
    }
  }

}
