package com.example.application.views.components;

import com.example.application.components.Sidebar;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Sidebars")
@Route(value = "sidebars", layout = MainLayout.class)
public class SidebarsView extends ComponentView {

    public static final String JOHN_SMITH = "John Smith";
    public static final String EMILY_JOHNSON = "Emily Johnson";
    public static final String MICHAEL_DAVIS = "Michael Davis";
    public static final String SOPHIA_BROWN = "Sophia Brown";
    public static final String DANIEL_WILSON = "Daniel Wilson";
    public static final String OLIVIA_MARTINEZ = "Olivia Martinez";
    public static final String DAVID_THOMPSON = "David Thompson";

    public SidebarsView() {
        addClassNames(AlignItems.START, Gap.MEDIUM, Padding.Top.LARGE);

        RadioButtonGroup<String> mode = new RadioButtonGroup<>("Header theme");
        mode.setItems("Light", "Dark");
        mode.addValueChangeListener(e -> getChildren().forEach(component -> {
            if (component instanceof Sidebar) {
                if (e.getValue().equals("Dark")) {
                    ((Sidebar) component).addHeaderThemeName(Lumo.DARK);
                } else {
                    ((Sidebar) component).removeHeaderThemeName(Lumo.DARK);
                }
            }
        }));
        add(mode);

        Sidebar sidebar = new Sidebar(
                "New event",
                "Fill in the blibber-blabber below to create a sensational event that will leave everyone flibber-gasted!",
                createForm()
        );
        add(sidebar);

        Button button = new Button("Open sidebar", e -> sidebar.open());
        add(button);
    }

    private Component[] createForm() {
        TextField title = new TextField("Title");

        TextArea description = new TextArea("Description");

        MultiSelectComboBox<String> guests = new MultiSelectComboBox<>("Guests");
        guests.setItems(
                JOHN_SMITH, EMILY_JOHNSON, MICHAEL_DAVIS, SOPHIA_BROWN, DANIEL_WILSON, OLIVIA_MARTINEZ, DAVID_THOMPSON
        );

        RadioButtonGroup<String> visibility = new RadioButtonGroup<>("Visibility");
        visibility.setItems("Private", "Public");
        visibility.setValue("Private");

        return new Component[]{title, description, guests, visibility};
    }

}
