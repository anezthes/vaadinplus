package com.example.application.views;

import com.example.application.components.Highlight;
import com.example.application.components.Highlights;
import com.example.application.components.Tag;
import com.example.application.utilities.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Highlights")
@Route(value = "highlights", layout = MainLayout.class)
public class HighlightsView extends View {

	public static final String ORDERS = "Orders";
	public static final String ORDERS_VALUE = "42,719";
	public static final String ORDERS_CHANGE = "16.38%";
	public static final String ORDERS_WEEKLY = "+17K this week";
	public static final String SALES = "Sales";
	public static final String SALES_VALUE = "€546,110.70";
	public static final String SALES_CHANGE = "40.82%";
	public static final String SALES_WEEKLY = "+34K this week";
	public static final String VISITORS = "Visitors";
	public static final String VISITORS_VALUE = "62,806";
	public static final String VISITORS_CHANGE = "13.35%";
	public static final String VISITORS_WEEKLY = "+26K this week";
	public static final String RATING = "Rating";
	public static final String RATING_VALUE = "96.7%";

	public HighlightsView() {
		addH2("Basic");
		add(createHighlights());

		addH2("Prefix");
		add(createHighlightsWithPrefix());

		addH2("Details");
		add(createHighlightsWithDetails());

		addH2("Suffix");
		add(createHighlightsWithSuffix());

		addH2("Prefix, Details & Suffix");
		add(createHighlightsWithPrefixDetailsSuffix());

		addH2("Breakpoint");
		add(createHighlightsWithBreakpoint());

		addH2("Gap");
		add(createHighlightsWithGap());

		addH2("Grid");
		add(createGridHighlights());

		addH2("Theme: Dividers");
		Highlights highlights = createHighlights();
		highlights.setDividers(true);
		add(highlights);
	}

	private Highlights createHighlights() {
		return new Highlights(
				new Highlight(ORDERS, ORDERS_VALUE),
				new Highlight(SALES, SALES_VALUE),
				new Highlight(VISITORS, VISITORS_VALUE)
		);
	}

	private Highlights createHighlightsWithPrefix() {
		Highlights highlights = new Highlights();

		Highlight highlight = new Highlight(
				createIcon(VaadinIcon.CUBE, BackgroundColor.PRIMARY_10, TextColor.PRIMARY),
				ORDERS, ORDERS_VALUE
		);
		highlights.add(highlight);

		highlight = new Highlight(
				createIcon(VaadinIcon.BAR_CHART, BackgroundColor.SUCCESS_10, TextColor.SUCCESS),
				SALES, SALES_VALUE
		);
		highlights.add(highlight);

		highlight = new Highlight(
				createIcon(VaadinIcon.USERS, BackgroundColor.ERROR_10, TextColor.ERROR),
				VISITORS, VISITORS_VALUE
		);
		highlights.add(highlight);

		return highlights;
	}

	private Icon createIcon(VaadinIcon icon, BackgroundColor backgroundColor, TextColor textColor) {
		Icon i = icon.create();
		i.addClassNames(
				LumoUtility.BorderRadius.LARGE, LumoUtility.Height.XLARGE, LumoUtility.Padding.MEDIUM,
				LumoUtility.Width.XLARGE
		);
		i.addClassNames(backgroundColor.getClassName(), textColor.getClassName());
		return i;
	}

