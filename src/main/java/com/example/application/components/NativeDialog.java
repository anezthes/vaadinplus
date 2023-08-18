package com.example.application.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.*;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Tag("dialog")
public class NativeDialog extends HtmlContainer implements HasAriaLabel {

    public NativeDialog(Component... components) {
        super(components);
        addClassNames(LumoUtility.Background.BASE, LumoUtility.Border.NONE, LumoUtility.BorderRadius.MEDIUM,
                LumoUtility.BoxShadow.LARGE, LumoUtility.Padding.XSMALL);
        getStyle().set("inset", "auto");
    }

    public void open() {
        getElement().setAttribute("open", true);
    }

    public void close() {
        getElement().setAttribute("open", false);
    }

    public void setRight(float size, Unit unit) {
        getStyle().set("inset-inline-end", size + unit.toString());
    }

    public void setTop(float size, Unit unit) {
        getStyle().set("inset-block-start", size + unit.toString());
    }
}
