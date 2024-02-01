package com.example.application.components.dialogs;

import com.vaadin.flow.component.*;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

@Tag("dialog")
public class NativeDialog extends HtmlContainer implements HasAriaLabel {

    public NativeDialog(Component... components) {
        super(components);
        addClassNames(Background.BASE, Border.NONE, BorderRadius.MEDIUM, BoxShadow.LARGE, Display.BLOCK, Padding.XSMALL);

        // Close the (modal) dialog when clicking outside it
        getElement().executeJs(
                "$0.addEventListener('click', (event) => {" +
                        "if (event.target === $0) {" +
                        "$0.close();" +
                        "}" +
                        "})", getElement());

        // Prevent click & focus events
        getElement().setAttribute("inert", true);

        // Default position
        getStyle().set("inset", "auto");

        // Fix for initial rendering
        getStyle().set("opacity", "0");
    }

    public void showModal() {
        // Allow click & focus events
        getElement().removeAttribute("inert");

        // Not needed after initial rendering
        getStyle().remove("opacity");

        getElement().executeJs("$0.showModal()", getElement());
    }

    public void close() {
        // Prevent click & focus events
        getElement().setAttribute("inert", true);

        getElement().executeJs("$0.close()", getElement());
    }

    public void setRight(float size, Unit unit) {
        getStyle().set("inset-inline-end", size + unit.toString());
    }

    public void setTop(float size, Unit unit) {
        getStyle().set("inset-block-start", size + unit.toString());
    }
}
