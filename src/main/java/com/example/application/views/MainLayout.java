package com.example.application.views;


import com.example.application.views.components.ComponentsView;
import com.example.application.views.elements.ElementsView;
import com.example.application.views.feedback.FeedbackView;
import com.example.application.views.forms.FormsView;
import com.example.application.views.layout.LayoutView;
import com.example.application.views.lists.ListsView;
import com.example.application.views.navigation.NavigationView;
import com.example.application.views.overlays.OverlaysView;
import com.example.application.views.pageexamples.PageExamplesView;
import com.example.application.views.pagesections.PageSectionsView;
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
				new MenuItemInfo("Components", "la la-file", ComponentsView.class),
				new MenuItemInfo("Elements", "la la-file", ElementsView.class),
				new MenuItemInfo("Feedback", "la la-file", FeedbackView.class),
				new MenuItemInfo("Forms", "la la-file", FormsView.class),
				new MenuItemInfo("Header", "la la-heading", HeaderView.class),
				new MenuItemInfo("Key-Value Pairs", "la la-key", KeyValuePairsView.class),
				new MenuItemInfo("Layout", "la la-file", LayoutView.class),
				new MenuItemInfo("Lists", "la la-file", ListsView.class),
				new MenuItemInfo("Navigation", "la la-file", NavigationView.class),
				new MenuItemInfo("Overlays", "la la-file", OverlaysView.class),
				new MenuItemInfo("Page Examples", "la la-file", PageExamplesView.class),
				new MenuItemInfo("Page Sections", "la la-file", PageSectionsView.class),
				new MenuItemInfo("Statistics", "la la-chart-line", StatisticsView.class),
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
