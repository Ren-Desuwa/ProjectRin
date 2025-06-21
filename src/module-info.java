/**
 * 
 */
/**
 * 
 */
module ProjectRin {
	requires java.desktop;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
//	requires
	
	opens app.ui.controller to javafx.fxml;
	
	exports app.ui.view;
	exports app.ui.controller to javafx.fxml;
}