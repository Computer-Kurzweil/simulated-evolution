package org.woehlke.simulation.evolution.view;

import org.woehlke.simulation.evolution.config.GuiConfigDefault;
import org.woehlke.simulation.evolution.model.Cell;
import org.woehlke.simulation.evolution.model.Point;
import org.woehlke.simulation.evolution.model.World;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Graphics;
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

  public WorldCanvas(final World world) {
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
   * @param graphics Graphics Context with the Tools for Painting.
   */
  public void paint(Graphics graphics) {
    super.paintComponent(graphics);
    int width = world.getWorldDimensions().getWidth();
    int height = world.getWorldDimensions().getHeight();
    graphics.setColor(COLOR_WATER);
    graphics.fillRect(0, 0, width, height);
    graphics.setColor(COLOR_FOOD);
    for (int posY = 0; posY < height; posY++) {
      for (int posX = 0; posX < width; posX++) {
        if (world.hasFood(posX, posY)) {
          graphics.drawLine(posX, posY, posX, posY);
        }
      }
    }
    List<Cell> population = world.getAllCells();
    for (Cell cell : population) {
      Point[] square = cell.getPosition().getNeighbourhood(world.getWorldDimensions());
      graphics.setColor(cell.getLifeCycleStatus().getColor());
      for (Point pixel : square) {
        graphics.drawLine(pixel.getX(), pixel.getY(), pixel.getX(), pixel.getY());
      }
    }
  }

  public void update(Graphics graphics) {
    Dimension preferredSize = new Dimension(
      this.world.getWorldDimensions().getWidth(),
      this.world.getWorldDimensions().getHeight()
    );
    this.setPreferredSize(preferredSize);
    paint(graphics);
  }

  public World getWorld() {
    return world;
  }
}
