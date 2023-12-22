package es.unex.cum.mdp.sesion06;


import es.unex.cum.mdp.sesion02.Persona;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo02_TableView extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		VBox root = new VBox();
		primaryStage.setScene(new Scene(root, 400, 450));		
		
		//Inicio codigo TableView
		
		Label et1=new Label("Ejemplo de TableView");
		
		//Paso 1. Crear el objeto tableview
		
		//TODO
			TableView<Persona> ta = new TableView<Persona>();
		//Paso 2: Definir las columnas
		
		//TODO
			TableColumn<Persona, String> colNombre = new TableColumn<>("nombre");
			TableColumn<Persona, String> colDni = new TableColumn<>("dni");
			TableColumn<Persona, Integer> colEdad = new TableColumn<>("edad");
			
			ta.getColumns().addAll(colNombre,colDni,colEdad);
		//Paso 3: Establecer los campos con los atributos de Persona
			
		//TODO
			colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre") );
			colDni.setCellValueFactory(new PropertyValueFactory<>("Dni") );
			colEdad.setCellValueFactory(new PropertyValueFactory<>("Edad") );
		//Paso 4: Agregar los datos al tableView
		
		//TODO
		 ta.getItems().add(new Persona("Luis","44",44));
		 ta.getItems().add(new Persona("Luis2","444",444));
		 ta.getItems().add(new Persona("Luis3","445",445));
		//Paso 5: Capturar el evento onClick
		
		//TODO Descomentar
		
		ta.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				TableViewSelectionModel<Persona> t=ta.getSelectionModel();
				Persona p=t.getSelectedItem();
				int pos=t.getSelectedIndex();
				et1.setText("Objeto: " + p.toString()+" en posicion:"+pos);
			}
		});
		root.getChildren().add(ta);
		root.getChildren().add(et1);
		//Fin codigo TableView
		primaryStage.show();
	}
}