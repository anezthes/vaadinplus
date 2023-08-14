package com.example.application.views.components;

import com.example.application.components.EmptyState;
import com.example.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Empty states")
@Route(value = "empty-states", layout = MainLayout.class)
public class EmptyStatesView extends ComponentView {

    public EmptyStatesView() {
        EmptyState emptyState = new EmptyState("Empty in events", "Create an event and it will show up here", "New event");
        emptyState.setIcon(LineAwesomeIcon.CALENDAR_PLUS.create());
        add(emptyState);
    }

}
