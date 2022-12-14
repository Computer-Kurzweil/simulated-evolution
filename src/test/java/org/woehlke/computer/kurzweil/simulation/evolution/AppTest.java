package org.woehlke.computer.kurzweil.simulation.evolution;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple AppMainDesktop.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    @Order(1)
    public void testApp()
    {
        boolean result = true;
        assertTrue(result);
    }

    @Test
    @Order(2)
    public void testAnotherOne()
    {
        boolean result = true;
        assertTrue(result);
    }
}
