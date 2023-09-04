package com.example.application.components;

import com.example.application.utilities.Gap;
import com.example.application.utilities.IconSize;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * Convenience class for creating menu items with icons.
 */
public class Item extends Layout {

    public Item(String text, LineAwesomeIcon icon) {
        setAlignItems(FlexComponent.Alignment.CENTER);
        setGap(Gap.SMALL);

        Component i = icon.create();
        i.getStyle().set("--_size", IconSize.SMALL.getCSSVariable());
        add(i, new Text(text));
    }

    public Item(LineAwesomeIcon icon) {
        Component i = icon.create();
        i.getStyle().set("--_size", IconSize.SMALL.getCSSVariable());
        add(i);
    }

}
