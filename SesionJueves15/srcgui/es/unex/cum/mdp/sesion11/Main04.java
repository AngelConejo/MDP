package es.unex.cum.mdp.sesion11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main04 extends Application{
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
	  try {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource 	
				("Ejemplo04.fxml")); //Ponemos el fichero fxml creado
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	  } catch (Exception e) {
	  }
	}
}
