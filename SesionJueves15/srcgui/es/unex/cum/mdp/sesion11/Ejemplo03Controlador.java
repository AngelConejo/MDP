package es.unex.cum.mdp.sesion11;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Ejemplo03Controlador implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private TextField ct1;

	@FXML
	private Label et1;

	@FXML
	void ClickenPinchame(ActionEvent event) {
		try {
			int x = Integer.parseInt(ct1.getText());
			if (x % 2 == 0)
				et1.setText("Es par");
			else
				et1.setText("Es impar");
		} catch (NumberFormatException e) {
			et1.setText("Valor no valido");
		}

	}

}
