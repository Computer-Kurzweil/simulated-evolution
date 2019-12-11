package org.woehlke.simulation.evolution.config;

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

  public GuiConfig(){
    this.title = TITLE;
    this.scale = SCALE;
    this.width = WIDTH;
    this.height = HEIGHT;
    this.subtitle = SUB_TITLE;
    this.footer = FOOTER;
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

}