	private Highlights createHighlightsWithDetails() {
		Highlights highlights = new Highlights();

		Highlight highlight = new Highlight(ORDERS, ORDERS_VALUE);
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, ORDERS_CHANGE, TextColor.SUCCESS),
				new Tag(ORDERS_WEEKLY)
		);
		highlights.add(highlight);

		highlight = new Highlight(SALES, SALES_VALUE);
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, SALES_CHANGE, TextColor.SUCCESS),
				new Tag(SALES_WEEKLY)
		);
		highlights.add(highlight);

		highlight = new Highlight(VISITORS, VISITORS_VALUE);
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, VISITORS_CHANGE, TextColor.SUCCESS),
				new Tag(VISITORS_WEEKLY)
		);
		highlights.add(highlight);

		return highlights;
	}

	private Highlights createHighlightsWithSuffix() {
		Highlights highlights = new Highlights();

		Highlight highlight = new Highlight(ORDERS, ORDERS_VALUE, createSuffix(ORDERS));
		highlights.add(highlight);

		highlight = new Highlight(SALES, SALES_VALUE, createSuffix(SALES));
		highlights.add(highlight);

		highlight = new Highlight(VISITORS, VISITORS_VALUE, createSuffix(VISITORS));
		highlights.add(highlight);

		return highlights;
	}

	private RouterLink createSuffix(String label) {
		Icon icon = VaadinIcon.CHEVRON_RIGHT_SMALL.create();
		icon.addClassNames(LumoUtility.IconSize.SMALL, LumoUtility.TextColor.SECONDARY);

		RouterLink link = new RouterLink("", HighlightsView.class);
		link.add(icon);
		link.addClassNames(LumoUtility.Display.FLEX, LumoUtility.Padding.SMALL);
		link.getElement().setAttribute("aria-label", label);
		link.getElement().setAttribute("title", label);
		return link;
	}

	private Highlights createHighlightsWithPrefixDetailsSuffix() {
		Highlights highlights = new Highlights();

		Highlight highlight = new Highlight(
				createIcon(VaadinIcon.CUBE, BackgroundColor.PRIMARY_10, TextColor.PRIMARY),
				ORDERS, ORDERS_VALUE, createSuffix(ORDERS)
		);
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, ORDERS_CHANGE, TextColor.SUCCESS),
				new Tag(ORDERS_WEEKLY)
		);
		highlights.add(highlight);

		highlight = new Highlight(
				createIcon(VaadinIcon.BAR_CHART, BackgroundColor.SUCCESS_10, TextColor.SUCCESS),
				SALES, SALES_VALUE, createSuffix(SALES)
		);
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, SALES_CHANGE, TextColor.SUCCESS),
				new Tag(SALES_WEEKLY)
		);
		highlights.add(highlight);

		highlight = new Highlight(
				createIcon(VaadinIcon.USERS, BackgroundColor.ERROR_10, TextColor.ERROR),
				VISITORS, VISITORS_VALUE, createSuffix(VISITORS)
		);
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, VISITORS_CHANGE, TextColor.SUCCESS),
				new Tag(VISITORS_WEEKLY)
		);
		highlights.add(highlight);

		return highlights;
	}

	private Highlights createGridHighlights() {
		Highlights highlights = createHighlights();

		// Add a fourth item for a nice 2x2 grid
		highlights.add(new Highlight(RATING, RATING_VALUE));

		highlights.setDisplay(Display.GRID);
		highlights.setGridColumns(GridColumns.COLUMNS_2);
		return highlights;
	}

	private Component[] createHighlightsWithBreakpoint() {
		Highlights highlights = createHighlights();

		RadioButtonGroup<Breakpoint> rbc = new RadioButtonGroup<>("Breakpoint", Breakpoint.values());
		rbc.addThemeVariants(RadioGroupVariant.LUMO_HELPER_ABOVE_FIELD);
		rbc.setHelperText("Resize the browser to see the difference");
		rbc.setItemLabelGenerator((ItemLabelGenerator<Breakpoint>) item -> {
			String label;
			switch (item) {
				case SMALL:
					label = "S";
					break;
				case MEDIUM:
				default:
					label = "M";
					break;
				case LARGE:
					label = "L";
					break;
				case XLARGE:
					label = "XL";
					break;
				case XXLARGE:
					label = "XXL";
					break;
			}
			return label;
		});
		rbc.addValueChangeListener(event -> highlights.setBreakpoint(event.getValue()));

		return new Component[]{rbc, highlights};
	}

	private Component[] createHighlightsWithGap() {
		Highlights highlights = createHighlights();

		RadioButtonGroup<Gap> rbc = new RadioButtonGroup<>("Gap", Gap.values());
		rbc.setItemLabelGenerator((ItemLabelGenerator<Gap>) item -> {
			String label;
			switch (item) {
				case XSMALL:
					label = "XS";
					break;
				case SMALL:
					label = "S";
					break;
				case MEDIUM:
				default:
					label = "M";
					break;
				case LARGE:
					label = "L";
					break;
				case XLARGE:
					label = "XL";
					break;
			}
			return label;
		});
		rbc.addValueChangeListener(event -> highlights.setGap(event.getValue()));

		return new Component[]{rbc, highlights};
	}

}
