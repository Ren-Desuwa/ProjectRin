package app.ui.controller;

import app.utils.Debugger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainMenuController {
	@FXML private Rectangle hoverTrigger;
	@FXML private AnchorPane sidePanel;
	
	@FXML void initialize() {
		Platform.runLater(() -> sidePanel.setTranslateX(-sidePanel.getWidth()));
		hoverTrigger.setOnMouseEntered(e -> showSidePanel());
		sidePanel.setOnMouseExited(e -> hideSidePanel());
	}
	
	void showSidePanel() {
		Debugger.log("Showing side panel");
	    TranslateTransition slideIn = new TranslateTransition(Duration.millis(200), sidePanel);
	    slideIn.setToX(0);
	    slideIn.play();
	}
	
	void hideSidePanel() {
		Debugger.log("Hiding side panel");
	    TranslateTransition slideOut = new TranslateTransition(Duration.millis(200), sidePanel);
	    slideOut.setToX(-sidePanel.getWidth());
	    slideOut.play();
	}
}	