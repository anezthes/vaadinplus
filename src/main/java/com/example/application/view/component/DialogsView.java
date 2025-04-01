package com.example.application.view.component;

import com.example.application.component.IconDialog;
import com.example.application.component.MaterialSymbol;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;


@PageTitle("Dialogs")
@Route(value = "dialogs", layout = MainLayout.class)
public class DialogsView extends ComponentView {

    public DialogsView() {
        addClassNames(AlignItems.START, Padding.Top.LARGE);

        add(
                new Button("Left-icon dialog", e -> createLeftIconDialog().open()),
                new Button("Top-icon dialog", e -> createTopIconDialog().open())
        );
    }

    private Dialog createLeftIconDialog() {
        IconDialog dialog = new IconDialog(
                MaterialSymbol.CHECK,
                "Zippity doo dah",
                "Your wibbly-wobbly task has been triumphantly accomplished, leaving everyone flabbergasted!"
        );
        dialog.setIconTheme(IconDialog.Theme.SUCCESS);
        dialog.setWidth(480, Unit.PIXELS);
        return dialog;
    }

    private Dialog createTopIconDialog() {
        IconDialog dialog = new IconDialog(
                MaterialSymbol.INFO,
                "Zippity doo dah",
                "Your wibbly-wobbly task has been triumphantly accomplished, leaving everyone flabbergasted!"
        );
        dialog.setIconPosition(IconDialog.Position.TOP);
        dialog.setIconTheme(IconDialog.Theme.PRIMARY);
        dialog.setWidth(400, Unit.PIXELS);
        return dialog;
    }

}
