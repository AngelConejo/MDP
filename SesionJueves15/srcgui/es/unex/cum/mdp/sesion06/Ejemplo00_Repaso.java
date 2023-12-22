package es.unex.cum.mdp.sesion06;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo00_Repaso extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		primaryStage.setScene(new Scene(root, 400, 450));
		// Inicio codigo
		Label et1 = new Label("Ejemplo1");
		root.getChildren().add(et1);
		Button bAnadir = new Button("Anadir");
		root.getChildren().add(bAnadir);
		TextField text = new TextField();
		root.getChildren().add(text);
		ListView<Integer> l = new ListView<Integer>();
		l.setPrefSize(200, 250);
		root.getChildren().add(l);
		bAnadir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {					
					l.getItems().add(Integer.parseInt(text.getText()));
				}catch (NumberFormatException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Información ");
					alert.setHeaderText("No hay número");
					alert.showAndWait();
				}
			}
		});
		// Fin codigo
		primaryStage.show();
	}
}
