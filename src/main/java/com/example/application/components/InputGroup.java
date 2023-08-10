package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class InputGroup extends Layout {

    public static final String INPUT_GROUP = "input-group";

    public InputGroup(Component... components) {
        super(components);
        addClassName(INPUT_GROUP);
        setFlexDirection(FlexDirection.ROW);

        for (Component component : components) {
            component.addClassNames(LumoUtility.MinWidth.NONE);
        }
    }

    @Override
    public void setFlexDirection(FlexDirection flexDirection) {
        super.setFlexDirection(flexDirection);
        if (flexDirection.equals(FlexDirection.COLUMN)) {
            setAlignItems(Alignment.STRETCH);
        } else {
            setAlignItems(Alignment.BASELINE);
        }
    }
}
