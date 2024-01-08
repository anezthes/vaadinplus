package com.example.application.components.list;

import com.example.application.components.Badge;
import com.example.application.utilities.BadgeVariant;
import com.example.application.utilities.Gap;
import com.example.application.utilities.LineClamp;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class TaskListItem extends ThreeLineListItem {

    private Span name;
    private Badge status;
    private Paragraph content;

    public TaskListItem(String name, String status, String content, String date) {
        setGap(Gap.SMALL);

        this.name = new Span(name);
        this.name.addClassNames(LumoUtility.FontWeight.SEMIBOLD);

        this.status = new Badge(status, BadgeVariant.PILL, BadgeVariant.SMALL);

        this.content = new Paragraph(content);
        this.content.addClassNames(LumoUtility.Margin.NONE);

        setPrimary(this.name, this.status);
        setSecondary(date);
        setContent(content);
        setContentLineClap(LineClamp.LINE_CLAMP_2);
    }

}
