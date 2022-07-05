package com.example.application.views;

import com.example.application.components.KeyValuePair;
import com.example.application.components.KeyValuePairs;
import com.example.application.utilities.Display;
import com.example.application.utilities.FlexDirection;
import com.example.application.utilities.GridColumnSpan;
import com.example.application.utilities.GridColumns;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Key-Value Pairs | Vaadin+")
@Route(value = "key-value-pairs", layout = MainLayout.class)
public class KeyValuePairsView extends Main {

	public KeyValuePairsView() {
		addClassNames(LumoUtility.Background.CONTRAST_5, LumoUtility.MinHeight.FULL, LumoUtility.Padding.LARGE);

		add(new H2("Horizontal with Breakpoint"));
		KeyValuePairs pairs = new KeyValuePairs(
				new KeyValuePair("Name", "John Smith"),
				new KeyValuePair("Email", "john.smith@company.com"),
				new KeyValuePair("About", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
				new KeyValuePair("Actions", new Button("Edit", VaadinIcon.EDIT.create()))
		);
		add(pairs);

		add(new H2("Horizontal without Breakpoint"));
		pairs = new KeyValuePairs(
				new KeyValuePair("Name", "John Smith"),
				new KeyValuePair("Email", "john.smith@company.com"),
				new KeyValuePair("About", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
				new KeyValuePair("Actions", new Button("Edit", VaadinIcon.EDIT.create()))
		);
		pairs.removeBreakpoint();
		add(pairs);

		add(new H2("Vertical"));
		pairs = new KeyValuePairs(
				new KeyValuePair("Name", "John Smith"),
				new KeyValuePair("Email", "john.smith@company.com"),
				new KeyValuePair("About", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
				new KeyValuePair("Actions", new Button("Edit", VaadinIcon.EDIT.create()))
		);
		pairs.setFlexDirection(FlexDirection.COLUMN);
		add(pairs);

		add(new H2("Border"));
		pairs = new KeyValuePairs(
				new KeyValuePair("Name", "John Smith"),
				new KeyValuePair("Email", "john.smith@company.com"),
				new KeyValuePair("About", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
				new KeyValuePair("Actions", new Button("Edit", VaadinIcon.EDIT.create()))
		);
		pairs.setBorder(true);
		add(pairs);

		add(new H2("Stripes"));
		pairs = new KeyValuePairs(
				new KeyValuePair("Name", "John Smith"),
				new KeyValuePair("Email", "john.smith@company.com"),
				new KeyValuePair("About", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
				new KeyValuePair("Actions", new Button("Edit", VaadinIcon.EDIT.create()))
		);
		pairs.setStripes(true);
		add(pairs);

		add(new H2("Grid"));
		KeyValuePair about = new KeyValuePair("About", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		pairs = new KeyValuePairs(
				new KeyValuePair("Name", "John Smith"),
				new KeyValuePair("Email", "john.smith@company.com"),
				about,
				new KeyValuePair("Actions", new Button("Edit", VaadinIcon.EDIT.create()))
		);
		pairs.setDisplay(Display.GRID);
		pairs.setFlexDirection(FlexDirection.COLUMN);
		pairs.setGridColumns(GridColumns.COLUMNS_2);
		pairs.setGridColumnSpan(GridColumnSpan.COLUMN_SPAN_2, about);
		add(pairs);
	}

}
