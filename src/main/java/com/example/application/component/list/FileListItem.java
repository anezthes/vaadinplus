package com.example.application.component.list;

import com.example.application.component.Layout;
import com.example.application.component.Span;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class FileListItem extends ListItem {

    public FileListItem(String primary, String secondary) {
        addClassNames(Background.CONTRAST_5, BorderRadius.LARGE, Padding.Horizontal.SMALL);
        removeClassName(Padding.Horizontal.MEDIUM);

        setPrefix(createFileIcon(primary.substring(primary.lastIndexOf('.') + 1)));

        setPrimary(new Span(primary, FontSize.XSMALL));
        setSecondary(new Span(secondary, FontSize.XXSMALL));
        this.column.removeClassName(Padding.Vertical.XSMALL);

        setGap(Layout.Gap.SMALL);
    }

    private Component createFileIcon(String fileName) {
        Div corner = new Div();
        corner.addClassNames(Background.CONTRAST_50, Display.FLEX, Position.ABSOLUTE, Position.End.NONE,
                Position.Top.NONE);
        corner.setHeight(30, Unit.PERCENTAGE);
        corner.setWidth(30, Unit.PERCENTAGE);

        Div fileIcon = new Div(corner, new Span(fileName.substring(fileName.lastIndexOf(".") + 1)));
        fileIcon.addClassNames(AlignItems.END, Background.PRIMARY, BorderRadius.SMALL, Display.FLEX,
                FontSize.XXSMALL, FontWeight.MEDIUM, JustifyContent.CENTER, Padding.XSMALL, Position.RELATIVE,
                TextColor.PRIMARY_CONTRAST);
        fileIcon.getStyle().set("clip-path", "polygon(0% 0%, 70% 0%, 100% 30%, 100% 100%, 0% 100%)");
        fileIcon.setHeight(1.75f, Unit.REM);
        fileIcon.setWidth(1.25f, Unit.REM);
        return fileIcon;
    }
}

