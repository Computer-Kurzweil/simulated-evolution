package org.woehlke.computer.kurzweil;

import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.application.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.tabs.simulatedevolution.SimulatedEvolutionTab;

/**
 * Class with main Method for Starting the Desktop Application.
 *
 * @see SimulatedEvolutionTab
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
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
