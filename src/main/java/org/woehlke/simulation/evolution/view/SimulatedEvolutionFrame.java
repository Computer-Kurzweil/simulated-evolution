package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfigDefault;
import org.woehlke.simulation.evolution.control.ObjectRegistry;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.MenuContainer;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 * This Frame wraps the SimulatedEvolutionApplet which is the Container for this Simulation.
 *
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:47:46
 *
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
  GuiConfigDefault {

  /**
   * TODO write doc.
   */
  public void showMe() {
    pack();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double height = rootPane.getHeight();
    double width = rootPane.getWidth();
    double startX = (screenSize.getWidth() - width) / 2d;
    double startY = (screenSize.getHeight() - height) / 2d;
    int myheight = Double.valueOf(height).intValue();
    int mywidth = Double.valueOf(width).intValue();
    int mystartX = Double.valueOf(startX).intValue();
    int mystartY = Double.valueOf(startY).intValue();
    this.setBounds(mystartX, mystartY, mywidth, myheight);
    rootPane.setVisible(true);
    toFront();
  }

  private final ObjectRegistry ctx;

  public SimulatedEvolutionFrame(ObjectRegistry ctx) {
    super(ctx.getGuiConfig().getTitle());
    this.ctx=ctx;
    JSeparator separator1 = new JSeparator();
    JSeparator separator2 = new JSeparator();
    BoxLayout layout = new BoxLayout(rootPane, BoxLayout.PAGE_AXIS);
    rootPane.setLayout(layout);
    rootPane.add(ctx.getPanelSubtitle());
    rootPane.add(ctx.getCanvas());
    rootPane.add(ctx.getPanelCopyright());
    rootPane.add(separator1);
    rootPane.add(ctx.getPanelLifeCycleStatus());
    rootPane.add(separator2);
    rootPane.add(ctx.getPanelButtons());
    pack();
    showMe();
  }
}
