package com.example.application.views.templates.wizard;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Step 3 - Wizard")
@Route(value = "3", layout = WizardLayout.class)
public class Step3View extends Div {

    public Step3View() {
        addClassNames(LumoUtility.Padding.Horizontal.LARGE, LumoUtility.Padding.Vertical.MEDIUM);

        H2 heading = new H2("Step 3");
        add(heading);
    }


}
