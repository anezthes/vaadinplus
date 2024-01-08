package com.example.application.components.dialogs;

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
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class SearchDialog extends Dialog {

    public static final String JOHN_SMITH = "John Smith";
    public static final String EMILY_JOHNSON = "Emily Johnson";
    public static final String MICHAEL_DAVIS = "Michael Davis";
    public static final String SOPHIA_BROWN = "Sophia Brown";
    public static final String DANIEL_WILSON = "Daniel Wilson";
    public static final String OLIVIA_MARTINEZ = "Olivia Martinez";
    public static final String DAVID_THOMPSON = "David Thompson";

    private TextField search;
    private ListBox list;
    private Preview preview;

    public SearchDialog() {
        addThemeVariants(DialogVariant.LUMO_NO_PADDING);
        setWidth(480, Unit.PIXELS);

        this.search = new TextField();
        this.search.addClassNames(LumoUtility.BoxSizing.BORDER, LumoUtility.Padding.Vertical.NONE);
        this.search.setAriaLabel("Search");
        this.search.setPlaceholder("Search");
        this.search.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());
        this.search.setWidthFull();

        this.list = new ListBox();
        this.list.addClassNames(LumoUtility.Flex.GROW, LumoUtility.Padding.Vertical.SMALL);
        this.list.setAriaLabel("Search results");
        this.list.setItems(
                JOHN_SMITH, EMILY_JOHNSON, MICHAEL_DAVIS, SOPHIA_BROWN, DANIEL_WILSON, OLIVIA_MARTINEZ, DAVID_THOMPSON
        );

        this.preview = new Preview();
        this.preview.setVisible(false);

        FlexLayout layout = new FlexLayout(
                this.search,
                new FlexLayout(this.list, this.preview)
        );
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        add(layout);
    }

    public void setPadding(boolean padding) {
        if (padding) {
            this.search.addClassNames(
                    LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10, LumoUtility.Padding.SMALL
            );
            this.search.removeClassNames(LumoUtility.Padding.Vertical.NONE);
            this.list.addClassNames(LumoUtility.Padding.Horizontal.SMALL);
        } else {
            this.search.removeClassNames(
                    LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10, LumoUtility.Padding.SMALL
            );
            this.search.addClassNames(LumoUtility.Padding.Vertical.NONE);
            this.list.removeClassNames(LumoUtility.Padding.Horizontal.SMALL);
        }
    }

    public void setPreview(boolean preview) {
        if (preview) {
            this.list.addClassNames(LumoUtility.Border.RIGHT, LumoUtility.BorderColor.CONTRAST_10);
        } else {
            this.list.removeClassNames(LumoUtility.Border.RIGHT, LumoUtility.BorderColor.CONTRAST_10);
        }
        this.preview.setVisible(preview);
    }

    private class Preview extends Section {

        private Avatar avatar;
        private H2 name;
        private Span role;

        Preview() {
            addClassNames(
                    LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX, LumoUtility.Flex.GROW,
                    LumoUtility.FlexDirection.COLUMN, LumoUtility.Gap.MEDIUM, LumoUtility.JustifyContent.CENTER,
                    LumoUtility.Padding.LARGE
            );

            this.avatar = new Avatar(EMILY_JOHNSON);
            this.avatar.addThemeVariants(AvatarVariant.LUMO_XLARGE);
            this.avatar.setImage("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

            this.name = new H2(EMILY_JOHNSON);
            this.name.addClassNames(LumoUtility.FontSize.XLARGE);

            this.role = new Span("Business Development Manager");
            this.role.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

            FlexLayout layout = new FlexLayout(name, role);
            layout.setAlignItems(FlexComponent.Alignment.CENTER);
            layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

            Button message = new Button(LineAwesomeIcon.COMMENTS.create());
            message.setAriaLabel("Message");

            Button video = new Button(LineAwesomeIcon.VIDEO_SOLID.create());
            video.setAriaLabel("Video call");

            FlexLayout buttons = new FlexLayout(message, video);
            buttons.addClassNames(LumoUtility.Gap.SMALL);

            add(avatar, layout, buttons);
        }
    }
}
