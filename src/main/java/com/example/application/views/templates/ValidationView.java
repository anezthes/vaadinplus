package com.example.application.views.templates;

import com.example.application.components.Layout;
import com.example.application.components.Notification;
import com.example.application.utilities.Breakpoint;
import com.example.application.utilities.GridColumnSpan;
import com.example.application.utilities.GridColumns;
import com.example.application.views.MainLayout;
import com.example.application.views.templates.validation.ContactBean;
import com.example.application.views.templates.validation.ErrorMessages;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

@PageTitle("Validation Form")
@Route(value = "validation-form", layout = MainLayout.class)
public class ValidationView extends Main {

    private final Div errorContainer;
    private ContactBean contactBean = new ContactBean();

    private final Binder<ContactBean> binder = new Binder<>();
    private TextField address;
    private TextField city;
    private ComboBox<String> state;
    private TextField zip;
    private TextField phone;
    private TextField email;

    private Button submitButton;

    public ValidationView() {
        addClassNames(AlignItems.STRETCH, Display.FLEX, JustifyContent.CENTER, MaxWidth.SCREEN_SMALL, Padding.LARGE, FlexDirection.COLUMN);
        errorContainer = new Div();
        add(errorContainer, createContactInformation());
        configureBinder();
        binder.setBean(contactBean);
    }

    public Component createContactInformation() {
        H2 title = new H2("Contact information");
        title.addClassNames(FontSize.XLARGE, Margin.Top.XLARGE);
        title.setId(title.getText().replace(" ", "-").toLowerCase());

        Paragraph description = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        description.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        address = new TextField("Address");
        city = new TextField("City");
        city.setHelperText("You must enter a city that starts with a T");
        state = new ComboBox<>("State");
        state.setItems("State 1", "State 2");
        zip = new TextField("ZIP");

        phone = new TextField("Phone");
        phone.setPrefixComponent(LineAwesomeIcon.PHONE_SOLID.create());

        email = new TextField("Email");
        email.setPrefixComponent(LineAwesomeIcon.ENVELOPE.create());

        submitButton = new Button("Submit");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        submitButton.addClickListener(event -> {
            submitForm();
        });

        Layout layout = new Layout(title, description, address, city, state, zip, phone, email, submitButton);
        // Viewport < 1024px
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        // Viewport > 1024px
        layout.setDisplay(Breakpoint.LARGE, com.example.application.utilities.Display.GRID);
        layout.setColumnGap(com.example.application.utilities.Gap.MEDIUM);
        layout.setGridColumns(GridColumns.COLUMNS_4);
        layout.setGridColumnSpan(GridColumnSpan.COLUMN_SPAN_2, city, phone, email);
        layout.setGridColumnSpan(GridColumnSpan.COLUMN_SPAN_FULL, title, description, address);
        return layout;
    }

    private void configureBinder() {
        binder.forField(address)
                .asRequired("The address cannot be empty")
                .bind(ContactBean::getAddress, ContactBean::setAddress);
        binder.forField(city)
                .asRequired("The city cannot be empty")
                .withValidator(value -> {
                    return (value != null) && value.startsWith("T");
                }, "The city should start with a T")
                .bind(ContactBean::getCity, ContactBean::setCity);
        binder.forField(state)
                .asRequired("The state cannot be empty")
                .bind(ContactBean::getState, ContactBean::setState);
        binder.forField(zip)
                .asRequired("The zip code cannot be empty")
                .bind(ContactBean::getZip, ContactBean::setZip);
        binder.forField(phone)
                .asRequired("The phone cannot be empty")
                .bind(ContactBean::getPhone, ContactBean::setPhone);
        binder.forField(email)
                .asRequired("The email address cannot be empty")
                .withValidator(new EmailValidator("Enter a valid email address"))
                .bind(ContactBean::getEmail, ContactBean::setEmail);
        binder.withValidator(contactBean -> {
            return contactBean.getCity().equals("Turku");
        }, "The city must be Turku");
    }

    private void submitForm() {
        BinderValidationStatus<ContactBean> validationStatus = binder.validate();
        errorContainer.removeAll();
        errorContainer.setVisible(false);
        if (validationStatus.isOk()) {
            //Everything is fine, do your action
            Dialog dialog = new Dialog();
            dialog.add("The form is valid");
            dialog.open();
        } else {
            // display the error message
            Optional<ErrorMessages> optionalNotification = ErrorMessages.createErrorNotification(validationStatus);
            optionalNotification.ifPresentOrElse(notification -> {
                errorContainer.setVisible(true);
                errorContainer.add(notification);
            }, () -> {
            });
        }
    }

}
