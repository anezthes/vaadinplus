package com.example.application.components;

import com.vaadin.flow.component.Component;

public class InputGroup extends Layout {

	public static final String INPUT_GROUP = "input-group";

	public InputGroup(Component... components) {
		addClassName(INPUT_GROUP);
		setFlexDirection(FlexDirection.ROW);
		add(components);
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
