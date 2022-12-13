package org.woehlke.computer.kurzweil.simulated.evolution.config;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.model.lattice.LatticePoint;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.CellCore;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.util.Date;
import java.util.Random;

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
@ToString(exclude={"random","frame"},callSuper=true)
public class ComputerKurzweilContext {

    private final Random random;
    private final ComputerKurzweilProperties properties;

    public ComputerKurzweilContext(
        ComputerKurzweilProperties computerKurzweilProperties
    ) {
        this.properties = computerKurzweilProperties;
        long seed = new Date().getTime();
        this.random = new Random(seed);
    }

    public CompoundBorder getTabbedPaneBorder() {
        return getBorder();
    }

    public CompoundBorder getFrameBorder(){
        return getBorder();
    }

    public CompoundBorder getBorder(){
        int left = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int right = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int top = this.getProperties().getAllinone().getView().getBorderPaddingY();
        int bottom = this.getProperties().getAllinone().getView().getBorderPaddingY();
        return BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(),
            BorderFactory.createEmptyBorder(left,right,top,bottom)
        );
    }

    public CompoundBorder getBorder(String label){
        int top = this.getProperties().getAllinone().getView().getBorderPaddingY();
        int left = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int bottom = this.getProperties().getAllinone().getView().getBorderPaddingY();
        int right = this.getProperties().getAllinone().getView().getBorderPaddingX();
        return BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(label),
            BorderFactory.createEmptyBorder(top,left,bottom,right)
        );
    }

    private CompoundBorder getDoubleBorder(){
        int left = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int right = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int top = this.getProperties().getAllinone().getView().getBorderPaddingY();
        int bottom = this.getProperties().getAllinone().getView().getBorderPaddingY();
        return BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(left,right,top,bottom),
            BorderFactory.createEmptyBorder(left,right,top,bottom)
        );
    }

    private CompoundBorder getDoubleBorder(String label){
        int left = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int right = this.getProperties().getAllinone().getView().getBorderPaddingX();
        int top = this.getProperties().getAllinone().getView().getBorderPaddingY();
        int bottom = this.getProperties().getAllinone().getView().getBorderPaddingY();
        return BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(left,right,top,bottom),
            BorderFactory.createEmptyBorder(left,right,top,bottom)
        );
    }

    public CompoundBorder getBottomButtonsPanelBorder(){
        return getDoubleBorder();
    }

    public CompoundBorder getBottomButtonsPanelBorder(String label){
        return getDoubleBorder(label);
    }

    private Border getZeroBorder() {
        int top = 0;
        int left = 0;
        int bottom = 0;
        int right = 0;
        return BorderFactory.createEmptyBorder(top,left,bottom,right);
    }

    public Border getTabBorder() {
        return getZeroBorder();
    }

    public Border getCanvasBorder() {
        return getZeroBorder();
    }

    public LatticePoint getWorldDimensions(){
        int x = this.properties.getAllinone().getLattice().getWidth();
        int y = this.properties.getAllinone().getLattice().getHeight();
        return new LatticePoint(x,y);
    }

    public LatticePoint getNextRandomLatticePoint() {
        int x = this.properties.getAllinone().getLattice().getWidth();
        int y = this.properties.getAllinone().getLattice().getHeight();
        int nextX = this.getRandom().nextInt(x);
        int nextY = this.getRandom().nextInt(y);
        LatticePoint p = new LatticePoint(nextX,nextY);
        p.normalize(this.getWorldDimensions());
        p.absoluteValue();
        return p;
    }

    public LifeCycle getNewCellLifeCycle() {
        return new LifeCycle(this.properties.getSimulatedevolution().getCellConf().getFatAtBirth());
    }

    public CellCore getNewCellCore() {
        return new CellCore(this.random);
    }

    public void start(){ }

    public void stop() { }

}
