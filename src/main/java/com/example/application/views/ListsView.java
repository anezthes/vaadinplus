package com.example.application.views;

import com.example.application.components.Badge;
import com.example.application.components.Tag;
import com.example.application.components.list.*;
import com.example.application.utilities.*;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarGroup;
import com.vaadin.flow.component.avatar.AvatarGroup.AvatarGroupItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
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
	public static final String PERSON_4 = "Olivia Brown";
	public static final String PERSON_4_EMAIL = "olivia.brown@company.com";
	public static final String PERSON_5 = "Amelia Jones";
	public static final String PERSON_5_EMAIL = "amelia.jones@company.com";
	public static final String PERSON_6 = "Charlotte Miller";
	public static final String PERSON_6_EMAIL = "charlotte.miller@company.com";
	public static final String PERSON_7 = "Sophia Davis";
	public static final String PERSON_7_EMAIL = "sophia.davis@company.com";
	public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

	public ListsView() {
		addClassNames(
				LumoUtility.MinHeight.FULL, LumoUtility.Padding.Bottom.LARGE, LumoUtility.Padding.Horizontal.LARGE
		);

		add(new H2("Basic"));
		add(createList());

		add(new H2("Prefix"));
		add(createListWithPrefix());

		add(new H2("Suffix"));
		add(createListWithSuffix());

		add(new H2("Prefix & Suffix"));
		add(createListWithPrefixSuffix());

		add(new H2("Grid"));
		add(createGridList());

		add(new H2("Example: Images"));
		add(createImageList());

		add(new H2("Example: Tasks"));
		add(createTaskList());

		add(new H2("Example: Version History"));
		add(createVersionHistory());

		add(new H2("Example: Notifications"));
		add(createNotifications());

		add(new H2("Example: Timeline"));
		add(createTimeline());

		add(new H2("Theme: Border"));
		UnorderedList list = createList();
		list.setBorder(true);
		add(list);
	}

	private UnorderedList createList() {
		return new UnorderedList(
				new ListItem(PERSON_1, PERSON_1_EMAIL),
				new ListItem(PERSON_2, PERSON_2_EMAIL),
				new ListItem(PERSON_3, PERSON_3_EMAIL),
				new ListItem(PERSON_4, PERSON_4_EMAIL),
				new ListItem(PERSON_5, PERSON_5_EMAIL),
				new ListItem(PERSON_6, PERSON_6_EMAIL),
				new ListItem(PERSON_7, PERSON_7_EMAIL)
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
				new ListItem(PERSON_1, PERSON_1_EMAIL, createLink(PERSON_1)),
				new ListItem(PERSON_2, PERSON_2_EMAIL, createLink(PERSON_2)),
				new ListItem(PERSON_3, PERSON_3_EMAIL, createLink(PERSON_3))
		);
	}

	private RouterLink createLink(String label) {
		Icon icon = VaadinIcon.CHEVRON_RIGHT_SMALL.create();
		icon.addClassNames(LumoUtility.Height.MEDIUM, LumoUtility.Padding.SMALL, LumoUtility.Width.MEDIUM);

		RouterLink link = new RouterLink();
		link.add(icon);
		link.getElement().setAttribute("aria-label", label);
		link.getElement().setAttribute("title", label);
		link.setRoute(ListsView.class);
		return link;
	}

	private UnorderedList createListWithPrefixSuffix() {
		return new UnorderedList(
				new ListItem(new Avatar(PERSON_1), PERSON_1, PERSON_1_EMAIL, createLink(PERSON_1)),
				new ListItem(new Avatar(PERSON_2), PERSON_2, PERSON_2_EMAIL, createLink(PERSON_2)),
				new ListItem(new Avatar(PERSON_3), PERSON_3, PERSON_3_EMAIL, createLink(PERSON_3))
		);
	}

	private UnorderedList createGridList() {
		UnorderedList list = createList();
		list.setAutoFill(200, Unit.PIXELS);
		list.setGap(Gap.MEDIUM);
		return list;
	}

	private UnorderedList createImageList() {
		UnorderedList list = new UnorderedList();
		list.setAutoFill(200, Unit.PIXELS);
		list.setGap(Gap.MEDIUM);
		list.removeBackgroundColor();

		list.add(
				new ImageListItem(
						"https://images.unsplash.com/photo-1511884642898-4c92249e20b6?w=640",
						"Aerial shot of forest",
						"Pine Watt", "November 28, 2017",
						createIconButton(VaadinIcon.ELLIPSIS_DOTS_V, "Actions")
				),
				new ImageListItem(
						"https://images.unsplash.com/photo-1434725039720-aaad6dd32dfe?w=640",
						"Photo of green grass field at sunrise",
						"Ales Krivec", "June 19, 2015",
						createIconButton(VaadinIcon.ELLIPSIS_DOTS_V, "Actions")
				),
				new ImageListItem(
						"https://images.unsplash.com/photo-1532274402911-5a369e4c4bb5?w=640",
						"Brown wooden dock between lavender flower field near body of water during golden hour",
						"Mark Harpur", "July 22, 2018",
						createIconButton(VaadinIcon.ELLIPSIS_DOTS_V, "Actions")
				),
				new ImageListItem(
						"https://images.unsplash.com/photo-1501785888041-af3ef285b470?w=640",
						"Three brown wooden boat on blue lake water taken at daytime",
						"Pietro De Grandi", "August 3, 2017",
						createIconButton(VaadinIcon.ELLIPSIS_DOTS_V, "Actions")
				),
				new ImageListItem(
						"https://images.unsplash.com/photo-1470770841072-f978cf4d019e?w=640",
						"Brown house near body of water",
						"Luca Bravo", "August 9, 2016",
						createIconButton(VaadinIcon.ELLIPSIS_DOTS_V, "Actions")
				),
				new ImageListItem(
						"https://images.unsplash.com/photo-1433838552652-f9a46b332c40?w=640",
						"Hot air balloon contest",
						"Daniela Cuevas", "June 9, 2015",
						createIconButton(VaadinIcon.ELLIPSIS_DOTS_V, "Actions")
				),
				new ImageListItem(
						"https://images.unsplash.com/photo-1419242902214-272b3f66ee7a?w=640",
						"Silhouette photo of mountain during night time",
						"Vincentiu Solomon", "December 22, 2014",
						createIconButton(VaadinIcon.ELLIPSIS_DOTS_V, "Actions")
				),
				new ImageListItem(
						"https://images.unsplash.com/photo-1468276311594-df7cb65d8df6?w=640",
						"Milky way above body of water",
						"Kristopher Roller", "July 12, 2016",
						createIconButton(VaadinIcon.ELLIPSIS_DOTS_V, "Actions")
				)
		);
		return list;
	}

	private Button createIconButton(VaadinIcon icon, String ariaLabel) {
		Button button = new Button(icon.create());
		button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		button.getElement().setAttribute("aria-label", ariaLabel);
		return button;
	}

	private UnorderedList createTaskList() {
		UnorderedList list = new UnorderedList(
				createTaskItem("Task 1", "Status", "Aug 8, 2022 ⋅ 7:30 PM"),
				createTaskItem("Task 2", "Status", "Aug 9, 2022 ⋅ 2:00 PM"),
				createTaskItem("Task 3", "Status", "Aug 12, 2022 ⋅ 5:45 PM"),
				createTaskItem("Task 4", "Status", "Aug 16, 2022 ⋅ 9:25 AM"),
				createTaskItem("Task 5", "Status", "Aug 27, 2022 ⋅ 10:15 AM"),
				createTaskItem("Task 6", "Status", "Aug 29, 2022 ⋅ 4:30 PM")
		);
		list.setBorder(true);
		return list;
	}

	private ThreeLineListItem createTaskItem(String taskName, String taskStatus, String taskDate) {
		Span name = new Span(taskName);
		name.addClassNames(LumoUtility.FontWeight.SEMIBOLD);

		Badge status = new Badge(taskStatus);
		status.addThemeVariants(BadgeVariant.PILL);

		AvatarGroup avatarGroup = createAvatarGroup();

		Paragraph content = new Paragraph(LOREM_IPSUM);
		content.addClassNames(LumoUtility.Margin.NONE);

		ThreeLineListItem item = new ThreeLineListItem();
		item.setGap(Gap.SMALL);

		item.setPrimary(name, status);
		item.setSecondary(taskDate);
		item.setSuffix(avatarGroup, createLink(taskName));
		item.setContent(content);
		item.setContentLineClap(LineClamp.LINE_CLAMP_2);
		return item;
	}

	private AvatarGroup createAvatarGroup() {
		return new AvatarGroup(
				new AvatarGroupItem(PERSON_1),
				new AvatarGroupItem(PERSON_2),
				new AvatarGroupItem(PERSON_3)
		);
	}

	private UnorderedList createVersionHistory() {
		return new UnorderedList(
				new ListItem(
						new Text("Aug 24, 11:01 AM"),
						new Tag(new Avatar(PERSON_1), PERSON_1)
				),
				new ListItem(
						new Text("Aug 22, 6:20 PM"),
						new Tag(new Avatar(PERSON_2), PERSON_2)
				),
				new ListItem(
						new Text("Aug 22, 5:47 PM"),
						new Tag(new Avatar(PERSON_3), PERSON_3)
				)
		);
	}

	private UnorderedList createNotifications() {
		return new UnorderedList(
				new NotificationListItem(
						PERSON_1, "approved", "Invoice #7121", this.getClass(), "8m ago"
				),
				new NotificationListItem(
						PERSON_2, "commented on", "Q4 Report", this.getClass(), "12m ago"
				),
				new NotificationListItem(
						PERSON_3, "replied to", "your comment", this.getClass(), "1h ago"
				)
		);
	}

	private UnorderedList createTimeline() {
		return new UnorderedList(
				new TimelineListItem(
						VaadinIcon.CHECK,
						BackgroundColor.SUCCESS,
						TextColor.SUCCESS_CONTRAST,
						PERSON_1,
						"marked issue as fixed",
						"1d ago"
				),
				new TimelineListItem(
						VaadinIcon.TAG,
						PERSON_2,
						new Span(
								new Text(" added "),
								new Badge("bug", BadgeVariant.ERROR),
								new Text(" "),
								new Badge("a11y", BadgeVariant.SUCCESS)
						),
						"4d ago"
				),
				new TimelineListItem(
						VaadinIcon.PENCIL,
						PERSON_3,
						"changed the title",
						"5d ago"
				)
		);
	}

}
