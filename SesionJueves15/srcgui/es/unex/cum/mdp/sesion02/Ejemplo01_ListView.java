package es.unex.cum.mdp.sesion02;






import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo01_ListView extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();

		/////////////////////////
		//Inicio Codigo necesario
		/////////////////////////

		Label et = new Label("Prueba de etiqueta");
		root.getChildren().add(et);

		ListView l= new ListView();
		
		l.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		 public void handle(MouseEvent event) {
		 String valor=(String)l.getSelectionModel().getSelectedItem();
		int pos=l.getSelectionModel().getSelectedIndex();
		et.setText("Posicion: "+pos+" Valor: "+valor);
		 }
		});
		
		root.getChildren().add(l);

		//Añadimos un boton.
		Button b = new Button("Ok");
		root.getChildren().add(b);
		
		
		
		TextField t = new TextField();
		
		b.setOnAction(new EventHandler<ActionEvent>() { //Captura del evento
			@Override
			public void handle(ActionEvent event) {
				//A partir de aqui hace lo que quiero que haga
				et.setText(t.getText());
				//cambia la etiqueta por lo que pone en el cuadro de texto.
			}
		});
		//root.getChildren().add(b); //Se a単ade al panel

		//A単adir un cuadro de texto
		
		t.setText("Esto es un cuadro de texto");
		root.getChildren().add(t);

		//LISTA
		/*
		 * 1--> Definirlo
		 * 2--> Añadir datos: getItems().add("Hola");
		 * 3--> Seleccione algun dato
		 * 3.1-> Solo uno: (posicion y objeto).
		 * 3.2-> Varios: 
		 */
		l.getItems().add("Hola");
		l.getItems().add("Adios");
		l.getItems().add("Como estas");
		




		//Fin codigo necesario		
		/////////////////////////
		primaryStage.setScene(new Scene(root, 200, 250));
		primaryStage.show();
	}
}