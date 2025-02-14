package com.example.application.component.dialog;

import com.example.application.component.list.List;
import com.example.application.component.list.MessageLinkListItem;
import com.example.application.view.HomeView;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.popover.Popover;
import com.vaadin.flow.component.popover.PopoverVariant;

import java.time.LocalDateTime;

public class MessagesDialog extends Popover {

    public MessagesDialog() {
        addThemeVariants(PopoverVariant.ARROW);
        setAriaLabel("Messages");

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
        list.setMaxWidth(25, Unit.REM);
        add(list);
    }

}
