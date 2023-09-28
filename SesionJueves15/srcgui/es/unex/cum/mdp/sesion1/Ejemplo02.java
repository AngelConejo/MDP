package es.unex.cum.mdp.sesion1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo02 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World!");
		VBox root = new VBox();
		// -------------------------
		Label l = new Label(); //Creación de etiqueta
		Button btn = new Button(); //Creación de botón
		btn.setText("Pinchame");	//Texto del botón
		l.setText("Valor inicial");	//Texto de la etiqueta
		btn.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			l.setText("Cambiamos la etiqueta");		
		}});
		root.getChildren().add(btn);
		root.getChildren().add(l);
		//------------------
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

}
