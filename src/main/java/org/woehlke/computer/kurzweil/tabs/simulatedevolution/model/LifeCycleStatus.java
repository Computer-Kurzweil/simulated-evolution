package org.woehlke.computer.kurzweil.tabs.simulatedevolution.model;

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
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
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
    OLD(DARK_GRAY, BLACK),
    DEAD(BLACK, BLACK),
    POPULATION(WHITE, BLACK);

    private Color color;
    private Color colorFont;

    LifeCycleStatus(Color color, Color colorFont){
        this.color=color;
        this.colorFont = colorFont;
    }

    public Color getColorForeground() {
        return colorFont;
    }
    public Color getColorBackground() {
        return color;
    }
}
