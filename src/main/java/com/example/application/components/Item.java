package com.example.application.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility.IconSize;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * Convenience class for creating menu items with icons.
 */
public class Item extends Layout {

    public Item(String text, LineAwesomeIcon icon) {
        setAlignItems(Layout.AlignItems.CENTER);
        setGap(Layout.Gap.SMALL);

        SvgIcon svgIcon = icon.create();
        svgIcon.addClassNames(IconSize.SMALL);
        add(svgIcon, new Text(text));
    }

    public Item(String text, LumoIcon icon) {
        setAlignItems(Layout.AlignItems.CENTER);
        setGap(Layout.Gap.SMALL);

        Icon i = icon.create();
        i.addClassNames(IconSize.SMALL);
        add(i, new Text(text));
    }

}
