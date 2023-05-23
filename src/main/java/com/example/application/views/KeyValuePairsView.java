package com.example.application.views;

import com.example.application.components.KeyValuePair;
import com.example.application.components.KeyValuePairs;
import com.example.application.utilities.GridColumnSpan;
import com.example.application.utilities.GridColumns;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Key-Value Pairs")
@Route(value = "key-value-pairs", layout = MainLayout.class)
public class KeyValuePairsView extends View {

	public KeyValuePairsView() {
		addH2("Horizontal with Breakpoint");
		KeyValuePairs pairs = createKeyValuePairs();
		add(pairs);

		addH2("Horizontal without Breakpoint");
		pairs = createKeyValuePairs();
		pairs.removeBreakpoint();
		add(pairs);

		addH2("Vertical");
		pairs = createKeyValuePairs();
		pairs.setKeyPosition(KeyValuePair.KeyPosition.TOP);
		add(pairs);

		addH2("Column Span");
		pairs = createKeyValuePairs();
		pairs.setColumns(GridColumns.COLUMNS_2);
		pairs.setColumnSpan(
				GridColumnSpan.COLUMN_SPAN_2,
				// Just beautiful...
				(HasStyle) pairs.getChildren().skip(2).findFirst().get()
		);
		pairs.setKeyPosition(KeyValuePair.KeyPosition.TOP);
		add(pairs);

		addH2("Theme: Dividers");
		pairs = createKeyValuePairs();
		pairs.setDividers(true);
		add(pairs);

		addH2("Theme: Stripes");
		pairs = createKeyValuePairs();
		pairs.setStripes(true);
		add(pairs);
	}

	private KeyValuePairs createKeyValuePairs() {
		return new KeyValuePairs(
				new KeyValuePair("Name", "John Smith"),
				new KeyValuePair("Email", "john.smith@company.com"),
				new KeyValuePair("About", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
				new KeyValuePair("Actions", new Button("Edit", VaadinIcon.EDIT.create()))
		);
	}

}
