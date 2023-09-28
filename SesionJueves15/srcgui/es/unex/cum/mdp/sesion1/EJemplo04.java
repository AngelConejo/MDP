package es.unex.cum.mdp.sesion1;


import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EJemplo04 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World!");
		HBox root = new HBox();
				
		Button btn = new Button();
		btn.setText("Info");		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//Información
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Diálogo de Información ");
				alert.setHeaderText("Titulo del dialgo");
				alert.setContentText("Buenos días!");
				alert.showAndWait();
			}
		});
		
		Button btn1 = new Button();
		btn1.setText("Advert.");		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//Advertencia
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Dialogo de Advertencia");
				alert.setHeaderText("Título de diálogo");
				alert.setContentText("Cuidado, formatearás el ordenador!");
				alert.showAndWait();
			}
		});

		
		Button btn2 = new Button();
		btn2.setText("Error");		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//Error
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Diálogo de Error");
				alert.setHeaderText("Título de diálogo.");
				alert.setContentText("Ooops, ALgo fué mal!");
				alert.showAndWait();
			}
		});
		
		
		Button btn3 = new Button();
		btn3.setText("Confirmación");		
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//Confirmación
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Dialogo de Confirmación");
				alert.setHeaderText("Título del diálogo");
				alert.setContentText("Esta todo correcto?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					//Hacer algo
				} else {
				    // Hacer ago
				}				
			}
		});
		
		Button btn4 = new Button();
		btn4.setText("Entrada de datos");		
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//Confirmación
				TextInputDialog dialog = new TextInputDialog("walter");
				dialog .setTitle("Dialogo de Entrada de datos");
				dialog .setHeaderText("Título del diálogo");
				// Traditional way to get the response value.
				Optional<String> result = dialog.showAndWait();
				if (result.isPresent()){
				    System.out.println("Tú nombre es: " + result.get());
				}
			}
		});

		
		root.getChildren().add(btn);
		root.getChildren().add(btn1);
		root.getChildren().add(btn2);
		root.getChildren().add(btn3);
		root.getChildren().add(btn4);
		
		primaryStage.setScene(new Scene(root, 500, 250));
		primaryStage.show();
	}
}
