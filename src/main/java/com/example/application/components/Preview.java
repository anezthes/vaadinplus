package com.example.application.components;

import com.example.application.utilities.BoxSizing;
import com.example.application.utilities.Gap;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Preview extends Layout {

    public Preview(Component... components) {
        super(components);
        addClassNames(LumoUtility.Background.CONTRAST_5, LumoUtility.BorderRadius.MEDIUM, LumoUtility.Padding.LARGE);
        setBoxSizing(BoxSizing.BORDER);
        setFlexDirection(FlexDirection.COLUMN);
        setGap(Gap.MEDIUM);
    }

}
