package org.woehlke.simulation.evolution;

import org.woehlke.simulation.evolution.config.GuiConfig;
import org.woehlke.simulation.evolution.config.WorldMapFoodConf;

import java.awt.*;
import java.io.Serializable;

/**
 * The Config for running the Simulation.
 *
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 *
 * (C) 2013 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 17.11.2018
 * Time: 16:33:14
 */
public class SimulatedEvolutionConfig implements Serializable, GuiConfig, WorldMapFoodConf {

    private static final long serialVersionUID = -4370382255481437491L;

  /**
   * TODO write doc.
   */
    private final String title;

  /**
   * TODO write doc.
   */
    private final String subtitle;

  /**
   * TODO write doc.
   */
    private final String footer;

  /**
   * TODO write doc.
   */
    private final int scale;

  /**
   * TODO write doc.
   */
    private final int width;

  /**
   * TODO write doc.
   */
    private final int height;

  /**
   * TODO write doc.
   */
    private final int heightOfTitle;

  /**
   * TODO write doc.
   */
    private final int startPositionOnScreenX;

  /**
   * TODO write doc.
   */
    private final int startPositionOnScreenY;


  /**
   * TODO write doc.
   */
    private final int queueMaxLength;

  /**
   * TODO write doc.
   */
    private final int initialPopulation;

  /**
   * TODO write doc.
   */
    private Dimension preferredSize;

  /**
   * TODO write doc.
   */
    private Rectangle frameRectangle;

  /**
   * TODO write doc.
   */
    private Rectangle panelNorthRectangle;

  /**
   * TODO write doc.
   */
    private Rectangle panelSouthRectangle;

  /**
   * TODO write doc.
   */
    private Rectangle canvasRectangle;

  /**
   * TODO write doc.
   */
    public SimulatedEvolutionConfig(){
        this.title = TITLE;
        this.scale = SCALE;
        this.width = WIDTH * SCALE;
        this.height = HEIGHT * SCALE;
        this.subtitle = SUB_TITLE;
        this.footer = FOOTER;
        this.heightOfTitle = HEIGHT_OF_TITLE;
        this.startPositionOnScreenX = START_POSITION_ON_SCREEN_X;
        this.startPositionOnScreenY = START_POSITION_ON_SCREEN_Y;
        this.queueMaxLength = QUEUE_MAX_LENGTH;
        this.initialPopulation = INITIAL_POPULATION;
        init();
    }

  /**
   * TODO write doc.
   */
    public SimulatedEvolutionConfig(
        String title, String subtitle, String footer,
        int scale, int width, int height, int heightOfTitle,
        int startPositionOnScreenX, int startPositionOnScreenY, int queueMaxLength, int initialPopulation
    ) {
        this.title = title;
        this.scale = scale;
        this.width = width * scale;
        this.height = height * scale;
        this.subtitle = subtitle;
        this.footer = footer;
        this.heightOfTitle = heightOfTitle;
        this.startPositionOnScreenX = startPositionOnScreenX;
        this.startPositionOnScreenY = startPositionOnScreenY;
        this.queueMaxLength = queueMaxLength;
        this.initialPopulation = initialPopulation;
        init();
    }

  /**
   * TODO write doc.
   */
    public void init(){
        int width = this.getWidth();
        int height = ( this.scale * this.getHeightOfTitle() );
        int height2 = this.getHeight() + height;
        int height3 = height2 + height;
        int startX = this.getStartPositionOnScreenX();
        int startY = this.getStartPositionOnScreenY();
        int startY2 = startY  + this.getHeightOfTitle();
        int startY3 = startY2 + this.getHeight();
        this.preferredSize = new Dimension(width, height);
        this.panelNorthRectangle = new Rectangle(
            startX, startY, width, height
        );
        this.canvasRectangle = new Rectangle(
            startX, startY2, width, height2
        );
        this.panelSouthRectangle = new Rectangle(
            startX, startY3, width, height
        );
        this.frameRectangle = new Rectangle(
            startX, startY, width, height3
        );
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getFooter() {
        return footer;
    }

    public int getHeightOfTitle() {
        return heightOfTitle;
    }

    public int getStartPositionOnScreenX() {
        return startPositionOnScreenX;
    }

    public int getStartPositionOnScreenY() {
        return startPositionOnScreenY;
    }

    public Dimension getPreferredSize() {
        return preferredSize;
    }

    public Rectangle getFrameRectangle() {
        return frameRectangle;
    }

    public Rectangle getPanelNorthRectangle() {
        return panelNorthRectangle;
    }

    public Rectangle getPanelSouthRectangle() {
        return panelSouthRectangle;
    }

    public Rectangle getCanvasRectangle() {
        return canvasRectangle;
    }

    public int getQueueMaxLength() {
        return queueMaxLength;
    }

    public int getInitialPopulation() {
        return initialPopulation;
    }
}
