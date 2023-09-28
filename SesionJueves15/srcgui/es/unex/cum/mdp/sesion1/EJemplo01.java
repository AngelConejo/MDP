package es.unex.cum.mdp.sesion1;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EJemplo01 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World!");
		StackPane root = new StackPane();
		//----------
		Button btn = new Button();
		btn.setText("Pinchame");		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setTitle("Lo hemos cambiado!");			
			}
		});
		root.getChildren().add(btn);
		//---------------
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
