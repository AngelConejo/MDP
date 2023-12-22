package es.unex.cum.mdp.sesion11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main03 extends Application{
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
	  try {
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource 	
				("Ejemplo03.fxml")); //Ponemos el fichero fxml creado
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	  } catch (Exception e) {
	  }
	}
}
