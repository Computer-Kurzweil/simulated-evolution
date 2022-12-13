package org.woehlke.computer.kurzweil.simulated.evolution.model.lattice;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
public enum LatticeNeighbourhoodType {

    /**
     * https://en.wikipedia.org/wiki/Von_Neumann_neighborhood
     */
    VON_NEUMANN_NEIGHBORHOOD,

    /**
     * https://en.wikipedia.org/wiki/Moore_neighborhood
     */
    MOORE_NEIGHBORHOOD,

    WOEHLKE_NEIGHBORHOOD;
}
