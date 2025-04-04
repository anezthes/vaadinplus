package com.example.application.component.list;

import com.example.application.component.Layout;
import com.example.application.component.Span;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
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
        Layout corner = new Layout();
        corner.addClassNames(Background.CONTRAST_50, Position.End.NONE, Position.Top.NONE);
        corner.setHeight(30, Unit.PERCENTAGE);
        corner.setPosition(Layout.Position.ABSOLUTE);
        corner.setWidth(30, Unit.PERCENTAGE);

        Layout fileIcon = new Layout(corner, new Span(fileName.substring(fileName.lastIndexOf(".") + 1)));
        fileIcon.addClassNames(Background.PRIMARY, BorderRadius.SMALL, FontSize.XXSMALL, FontWeight.MEDIUM,
                Padding.XSMALL, TextColor.PRIMARY_CONTRAST);
        fileIcon.getStyle().set("clip-path", "polygon(0% 0%, 70% 0%, 100% 30%, 100% 100%, 0% 100%)");
        fileIcon.setAlignItems(Layout.AlignItems.END);
        fileIcon.setHeight(1.75f, Unit.REM);
        fileIcon.setJustifyContent(Layout.JustifyContent.CENTER);
        fileIcon.setPosition(Layout.Position.RELATIVE);
        fileIcon.setWidth(1.25f, Unit.REM);
        return fileIcon;
    }
}

