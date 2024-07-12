package com.example.application.components.dialogs;

import com.example.application.components.list.List;
import com.example.application.components.list.MessageLinkListItem;
import com.example.application.views.HomeView;
import com.vaadin.flow.component.Unit;

import java.time.LocalDateTime;

public class MessagesDialog extends NativeDialog {

    public MessagesDialog() {
        setAriaLabel("Messages");
        setMaxWidth(30, Unit.REM);

        // TODO: Mobile positioning
        // Position
        setRight(0.5f, Unit.REM);
        setTop(3.5f, Unit.REM);

        // Links
        List list = new List(
                new MessageLinkListItem("Sarah Anderson", "Hi John! Found a quicker way for you to access project files. Check 'Resources' for a shortcut to key documents!",
                        LocalDateTime.now().minusMinutes(12), HomeView.class),
                new MessageLinkListItem("Daniel Parker", "Hey John! Noticed an error in your report's data. Double-check Section 3 for accuracy before finalizing.",
                        LocalDateTime.now().minusMinutes(36), HomeView.class),
                new MessageLinkListItem("Rachel Hughes", "Hello John! Seeking your input for the upcoming presentation. Please review slides 5 to 10 and share your thoughts.",
                        LocalDateTime.now().minusMinutes(42), HomeView.class),
                new MessageLinkListItem("Andrew Murphy", "Hey John! Let's discuss the client proposal in the 'Ideas' section. Your insights are valuable!",
                        LocalDateTime.now().minusMinutes(56), HomeView.class)
        );
        add(list);
    }

}
