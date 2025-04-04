package com.example.application.component.ai;

import com.example.application.component.Layout;
import com.example.application.component.MaterialSymbol;
import com.example.application.component.list.FileListItem;
import com.example.application.component.list.List;
import com.example.application.theme.InputTheme;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextAreaVariant;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class AIInput extends Layout {

    private final List list;
    private final TextArea textArea;
    private final Button attachment;
    private final Button model;
    private final Button tokens;
    private final Button send;

    public AIInput() {
        addClassNames(Background.CONTRAST_5, Border.ALL, BorderColor.CONTRAST_5, BorderRadius.LARGE,
                Margin.Horizontal.AUTO, MaxWidth.SCREEN_MEDIUM, Padding.SMALL);
        setBoxSizing(BoxSizing.BORDER);
        setFlexDirection(FlexDirection.COLUMN);
        setGap(Gap.SMALL);

        // File list
        list = new List(
                new FileListItem("List.txt", "Code ⋅ 2:45 KB"),
                new FileListItem("List.txt", "Code ⋅ 2:45 KB")
        );
        list.setDisplay(Display.FLEX);
        list.setGap(Gap.SMALL);
        list.removeBackgroundColor();

        // Text area
        textArea = new TextArea();
        textArea.setPlaceholder("Give AI a task to work on...");
        textArea.addClassNames(Padding.NONE, Width.FULL);
        textArea.addThemeName(InputTheme.TRANSPARENT);
        textArea.addThemeVariants(TextAreaVariant.LUMO_SMALL);

        // Actions
        attachment = new Button(MaterialSymbol.ATTACHMENT.create());
        attachment.addClassNames(Background.TRANSPARENT, Border.ALL, BorderColor.CONTRAST_20, BorderRadius.FULL,
                Margin.Vertical.NONE, Padding.NONE, TextColor.SECONDARY);
        attachment.addThemeVariants(ButtonVariant.LUMO_SMALL);
        attachment.setAriaLabel("Attachment");
        attachment.setTooltipText("Attachment");

        model = new Button("Llama 2.0", MaterialSymbol.SMART_TOY.create());
        model.addClassNames(Background.TRANSPARENT, Border.ALL, BorderColor.CONTRAST_20, BorderRadius.FULL,
                Margin.Vertical.NONE, TextColor.SECONDARY);
        model.addThemeVariants(ButtonVariant.LUMO_SMALL);

        tokens = new Button("742", MaterialSymbol.STARS_2.create());
        tokens.addClassNames(Background.TRANSPARENT, Border.ALL, BorderColor.CONTRAST_20, BorderRadius.FULL,
                Margin.Start.AUTO, Margin.Vertical.NONE, TextColor.SECONDARY);
        tokens.addThemeVariants(ButtonVariant.LUMO_SMALL);
        tokens.setTooltipText("Tokens");

        send = new Button(MaterialSymbol.ARROW_UPWARD_ALT.create());
        send.addClassNames(BorderRadius.FULL, Margin.NONE, Padding.NONE);
        send.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SMALL);
        send.setAriaLabel("Send");
        send.setTooltipText("Send");

        Layout actions = new Layout(attachment, model, tokens, send);
        actions.setGap(Gap.SMALL);

        add(list, textArea, actions);
    }

    public List getList() {
        return list;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public Button getAttachment() {
        return attachment;
    }

    public Button getModel() {
        return model;
    }

    public Button getTokens() {
        return tokens;
    }

    public Button getSend() {
        return send;
    }
}
