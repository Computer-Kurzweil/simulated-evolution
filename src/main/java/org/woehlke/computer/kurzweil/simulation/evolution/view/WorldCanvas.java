package org.woehlke.computer.kurzweil.simulation.evolution.view;

import lombok.Getter;
import lombok.Setter;
import org.woehlke.computer.kurzweil.simulation.evolution.model.Cell;
import org.woehlke.computer.kurzweil.simulation.evolution.model.WorldPoint;
import org.woehlke.computer.kurzweil.simulation.evolution.model.WorldModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * View for the World Data Model for Displaying Food and Bacteria Cells.
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://thomas-woehlke.de/p/simulated-evolution/
 * @author Thomas Woehlke
 * Date: 05.02.2006
 * Time: 00:51:51
 */
@Getter
public class WorldCanvas extends JComponent {

    static final long serialVersionUID = 242L;

    /**
     * Reference to the Data Model.
     */
    @Setter
    private WorldModel worldModel;
    private WorldPoint worldDimensions;

    private final Color WATER = Color.BLACK;
    private final Color FOOD = Color.GREEN;

    public WorldCanvas(WorldPoint worldDimensions) {
        this.worldDimensions = worldDimensions;
        this.setBackground(WATER);
        this.setSize(this.worldDimensions.getX(), this.worldDimensions.getY());
    }

    /**
     * Paint the World on the Canvas and show Food and Bacteria Cells.
     * @param g Graphics Context with the Tools for Painting.
     */
    public void paint(Graphics g) {
        super.paintComponent(g);
        int width = worldDimensions.getX();
        int height = worldDimensions.getY();
        g.setColor(WATER);
        g.fillRect(0,0,width,height);
        g.setColor(FOOD);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (worldModel.hasFood(x, y)) {
                    g.drawLine(x,y,x,y);
                }
            }
        }
        List<Cell> population = worldModel.getAllCells();
        for (Cell p:population) {
            WorldPoint[] square = p.getPosition().getNeighbourhood(worldDimensions);
            g.setColor(p.getLifeCycleStatus().getColor());
            for(WorldPoint pixel:square){
                g.drawLine(pixel.getX(),pixel.getY(),pixel.getX(),pixel.getY());
            }
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

}
