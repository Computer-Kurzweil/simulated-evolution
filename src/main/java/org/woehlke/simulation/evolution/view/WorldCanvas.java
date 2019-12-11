package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfigDefault;
import org.woehlke.simulation.evolution.model.*;
import org.woehlke.simulation.evolution.model.Point;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

import static org.woehlke.simulation.evolution.config.GuiConfigColors.COLOR_FOOD;
import static org.woehlke.simulation.evolution.config.GuiConfigColors.COLOR_WATER;


/**
 * View for the World Data Model for Displaying Food and Bacteria Cells.
 * <p>
 * Simulated Evolution.
 * Artificial Life Simulation of Bacteria Motion depending on DNA.
 * <p>
 * &copy; 2006 - 2018 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 *
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:51:51
 */
public class WorldCanvas extends JComponent implements GuiConfigDefault, Serializable {

  private static final long serialVersionUID = -27002509360079509L;

  /**
   * Reference to the Data Model.
   */
  private final World world;

  public WorldCanvas(World world) {
    this.world = world;
    this.setBackground(COLOR_WATER);
    Dimension preferredSize = new Dimension(
      this.world.getWorldDimensions().getWidth(),
      this.world.getWorldDimensions().getHeight()
    );
    this.setPreferredSize(preferredSize);
  }

  /**
   * Paint the World on the Canvas and show Food and Bacteria Cells.
   *
   * @param g Graphics Context with the Tools for Painting.
   */
  public void paint(Graphics g) {
    super.paintComponent(g);
    int width = world.getWorldDimensions().getWidth();
    int height = world.getWorldDimensions().getHeight();
    g.setColor(COLOR_WATER);
    g.fillRect(0, 0, width, height);
    g.setColor(COLOR_FOOD);
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (world.hasFood(x, y)) {
          g.drawLine(x, y, x, y);
        }
      }
    }
    List<Cell> population = world.getAllCells();
    for (Cell p : population) {
      Point[] square = p.getPosition().getNeighbourhood(world.getWorldDimensions());
      g.setColor(p.getLifeCycleStatus().getColor());
      for (Point pixel : square) {
        g.drawLine(pixel.getX(), pixel.getY(), pixel.getX(), pixel.getY());
      }
    }
  }

  public void update(Graphics g) {
    Dimension preferredSize = new Dimension(
      this.world.getWorldDimensions().getWidth(),
      this.world.getWorldDimensions().getHeight()
    );
    this.setPreferredSize(preferredSize);
    paint(g);
  }

  public World getWorld() {
    return world;
  }
}
