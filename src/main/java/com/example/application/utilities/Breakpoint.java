package com.example.application.utilities;

public enum Breakpoint {
	SMALL, MEDIUM, LARGE, XLARGE, XXLARGE;

	public FlexRowBreakpoint getFlexRowBreakpoint() {
		return FlexRowBreakpoint.valueOf(this.name());
	}
}
