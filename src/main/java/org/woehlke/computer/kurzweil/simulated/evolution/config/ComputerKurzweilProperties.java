package org.woehlke.computer.kurzweil.simulated.evolution.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.view.tabs.TabType;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Valid
@Getter
@Setter
////@Validated
public class ComputerKurzweilProperties {

    @Valid
    public Allinone allinone = new Allinone();

    @Valid
    public Mandelbrot mandelbrot = new Mandelbrot();

    @Valid
    public SimulatedEvolution simulatedevolution = new SimulatedEvolution();

    @Valid
    public Cca cca = new Cca();

    @Valid
    public WienerProcess randomwalk = new WienerProcess();

    @Valid
    public Dla dla = new Dla();

    @Valid
    public Kochsnowflake kochsnowflake = new Kochsnowflake();

    @Valid
    public Samegame samegame = new Samegame();

    @Valid
    public Sierpinskitriangle sierpinskitriangle = new Sierpinskitriangle();

    @Valid
    public Tetris tetris = new Tetris();

    @Valid
    public Turmite turmite = new Turmite();

    @Valid
    public Wator wator = new Wator();

    @Valid
    public Gameoflive gameoflive = new Gameoflive();

    ////@Validated
    @ToString
    @Getter
    @Setter
    public static class Allinone {

        @Valid
        public Lattice lattice = new Lattice();

        @Valid
        public View view = new View();

        ////@Validated
        @Getter
        @Setter
        @ToString
        public static class Lattice {

            @NotNull
            private Integer width;

            @NotNull
            private Integer height;
        }

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @NotBlank
            private String copyright;

            @NotNull
            private Integer borderPaddingX;

            @NotNull
            private Integer borderPaddingY;

            @NotNull
            private Integer titleHeight;

            @NotBlank
            private String startStopp;

            @NotBlank
            private String start;

            @NotBlank
            private String stop;

