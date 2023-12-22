package es.unex.cum.mdp.sesion11;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import es.unex.cum.mdp.sesion05.Desguace;
import es.unex.cum.mdp.sesion05.Pieza;
import es.unex.cum.mdp.sesion05.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

public class Ejemplo04Controlador implements Initializable {

	private Desguace d;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		d = new Desguace("Manolo");
		d.addVehiculo(new Vehiculo("Seat", "Toledo", null, 1, 5));
		d.addVehiculo(new Vehiculo("Renault", "Megane", null, 2, 5));
		d.addPiezaDesguace(new Pieza("1", "Freno", 10));
		d.addPiezaDesguace(new Pieza("2", "Volante", 10));
		d.addPiezaVehiculo("1", 1);

	}

	@FXML
	private BorderPane bpCentral;

	@FXML
	private Label etCentral;

	

	@FXML
	void BtnVehiculos(ActionEvent event) {
		//Se cambia la etiqueta central
		etCentral.setText("Vehiculos");
		//Quitamos lo que haya en el panel central y derecha
		bpCentral.setRight(null);
		bpCentral.setCenter(null);
		
		//Al panel central añadimos un tableview para Vehiculo
		TableView<Vehiculo> tview = new TableView<Vehiculo>();
		TableColumn<Vehiculo, String> colMarca = new TableColumn<>("Marca");
		TableColumn<Vehiculo, String> colModelo = new TableColumn<>("Modelo");
		TableColumn<Vehiculo, Integer> colBastidor = new TableColumn<>("Bastidor");
		TableColumn<Vehiculo, String> colNombre = new TableColumn<>("Nombre");
		TableColumn<Vehiculo, String> colCantidad = new TableColumn<>("Cantidad");

		tview.getColumns().addAll(colMarca, colModelo, colBastidor, colNombre, colCantidad);

		// Fijar el valor de las celdas de Marca, modelo y Bastidor

		colMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
		colModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
		colBastidor.setCellValueFactory(new PropertyValueFactory<>("Bastidor"));

		// Fijar el valor de las celdas nombre y cantidad. Son casos especiales y se
		// verán.

		colNombre.setCellValueFactory(cellData -> {
			// cellData.getValue() es un objeto vehiculo
			if (cellData.getValue().getPropietario() == null)
				return new SimpleStringProperty();
			else
				return new SimpleStringProperty(cellData.getValue().getPropietario().getNombre());
		});

		colCantidad.setCellValueFactory(new Callback<CellDataFeatures<Vehiculo, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<Vehiculo, String> p) {
				// p.getValue() es un objeto Vehiculo
				return new SimpleStringProperty(String.valueOf(p.getValue().getCont()));
			}
		});

		ObservableList<Vehiculo> data = FXCollections.observableArrayList();
		data.addAll(d.getVehiculos());
		// Fijar al tableView el ObservableList y al panel central
		tview.setItems(data);
		bpCentral.setCenter(tview);

		//Cuando se pulse sobre un vehiculo, añadimos un panel a la derecha con las piezas
		tview.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//Se crea el listView
				ListView<Pieza> lPiezas;
				lPiezas = new ListView<Pieza>();
				//Se fija el listview a la derecha
				bpCentral.setRight(lPiezas);
				//Se carga con los datos del vehiculo seleccionado
				Vehiculo v = tview.getSelectionModel().getSelectedItem();
				lPiezas.getItems().addAll(v.getPiezas());
			}
		});

	}

	@FXML
	void btnPersonas(ActionEvent event) {

	}

	@FXML
	void btnPiezas(ActionEvent event) {
		//Se cambia la etiqueta a peizas
		etCentral.setText("Piezas");
		//Se quita todo lo que hay
		bpCentral.setRight(null);
		bpCentral.setCenter(null);
		//Se añade un tableview de piezas al panel central
		TableView<Pieza> tview = new TableView<Pieza>();
		TableColumn<Pieza, String> colId = new TableColumn<>("id");
		TableColumn<Pieza, String> colNombre = new TableColumn<>("nombre");
		TableColumn<Pieza, Integer> colStock = new TableColumn<>("stock");

		tview.getColumns().addAll(colId, colNombre, colStock);

		// Fijar el valor de las celdas de Marca, modelo y Bastidor

		colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		colStock.setCellValueFactory(new PropertyValueFactory<>("Stock"));

		ObservableList<Pieza> data = FXCollections.observableArrayList();
		ArrayList<Pieza> aux = new ArrayList<>(d.getAlmacen());
		data.addAll(aux);
		// Fijar al tableView el ObservableList
		tview.setItems(data);
		bpCentral.setCenter(tview);

	}

}
