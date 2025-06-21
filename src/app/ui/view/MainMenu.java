package app.ui.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/resources/view/MainMenu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("ProjectRin - Main Menu");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

