package es.unex.cum.mdp.sesion06;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import src.es.unex.cum.mdp.sesion03.Desguace;
import src.es.unex.cum.mdp.sesion03.Pieza;
import src.es.unex.cum.mdp.sesion03.Vehiculo;

public class Ejemplo04 extends Application {

	private Desguace d = new Desguace("La chatarra");
	private ListView<Pieza> lPiezas;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Gestión de un Desguace");
		BorderPane root = new BorderPane();
		primaryStage.setScene(new Scene(root, 800, 400));

		///////////////////////////////////
		// Definiciones
		///////////////////////////////////

		// TODO Definir un ListView de Pieza
		
		lPiezas = new ListView<Pieza>();
		
		// TODO Definir un TableView de Vehiculo

		TableView<Vehiculo> tVehiculos = new TableView<Vehiculo>();
		ObservableList<Vehiculo> data = FXCollections.observableArrayList();
		
		///////////////////////////////////
		// Panel inferior:
		// Definiremos un panel HBox se añadirá al root
		///////////////////////////////////

		// TODO Crear el panel HBox (bot) y añadirlo al Botton de root
		HBox bot=new HBox();
		root.setBottom(bot);
		
		// TODO: Crear etiqueta (Ejemplo) y añadirla al panel bot
		
		
		
		///////////////////////////////////
		// Panel de la derecha
		// Crearemos un panel VBox con varios componentes
		///////////////////////////////////

		// TODO: Crear un panel VBox (izq) y asociarlo a la parte izquierda de root

		// TODO: Crear 3 etiquetas (lText1, lText2 y lText3) con valor marca, modelo y bastidor y añadirlo a izq
		
		// TODO: Crear 3 cuadro de texto (tText1, tText2 y tText3) con valor vacio y añadirlo al panel izq

		// TODO: Crear 2 botones (añadir y borrar) y añadirlo al panel izq
		Button bAnadir = new Button("Anadir");
		root.getChildren().add(bAnadir);
		Button bBorrar = new Button("Borrar");
		root.getChildren().add(bAnadir);
		// TODO: crear la acción del botón añadir

		// TODO: crear la acción del botón borrar

		// TODO: Radio button para escoger

		// TODO: Crear una etiqueta con valor "Tipo de Objeto" y añadirla a izq
		

		
		// TODO: Crear un toggle group denominado tg

		// TODO: Crear 3 radio button con valor Pieza, Vehiculo, Persona y añadirlo a izq
		
		//TODO: Asociar cada radio button al toggle group
		
		
		//TODO: Crear el evento onClick. Descomentar

		//tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		//	public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {
				//RadioButton rb = (RadioButton) tg.getSelectedToggle();

				//if (rb != null) {
					//String s = rb.getText();
					
					//TODO: Dependiendo del valor de s, cambiar las tres etiquetas
					//Si es Vehiculo: marca, modelo y bastidor
					//Si es Pieza: id, nombre, stock
					//Si es persona: nombre, dni y edad

				//}
			//}
		//});

		// TODO: Crear el evento onClick sobre el botón añadir
		
		//Dependiendo del tipo de radio button, se añadirá  un vehiculo, una pieza al vehiculo selecciona 
		// o una persona al vehiculo seleccionado
		
		//bAnadir.setOnAction(new EventHandler<ActionEvent>() {
		//	@Override
		//	public void handle(ActionEvent event) {
		
				//TODO: Coger el radio button seleccionado como se ha hecho antes

				//TODO: Si es distinto de null, coger su valor textual
		
				//De momento no usaremos los componentes ListView y TableView

				//TODO: Si es Pieza, se añade al primer vehiculo del desguace la Pieza crear a partir de los CTs

				//TODO: Si es Vehiculo, se añade un vehículo al desguace con los valores de los CTs
					
				// TODO: Si es persona, se añade al primer vehiculo del desguace la persona creada a partir de los CTs
		
				//TODO: Haremos un syso de desguace para ver que ha funcionado

				//TODO: Se borra el texto de los CTs
				
			//	}
		//});
		
		//TODO: Crear el evento onClick en Borrar
//		bBorrar.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//
//			}
//		});

		///////////////////////////////////
		// Panel del derecha
		// Crearemos un panel VBox con varios componentes
		///////////////////////////////////

		// TODO crear el panel VBOX(der) y añadirlo a root

		// TODO: Añadir al panel der el ListView de Personas (lPersonas)


		///////////////////////////////////
		// Panel del centro
		// Crearemos un panel VBox 
		///////////////////////////////////
		
		// TODO crear el panel VBOX(cent) y añadirlo a root

		// TODO: Añadir al panel cent el TableView de Vehiculos(tVehiculos)

		//TODO: Definir las 5 columnas: Marca, modelo, bastidor, nombre (persona) y Cantidad (de piezas)

		//TODO: Fijar el valor de las celdas de Marca, modelo y Bastidor
		
		//TODO: Fijar el valor de las celdas nombre y cantidad. Son casos especiales y se verán. 

		//TODO: Añadir las columnas al TableView

		//TODO: Añadir un par de vehículos al desguace

		//TODO: Añadir al ObservableList los vehiculos del Desguace
		//data.addAll(d.getVehiculos());
		//TODO: Añadir al tableView el ObservableList
		//tVehiculos.setItems(data);
		
		//TODO: Capturar el evento click sobre el TableView
		
//		tVehiculos.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				//TODO: Cargar en el ListView las piezas del Vehículo seleccionado				
//			}
//		});

		///////////////////////////////////
		// Fin del código
		///////////////////////////////////
		primaryStage.show();

	}
}