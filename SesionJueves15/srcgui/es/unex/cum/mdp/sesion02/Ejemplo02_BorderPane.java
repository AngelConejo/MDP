package es.unex.cum.mdp.sesion02;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ejemplo02_BorderPane extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// El panel se encuentra dividido en 5 subpaneles. 
		// Si uno no se usa, no se muestra
		// 			Top
		//
		// Left 	Center 	Right
		//
		// 			Botton

		// layout
		BorderPane borderPane = new BorderPane();
		
		// control parte superior
		Button topButton = new Button("TOP");
		borderPane.setTop(topButton);
		
		// control parte inferior
		Button bottomButton = new Button("BOTTOM");
		borderPane.setBottom(bottomButton);
		
		// control en lado izquierdo
		Button leftButton = new Button("LEFT");
		borderPane.setLeft(leftButton);
		
		//TODO. Añadir al nodo izquierdo un layout VBox y añadir dos botones.
		
		// control en lado derecho
		Button rightButton = new Button("RIGHT");
		borderPane.setRight(rightButton);
		
		// Control en el centro
		borderPane.setCenter(new Button("CENTER"));

		// alineacion de controles respecto el lugar del Pane que se encuentren
		BorderPane.setAlignment(topButton, Pos.CENTER);
		BorderPane.setAlignment(bottomButton, Pos.CENTER);
		BorderPane.setAlignment(leftButton, Pos.CENTER);
		BorderPane.setAlignment(rightButton, Pos.CENTER);

		primaryStage.setScene(new Scene(borderPane, 400, 300));
		primaryStage.show();

	}
}