package com.example.application.views.templates;

import com.example.application.components.Layout;
import com.example.application.utilities.GridColumnSpan;
import com.example.application.utilities.GridColumns;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.UploadI18N;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Profile")
@Route(value = "profile", layout = MainLayout.class)
public class ProfileView extends Main {

    public ProfileView() {
        addClassNames(Display.FLEX, FlexDirection.COLUMN, Margin.Horizontal.AUTO, MaxWidth.SCREEN_SMALL,
                Padding.Bottom.LARGE, Padding.Horizontal.LARGE);
        add(createPublicInformation(), createContactInformation());
    }

    public Component createPublicInformation() {
        H2 title = new H2("Public Information");
        title.addClassNames(FontSize.XLARGE, Margin.Top.XLARGE);

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
        avatarLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        avatarLayout.setGap(com.example.application.utilities.Gap.LARGE);

        TextField username = new TextField("Username");
        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");

        Layout layout = new Layout(title, description, avatarLayout, username, firstName, lastName);
        layout.setColumnGap(com.example.application.utilities.Gap.MEDIUM);
        layout.setDisplay(com.example.application.utilities.Display.GRID);
        layout.setGridColumns(GridColumns.COLUMNS_2);
        layout.setGridColumnSpan(GridColumnSpan.COLUMN_SPAN_2, title, description, avatarLayout, username);
        return layout;
    }

    public Component createContactInformation() {
        H2 title = new H2("Contact Information");
        title.addClassNames(FontSize.XLARGE, Margin.Top.XLARGE);

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
        layout.setColumnGap(com.example.application.utilities.Gap.MEDIUM);
        layout.setDisplay(com.example.application.utilities.Display.GRID);
        layout.setGridColumns(GridColumns.COLUMNS_4);
        layout.setGridColumnSpan(GridColumnSpan.COLUMN_SPAN_2, city, phone, email);
        layout.setGridColumnSpan(GridColumnSpan.COLUMN_SPAN_4, title, description, address);
        return layout;
    }
}
