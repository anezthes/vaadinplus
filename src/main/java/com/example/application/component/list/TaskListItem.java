package com.example.application.component.list;

import com.example.application.component.Badge;
import com.example.application.component.Layout;
import com.example.application.component.Span;
import com.example.application.utility.BadgeVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

public class TaskListItem extends ThreeLineListItem {

    public TaskListItem(String name, String status, String content, String date) {
        setGap(Layout.Gap.SMALL);

        Paragraph paragraph = new Paragraph(content);
        paragraph.addClassNames(Margin.Vertical.NONE);

        setPrimary(
                new Span(name, FontWeight.SEMIBOLD),
                new Badge(status, BadgeVariant.PILL, BadgeVariant.SMALL)
        );
        setSecondary(date);
        setContent(content);
        setLineClamp(Layout.LineClamp.LINE_CLAMP_2);
    }

}
