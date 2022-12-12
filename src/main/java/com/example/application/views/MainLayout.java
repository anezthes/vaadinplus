package com.example.application.views;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

	private H1 viewTitle;

	public MainLayout() {
		setPrimarySection(Section.DRAWER);
		addToNavbar(true, createHeaderContent());
		addToDrawer(createDrawerContent());
	}

	private Component createHeaderContent() {
		DrawerToggle toggle = new DrawerToggle();
		toggle.addClassNames("view-toggle");
		toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
		toggle.getElement().setAttribute("aria-label", "Menu toggle");

		viewTitle = new H1();
		viewTitle.addClassNames("view-title");

		Header header = new Header(toggle, viewTitle);
		header.addClassNames("view-header");
		return header;
	}

	private Component createDrawerContent() {
		H2 appName = new H2("Vaadin+");
		appName.addClassNames("app-name");

		com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
				createNavigation());
		section.addClassNames("drawer-section");
		return section;
	}

	private Nav createNavigation() {
		Nav nav = new Nav();
		nav.addClassNames("menu-item-container");
		nav.getElement().setAttribute("aria-labelledby", "views");

		// Wrap the links in a list; improves accessibility
		UnorderedList list = new UnorderedList();
		list.addClassNames("navigation-list");
		nav.add(list);

		for (MenuItemInfo menuItem : createMenuItems()) {
			list.add(menuItem);

		}
		return nav;
	}

	private MenuItemInfo[] createMenuItems() {
		return new MenuItemInfo[]{
				new MenuItemInfo("Checkboxes", "la la-check-square", CheckboxesView.class),
				new MenuItemInfo("Headers", "la la-heading", HeadersView.class),
				new MenuItemInfo("Highlights", "la la-lightbulb", HighlightsView.class),
				new MenuItemInfo("Input Groups", "la la-keyboard", InputGroupsView.class),
				new MenuItemInfo("Key-Value Pairs", "la la-key", KeyValuePairsView.class),
				new MenuItemInfo("Lists", "la la-list", ListsView.class),
				new MenuItemInfo("Notifications", "la la-bell", NotificationsView.class),
				new MenuItemInfo("Radio Buttons", "la la-dot-circle", RadioButtonsView.class),
		};
	}

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		viewTitle.setText(getCurrentPageTitle());
	}

	private String getCurrentPageTitle() {
		PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
		return title == null ? "" : title.value();
	}

	/**
	 * A simple navigation item component, based on ListItem element.
	 */
	public static class MenuItemInfo extends ListItem {

		private final Class<? extends Component> view;

		public MenuItemInfo(String menuTitle, String iconClass, Class<? extends Component> view) {
			this.view = view;
			RouterLink link = new RouterLink();
			link.addClassNames("menu-item-link");
			link.setRoute(view);

			Span text = new Span(menuTitle);
			text.addClassNames("menu-item-text");

			link.add(new LineAwesomeIcon(iconClass), text);
			add(link);
		}

		public Class<?> getView() {
			return view;
		}

		/**
		 * Simple wrapper to create icons using LineAwesome iconset. See
		 * https://icons8.com/line-awesome
		 */
		@NpmPackage(value = "line-awesome", version = "1.3.0")
		public static class LineAwesomeIcon extends Span {
			public LineAwesomeIcon(String lineawesomeClassnames) {
				addClassNames("menu-item-icon");
				if (!lineawesomeClassnames.isEmpty()) {
					addClassNames(lineawesomeClassnames);
				}
			}
		}

	}
}
