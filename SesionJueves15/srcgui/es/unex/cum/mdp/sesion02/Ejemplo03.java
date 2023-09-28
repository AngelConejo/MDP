package es.unex.cum.mdp.sesion02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo03 extends Application {
	private Casa c;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Array de Objetos");
		BorderPane root = new BorderPane();
		primaryStage.setScene(new Scene(root, 600, 400));

		///////////////////////////////////
		// Definiciones
		///////////////////////////////////
		c = new Casa(5);
		ListView<Persona> lPersonas = new ListView<Persona>();

		///////////////////////////////////
		// Panel inferior:
		// Definiremos un panel HBox se añadirá al root
		///////////////////////////////////

		// TODO Crear el panel HBox (bot) y añadirlo al Botton de root
		VBox bot=new VBox();
		root.setBottom(bot);
		// TODO: Crear etiqueta (Ejemplo) y añadirla al panel bot
		Label l1=new Label("Ejemplo");
		bot.getChildren().add(l1);
		///////////////////////////////////
		// Panel de la izquierda
		VBox iz=new VBox();
		root.setLeft(iz);
		// Crearemos un panel VBox con varios componentes
		///////////////////////////////////
		Label l2=new Label ("Nombre");
		TextField tNombre=new TextField("");
		Label l3=new Label ("DNI");
		TextField tDNI=new TextField("");
		Label l4=new Label ("Edad");
		TextField tEdad=new TextField("");
		
		iz.getChildren().addAll(l2,tNombre,l3,tDNI,l4,tEdad);
		

		//  Crear un panel VBox (izq) y asociarlo a la parte izquierda de root

		// Crear 3 etiquetas y 3 cuadro de texto y añadirlo al panel izq

		// TODO: Crear 2 botones (añadir y borrar) y añadirlo al panel izq
		
			Button b1=new Button("Add");
			Button b2=new Button ("Borrar");
			iz.getChildren().addAll(b1,b2);
			// TODO crear la acción del botón añadir
			b1.setOnAction(new EventHandler<ActionEvent>() { //Captura del evento
				@Override
				public void handle(ActionEvent event) {
					//A partir de aqui hace lo que quiero que haga
					lPersonas.getItems().add(new Persona(tNombre.getText(),tDNI.getText(),Integer.parseInt(tEdad.getText())));
					tNombre.setText("");
					tDNI.setText("");
					tEdad.setText("");
					//cambia la etiqueta por lo que pone en el cuadro de texto.
				}
			});

		// TODO crear la acción del botón borrar
			b2.setOnAction(new EventHandler<ActionEvent>() { //Captura del evento
					@Override
					public void handle(ActionEvent event) {
						//A partir de aqui hace lo que quiero que haga
						int pos=lPersonas.getSelectionModel().getSelectedIndex();
						if (pos==-1) {
							
						}
						else{
							if (c.borrar(pos)){
				lPersonas.getItems().remove(pos);
			}
						}
						//cambia la etiqueta por lo que pone en el cuadro de texto.
					}
			});
		///////////////////////////////////
		// Panel del centro
		// Crearemos un panel VBox con varios componentes
		///////////////////////////////////

		// TODO crear el panel VBOX(der) y añadirlo a root
					VBox cent=new VBox();
					root.setCenter(cent);
		// TODO: Añadir al panel der el ListView de Personas (lPersonas)
					cent.getChildren().add(lPersonas);
		// TODO añadir un par de personas a ListView
					
					lPersonas.getItems().add(new Persona ("Juan", "44", 44));
					c.add(new Persona("Juan", "44", 44));
					lPersonas.getItems().add(new Persona ("Ana","30",30));
					c.add(new Persona("Ana","30",30));

		// TODO capturar el evento setOnMouseClicked y mostrar la información

		// TODO Decidir que se quiere mostrar

		///////////////////////////////////
		// Fin del código
		///////////////////////////////////
		primaryStage.show();

	}
}