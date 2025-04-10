package com.example.application.view.component;

import com.example.application.component.Badge;
import com.example.application.component.Layout;
import com.example.application.component.MaterialSymbol;
import com.example.application.component.Tag;
import com.example.application.component.list.*;
import com.example.application.utility.BadgeVariant;
import com.example.application.utility.Color;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarGroup;
import com.vaadin.flow.component.avatar.AvatarGroup.AvatarGroupItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.*;


@PageTitle("Lists")
@Route(value = "lists", layout = MainLayout.class)
public class ListsView extends ComponentView {

    public static final String PERSON_1 = "Ava Smith";
    public static final String PERSON_1_EMAIL = "ava.smith@company.com";
    public static final String PERSON_1_IMG = "https://images.unsplash.com/photo-1530785602389-07594beb8b73?w=160";

    public static final String PERSON_2 = "Emma Johnson";
    public static final String PERSON_2_EMAIL = "emma.johnson@company.com";
    public static final String PERSON_2_IMG = "https://images.unsplash.com/photo-1553514029-1318c9127859?w=160";

    public static final String PERSON_3 = "Mia Williams";
    public static final String PERSON_3_EMAIL = "mia.williams@company.com";
    public static final String PERSON_3_IMG = "https://images.unsplash.com/photo-1580489944761-15a19d654956?w=160";

    public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public ListsView() {
        addH2("Basic");
        addPreview(createList());

        addH2("Prefix");
        addPreview(createListWithPrefix());

        addH2("Suffix");
        addPreview(createListWithSuffix());

        addH2("Prefix & suffix");
        addPreview(createListWithPrefixSuffix());

        addH2("Grid");
        addPreview(createGridList());

        addH2("Example: images");
        addPreview(createImageList());

        addH2("Example: tasks");
        addPreview(createTaskList());

        addH2("Example: version history");
        addPreview(createVersionHistory());

        addH2("Example: notifications");
        addPreview(createNotifications());

        addH2("Example: timeline");
        addPreview(createTimeline());

        addH2("Utility class: divide-y");
        List list = createList();
        list.addClassNames(Divide.Y);
        addPreview(list);
    }

    private List createList() {
        return new List(
                new ListItem(PERSON_1, PERSON_1_EMAIL),
                new ListItem(PERSON_2, PERSON_2_EMAIL),
                new ListItem(PERSON_3, PERSON_3_EMAIL)
        );
    }

    private List createListWithPrefix() {
        return new List(
                new ListItem(new Avatar(PERSON_1), PERSON_1, PERSON_1_EMAIL),
                new ListItem(new Avatar(PERSON_2), PERSON_2, PERSON_2_EMAIL),
                new ListItem(new Avatar(PERSON_3), PERSON_3, PERSON_3_EMAIL)
        );
    }

    private List createListWithSuffix() {
        return new List(
                new ListItem(PERSON_1, PERSON_1_EMAIL, createSuffix(PERSON_1)),
                new ListItem(PERSON_2, PERSON_2_EMAIL, createSuffix(PERSON_2)),
                new ListItem(PERSON_3, PERSON_3_EMAIL, createSuffix(PERSON_3))
        );
    }

    private RouterLink createSuffix(String label) {
        RouterLink link = new RouterLink("", HighlightsView.class);
        link.add(MaterialSymbol.ARROW_RIGHT_ALT.create(IconSize.SMALL, TextColor.SECONDARY));
        link.addClassNames(Display.FLEX, Padding.SMALL);
        link.getElement().setAttribute("aria-label", label);
        link.getElement().setAttribute("title", label);
        return link;
    }

    private List createListWithPrefixSuffix() {
        return new List(
                new ListItem(new Avatar(PERSON_1), PERSON_1, PERSON_1_EMAIL, createSuffix(PERSON_1)),
                new ListItem(new Avatar(PERSON_2), PERSON_2, PERSON_2_EMAIL, createSuffix(PERSON_2)),
                new ListItem(new Avatar(PERSON_3), PERSON_3, PERSON_3_EMAIL, createSuffix(PERSON_3))
        );
    }

    private List createGridList() {
        List list = createList();
        list.setAutoFill(200, Unit.PIXELS);
        list.setGap(Layout.Gap.MEDIUM);
        return list;
    }

