package org.woehlke.computer.kurzweil.simulated.evolution.view.tabs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.Serializable;


/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
@Log4j2
@Getter
@ToString
@EqualsAndHashCode(callSuper=false)
public abstract class TabPanel extends JPanel implements ActionListener, Serializable {
    private static final long serialVersionUID = 242L;
}
