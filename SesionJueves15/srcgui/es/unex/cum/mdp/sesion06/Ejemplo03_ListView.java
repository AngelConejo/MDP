package es.unex.cum.mdp.sesion06;

import es.unex.cum.mdp.sesion04.Persona;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo03_ListViewSolPersona extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		Label et1=new Label("Ejemplo de ListView");

		//Inicio Codigo necesario
		ListView l = new ListView();
		l.setPrefSize(200, 250);
		//l.setEditable(false);
		l.getItems().add(new Persona("1", "2", 3));
		l.getItems().add(new Persona("4", "5", 6));

		l.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// Para selección individual
				Persona valor=(Persona)l.getSelectionModel().getSelectedItem();
				et1.setText("Objeto: " + valor.toString()+" en posicion:"+l.getSelectionModel().getSelectedIndex());
			}
		});
		
		//Fin codigo necesario
		root.getChildren().add(l);
		root.getChildren().add(et1);

		primaryStage.setScene(new Scene(root, 200, 250));
		primaryStage.show();
	}
}