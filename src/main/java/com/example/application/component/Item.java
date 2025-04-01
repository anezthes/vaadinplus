package com.example.application.component;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.theme.lumo.LumoUtility.IconSize;


/**
 * Convenience class for creating menu items with icons.
 */
public class Item extends Layout {

    public Item(String text, MaterialSymbol symbol) {
        setAlignItems(Layout.AlignItems.CENTER);
        setGap(Layout.Gap.SMALL);

        add(symbol.create(IconSize.SMALL), new Text(text));
    }

}
