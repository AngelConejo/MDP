package es.unex.cum.mdp.sesion06;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Ejemplo3_SDesguace_BVehiculo extends Application {

	
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

		// Definir un ListView de Pieza

		// Definir un TableView de Vehiculo
		lPiezas = new ListView<Pieza>();
		TableView<Vehiculo> tVehiculos = new TableView<Vehiculo>();
		
		/**********IMPORTANTE: 
		En lugar de usar el método getItems().add() para añadir vehículo a la lista
		Definiremos un objeto ObservableList y se fijará al TableView y todas las operaciones
		con el tableView se realizará sobre esta lista
		********************/
		ObservableList<Vehiculo> data = FXCollections.observableArrayList();
		VBox der = new VBox();
		///////////////////////////////////
		// Panel inferior:
		// Definiremos un panel HBox se añadirá al root
		///////////////////////////////////

		// Crear el panel HBox (bot) y añadirlo al Botton de root

		HBox inf = new HBox();
		root.setBottom(inf);

		// Crear etiqueta (Ejemplo) y añadirla al panel bot

		Label et1 = new Label("Ejemplo de ListView");
		inf.getChildren().add(et1);

		///////////////////////////////////
		// Panel de la derecha
		// Crearemos un panel VBox con varios componentes
		///////////////////////////////////

		// Crear un panel VBox (izq) y asociarlo a la parte izquierda de root

		VBox izq = new VBox(); // El panel de la derecha se fija como vBox
		root.setLeft(izq); // Se añade al panel principal, el panel vBox (der)

		// Crear 3 etiquetas y 3 cuadro de texto y añadirlo al panel izq
		
		Label lText1 = new Label("Marca");
		Label lText2 = new Label("Modelo");
		Label lText3 = new Label("Bastidor");
		TextField tText1 = new TextField();
		TextField tText2 = new TextField();
		TextField tText3 = new TextField();

		// Crear 2 botones (añadir y borrar) y añadirlo al panel izq
		Button bAnadir = new Button("Añadir");
		Button bBorrar = new Button("Borrar");
		izq.getChildren().addAll(lText1, tText1, lText2, tText2, lText3, tText3, bAnadir, bBorrar);

		// create a label
		Label l = new Label("Tipo de Objeto ");

		// create a toggle group
		ToggleGroup tg = new ToggleGroup();
		// create radiobuttons
		RadioButton r1 = new RadioButton("Pieza");
		RadioButton r2 = new RadioButton("Vehiculo");
		RadioButton r3 = new RadioButton("Persona");
		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		r3.setToggleGroup(tg);
		r2.setSelected(true);
		
		// add label y radio button
		izq.getChildren().addAll(l, r1, r2, r3);

		// Cambiar cuando se pincha el radioButton
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {

				RadioButton rb = (RadioButton) tg.getSelectedToggle();

				if (rb != null) {
					String s = rb.getText();

					if (rb.getText().equals("Pieza")) {
						et1.setText("Pieza");
						lText1.setText("id");
						lText2.setText("nombre");
						lText3.setText("stock");
					} else if (rb.getText().equals("Vehiculo")) {
						et1.setText("Vehiculo");
						lText1.setText("marca");
						lText2.setText("modelo");
						lText3.setText("bastidor");

					} else {
						et1.setText("Persona");
						lText1.setText("nombre");
						lText2.setText("dni");
						lText3.setText("edad");

					}
				}
			}
		});

		//Acción sobre el botón añadir
		bAnadir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				RadioButton rb = (RadioButton) tg.getSelectedToggle();

				if (rb != null) {
					String s = rb.getText();
					//Comprobamos que radioButton está seleccionado
					
					if (rb.getText().equals("Pieza")) {
						//Tenemos que tener seleccionado un vehiculo, para añadirle la pieza
						int pos = tVehiculos.getSelectionModel().getSelectedIndex();
						if (pos == -1) {
							et1.setText("Selecciona un vehiculo");
						} else {
							//Se añade la pieza al vehiculo en el modelo
							Vehiculo v = tVehiculos.getSelectionModel().getSelectedItem();
							Pieza p = new Pieza(tText1.getText(), tText2.getText(), Integer.parseInt(tText3.getText()));
							if (v.addPiezaV(p)) {
								et1.setText("Todo correcto");
							} else {
								et1.setText("No se ha podido añadir");
							}
							//Se añade la pieza a la vista (ListView)
							lPiezas.refresh();
							lPiezas= new ListView<Pieza>();
							der.getChildren().set(0, lPiezas); //Sustituimos el listView
							lPiezas.refresh();
							lPiezas.getItems().addAll(v.getPiezas()); //Añadimos el array de Piezas
							//Como se tiene un atributo cantidad, se refresca también el tableView
							data.clear();
							
							//TODO cambiar por SDesguace
							//Desguace d= new Desguace();
							SDesguace d= SDesguace.getInstance();
							data.addAll(d.getVehiculos());
							tVehiculos.refresh();
						}

					} else if (rb.getText().equals("Vehiculo")) {
						//Se añade el vehiculo al modelo
						//*******************************************
						//TODO cambiar por la BuilderVehiculo de Vehiculo
						int tipo=(int)(Math.random()*2)+1;
						Vehiculo v = new Vehiculo(tText1.getText(), tText2.getText(), null,
								Integer.parseInt(tText3.getText()),3);
						
						
						//************************************************
						//TODO cambiar por SDesguace
						//Desguace d= new Desguace();
						SDesguace d= SDesguace.getInstance();
						d.addVehiculo(v);
						//Se refresca el TableView. Para ello se nutre nuevamente el objeto ObservableLista
						//Con la lista de vehículos.
						data.clear();
						data.addAll(d.getVehiculos());
						tVehiculos.refresh();
						
					} else { //Es persona
						//Se tiene que seleccionar un vehículo previamente
						int pos = tVehiculos.getSelectionModel().getSelectedIndex();
						if (pos == -1) {
							et1.setText("Selecciona un vehiculo");
						} else {
							//Al vehiculo se establece la Pesrona
							Vehiculo v = tVehiculos.getSelectionModel().getSelectedItem();
							Persona p = new Persona(tText1.getText(), tText2.getText(), Integer.parseInt(tText3.getText()));
							//Se cambia en el modelo
							v.setPropietario(p);
							//Se cambia en la vista
							data.set(pos, v);
						}

					}
					tText1.clear();
					tText2.clear();
					tText3.setText("");
				}
			}
		});
		
		//TODO: Por hacer
		bBorrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});

		///////////////////////////////////
		// Panel del derecha
		// Crearemos un panel VBox con varios componentes
		///////////////////////////////////
		
		root.setRight(der); // El panel de la derecha se fija como vBox
		der.getChildren().add(lPiezas);

		///////////////////////////////////
		// Panel del centro
		// Crearemos un panel VBox con varios componentes
		///////////////////////////////////

		// crear el panel VBOX(centro) y añadirlo a root

		VBox cent = new VBox();
		root.setCenter(cent); // El panel de la derecha se fija como vBox
		
		// Añadir al panel cent el TableView de Vehiculos(tVehiculos)
		cent.getChildren().add(tVehiculos);
		// Definir las 5 columnas: Marca, modelo, bastidor, nombre (persona) y Cantidad (de piezas)

		TableColumn<Vehiculo,String> colMarca = new TableColumn<>("Marca");
		TableColumn<Vehiculo,String> colModelo = new TableColumn<>("Modelo");
		TableColumn<Vehiculo,Integer> colBastidor = new TableColumn<>("Bastidor");
		TableColumn<Vehiculo,String> colNombre = new TableColumn<>("Nombre");
		TableColumn<Vehiculo,String> colCantidad = new TableColumn<>("Cantidad");
		tVehiculos.getColumns().addAll(colMarca, colModelo, colBastidor,colNombre,colCantidad);
		
		//Fijar el valor de las celdas de Marca, modelo y Bastidor
		
		colMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
		colModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
		colBastidor.setCellValueFactory(new PropertyValueFactory<>("Bastidor"));
		
		//Fijar el valor de las celdas nombre y cantidad. Son casos especiales y se verán.
		
		colNombre.setCellValueFactory(cellData -> {
				//cellData.getValue() es un objeto vehiculo
				if (cellData.getValue().getPropietario()==null) return new SimpleStringProperty();
				else return new SimpleStringProperty(cellData.getValue().getPropietario().getNombre());
			}
		);
		
		colCantidad.setCellValueFactory(new Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Vehiculo, String> p) {
		         // p.getValue() es un objeto Vehiculo
		         return new SimpleStringProperty(String.valueOf(p.getValue().getCont()));
		     }
		 });

		 // Otra forma de hacerlo
		//colCantidad.setCellValueFactory(p -> new SimpleStringProperty(String.valueOf(p.getValue().getCont())));

		//Añadir un par de vehículos al desguace
		//TODO cambiar por SDesguace		
		//Desguace d= new Desguace();
		SDesguace d= SDesguace.getInstance();
		//TODO Cambiar por el patrón builder
		d.addVehiculo(new Vehiculo("seat", "toledo", null, 1,3));
		d.addVehiculo(new Vehiculo("renault", "megane", null, 2,3));

		//Añadir al ObservableList los vehiculos del Desguace
		data.addAll(d.getVehiculos());
		//Fijar al tableView el ObservableList
		tVehiculos.setItems(data);
		
		//Capturar el evento click sobre el TableView
		//Cuando pinchemos --> Mostraremos la lista de piezas
		tVehiculos.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				//lPiezas.getItems().clear();
				lPiezas= new ListView<Pieza>();
				der.getChildren().set(0, lPiezas);
				lPiezas.refresh();
				
				Vehiculo v = tVehiculos.getSelectionModel().getSelectedItem();
				lPiezas.getItems().addAll(v.getPiezas());
			}
		});
		// Para decidir que se va a mostrar. Sino se muestra toString

		///////////////////////////////////
		// Fin del código
		///////////////////////////////////
		primaryStage.show();

	}
}