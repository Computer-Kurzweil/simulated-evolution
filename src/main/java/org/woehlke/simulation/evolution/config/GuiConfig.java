package org.woehlke.simulation.evolution.config;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * TODO write doc.
 */
public class GuiConfig implements GuiConfigDefault, Serializable {

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
  private final int heightOfFooter;

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
  private Rectangle panelCopyrightRectangle;


  /**
   * TODO write doc.
   */
  private Rectangle panelButtonsRectangle;

  public GuiConfig(){
    this.title = TITLE;
    this.scale = SCALE;
    this.width = WIDTH;
    this.height = HEIGHT;
    this.subtitle = SUB_TITLE;
    this.footer = FOOTER;
    this.heightOfTitle = HEIGHT_OF_TITLE;
    this.heightOfFooter = HEIGHT_OF_FOOTER;
    this.startPositionOnScreenX = START_POSITION_ON_SCREEN_X;
    this.startPositionOnScreenY = START_POSITION_ON_SCREEN_Y;
    init();
  }

  /**
   * TODO write doc.
   */
  public void init() {
    int widthSubtitle = (this.getScale() * this.getWidth());
    int widthCanvas = widthSubtitle;
    int widthFooter = widthSubtitle;
    int widthFrame = widthSubtitle;
    int heightSubtitle = (this.getScale() * this.getHeightOfTitle());
    int heightCanvas = (this.getScale() * this.getHeight());
    int heightCopyright = (this.getScale() * this.getHeightOfTitle());
    int heightButtons = (this.getScale() * this.getHeightOfFooter());
    int heightFooter = (heightCopyright + heightButtons + JSeparator.HEIGHT);
    int heightFrame = heightSubtitle + heightCanvas + heightFooter;
    int startFrameX = this.getStartPositionOnScreenX();
    int startFrameY = this.getStartPositionOnScreenY();
    int startCanvasY = startFrameX + this.getHeightOfTitle();
    int startFooterY = startFrameY + this.getHeight();
    int startCopyrightY = startFooterY;
    int startButtonsY = startCopyrightY + heightCopyright + JSeparator.HEIGHT;
    this.panelNorthRectangle = new Rectangle(
      startFrameX, startFrameY, widthSubtitle, heightSubtitle
    );
    this.canvasRectangle = new Rectangle(
      startFrameX, startCanvasY, widthCanvas , heightCanvas
    );
    this.panelCopyrightRectangle = new Rectangle(
      startFrameX, startCopyrightY, widthFooter, heightCopyright
    );
    this.panelButtonsRectangle = new Rectangle(
      startFrameX, startButtonsY, widthFooter, heightButtons
    );
    this.panelSouthRectangle = new Rectangle(
      startFrameX, startFooterY, widthFooter, heightFooter
    );
    this.frameRectangle = new Rectangle(
      startFrameX, startFrameY, widthFrame, heightFrame
    );
  }

  public String getTitle() {
    return title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public String getFooter() {
    return footer;
  }

  public int getScale() {
    return scale;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getHeightOfTitle() {
    return heightOfTitle;
  }

  public int getHeightOfFooter() {
    return heightOfFooter;
  }

  public int getStartPositionOnScreenX() {
    return startPositionOnScreenX;
  }

  public int getStartPositionOnScreenY() {
    return startPositionOnScreenY;
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

  public Rectangle getPanelCopyrightRectangle() {
    return panelCopyrightRectangle;
  }

  public Rectangle getPanelButtonsRectangle() {
    return panelButtonsRectangle;
  }
}
