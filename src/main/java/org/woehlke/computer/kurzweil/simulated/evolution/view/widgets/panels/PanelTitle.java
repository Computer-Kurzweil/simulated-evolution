package org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.panels;


import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
//import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilContext;
import org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.layouts.FlowLayoutCenter;

import javax.swing.*;
import java.io.Serializable;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Log4j2
@ToString
@EqualsAndHashCode(callSuper=true)
@Deprecated
public class PanelTitle extends JPanel implements Serializable {

    static final long serialVersionUID = 242L;

    public PanelTitle(String text) {
        this.setLayout(new FlowLayoutCenter());
        this.add(new JLabel(text));
    }

    public void showMe() {
        this.setVisible(true);
    }

    /*
    public static PanelTitle getPanelTitleForApplication(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getAllinone().getView().getTitle();
        return new PanelTitle(text);
    }

    public static PanelTitle getPanelTitleForCca(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getCca().getView().getTitle();
        return new PanelTitle(text);
    }

    public static PanelTitle getPanelTitleForDla(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getDla().getView().getTitle();
        return new PanelTitle(text);
    }

    public static PanelTitle getPanelTitleForSimulatedEvolution(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getSimulatedevolution().getView().getTitle();
        return new PanelTitle(text);
    }

    public static PanelTitle getPanelTitleForSimulatedKochSnowflake(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getKochsnowflake().getView().getTitle();
        return new PanelTitle(text);
    }

    public static PanelTitle getPanelTitleForMandelbrot(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getMandelbrot().getView().getTitle();
        return new PanelTitle(text);
    }


    public static PanelTitle getPanelTitleForSameGame(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getSamegame().getView().getTitle();
        return new PanelTitle(text);
    }

    public static PanelTitle getPanelTitleForSierpinskiTriangle(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getSierpinskitriangle().getView().getTitle();
        return new PanelTitle(text);
    }

    public static PanelTitle getPanelTitleForSierpinskiTetris(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getTetris().getView().getTitle();
        return new PanelTitle(text);
    }

    public static PanelTitle getPanelTitleForSierpinskiTurmite(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getTurmite().getView().getTitle();
        return new PanelTitle(text);
    }

    public static PanelTitle getPanelTitleForSierpinskiWaTor(ComputerKurzweilContext ctx) {
        String text = ctx.getProperties().getWator().getView().getTitle();
        return new PanelTitle(text);
    }
    */
}
