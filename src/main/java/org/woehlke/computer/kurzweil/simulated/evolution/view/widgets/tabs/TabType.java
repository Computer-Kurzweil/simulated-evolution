package org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.tabs;

import lombok.Getter;

import java.awt.event.KeyEvent;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Getter
@Deprecated
public enum TabType {

    CYCLIC_CELLULAR_AUTOMATON(
        KeyEvent.VK_1,
        true,
        "Cyclic Cellular Automaton",
        "Cyclic Cellular Automaton",
        "Cyclic Cellular Automaton"
    ),
    DIFFUSION_LIMITED_AGGREGATION(
        KeyEvent.VK_2,
        true,
        "Diffusion Limited Aggregation",
        "Fractal Random Walk due to Brownian Motion Cluster",
        "Diffusion Limited Aggregation. Fractal Random Walk due to Brownian Motion Cluster"
    ),
    SIMULATED_EVOLUTION(
        KeyEvent.VK_3,
        true,
        "Simulated Evolution",
        "Artificial Life Simulation of Bacteria Motion depending on DNA and their Evolution",
        "Artificial Life Simulation of Bacteria Motion depending on DNA and their Evolution"
    ),
    MANDELBROT_SET(
        KeyEvent.VK_4,
        true,
        "Mandelbrot Set",
        "Fractal Mandelbrot Set drawn by a Turing Machine",
        "Fractal Mandelbrot Set drawn by a Turing Machine"
    ),
    RANDOM_WALK_WIENER_PROCESS(
        KeyEvent.VK_5,
        true,
        "Random Walk",
        "Brownian Motion by Fractal Random Walk",
        "Random Walk. Brownian Motion by Fractal Random Walk"
    ),
    KOCH_SNOWFLAKE(
        KeyEvent.VK_6,
        false,
        "Koch Snowflake",
        "Fractal Koch Snowflake",
        "Fractal Koch Snowflake"
    ),
    SAME_GAME(
        KeyEvent.VK_7,
        false,
        "Same Game",
        "Play the Same Game",
        "Play the Same Game"
    ),
    SIERPINSKI_TRIANGLE(
        KeyEvent.VK_0,
        false,
        "Sierpinski Triangle'",
        "Fractal Sierpinski Triangle",
        "Fractal Sierpinski Triangle"
    ),
    TETRIS(
        KeyEvent.VK_8,
        false,
        "Tetris",
        "Play Tetris",
        "Play Tetris"
    ),
    TURMITE(
        KeyEvent.VK_9,
        false,
        "Turmite",
        "Turmites as Turing Machines with 2D Tape",
        "Turmites as Turing Machines with 2D Tape"
    ),
    WATOR(
        KeyEvent.VK_A,
        false,
        "WaTor",
        "Population Dynamics on Planet Water Torus",
        "Population Dynamics on Planet Water Torus"
    ),
    CONWAYS_GAME_OF_LIFE(
        KeyEvent.VK_B,
        false,
        "Conways Game of Life",
        "Conways Game of Life Cellular Automaton",
        "Conways Game of Life Cellular Automaton"
    );

    private int keyEvent;
    private boolean active;
    private String title;
    private String subTitle;
    private String tooltip;

    TabType(int keyEvent, boolean active, String title, String subTitle, String tooltip){
        this.keyEvent=keyEvent;
        this.active=active;
        this.title=title;
        this.subTitle=subTitle;
        this.tooltip=tooltip;
    }

}
