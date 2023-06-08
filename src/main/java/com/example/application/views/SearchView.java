package com.example.application.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.dialog.DialogVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Search")
@Route(value = "search", layout = MainLayout.class)
public class SearchView extends View {

    public static final String JOHN_SMITH = "John Smith";
    public static final String EMILY_JOHNSON = "Emily Johnson";
    public static final String MICHAEL_DAVIS = "Michael Davis";
    public static final String SOPHIA_BROWN = "Sophia Brown";
    public static final String DANIEL_WILSON = "Daniel Wilson";
    public static final String OLIVIA_MARTINEZ = "Olivia Martinez";
    public static final String DAVID_THOMPSON = "David Thompson";

    public SearchView() {
        addClassNames(LumoUtility.AlignItems.START, LumoUtility.Padding.Top.LARGE);

        createBasicExample();
        createPaddedExample();
        createPreviewExample();
    }

    private void createBasicExample() {
        ListBox listBox = createListBox();
        listBox.addClassNames(LumoUtility.Padding.Vertical.SMALL);

        Dialog dialog = new Dialog(createTextField(), listBox);
        dialog.addThemeVariants(DialogVariant.LUMO_NO_PADDING);
        dialog.setWidth(480, Unit.PIXELS);

        Button button = new Button("Basic Example", e -> dialog.open());
        button.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());
        add(button);
    }

    private void createPaddedExample() {
        FlexLayout layout = new FlexLayout(
                createTextField(),
                createListBox()
        );
        layout.addClassNames(LumoUtility.Gap.SMALL, LumoUtility.Padding.SMALL);
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

        Dialog dialog = new Dialog(layout);
        dialog.addThemeVariants(DialogVariant.LUMO_NO_PADDING);
        dialog.setWidth(480, Unit.PIXELS);

        Button button = new Button("Padded Example", e -> dialog.open());
        button.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());
        add(button);
    }

    private void createPreviewExample() {
        ListBox listBox = createListBox();
        listBox.addClassNames(
                LumoUtility.Border.RIGHT, LumoUtility.BorderColor.CONTRAST_10, LumoUtility.Flex.GROW,
                LumoUtility.Padding.SMALL
        );
        listBox.setValue(EMILY_JOHNSON);

        FlexLayout layout = new FlexLayout(
                createTextField(),
                new FlexLayout(
                        listBox,
                        createPreview()
                )
        );
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

        Dialog dialog = new Dialog(layout);
        dialog.addThemeVariants(DialogVariant.LUMO_NO_PADDING);
        dialog.setWidth(800, Unit.PIXELS);

        Button button = new Button("Preview Example", e -> dialog.open());
        button.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());
        add(button);
    }

    private TextField createTextField() {
        TextField textField = new TextField();
        textField.addClassNames(LumoUtility.Padding.Vertical.NONE);
        textField.setAriaLabel("Padding");
        textField.setPlaceholder("Search");
        textField.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());
        textField.setWidthFull();
        return textField;
    }

    private ListBox createListBox() {
        ListBox listBox = new ListBox();
        listBox.setAriaLabel("Search results");
        listBox.setItems(
                JOHN_SMITH, EMILY_JOHNSON, MICHAEL_DAVIS, SOPHIA_BROWN, DANIEL_WILSON, OLIVIA_MARTINEZ, DAVID_THOMPSON
        );
        return listBox;
    }

    private Component createPreview() {
        Avatar avatar = new Avatar(EMILY_JOHNSON);
        avatar.addThemeVariants(AvatarVariant.LUMO_XLARGE);
        avatar.setImage("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

        H2 name = new H2(EMILY_JOHNSON);
        name.addClassNames(LumoUtility.FontSize.XLARGE);

        Span role = new Span("Business Development Manager");
        role.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        FlexLayout text = new FlexLayout(name, role);
        text.setAlignItems(FlexComponent.Alignment.CENTER);
        text.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

        Button message = new Button(LineAwesomeIcon.COMMENTS.create());
        message.setAriaLabel("Message");

        Button video = new Button(LineAwesomeIcon.VIDEO_SOLID.create());
        video.setAriaLabel("Video Call");

        FlexLayout buttons = new FlexLayout(message, video);
        buttons.addClassNames(LumoUtility.Gap.SMALL);

        Section section = new Section(avatar, text, buttons);
        section.addClassNames(
                LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX, LumoUtility.Flex.GROW,
                LumoUtility.FlexDirection.COLUMN, LumoUtility.Gap.MEDIUM, LumoUtility.JustifyContent.CENTER,
                LumoUtility.Padding.LARGE
        );
        return section;
    }

}
