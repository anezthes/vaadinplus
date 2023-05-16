package com.example.application.views;

import com.example.application.themes.TabsTheme;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Segmented Controls")
@Route(value = "segmented-controls", layout = MainLayout.class)
public class SegmentedControlsView extends Main {

	public SegmentedControlsView() {
		addClassNames(
				LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN, LumoUtility.AlignItems.START,
				LumoUtility.Padding.Bottom.LARGE, LumoUtility.Padding.Horizontal.LARGE, LumoUtility.Gap.XSMALL
		);

		add(new H2("Default"));
		add(createTabs(TabsTheme.SEGMENTED_CONTROLS));
		add(createSmallTabs(TabsTheme.SEGMENTED_CONTROLS));

		add(new H2("Border"));
		add(createTabs(TabsTheme.SEGMENTED_CONTROLS_BORDER));
		add(createSmallTabs(TabsTheme.SEGMENTED_CONTROLS_BORDER));

		add(new H2("Filled"));
		add(createTabs(TabsTheme.SEGMENTED_CONTROLS_FILLED));
		add(createSmallTabs(TabsTheme.SEGMENTED_CONTROLS_FILLED));

		add(new H2("Hollow"));
		add(createTabs(TabsTheme.SEGMENTED_CONTROLS_HOLLOW));
		add(createSmallTabs(TabsTheme.SEGMENTED_CONTROLS_HOLLOW));
	}

	private static Tabs createTabs(String tabsTheme) {
		Tab details = new Tab("Details");
		Tab payment = new Tab("Payment");
		Tab shipping = new Tab("Shipping");

		Tabs tabs = new Tabs(details, payment, shipping);
		tabs.addThemeName(tabsTheme);
		tabs.setWidthFull();
		return tabs;
	}

	private static Tabs createSmallTabs(String tabsTheme) {
		Tab read = new Tab("Read");
		Tab write = new Tab("Write");

		Tabs tabs = new Tabs(read, write);
		tabs.addThemeName(tabsTheme);
		tabs.setWidth("auto");
		return tabs;
	}

}
