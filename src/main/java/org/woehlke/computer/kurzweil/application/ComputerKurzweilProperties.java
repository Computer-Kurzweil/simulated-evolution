package org.woehlke.computer.kurzweil.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.tabs.TabType;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Log4j2
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Valid
////@Validated
public class ComputerKurzweilProperties {

    @Valid
    @Getter
    @Setter
    public Allinone allinone = new Allinone();
    @Valid
    @Getter
    @Setter
    public Mandelbrot mandelbrot = new Mandelbrot();
    @Valid
    @Getter
    @Setter
    public SimulatedEvolution simulatedevolution = new SimulatedEvolution();
    @Valid
    @Getter
    @Setter
    public Cca cca = new Cca();
    @Valid
    @Getter
    @Setter
    public WienerProcess randomwalk = new WienerProcess();
    @Valid
    @Getter
    @Setter
    public Dla dla = new Dla();
    @Valid
    @Getter
    @Setter
    public Kochsnowflake kochsnowflake = new Kochsnowflake();
    @Valid
    @Getter
    @Setter
    public Samegame samegame = new Samegame();
    @Valid
    @Getter
    @Setter
    public Sierpinskitriangle sierpinskitriangle = new Sierpinskitriangle();
    @Valid
    @Getter
    @Setter
    public Tetris tetris = new Tetris();
    @Valid
    @Getter
    @Setter
    public Turmite turmite = new Turmite();
    @Valid
    @Getter
    @Setter
    public Wator wator = new Wator();
    @Valid
    @Getter
    @Setter
    public Gameoflive gameoflive = new Gameoflive();

    ////@Validated
    @ToString
    public static class Allinone {

        @Valid
        @Getter
        @Setter
        public Lattice lattice = new Lattice();
        @Valid
        @Getter
        @Setter
        public View view = new View();

        ////@Validated
        @ToString
        public static class Lattice {
            @NotNull
            @Getter
            @Setter
            private Integer width;
            @NotNull
            @Getter
            @Setter
            private Integer height;
        }

