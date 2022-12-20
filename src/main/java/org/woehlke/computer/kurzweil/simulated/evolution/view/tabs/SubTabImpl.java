package org.woehlke.computer.kurzweil.simulated.evolution.view.tabs;

import lombok.Getter;
import lombok.ToString;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.view.widgets.layouts.FlowLayoutCenter;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.event.KeyEvent;
import java.io.Serializable;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see <a href="https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html">Blog Article</a>
 * @see <a href="https://github.com/Computer-Kurzweil/simulated-evolution">Github Repository</a>
 * @see <a href="https://java.woehlke.org/simulated-evolution/">Maven Project Repository</a>
 */
@Getter
@ToString
//TODO rename to AbstractPanel, see also to TabPanel
@Deprecated
public abstract class SubTabImpl extends JPanel implements Serializable {

    static final long serialVersionUID = 242L;

    private final String title;
    private final String subTitle;
    private final String toolTipText;

    // TODO: remove or use it
    @Deprecated
    private final Icon icon;
    private final int keyEvent;
    private final ComputerKurzweilProperties properties;
    private final CompoundBorder border;
    private final FlowLayoutCenter layout;

    // TODO: remove
    @Deprecated
    public SubTabImpl(
        String title,
        String subTitle,
        String toolTipText,
        Icon icon,
        int keyEvent,
        ComputerKurzweilProperties properties
    ) {
        this.title = title;
        this.subTitle = subTitle;
        this.toolTipText = toolTipText;
        this.icon = icon;
        this.keyEvent = keyEvent;
        this.properties = properties;
        this.border = getDoubleBorder();
        this.setBorder(  this.border);
        this.layout = new FlowLayoutCenter();
        this.setLayout( this.layout);
    }

    public SubTabImpl(String title, ComputerKurzweilProperties properties) {
        this.title = title;
        this.subTitle = title;
        this.toolTipText = title;
        this.icon = null;
        this.keyEvent = KeyEvent.CHAR_UNDEFINED;
        this.properties = properties;
        this.border = getDoubleBorder();
        this.setBorder(  this.border);
        this.layout = new FlowLayoutCenter();
        this.setLayout( this.layout);
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

}
