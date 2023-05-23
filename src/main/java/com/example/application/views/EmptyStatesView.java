package com.example.application.views;

import com.example.application.components.EmptyState;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Empty States")
@Route(value = "empty-states", layout = MainLayout.class)
public class EmptyStatesView extends View {

    public EmptyStatesView() {
        EmptyState emptyState = new EmptyState("Empty in events", "Create an event and it will show up here", "New Event");
        emptyState.setIcon(LineAwesomeIcon.CALENDAR_PLUS.create());
        add(emptyState);
    }

}
