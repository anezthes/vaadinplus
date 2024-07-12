package com.example.application.views.templates;

import com.example.application.components.Layout;
import com.example.application.utilities.Breakpoint;
import com.example.application.views.MainLayout;
import com.example.application.views.templates.validation.ContactBean;
import com.example.application.views.templates.validation.ErrorSummary;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.Optional;

@PageTitle("Validation form")
@Route(value = "validation-form", layout = MainLayout.class)
public class ValidationView extends Main {

    private ContactBean bean = new ContactBean();
    private Binder<ContactBean> binder = new Binder<>();
    private Div errorSummary;
    private TextField address;
    private TextField city;
    private ComboBox<String> state;
    private TextField zip;
    private TextField phone;
    private TextField email;
    private Button submit;

    public ValidationView() {
        addClassNames(BoxSizing.BORDER, Display.FLEX, FlexDirection.COLUMN, MaxWidth.SCREEN_SMALL, Padding.LARGE);

        add(createContactInformation());
        configureBinder();
    }

    public Component createContactInformation() {
        H2 title = new H2("Contact information");
        title.addClassNames(FontSize.XLARGE, Margin.Bottom.SMALL);
        title.setId(formatId(title.getText()));

        this.errorSummary = new Div();
        this.errorSummary.addClassNames(Margin.Vertical.SMALL);
        this.errorSummary.setVisible(false);

        this.address = new TextField("Address");

        this.city = new TextField("City");
        this.city.setHelperText("You must enter a city that starts with a T");

        this.state = new ComboBox<>("State");
        this.state.setItems("State 1", "State 2");

        this.zip = new TextField("ZIP");

        this.phone = new TextField("Phone");
        this.phone.setPrefixComponent(LineAwesomeIcon.PHONE_SOLID.create());

        this.email = new TextField("Email");
        this.email.setPrefixComponent(LineAwesomeIcon.ENVELOPE.create());

        this.submit = new Button("Submit", e -> submit());
        this.submit.addClassNames(Margin.Top.LARGE);
        this.submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // Set IDs
        for (Component component : new Component[]{this.address, this.city, this.state, this.zip, phone, this.email}) {
            component.setId(formatId(((HasLabel) component).getLabel()));
        }

        Layout layout = new Layout(title, this.errorSummary, this.address, this.city, this.state, this.zip, phone,
                this.email, this.submit);
        layout.setColumns(Layout.GridColumns.COLUMNS_4);
        layout.setColumnGap(Layout.Gap.MEDIUM);
        layout.setColumnSpan(Layout.ColumnSpan.COLUMN_SPAN_2, this.city, this.phone, this.email);
        layout.setColumnSpan(Layout.ColumnSpan.COLUMN_SPAN_FULL, title, this.errorSummary, this.address);
        layout.setDisplay(Breakpoint.LARGE, Layout.Display.GRID);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);

        return layout;
    }

    private String formatId(String id) {
        return id.replace(" ", "-").toLowerCase();
    }

    private void configureBinder() {
        this.binder.forField(this.address)
                .asRequired("The address cannot be empty")
                .bind(ContactBean::getAddress, ContactBean::setAddress);
        this.binder.forField(this.city)
                .asRequired("The city cannot be empty")
                .withValidator(value -> {
                    return (value != null) && value.startsWith("T");
                }, "The city should start with a T")
                .bind(ContactBean::getCity, ContactBean::setCity);
        this.binder.forField(this.state)
                .asRequired("The state cannot be empty")
                .bind(ContactBean::getState, ContactBean::setState);
        this.binder.forField(this.zip)
                .asRequired("The zip code cannot be empty")
                .bind(ContactBean::getZip, ContactBean::setZip);
        this.binder.forField(this.phone)
                .asRequired("The phone cannot be empty")
                .bind(ContactBean::getPhone, ContactBean::setPhone);
        this.binder.forField(this.email)
                .asRequired("The email address cannot be empty")
                .withValidator(new EmailValidator("Enter a valid email address"))
                .bind(ContactBean::getEmail, ContactBean::setEmail);
        this.binder.withValidator(contactBean -> {
            return contactBean.getCity().equals("Turku");
        }, "The city must be Turku");

        this.binder.setBean(this.bean);
    }

    private void submit() {
        BinderValidationStatus<ContactBean> validationStatus = this.binder.validate();

        this.errorSummary.removeAll();
        this.errorSummary.setVisible(false);

        if (validationStatus.isOk()) {
            // Everything is fine, do your action
            Dialog dialog = new Dialog();
            dialog.add("The form is valid");
            dialog.open();

        } else {
            // Display the error message
            Optional<ErrorSummary> errorNotification = ErrorSummary.createErrorNotification(validationStatus);
            errorNotification.ifPresentOrElse(notification -> {
                this.errorSummary.add(notification);
                this.errorSummary.setVisible(true);
            }, () -> {
            });
        }
    }

}
