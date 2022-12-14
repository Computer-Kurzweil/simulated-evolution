package org.woehlke.computer.kurzweil.simulated.evolution.control;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilContext;
import org.woehlke.computer.kurzweil.simulated.evolution.model.world.WorldPoint;
import org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.SimulatedEvolutionCanvas;
import org.woehlke.computer.kurzweil.simulated.evolution.model.SimulatedEvolutionModel;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;

import java.util.concurrent.ForkJoinTask;

import static java.lang.Thread.State.NEW;
/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
@Getter
@ToString(callSuper = false, exclude={"ctx","controller","tab"})
@EqualsAndHashCode(callSuper = false, exclude={"ctx","controller","tab"})
public class SimulatedEvolutionContext extends ForkJoinTask<Void> {

    private static final long serialVersionUID = 242L;

    private final ComputerKurzweilContext ctx;
    private final SimulatedEvolutionTab tab;
    private final SimulatedEvolutionCanvas canvas;
    private final SimulatedEvolutionModel tabModel;

    @Setter
    private SimulatedEvolutionController controller;

    public SimulatedEvolutionContext(
        SimulatedEvolutionTab tab,
        ComputerKurzweilContext ctx
    ) {
       this.tab = tab;
       this.ctx = ctx;
       int scale = 2;
       int width = 320 * scale;
       int height = 234 * scale;
       WorldPoint worldDimensions = new WorldPoint(width,height);
       this.canvas = new SimulatedEvolutionCanvas(  worldDimensions );
       this.tabModel = this.canvas.getTabModel();
       this.controller = new SimulatedEvolutionController();
    }

    public void stopController() {
        this.controller.exit();
        this.controller = null;
        this.controller = new SimulatedEvolutionController();
    }

    public void startController() {
        if(this.controller == null){
            this.controller = new SimulatedEvolutionController();
        } else {
            if(this.controller.getState() != NEW){
                this.stopController();
            }
        }
    }

    @Override
    public Void getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Void value) {

    }

    @Override
    protected boolean exec() {
        this.tab.update();
        this.tab.repaint();
        return true;
    }
}
