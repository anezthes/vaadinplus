package com.example.application.components;

import com.example.application.utilities.FlexRowBreakpoint;
import com.example.application.utilities.Gap;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.DescriptionList;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class KeyValuePair extends Layout {

	private com.example.application.utilities.FlexDirection direction;
	private FlexRowBreakpoint breakpoint;

	private DescriptionList.Term key;
	private DescriptionList.Description value;

	public KeyValuePair(String key, String value) {
		this(new Text(key), new Text(value));
	}

	public KeyValuePair(String key, Component value) {
		this(new Text(key), value);
	}

	public KeyValuePair(Component key, Component value) {
		this.key = new DescriptionList.Term(key);
		this.key.addClassNames(
				LumoUtility.FontSize.SMALL, LumoUtility.FontWeight.MEDIUM, LumoUtility.TextColor.SECONDARY
		);

		this.value = new DescriptionList.Description(value);
		this.value.addClassNames(LumoUtility.Margin.NONE);

		add(this.key, this.value);

		addClassNames(LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.Padding.Vertical.SMALL);
		setAlignItems(Alignment.BASELINE);
		setBreakpoint(FlexRowBreakpoint.MEDIUM);
		setColumnGap(Gap.MEDIUM);
		setFlexDirection(com.example.application.utilities.FlexDirection.ROW);
		setKeyWidth(25, Unit.PERCENTAGE);
	}

	public void setBreakpoint(FlexRowBreakpoint breakpoint) {
		if (this.breakpoint != null) {
			removeClassNames(this.breakpoint.getClassName());
		}
		this.breakpoint = breakpoint;
		updateClassNames();
	}

	public void removeBreakpoint() {
		setBreakpoint(null);
	}

	public void setFlexDirection(com.example.application.utilities.FlexDirection direction) {
		if (this.direction != null) {
			removeClassNames(this.direction.getClassName());
		}
		this.direction = direction;
		updateClassNames();
	}

	public void setKeyWidth(float width, Unit unit) {
		this.key.setMinWidth(width, unit);
	}

	private void updateClassNames() {
		if (this.direction != null) {
			if (this.direction.equals(com.example.application.utilities.FlexDirection.ROW)) {
				// If there's a breakpoint, we set the flex direction to column
				// because our responsive styles are mobile-first.
				if (this.breakpoint != null) {
					addClassNames(LumoUtility.FlexDirection.COLUMN);
					addClassNames(this.breakpoint.getClassName());
				} else {
					removeClassNames(LumoUtility.FlexDirection.COLUMN);
				}
			} else {
				addClassNames(LumoUtility.FlexDirection.COLUMN);
				if (this.breakpoint != null) {
					removeClassNames(this.breakpoint.getClassName());
				}
			}
		}
	}

}
