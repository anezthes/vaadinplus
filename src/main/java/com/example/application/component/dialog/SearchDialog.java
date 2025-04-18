package com.example.application.component.dialog;

import com.example.application.component.Layout;
import com.example.application.component.MaterialSymbol;
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
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class SearchDialog extends Dialog {

    public static final String JOHN_SMITH = "John Smith";
    public static final String EMILY_JOHNSON = "Emily Johnson";
    public static final String MICHAEL_DAVIS = "Michael Davis";
    public static final String SOPHIA_BROWN = "Sophia Brown";
    public static final String DANIEL_WILSON = "Daniel Wilson";
    public static final String OLIVIA_MARTINEZ = "Olivia Martinez";
    public static final String DAVID_THOMPSON = "David Thompson";

    private final TextField search;
    private final ListBox<String> list;
    private final Preview preview;

    public SearchDialog() {
        addThemeVariants(DialogVariant.LUMO_NO_PADDING);
        setWidth(480, Unit.PIXELS);

        this.search = new TextField();
        this.search.addClassNames(BoxSizing.BORDER, Padding.Vertical.NONE);
        this.search.setAriaLabel("Search");
        this.search.setPlaceholder("Search");
        this.search.setPrefixComponent(MaterialSymbol.SEARCH.create());
        this.search.setWidthFull();

        this.list = new ListBox<>();
        this.list.addClassNames(Flex.GROW, Padding.Vertical.SMALL);
        this.list.setAriaLabel("Search results");
        this.list.setItems(
                JOHN_SMITH, EMILY_JOHNSON, MICHAEL_DAVIS, SOPHIA_BROWN, DANIEL_WILSON, OLIVIA_MARTINEZ, DAVID_THOMPSON
        );

        this.preview = new Preview();
        this.preview.setVisible(false);

        Layout layout = new Layout(
                this.search,
                new Layout(this.list, this.preview)
        );
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        add(layout);
    }

    public void setPadding(boolean padding) {
        if (padding) {
            this.search.addClassNames(Border.BOTTOM, Padding.SMALL);
            this.search.removeClassNames(Padding.Vertical.NONE);
            this.list.addClassNames(Padding.Horizontal.SMALL);
        } else {
            this.search.removeClassNames(Border.BOTTOM, Padding.SMALL);
            this.search.addClassNames(Padding.Vertical.NONE);
            this.list.removeClassNames(Padding.Horizontal.SMALL);
        }
    }

    public void setPreview(boolean preview) {
        if (preview) {
            this.list.addClassNames(Border.RIGHT);
        } else {
            this.list.removeClassNames(Border.RIGHT);
        }
        this.preview.setVisible(preview);
    }

    private static class Preview extends Section {

        Preview() {
            addClassNames(AlignItems.CENTER, Display.FLEX, Flex.GROW, FlexDirection.COLUMN, Gap.MEDIUM,
                    JustifyContent.CENTER, Padding.LARGE);

            Avatar avatar = new Avatar(EMILY_JOHNSON);
            avatar.addThemeVariants(AvatarVariant.LUMO_XLARGE);
            avatar.setImage("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

            H2 name = new H2(EMILY_JOHNSON);
            name.addClassNames(FontSize.XLARGE);

            Span role = new Span("Business Development Manager");
            role.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

            Layout layout = new Layout(name, role);
            layout.setAlignItems(Layout.AlignItems.CENTER);
            layout.setFlexDirection(Layout.FlexDirection.COLUMN);

            Button message = new Button(MaterialSymbol.COMMENT.create());
            message.setAriaLabel("Message");

            Button video = new Button(MaterialSymbol.VIDEO_CALL.create());
            video.setAriaLabel("Video call");

            FlexLayout buttons = new FlexLayout(message, video);
            buttons.addClassNames(Gap.SMALL);

            add(avatar, layout, buttons);
        }
    }
}
