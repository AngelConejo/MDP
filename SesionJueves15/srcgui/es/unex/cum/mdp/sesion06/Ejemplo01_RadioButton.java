package es.unex.cum.mdp.sesion06;	

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo01_RadioButton extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		VBox root = new VBox();
		primaryStage.setScene(new Scene(root, 400, 450));

		// Inicio codigo TableView

		Label et1 = new Label("Ejemplo de RadioButton");

		// Paso 1. Crear el objeto ToggleGroup

		// TODO
		ToggleGroup group=new ToggleGroup();

		// Paso 2: Crear los objetos RadioButton

		// TODO
		
		RadioButton rb1 = new RadioButton("Home");
		RadioButton rb2 = new RadioButton("Calendar");
		RadioButton rb3 = new RadioButton("Contacts");

		// Paso 3: Asociar los RadioButton a los ToggleGroup

		// TODO
		rb1.setToggleGroup(group);
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		
		rb1.setSelected(true);
		// Paso 4: Capturar el evento onClick

//		 TODO Descomentar

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {

				RadioButton rb = (RadioButton) group.getSelectedToggle();

				if (rb != null) {

					if (rb.getText().equals("Home")) {
						et1.setText("Home");}
					
						else if(rb.getText().equals("Calendar")) {
							et1.setText("Calendar");
						}
						else {
							et1.setText("Contacts");
						}
					}
				} 
			
		});

		root.getChildren().add(et1);
		root.getChildren().addAll(rb1,rb2,rb3);
		// Fin codigo TableView
		primaryStage.show();
	}
}