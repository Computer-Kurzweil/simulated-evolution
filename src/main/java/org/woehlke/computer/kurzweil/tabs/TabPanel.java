package org.woehlke.computer.kurzweil.tabs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import javax.swing.*;

@Log4j2
@Getter
@ToString
@EqualsAndHashCode(callSuper=false)
public abstract class TabPanel extends JPanel implements Tab {
    private static final long serialVersionUID = 242L;
}
