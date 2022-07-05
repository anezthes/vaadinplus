package com.example.application.views;

import com.example.application.components.Header;
import com.example.application.components.Tag;
import com.example.application.utilities.FontSize;
import com.example.application.utilities.HeadingLevel;
import com.example.application.views.home.HomeView;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Header | Vaadin+")
@Route(value = "header", layout = MainLayout.class)
public class HeaderView extends Main {

	public HeaderView() {
		addClassNames(LumoUtility.Background.CONTRAST_5, LumoUtility.MinHeight.FULL, LumoUtility.Padding.LARGE);

		add(new H2("Basic"));
		Header header = new Header("Lorem ipsum", HeadingLevel.H3);
		add(header);

		add(new H2("Breadcrumb"));
		header = new Header("Lorem ipsum", HeadingLevel.H3);
		header.setBreadcrumb(
				new RouterLink("Home", HomeView.class),
				new RouterLink("Headings", HeaderView.class)
		);
		add(header);

		add(new H2("Details"));
		header = new Header("Lorem ipsum", HeadingLevel.H3);
		header.setDetails(
				new Tag(VaadinIcon.DENTAL_CHAIR, "Dolor sit"),
				new Tag(VaadinIcon.PAPERPLANE, "Amet consectetur"),
				new Tag(VaadinIcon.THUMBS_UP, "Adipiscing elit")
		);
		add(header);

		add(new H2("Tabs"));
		header = new Header("Lorem ipsum", HeadingLevel.H3);
		header.setTabs(new Tab("Tab 1"), new Tab("Tab 2"), new Tab("Tab 3"));
		add(header);

		add(new H2("Actions"));
		header = new Header("Lorem ipsum", HeadingLevel.H3);
		Button button = new Button("Button");
		Button primaryButton = new Button("Button");
		primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		header.setActions(button, primaryButton);
		add(header);

		add(new H2("Breadcrumb, details, tabs & actions"));
		header = new Header("Lorem ipsum", HeadingLevel.H3);
		header.setBreadcrumb(
				new RouterLink("Home", HomeView.class),
				new RouterLink("Headings", HeaderView.class)
		);
		header.setDetails(
				new Tag(VaadinIcon.DENTAL_CHAIR, "Dolor sit"),
				new Tag(VaadinIcon.PAPERPLANE, "Amet consectetur"),
				new Tag(VaadinIcon.THUMBS_UP, "Adipiscing elit")
		);
		header.setTabs(new Tab("Tab 1"), new Tab("Tab 2"), new Tab("Tab 3"));
		button = new Button("Button");
		primaryButton = new Button("Button");
		primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		header.setActions(button, primaryButton);
		add(header);

		add(new H2("User example"));
		createUserExample();
	}

	private void createUserExample() {
		Avatar avatar = new Avatar("John Smith");

		Span details = new Span("john.smith@company.com");
		details.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

		Button button = new Button("Edit", VaadinIcon.EDIT.create());

		Header header = new Header("John Smith", HeadingLevel.H3);
		header.setPrefix(avatar);
		header.removeColumnGap();
		header.setHeadingFontSize(FontSize.LARGE);
		header.setDetails(details);
		header.setActions(button);
		add(header);
	}

}
