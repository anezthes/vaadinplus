package com.example.application.components;

import com.example.application.utilities.Breakpoint;
import com.example.application.utilities.FlexRowBreakpoint;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;

public class Highlights extends Layout implements HasTheme {

    private FlexRowBreakpoint breakpoint;

    public Highlights(Highlight... highlights) {
        addClassNames("highlights");
        add(highlights);
        setBreakpoint(Breakpoint.MEDIUM);
        setFlexDirection(FlexDirection.COLUMN);
        setFlexWrap(FlexWrap.WRAP);
        setOverflow(Overflow.HIDDEN);
        setWidthFull();
    }

    public void add(Highlight... highlights) {
        for (Highlight highlight : highlights) {
            setFlexBasis("0", highlight);
            setFlexGrow(highlight);
        }
        super.add(highlights);
    }

    public void setBreakpoint(Breakpoint breakpoint) {
        if (this.breakpoint != null) {
            removeClassNames(this.breakpoint.getClassName());
        }
        addClassNames(breakpoint.getFlexRowBreakpoint().getClassName());
        this.breakpoint = breakpoint.getFlexRowBreakpoint();
    }

    @Override
    public void setColumnGap(Gap gap) {
        super.setColumnGap(gap);
        removeClassNames(Background.BASE);
    }

    @Override
    public void removeColumnGap() {
        super.removeColumnGap();
        addClassNames(Background.BASE);
    }

    @Override
    public void setRowGap(Gap gap) {
        super.setRowGap(gap);
        removeClassNames(Background.BASE);
    }

    @Override
    public void removeRowGap() {
        super.removeRowGap();
        addClassNames(Background.BASE);
    }
}