            @NotBlank
            private String info;
        }
    }

    ////@Validated
    @ToString
    @Getter
    @Setter
    public static class Mandelbrot {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @NotBlank
            private String buttonsZoom;

            @NotBlank
            private String buttonsZoomOut;

            @NotBlank
            private String buttonsSwitch;

            @NotBlank
            private String buttonsZoomLabel;

            @NotBlank
            private String buttonsLabel;
        }

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class Control {

            @NotNull
            private Integer threadSleepTime;
        }
    }

    ////@Validated
    @ToString
    @Getter
    @Setter
    public static class SimulatedEvolution {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        @Valid
        public CellConf cellConf = new CellConf();

        @Valid
        public Population population = new Population();

        @Valid
        public Food food = new Food();

        @Valid
        public GardenOfEden gardenOfEden = new GardenOfEden();

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @NotBlank
            private String copyright;

            @NotNull
            private Integer width;

            @NotNull
            private Integer height;

            @NotNull
            private Integer scale;
        }

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class Control {

            @NotNull
            private Integer threadSleepTime;

            @NotNull
            private Integer exitStatus;

            @NotNull
            private Integer queueMaxLength;
        }

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class CellConf {

            @NotNull
            private Integer fatMax;

            @NotNull
            private Integer fatHungerMax;

            @NotNull
            private Integer fatMinimumForSex;

            @NotNull
            private Integer fatAtBirth;

            @NotNull
            private Integer fatPerFood;

            @NotNull
            private Integer ageOfAdulthood;

            @NotNull
            private Integer ageOld;

            @NotNull
            private Integer ageMax;
        }

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class Population {

            @NotNull
            private Integer initialPopulation;

            @NotBlank
            private String panelPopulationStatistics;

            @NotBlank
            private String youngCellsLabel;

            @NotBlank
            private String youngAndFatCellsLabel;

            @NotBlank
            private String fullAgeCellsLabel;

            @NotBlank
            private String hungryCellsLabel;

            @NotBlank
            private String oldCellsLabel;

            @NotBlank
            private String populationLabel;

            @NotBlank
            private String worldIterationLabel;

            @NotBlank
            private String generationOldestLabel;

            @NotBlank
            private String generationYoungestLabel;
        }

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class Food {

            @NotNull
            private Integer foodPerDay;

            @NotNull
            private Integer foodPerDayFieldColumns;

            @NotBlank
            private String foodPerDayLabel;

            @NotBlank
            private String foodPerDayBorderLabel;

            @NotBlank
            private String buttonFoodPerDayIncrease;

            @NotBlank
            private String buttonFoodPerDayDecrease;

            @NotBlank
            private String panelFood;
        }

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class GardenOfEden {

            @NotBlank
            private String panelGardenOfEden;

            @NotNull
            private Boolean gardenOfEdenEnabled;

            @NotBlank
            private String gardenOfEdenEnabledString;

            @NotBlank
            private String gardenOfEdenEnabledToggleButton;

            @NotNull
            private Integer foodPerDay;

            @NotNull
            private Integer gardenOfEdenLatticeDivisor;

            @NotNull
            private Integer gardenOfEdenLatticeDivisorPadding;
        }
    }

    ////@Validated
    @ToString
    @Getter
    @Setter
    public static class Cca {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @Valid
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            @Getter
            @Setter
            public static class Neighborhood {

                @NotBlank
                private String title;

                @NotBlank
                private String typeVonNeumann;

                @NotBlank
                private String typeMoore;

                @NotBlank
                private String typeWoehlke;
            }
        }

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class Control {

            @NotNull
            private Integer threadSleepTime;
        }
    }

    ////@Validated
    @ToString
    @Getter
    @Setter
    public static class WienerProcess {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;
        }

        ////@Validated
        @ToString
        @Getter
        @Setter
        public static class Control {

            @NotNull
            private Integer threadSleepTime;
        }
    }

    //@Validated
    @ToString
    @Getter
    @Setter
    public static class Dla {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;
        }

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class Control {

            @NotNull
            private Integer threadSleepTime;

            @NotNull
            private Integer numberOfParticles;
        }
    }

    @ToString
    @Getter
    @Setter
    public static class Kochsnowflake {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @Valid
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            @Getter
            @Setter
            public static class Neighborhood {

                @NotBlank
                private String title;

                @NotBlank
                private String typeVonNeumann;

                @NotBlank
                private String typeMoore;

                @NotBlank
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class Control {

            @NotNull
            private Integer threadSleepTime;

            @NotNull
            private Integer numberOfParticles;
        }
    }

    @ToString
    @Getter
    @Setter
    public static class Samegame {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @Valid
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            @Getter
            @Setter
            public static class Neighborhood {

                @NotBlank
                private String title;

                @NotBlank
                private String typeVonNeumann;

                @NotBlank
                private String typeMoore;

                @NotBlank
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class Control {

            @NotNull
            private Integer threadSleepTime;

            @NotNull
            private Integer numberOfParticles;
        }
    }

    @ToString
    @Getter
    @Setter
    public static class Sierpinskitriangle {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @Valid
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @Getter
            @Setter
            @ToString
            public static class Neighborhood {

                @NotBlank
                private String title;

                @NotBlank
                private String typeVonNeumann;

                @NotBlank
                private String typeMoore;

                @NotBlank
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        @Getter
        @Setter
        public static class Control {

            @NotNull
            private Integer threadSleepTime;

            @NotNull
            private Integer numberOfParticles;
        }
    }


    @Getter
    @Setter
    @ToString
    public static class Tetris {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @Getter
        @Setter
        @ToString
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @Valid
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @Getter
            @Setter
            @ToString
            public static class Neighborhood {
                @NotBlank
                private String title;

                @NotBlank
                private String typeVonNeumann;

                @NotBlank
                private String typeMoore;

                @NotBlank
                private String typeWoehlke;
            }
        }

        //@Validated
        @Getter
        @Setter
        @ToString
        public static class Control {

            @NotNull
            private Integer threadSleepTime;

            @NotNull
            private Integer numberOfParticles;
        }
    }

    @Getter
    @Setter
    @ToString
    public static class Turmite {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @Getter
        @Setter
        @ToString
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @Valid
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            @Getter
            @Setter
            public static class Neighborhood {

                @NotBlank
                private String title;

                @NotBlank
                private String typeVonNeumann;

                @NotBlank
                private String typeMoore;

                @NotBlank
                private String typeWoehlke;
            }
        }

        //@Validated
        @Getter
        @Setter
        @ToString
        public static class Control {

            @NotNull
            private Integer threadSleepTime;

            @NotNull
            private Integer numberOfParticles;
        }
    }

    @Getter
    @Setter
    @ToString
    public static class Wator {

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @Getter
        @Setter
        @ToString
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @Valid
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @Getter
            @Setter
            @ToString
            public static class Neighborhood {
                @NotBlank
                private String title;

                @NotBlank
                private String typeVonNeumann;

                @NotBlank
                private String typeMoore;

                @NotBlank
                private String typeWoehlke;
            }
        }

        //@Validated
        @Getter
        @Setter
        @ToString
        public static class Control {

            @NotNull
            private Integer threadSleepTime;

            @NotNull
            private Integer numberOfParticles;
        }
    }

    @Getter
    @Setter
    @ToString
    public static class Gameoflive{

        @Valid
        public View view = new View();

        @Valid
        public Control control = new Control();

        //@Validated
        @Getter
        @Setter
        @ToString
        public static class View {

            @NotBlank
            private String title;

            @NotBlank
            private String subtitle;

            @Valid
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @Getter
            @Setter
            @ToString
            public static class Neighborhood {

                @NotBlank
                private String title;

                @NotBlank
                private String typeVonNeumann;

                @NotBlank
                private String typeMoore;

                @NotBlank
                private String typeWoehlke;
            }
        }

        //@Validated
        @Getter
        @Setter
        @ToString
        public static class Control {

            @NotNull
            private Integer threadSleepTime;

            @NotNull
            private Integer numberOfParticles;
        }
    }

    public static ComputerKurzweilProperties propertiesFactory(String conf, String jar){
        log.info("propertiesFactory");
        log.info("propertiesFactory conf: "+conf);
        log.info("propertiesFactory jar:  "+jar);
        ComputerKurzweilProperties properties;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            JarFile jarFile = new JarFile(jar);
            JarEntry entry = jarFile.getJarEntry(conf);
            InputStream input = jarFile.getInputStream(entry);
            properties = mapper.readValue(input, ComputerKurzweilProperties.class);
            log.info(properties.toString());
        } catch (Exception e) {
            e.printStackTrace();
            properties = new ComputerKurzweilProperties();
        }
        log.info("propertiesFactory done");
        return properties;
    }

    public String getSubtitle(TabType tabType){
        switch (tabType){
            case CYCLIC_CELLULAR_AUTOMATON:
                return this.getCca().getView().getSubtitle();
            case DIFFUSION_LIMITED_AGGREGATION:
                return this.getDla().getView().getSubtitle();
            case SIMULATED_EVOLUTION:
                return this.getSimulatedevolution().getView().getSubtitle();
            case MANDELBROT_SET:
                return this.getMandelbrot().getView().getSubtitle();
            case RANDOM_WALK_WIENER_PROCESS:
                return this.getRandomwalk().getView().getSubtitle();
            case KOCH_SNOWFLAKE:
                return this.getKochsnowflake().getView().getSubtitle();
            case SAME_GAME:
                return this.getSamegame().getView().getSubtitle();
            case SIERPINSKI_TRIANGLE:
                return this.getSierpinskitriangle().getView().getSubtitle();
            case TETRIS:
                return this.getTetris().getView().getSubtitle();
            case TURMITE:
                return this.getTurmite().getView().getSubtitle();
            case WATOR:
                return this.getWator().getView().getSubtitle();
            case CONWAYS_GAME_OF_LIFE:
                return this.getGameoflive().getView().getSubtitle();
            default:
                return "UNDEFINED";
        }
    }

    public String getTitle(TabType tabType){
        switch (tabType){
            case CYCLIC_CELLULAR_AUTOMATON:
                return this.getCca().getView().getTitle();
            case DIFFUSION_LIMITED_AGGREGATION:
                return this.getDla().getView().getTitle();
            case SIMULATED_EVOLUTION:
                return  this.getSimulatedevolution().getView().getTitle();
            case MANDELBROT_SET:
                return this.getMandelbrot().getView().getTitle();
            case RANDOM_WALK_WIENER_PROCESS:
                return this.getRandomwalk().getView().getTitle();
            case KOCH_SNOWFLAKE:
                return this.getKochsnowflake().getView().getTitle();
            case SAME_GAME:
                return this.getSamegame().getView().getTitle();
            case SIERPINSKI_TRIANGLE:
                return  this.getSierpinskitriangle().getView().getTitle();
            case TETRIS:
                return  this.getTetris().getView().getTitle();
            case TURMITE:
                return this.getTurmite().getView().getTitle();
            case WATOR:
                return this.getWator().getView().getTitle();
            case CONWAYS_GAME_OF_LIFE:
                return this.getGameoflive().getView().getTitle();
            default:
                return "UNDEFINED";
        }
    }
}
