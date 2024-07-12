package com.example.application.views.templates.wizard;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Step 2 - Wizard")
@Route(value = "2", layout = WizardLayout.class)
public class Step2View extends Div {

    public Step2View() {
        addClassNames(Padding.Horizontal.LARGE, Padding.Vertical.MEDIUM);

        H2 heading = new H2("Step 2");
        add(heading);
    }


}
