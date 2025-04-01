package com.example.application.view.component;

import com.example.application.component.EmptyState;
import com.example.application.component.MaterialSymbol;
import com.example.application.view.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Empty states")
@Route(value = "empty-states", layout = MainLayout.class)
public class EmptyStatesView extends ComponentView {

    public EmptyStatesView() {
        EmptyState emptyState = new EmptyState("Empty in events", "Create an event and it will show up here", "New event");
        emptyState.setIcon(MaterialSymbol.CALENDAR_ADD_ON.create());
        add(emptyState);
    }

}