        ////@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;
            @NotBlank
            @Getter
            @Setter
            private String copyright;
            @NotNull
            @Getter
            @Setter
            private Integer borderPaddingX;
            @NotNull
            @Getter
            @Setter
            private Integer borderPaddingY;
            @NotNull
            @Getter
            @Setter
            private Integer titleHeight;
            @NotBlank
            @Getter
            @Setter
            private String startStopp;
            @NotBlank
            @Getter
            @Setter
            private String start;
            @NotBlank
            @Getter
            @Setter
            private String stop;
            @NotBlank
            @Getter
            @Setter
            private String info;
        }
    }

    ////@Validated
    @ToString
    public static class Mandelbrot {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        ////@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;
            @NotBlank
            @Getter
            @Setter
            private String buttonsZoom;
            @NotBlank
            @Getter
            @Setter
            private String buttonsZoomOut;
            @NotBlank
            @Getter
            @Setter
            private String buttonsSwitch;
            @NotBlank
            @Getter
            @Setter
            private String buttonsZoomLabel;
            @NotBlank
            @Getter
            @Setter
            private String buttonsLabel;
        }

        ////@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
        }
    }

    ////@Validated
    @ToString
    public static class SimulatedEvolution {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();
        @Valid
        @Getter
        @Setter
        public CellConf cellConf = new CellConf();
        @Valid
        @Getter
        @Setter
        public Population population = new Population();
        @Valid
        @Getter
        @Setter
        public Food food = new Food();
        @Valid
        @Getter
        @Setter
        public GardenOfEden gardenOfEden = new GardenOfEden();

        ////@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;
        }

        ////@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
            @NotNull
            @Getter
            @Setter
            private Integer exitStatus;
            @NotNull
            @Getter
            @Setter
            private Integer queueMaxLength;
        }

        ////@Validated
        @ToString
        public static class CellConf {
            @NotNull
            @Getter
            @Setter
            private Integer fatMax;
            @NotNull
            @Getter
            @Setter
            private Integer fatHungerMax;
            @NotNull
            @Getter
            @Setter
            private Integer fatMinimumForSex;
            @NotNull
            @Getter
            @Setter
            private Integer fatAtBirth;
            @NotNull
            @Getter
            @Setter
            private Integer fatPerFood;
            @NotNull
            @Getter
            @Setter
            private Integer ageOfAdulthood;
            @NotNull
            @Getter
            @Setter
            private Integer ageOld;
            @NotNull
            @Getter
            @Setter
            private Integer ageMax;
        }

        ////@Validated
        @ToString
        public static class Population {
            @NotNull
            @Getter
            @Setter
            private Integer initialPopulation;
            @NotBlank
            @Getter
            @Setter
            private String panelPopulationStatistics;
            @NotBlank
            @Getter
            @Setter
            private String youngCellsLabel;
            @NotBlank
            @Getter
            @Setter
            private String youngAndFatCellsLabel;
            @NotBlank
            @Getter
            @Setter
            private String fullAgeCellsLabel;
            @NotBlank
            @Getter
            @Setter
            private String hungryCellsLabel;
            @NotBlank
            @Getter
            @Setter
            private String oldCellsLabel;
            @NotBlank
            @Getter
            @Setter
            private String populationLabel;
            @NotBlank
            @Getter
            @Setter
            private String generationOldestLabel;
            @NotBlank
            @Getter
            @Setter
            private String generationYoungestLabel;
        }

        ////@Validated
        @ToString
        public static class Food {
            @NotNull
            @Getter
            @Setter
            private Integer foodPerDay;
            @NotNull
            @Getter
            @Setter
            private Integer foodPerDayFieldColumns;
            @NotBlank
            @Getter
            @Setter
            private String foodPerDayLabel;
            @NotBlank
            @Getter
            @Setter
            private String foodPerDayBorderLabel;
            @NotBlank
            @Getter
            @Setter
            private String buttonFoodPerDayIncrease;
            @NotBlank
            @Getter
            @Setter
            private String buttonFoodPerDayDecrease;
            @NotBlank
            @Getter
            @Setter
            private String panelFood;
        }

        ////@Validated
        @ToString
        public static class GardenOfEden {
            @NotBlank
            @Getter
            @Setter
            private String panelGardenOfEden;
            @NotNull
            @Getter
            @Setter
            private Boolean gardenOfEdenEnabled;
            @NotBlank
            @Getter
            @Setter
            private String gardenOfEdenEnabledString;
            @NotBlank
            @Getter
            @Setter
            private String gardenOfEdenEnabledToggleButton;
            @NotNull
            @Getter
            @Setter
            private Integer foodPerDay;
            @NotNull
            @Getter
            @Setter
            private Integer gardenOfEdenLatticeDivisor;
            @NotNull
            @Getter
            @Setter
            private Integer gardenOfEdenLatticeDivisorPadding;
        }
    }

    ////@Validated
    @ToString
    public static class Cca {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {

            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;

            @Valid
            @Getter
            @Setter
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            public static class Neighborhood {
                @NotBlank
                @Getter
                @Setter
                private String title;
                @NotBlank
                @Getter
                @Setter
                private String typeVonNeumann;
                @NotBlank
                @Getter
                @Setter
                private String typeMoore;
                @NotBlank
                @Getter
                @Setter
                private String typeWoehlke;
            }
        }

        ////@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
        }
    }

    ////@Validated
    @ToString
    public static class WienerProcess {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {

            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;
        }

        ////@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
        }
    }

    //@Validated
    @ToString
    public static class Dla {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;
        }

        //@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
            @NotNull
            @Getter
            @Setter
            private Integer numberOfParticles;
        }
    }

    @ToString
    public static class Kochsnowflake {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;

            @Valid
            @Getter
            @Setter
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            public static class Neighborhood {
                @NotBlank
                @Getter
                @Setter
                private String title;
                @NotBlank
                @Getter
                @Setter
                private String typeVonNeumann;
                @NotBlank
                @Getter
                @Setter
                private String typeMoore;
                @NotBlank
                @Getter
                @Setter
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
            @NotNull
            @Getter
            @Setter
            private Integer numberOfParticles;
        }
    }

    @ToString
    public static class Samegame {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;

            @Valid
            @Getter
            @Setter
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            public static class Neighborhood {
                @NotBlank
                @Getter
                @Setter
                private String title;
                @NotBlank
                @Getter
                @Setter
                private String typeVonNeumann;
                @NotBlank
                @Getter
                @Setter
                private String typeMoore;
                @NotBlank
                @Getter
                @Setter
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
            @NotNull
            @Getter
            @Setter
            private Integer numberOfParticles;
        }
    }

    @ToString
    public static class Sierpinskitriangle {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;

            @Valid
            @Getter
            @Setter
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            public static class Neighborhood {
                @NotBlank
                @Getter
                @Setter
                private String title;
                @NotBlank
                @Getter
                @Setter
                private String typeVonNeumann;
                @NotBlank
                @Getter
                @Setter
                private String typeMoore;
                @NotBlank
                @Getter
                @Setter
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
            @NotNull
            @Getter
            @Setter
            private Integer numberOfParticles;
        }
    }

    @ToString
    public static class Tetris {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;

            @Valid
            @Getter
            @Setter
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            public static class Neighborhood {
                @NotBlank
                @Getter
                @Setter
                private String title;
                @NotBlank
                @Getter
                @Setter
                private String typeVonNeumann;
                @NotBlank
                @Getter
                @Setter
                private String typeMoore;
                @NotBlank
                @Getter
                @Setter
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
            @NotNull
            @Getter
            @Setter
            private Integer numberOfParticles;
        }
    }

    @ToString
    public static class Turmite {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;

            @Valid
            @Getter
            @Setter
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            public static class Neighborhood {
                @NotBlank
                @Getter
                @Setter
                private String title;
                @NotBlank
                @Getter
                @Setter
                private String typeVonNeumann;
                @NotBlank
                @Getter
                @Setter
                private String typeMoore;
                @NotBlank
                @Getter
                @Setter
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
            @NotNull
            @Getter
            @Setter
            private Integer numberOfParticles;
        }
    }

    @ToString
    public static class Wator {

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;

            @Valid
            @Getter
            @Setter
            public Neighborhood neighborhood = new Neighborhood();

            //@Validated
            @ToString
            public static class Neighborhood {
                @NotBlank
                @Getter
                @Setter
                private String title;
                @NotBlank
                @Getter
                @Setter
                private String typeVonNeumann;
                @NotBlank
                @Getter
                @Setter
                private String typeMoore;
                @NotBlank
                @Getter
                @Setter
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
            @NotNull
            @Getter
            @Setter
            private Integer numberOfParticles;
        }
    }

    @ToString
    public static class Gameoflive{

        @Valid
        @Getter
        @Setter
        public View view = new View();
        @Valid
        @Getter
        @Setter
        public Control control = new Control();

        //@Validated
        @ToString
        public static class View {
            @NotBlank
            @Getter
            @Setter
            private String title;
            @NotBlank
            @Getter
            @Setter
            private String subtitle;

            @Valid
            @Getter
            @Setter
            public ComputerKurzweilProperties.Wator.View.Neighborhood neighborhood = new Wator.View.Neighborhood();

            //@Validated
            @ToString
            public static class Neighborhood {
                @NotBlank
                @Getter
                @Setter
                private String title;
                @NotBlank
                @Getter
                @Setter
                private String typeVonNeumann;
                @NotBlank
                @Getter
                @Setter
                private String typeMoore;
                @NotBlank
                @Getter
                @Setter
                private String typeWoehlke;
            }
        }

        //@Validated
        @ToString
        public static class Control {
            @NotNull
            @Getter
            @Setter
            private Integer threadSleepTime;
            @NotNull
            @Getter
            @Setter
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
