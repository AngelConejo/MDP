package es.unex.cum.mdp.ej5calculadora;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("vista/Calculadora.fxml")); // Ponemos el
                                                                                                        // fichero fxml
                                                                                                        // creado
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("vista/Estilo.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}