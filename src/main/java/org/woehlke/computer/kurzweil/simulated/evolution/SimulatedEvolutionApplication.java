package org.woehlke.computer.kurzweil.simulated.evolution;

import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;

/**
 * Class with main Method for Starting the Desktop Application.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see SimulatedEvolutionTab
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
public class SimulatedEvolutionApplication {

    private SimulatedEvolutionApplication(String configFileName, String jarFilePath) {
        ComputerKurzweilProperties properties = ComputerKurzweilProperties.propertiesFactory(configFileName, jarFilePath);
        SimulatedEvolutionTab simulatedEvolutionTab = new SimulatedEvolutionTab(properties);
    }

    /**
     * Starting the Desktop Application
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        String configFileName = "application.yml";
        String jarFilePath = "target/simulatedevolution.jar";
        SimulatedEvolutionApplication application = new SimulatedEvolutionApplication(configFileName,jarFilePath);
    }
}
