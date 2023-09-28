package es.unex.cum.mdp.sesion1;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo03 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World!");
		VBox root = new VBox();
		
		//----------------------
		Label l = new Label();
		l.setText("Hola");

		TextField t=new TextField();
		
		Button btn = new Button();
		btn.setText("Pinchame");
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//vamos a coger el valor de textfield y vamos a ver si es par o no
				try {
					int x= Integer.parseInt(t.getText());
					if (x%2==0)
						l.setText("Es par");
					else l.setText("Es impar");
				}catch (NumberFormatException e) {
					l.setText("Valor no valido");
				}
				
			}
		});
		
		root.getChildren().add(btn);
		root.getChildren().add(l);
		root.getChildren().add(t);
		
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
