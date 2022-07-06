package com.example.application.views;

import com.example.application.components.Highlight;
import com.example.application.components.Highlights;
import com.example.application.components.Tag;
import com.example.application.utilities.BackgroundColor;
import com.example.application.utilities.Gap;
import com.example.application.utilities.TextColor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Statistics | Vaadin+")
@Route(value = "statistics", layout = MainLayout.class)
public class StatisticsView extends Main {

	public StatisticsView() {
		addClassNames(LumoUtility.Background.CONTRAST_5, LumoUtility.MinHeight.FULL, LumoUtility.Padding.LARGE);

		add(new H2("Basic"));
		add(createHighlights());

		add(new H2("Prefix"));
		add(createHighlightsWithPrefix());

		add(new H2("Details"));
		add(createHighlightsWithDetails());

		add(new H2("Suffix"));
		add(createHighlightsWithSuffix());

		add(new H2("Everything"));
		add(createHighlightsWithEverything());

		add(new H2("Theme: Border"));
		Highlights highlights = createHighlights();
		highlights.addThemeName(Highlights.BORDER);
		add(highlights);
	}

	private Highlights createHighlights() {
		return new Highlights(
				new Highlight("Orders", "7,973,513"),
				new Highlight("Sales", "€405,621.40"),
				new Highlight("Visitors", "471,625")
		);
	}

	private Highlights createHighlightsWithPrefix() {
		Highlights highlights = new Highlights();

		Highlight highlight = new Highlight("Orders", "7,973,513");
		Icon icon = createIcon(VaadinIcon.CUBE, BackgroundColor.PRIMARY_10, TextColor.PRIMARY);
		highlight.setPrefix(icon);
		highlights.add(highlight);

		highlight = new Highlight("Sales", "€405,621.40");
		icon = createIcon(VaadinIcon.BAR_CHART, BackgroundColor.SUCCESS_10, TextColor.SUCCESS);
		highlight.setPrefix(icon);
		highlights.add(highlight);

		highlight = new Highlight("Visitors", "471,625");
		icon = createIcon(VaadinIcon.USERS, BackgroundColor.ERROR_10, TextColor.ERROR);
		highlight.setPrefix(icon);
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

		Highlight highlight = new Highlight("Orders", "7,973,513");
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, "16.38%", TextColor.SUCCESS),
				new Tag("+74K this week")
		);
		highlight.getDetailsLayout().setColumnGap(Gap.SMALL);
		highlights.add(highlight);

		highlight = new Highlight("Sales", "€405,621.40");
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, "40.82%", TextColor.SUCCESS),
				new Tag("+34K this week")
		);
		highlight.getDetailsLayout().setColumnGap(Gap.SMALL);
		highlights.add(highlight);

		highlight = new Highlight("Visitors", "471,625");
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, "13.35%", TextColor.SUCCESS),
				new Tag("+26K this week")
		);
		highlight.getDetailsLayout().setColumnGap(Gap.SMALL);
		highlights.add(highlight);

		return highlights;
	}

	private Highlights createHighlightsWithSuffix() {
		Highlights highlights = new Highlights();

		Highlight highlight = new Highlight("Orders", "7,973,513");
		highlight.setSuffix(createLink());
		highlights.add(highlight);

		highlight = new Highlight("Sales", "€405,621.40");
		highlight.setSuffix(createLink());
		highlights.add(highlight);

		highlight = new Highlight("Visitors", "471,625");
		highlight.setSuffix(createLink());
		highlights.add(highlight);

		return highlights;
	}

	private RouterLink createLink() {
		Icon icon = VaadinIcon.ARROW_RIGHT.create();
		icon.addClassNames(LumoUtility.Height.MEDIUM, LumoUtility.Padding.SMALL, LumoUtility.Width.MEDIUM);

		RouterLink link = new RouterLink();
		link.add(icon);
		link.setRoute(StatisticsView.class);
		return link;
	}

	private Highlights createHighlightsWithEverything() {
		Highlights highlights = new Highlights();

		Highlight highlight = new Highlight("Orders", "7,973,513");
		Icon icon = createIcon(VaadinIcon.CUBE, BackgroundColor.PRIMARY_10, TextColor.PRIMARY);
		highlight.setPrefix(icon);
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, "16.38%", TextColor.SUCCESS),
				new Tag("+74K this week")
		);
		highlight.getDetailsLayout().setColumnGap(Gap.SMALL);
		highlight.setSuffix(createLink());
		highlights.add(highlight);

		highlight = new Highlight("Sales", "€405,621.40");
		icon = createIcon(VaadinIcon.BAR_CHART, BackgroundColor.SUCCESS_10, TextColor.SUCCESS);
		highlight.setPrefix(icon);
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, "40.82%", TextColor.SUCCESS),
				new Tag("+34K this week")
		);
		highlight.getDetailsLayout().setColumnGap(Gap.SMALL);
		highlight.setSuffix(createLink());
		highlights.add(highlight);

		highlight = new Highlight("Visitors", "471,625");
		icon = createIcon(VaadinIcon.USERS, BackgroundColor.ERROR_10, TextColor.ERROR);
		highlight.setPrefix(icon);
		highlight.setDetails(
				new Tag(VaadinIcon.TRENDING_UP, "13.35%", TextColor.SUCCESS),
				new Tag("+26K this week")
		);
		highlight.getDetailsLayout().setColumnGap(Gap.SMALL);
		highlight.setSuffix(createLink());
		highlights.add(highlight);

		return highlights;
	}

}
