package com.example.application.views;

import com.example.application.components.Step;
import com.example.application.components.Stepper;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Steppers")
@Route(value = "steppers", layout = MainLayout.class)
public class SteppersView extends View {

    public SteppersView() {
        addH2("Basic");
        add(createStepper());
    }

    private Stepper createStepper() {
        Step step1 = new Step("Quantum Flux Analysis", "Initiate the quantum flux analysis for dimensional harmonization", AppBarsView.class);
        Step step2 = new Step("Nebulicious Configuration", "Configure the nebulicious parameters for intergalactic harmonization", BreadcrumbsView.class);
        Step step3 = new Step("Hyperspectral Calibrations", "Perform hyperspectral calibrations to optimize quantum entanglement matrices", SteppersView.class);
        Step step4 = new Step("Transmogrification Validation", "Validate transmogrification integrity for inter-realm transference.", CheckboxesView.class);

        Stepper stepper = new Stepper(step1, step2, step3, step4);
        stepper.setState(Step.State.COMPLETE, step1);
        stepper.setState(Step.State.ERROR, step2);

        return stepper;
    }

}
