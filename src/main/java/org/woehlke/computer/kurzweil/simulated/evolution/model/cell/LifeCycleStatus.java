package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.awt.*;

import static java.awt.Color.*;

/**
 * The Status of the Cell's LifeCycle.
 * It is Displayed as Color of the Cell.
 *
 * @see LifeCycle
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 *
 * Date: 25.08.13
 * Time: 12:40
 */
@Log4j2
@Getter
@ToString
public enum LifeCycleStatus {

    YOUNG(BLUE, WHITE),
    YOUNG_AND_FAT(YELLOW, BLACK),
    FULL_AGE(RED, BLACK),
    HUNGRY(LIGHT_GRAY, WHITE),
    OLD(DARK_GRAY, WHITE),
    DEAD(BLACK, WHITE),
    POPULATION(WHITE, BLACK);

    private Color colorBackground;
    private Color colorFont;

    LifeCycleStatus(Color colorBackground, Color colorFont){
        this.colorBackground=colorBackground;
        this.colorFont = colorFont;
    }

    public Color getColor() { return colorBackground; }
    public Color getColorForeground() {
        return colorFont;
    }
    public Color getColorBackground() {
        return colorBackground;
    }
}