    private List createImageList() {
        List list = new List();
        list.setAutoFill(200, Unit.PIXELS);
        list.setGap(Layout.Gap.MEDIUM);

        list.add(
                new ImageListItem(
                        "https://images.unsplash.com/photo-1511884642898-4c92249e20b6?w=640",
                        "Aerial shot of forest",
                        "Pine Watt", "November 28, 2017",
                        createIconButton(MaterialSymbol.MORE_VERT, "Actions")
                ),
                new ImageListItem(
                        "https://images.unsplash.com/photo-1434725039720-aaad6dd32dfe?w=640",
                        "Photo of green grass field at sunrise",
                        "Ales Krivec", "June 19, 2015",
                        createIconButton(MaterialSymbol.MORE_VERT, "Actions")
                ),
                new ImageListItem(
                        "https://images.unsplash.com/photo-1532274402911-5a369e4c4bb5?w=640",
                        "Brown wooden dock between lavender flower field near body of water during golden hour",
                        "Mark Harpur", "July 22, 2018",
                        createIconButton(MaterialSymbol.MORE_VERT, "Actions")
                ),
                new ImageListItem(
                        "https://images.unsplash.com/photo-1501785888041-af3ef285b470?w=640",
                        "Three brown wooden boat on blue lake water taken at daytime",
                        "Pietro De Grandi", "August 3, 2017",
                        createIconButton(MaterialSymbol.MORE_VERT, "Actions")
                ),
                new ImageListItem(
                        "https://images.unsplash.com/photo-1470770841072-f978cf4d019e?w=640",
                        "Brown house near body of water",
                        "Luca Bravo", "August 9, 2016",
                        createIconButton(MaterialSymbol.MORE_VERT, "Actions")
                ),
                new ImageListItem(
                        "https://images.unsplash.com/photo-1433838552652-f9a46b332c40?w=640",
                        "Hot air balloon contest",
                        "Daniela Cuevas", "June 9, 2015",
                        createIconButton(MaterialSymbol.MORE_VERT, "Actions")
                ),
                new ImageListItem(
                        "https://images.unsplash.com/photo-1419242902214-272b3f66ee7a?w=640",
                        "Silhouette photo of mountain during night time",
                        "Vincentiu Solomon", "December 22, 2014",
                        createIconButton(MaterialSymbol.MORE_VERT, "Actions")
                ),
                new ImageListItem(
                        "https://images.unsplash.com/photo-1468276311594-df7cb65d8df6?w=640",
                        "Milky way above body of water",
                        "Kristopher Roller", "July 12, 2016",
                        createIconButton(MaterialSymbol.MORE_VERT, "Actions")
                )
        );
        return list;
    }

    private Button createIconButton(MaterialSymbol symbol, String ariaLabel) {
        Button button = new Button(symbol.create());
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        button.setAriaLabel(ariaLabel);
        button.setTooltipText(ariaLabel);
        return button;
    }

    private List createTaskList() {
        return new List(
                createTaskItem("Task 1", "Status", "Aug 8, 2022 ⋅ 7:30 PM"),
                createTaskItem("Task 2", "Status", "Aug 9, 2022 ⋅ 2:00 PM"),
                createTaskItem("Task 3", "Status", "Aug 12, 2022 ⋅ 5:45 PM")
        );
    }

    private ThreeLineListItem createTaskItem(String name, String status, String date) {
        TaskListItem item = new TaskListItem(name, status, LOREM_IPSUM, date);
        item.setSuffix(createAvatarGroup(), createSuffix(name));
        return item;
    }

    private AvatarGroup createAvatarGroup() {
        return new AvatarGroup(
                new AvatarGroupItem(PERSON_1),
                new AvatarGroupItem(PERSON_2),
                new AvatarGroupItem(PERSON_3)
        );
    }

    private List createVersionHistory() {
        return new List(
                new ListItem(
                        new Text("Aug 24, 11:01 AM"),
                        new Tag(new Avatar(PERSON_1, PERSON_1_IMG), PERSON_1)
                ),
                new ListItem(
                        new Text("Aug 22, 6:20 PM"),
                        new Tag(new Avatar(PERSON_2, PERSON_2_IMG), PERSON_2)
                ),
                new ListItem(
                        new Text("Aug 22, 5:47 PM"),
                        new Tag(new Avatar(PERSON_3, PERSON_3_IMG), PERSON_3)
                )
        );
    }

    private List createNotifications() {
        return new List(
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

    private List createTimeline() {
        TimelineListItem item1 = new TimelineListItem(
                MaterialSymbol.CHECK, Color.Background.SUCCESS, Color.Text.SUCCESS_CONTRAST,
                PERSON_1, "marked issue as fixed", "1d ago"
        );
        item1.setAvatarImage(PERSON_1_IMG);

        TimelineListItem item2 = new TimelineListItem(
                MaterialSymbol.TAG, Color.Background.PRIMARY, Color.Text.PRIMARY_CONTRAST,
                PERSON_2, new Span(
                new Text(" added labels "),
                new Badge("bug", BadgeVariant.ERROR, BadgeVariant.PILL),
                new Text(" "),
                new Badge("a11y", BadgeVariant.SUCCESS, BadgeVariant.PILL)
        ), "4d ago"
        );
        item2.setAvatarImage(PERSON_2_IMG);

        TimelineListItem item3 = new TimelineListItem(
                MaterialSymbol.EDIT, Color.Background.CONTRAST, Color.Text.PRIMARY_CONTRAST,
                PERSON_3, "changed the title", "5d ago"
        );
        item3.setAvatarImage(PERSON_3_IMG);

        TimelineListItem item4 = new TimelineListItem(
                MaterialSymbol.LIGHTBULB,
                "This is an API test by <b>" + PERSON_1 + "</b>", "3d ago"
        );

        return new List(item1, item2, item3, item4);
    }

}
