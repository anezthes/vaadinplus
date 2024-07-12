package com.example.application.views.templates;

import com.example.application.components.Layout;
import com.example.application.utilities.Breakpoint;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Profile")
@Route(value = "profile", layout = MainLayout.class)
public class ProfileView extends Main {

    public ProfileView() {
        addClassNames(AlignItems.START, Display.FLEX, JustifyContent.CENTER);
        add(createForm(), createLinks());
    }

    public Component createForm() {
        Layout layout = new Layout(createPublicInformation(), createContactInformation(), createPassword(),
                createNotifications());
        layout.addClassNames(BoxSizing.BORDER, MaxWidth.SCREEN_SMALL, Padding.LARGE);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        return layout;
    }

    public Component createPublicInformation() {
        H2 title = new H2("Public information");
        title.addClassNames(FontSize.XLARGE, Margin.Top.MEDIUM);
        title.setId(title.getText().replace(" ", "-").toLowerCase());

        Paragraph description = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        description.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Avatar avatar = new Avatar("Emily Johnson");
        avatar.addThemeVariants(AvatarVariant.LUMO_XLARGE);
        avatar.setImage("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

        Button uploadButton = new Button("Upload");
        uploadButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Upload upload = new Upload();
        upload.setDropAllowed(false);
        upload.setMaxFiles(1);
        upload.setUploadButton(uploadButton);

        Button delete = new Button("Delete");
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY);

        Layout avatarLayout = new Layout(avatar, upload, delete);
        avatarLayout.addClassNames(Margin.Bottom.XSMALL, Margin.Top.MEDIUM);
        avatarLayout.setAlignItems(Layout.AlignItems.CENTER);
        avatarLayout.setGap(Layout.Gap.LARGE);

        TextField username = new TextField("Username");
        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");

        Layout layout = new Layout(title, description, avatarLayout, username, firstName, lastName);
        // Viewport < 1024px
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        // Viewport > 1024px
        layout.setDisplay(Breakpoint.LARGE, Layout.Display.GRID);
        layout.setColumns(Layout.GridColumns.COLUMNS_2);
        layout.setColumnGap(Layout.Gap.MEDIUM);
        layout.setColumnSpan(Layout.ColumnSpan.COLUMN_SPAN_FULL, title, description, avatarLayout, username);
        return layout;
    }

    public Component createContactInformation() {
        H2 title = new H2("Contact information");
        title.addClassNames(FontSize.XLARGE, Margin.Top.XLARGE);
        title.setId(title.getText().replace(" ", "-").toLowerCase());

        Paragraph description = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        description.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        TextField address = new TextField("Address");
        TextField city = new TextField("City");
        ComboBox state = new ComboBox("State");
        TextField zip = new TextField("ZIP");

        TextField phone = new TextField("Phone");
        phone.setPrefixComponent(LineAwesomeIcon.PHONE_SOLID.create());

        EmailField email = new EmailField("Email");
        email.setPrefixComponent(LineAwesomeIcon.ENVELOPE.create());

        Layout layout = new Layout(title, description, address, city, state, zip, phone, email);
        // Viewport < 1024px
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        // Viewport > 1024px
        layout.setDisplay(Breakpoint.LARGE, Layout.Display.GRID);
        layout.setColumns(Layout.GridColumns.COLUMNS_4);
        layout.setColumnGap(Layout.Gap.MEDIUM);
        layout.setColumnSpan(Layout.ColumnSpan.COLUMN_SPAN_2, city, phone, email);
        layout.setColumnSpan(Layout.ColumnSpan.COLUMN_SPAN_FULL, title, description, address);
        return layout;
    }

    public Component createPassword() {
        H2 title = new H2("Password");
        title.addClassNames(FontSize.XLARGE, Margin.Top.XLARGE);
        title.setId(title.getText().replace(" ", "-").toLowerCase());

        Paragraph description = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        description.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        TextField currentPassword = new TextField("Current password");
        TextField newPassword = new TextField("New password");
        TextField confirmPassword = new TextField("Confirm password");

        Layout layout = new Layout(title, description, currentPassword, newPassword, confirmPassword);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        return layout;
    }

    public Component createNotifications() {
        H2 title = new H2("Notifications");
        title.addClassNames(FontSize.XLARGE, Margin.Top.XLARGE);
        title.setId(title.getText().replace(" ", "-").toLowerCase());

        Paragraph description = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        description.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        CheckboxGroup emailNotifications = new CheckboxGroup("Email notifications");
        emailNotifications.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        emailNotifications.setItems("Newsletters", "Promotional offers", "Account updates", "New messages or activities", "Events or upcoming appointments");

        CheckboxGroup pushNotifications = new CheckboxGroup("Push notifications");
        pushNotifications.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        pushNotifications.setItems("New messages", "Friend requests", "Activity updates", "Order status updates", "Reminders or alerts");

        Layout layout = new Layout(title, description, emailNotifications, pushNotifications);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        return layout;
    }

    public Component createLinks() {
        UnorderedList list = new UnorderedList(
                new ListItem(new Anchor("profile#public-information", "Public information")),
                new ListItem(new Anchor("profile#contact-information", "Contact information")),
                new ListItem(new Anchor("profile#password", "Password")),
                new ListItem(new Anchor("profile#notifications", "Notifications"))
        );
        list.addClassNames(Margin.Vertical.XLARGE, Padding.Horizontal.LARGE);

        Nav nav = new Nav(list);
        nav.addClassNames(Display.HIDDEN, Display.Breakpoint.Small.FLEX, FontSize.SMALL, Position.STICKY, "top-0");
        return nav;
    }
}
