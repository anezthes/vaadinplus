package com.example.application.components;

import com.example.application.utilities.Gap;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.theme.lumo.LumoUtility.IconSize;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * Convenience class for creating menu items with icons.
 */
public class Item extends Layout {

    public Item(String text, LineAwesomeIcon icon) {
        setAlignItems(FlexComponent.Alignment.CENTER);
        setGap(Gap.SMALL);

        SvgIcon svgIcon = icon.create();
        svgIcon.addClassNames(IconSize.SMALL);
        add(svgIcon, new Text(text));
    }

}
