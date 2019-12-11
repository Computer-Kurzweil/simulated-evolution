package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.SimulatedEvolutionConfig;
import org.woehlke.simulation.evolution.config.GuiConfig;
import org.woehlke.simulation.evolution.config.GuiConfigDefault;
import org.woehlke.simulation.evolution.control.ControllerThreadDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.function.DoubleToIntFunction;

/**
 * This Frame wraps the SimulatedEvolutionApplet which is the Container for this Simulation.
 *
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:47:46
 * @see SimulatedEvolutionApplet
 * @see javax.swing.JFrame
 * @see java.awt.image.ImageObserver
 * @see java.awt.event.WindowListener
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 */
public class SimulatedEvolutionFrame extends JFrame implements ImageObserver,
  MenuContainer,
  Serializable,
  GuiConfigDefault {

  private static final long serialVersionUID = -3830377190196972207L;

  private final GuiConfig guiConfig;

  /**
   * The View for the World. Food and Cells are painted to the Canvas.
   */
  private final WorldCanvas canvas;
  private final PanelSubtitle panelSubtitle;
  private final PanelCopyright panelCopyright;
  private final PanelButtons panelButtons;

  public void showMe() {
    pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double height = rootPane.getHeight();
    double width = rootPane.getWidth();
    double startX =  (screenSize.getWidth() - width) / 2d;
    double startY =  (screenSize.getHeight() - height) / 2d;
    int myheight = Double.valueOf(height).intValue();
    int mywidth =  Double.valueOf(width).intValue();
    int mystartX = Double.valueOf(startX).intValue();
    int mystartY = Double.valueOf(startY).intValue();
    this.setBounds(mystartX,mystartY,mywidth,myheight);
    setVisible(true);
    toFront();
  }

  public SimulatedEvolutionFrame(SimulatedEvolutionConfig guiConfig, WorldCanvas canvas) {
    super(guiConfig.getGuiConfig().getTitle());
    this.guiConfig = guiConfig.getGuiConfig();
    this.panelSubtitle = new PanelSubtitle(this.guiConfig);
    this.panelCopyright = new PanelCopyright(this.guiConfig);
    this.panelButtons = new PanelButtons(guiConfig);
    this.canvas = canvas;
    JSeparator separator = new JSeparator();
    BoxLayout layout = new BoxLayout(rootPane,BoxLayout.PAGE_AXIS);
    rootPane.setLayout(layout);
    rootPane.add(panelSubtitle);
    rootPane.add(canvas);
    rootPane.add(this.panelCopyright);
    rootPane.add(separator);
    rootPane.add(this.panelButtons);
    pack();
  }

  public WorldCanvas getCanvas() {
    return canvas;
  }

  public GuiConfig getGuiConfig() {
    return guiConfig;
  }

  public PanelSubtitle getPanelSubtitle() {
    return panelSubtitle;
  }

  public PanelCopyright getPanelCopyright() {
    return panelCopyright;
  }

  public PanelButtons getPanelButtons() {
    return panelButtons;
  }

  public void addController(ControllerThreadDesktop controller) {
    this.addWindowListener(controller);
    this.addWindowFocusListener(controller);
    this.addWindowStateListener(controller);
    this.panelButtons.addController(controller);
  }

}
