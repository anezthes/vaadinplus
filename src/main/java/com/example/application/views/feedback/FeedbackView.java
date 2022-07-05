package com.example.application.views.feedback;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Feedback")
@Route(value = "feedback", layout = MainLayout.class)
public class FeedbackView extends Main {

	public FeedbackView() {

	}

}
