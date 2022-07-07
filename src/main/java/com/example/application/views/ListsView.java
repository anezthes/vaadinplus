package com.example.application.views;

import com.example.application.components.ListItem;
import com.example.application.components.UnorderedList;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Lists | Vaadin+")
@Route(value = "lists", layout = MainLayout.class)
public class ListsView extends Main {

	public static final String PERSON_1 = "Ava Smith";
	public static final String PERSON_1_EMAIL = "ava.smith@company.com";
	public static final String PERSON_2 = "Emma Johnson";
	public static final String PERSON_2_EMAIL = "emma.johnson@company.com";
	public static final String PERSON_3 = "Mia Williams";
	public static final String PERSON_3_EMAIL = "mia.williams@company.com";

	public ListsView() {
		addClassNames(LumoUtility.Background.CONTRAST_5, LumoUtility.MinHeight.FULL, LumoUtility.Padding.LARGE);

		add(new H2("Basic"));
		add(createList());

		add(new H2("Prefix"));
		add(createListWithPrefix());

		add(new H2("Suffix"));
		add(createListWithSuffix());

		add(new H2("Prefix & suffix"));
		add(createListWithEverything());
	}

	private UnorderedList createList() {
		return new UnorderedList(
				new ListItem(PERSON_1, PERSON_1_EMAIL),
				new ListItem(PERSON_2, PERSON_2_EMAIL),
				new ListItem(PERSON_3, PERSON_3_EMAIL)
		);
	}

	private UnorderedList createListWithPrefix() {
		return new UnorderedList(
				new ListItem(new Avatar(PERSON_1), PERSON_1, PERSON_1_EMAIL),
				new ListItem(new Avatar(PERSON_2), PERSON_2, PERSON_2_EMAIL),
				new ListItem(new Avatar(PERSON_3), PERSON_3, PERSON_3_EMAIL)
		);
	}

	private UnorderedList createListWithSuffix() {
		return new UnorderedList(
				new ListItem(PERSON_1, PERSON_1_EMAIL, createSuffix(PERSON_1)),
				new ListItem(PERSON_2, PERSON_2_EMAIL, createSuffix(PERSON_2)),
				new ListItem(PERSON_3, PERSON_3_EMAIL, createSuffix(PERSON_3))
		);
	}

	private UnorderedList createListWithEverything() {
		return new UnorderedList(
				new ListItem(new Avatar(PERSON_1), PERSON_1, PERSON_1_EMAIL, createSuffix(PERSON_1)),
				new ListItem(new Avatar(PERSON_2), PERSON_2, PERSON_2_EMAIL, createSuffix(PERSON_2)),
				new ListItem(new Avatar(PERSON_3), PERSON_3, PERSON_3_EMAIL, createSuffix(PERSON_3))
		);
	}

	private RouterLink createSuffix(String label) {
		Icon icon = VaadinIcon.CHEVRON_RIGHT_SMALL.create();
		icon.addClassNames(LumoUtility.Height.MEDIUM, LumoUtility.Padding.SMALL, LumoUtility.Width.MEDIUM);

		RouterLink link = new RouterLink();
		link.add(icon);
		link.getElement().setAttribute("aria-label", label);
		link.getElement().setAttribute("title", label);
		link.setRoute(ListsView.class);
		return link;
	}

}
