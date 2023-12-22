package es.unex.cum.mdp.Calculadora.controler;

import es.unex.cum.mdp.Calculadora.modelo.Calculadora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraController {
	float cofre=0.0f;
	String llave="";
	@FXML
	private Button B0;

	@FXML
	private Button B1;

	@FXML
	private Button B2;

	@FXML
	private Button B3;

	@FXML
	private Button B4;

	@FXML
	private Button B5;

	@FXML
	private Button B6;

	@FXML
	private Button B7;

	@FXML
	private Button B8;

	@FXML
	private Button B9;

	@FXML
	private Button BBarra;

	@FXML
	private Button BCE;

	@FXML
	private Button BCL;

	@FXML
	private Button BDivision;

	@FXML
	private Button BIgual;

	@FXML
	private Button BMas;

	@FXML
	private Button BMasMenos;

	@FXML
	private Button BMsg;

	@FXML
	private Button BMultiplicacion;

	@FXML
	private Button BPunto;

	@FXML
	private TextField text1;

	@FXML
	void Especial(ActionEvent event) {
		Button b=(Button) event.getSource();
		switch (b.getId()) {
		case "BMsg":
			Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Bienvenido");
            alert.setHeaderText("Ojalá te salga todo mal, Bienvenido a mi calculadora");
            alert.setContentText("Pulsa Aceptar para empezar!");
            alert.showAndWait();
			break;
		case "BCE":
			text1.setText("");
			cofre=0.0f;
			break;
		case "CL":
			text1.setText("");
			break;
		case "BMasMenos":
				text1.setText(String.valueOf(Float.parseFloat(text1.getText())*-1));
		
		}
	}

	@FXML
	void Numerico(ActionEvent event) {
		Button b = (Button) event.getSource();
		switch (b.getId()) {
		case "B0":
			text1.appendText("0");
			break;
		case "B1":
			text1.appendText("1");
			break;
		case "B2":
			text1.appendText("2");
			break;
		case "B3":
			text1.appendText("3");
			break;
		case "B4":
			text1.appendText("4");
			break;
		case "B5":
			text1.appendText("5");
			break;
		case "B6":
			text1.appendText("6");
			break;
		case "B7":
			text1.appendText("7");
			break;
		case "B8":
			text1.appendText("8");
			break;
		case "B9":
			text1.appendText("9");
			break;
		case "BPunto":
			text1.appendText(".");
			break;

		}
	}
	
	@FXML
	void Operandos(ActionEvent event) {
		Button b=(Button)event.getSource();
		switch (b.getId())
		{
		case "BDivision":
			llave="BDivision";
			cofre=Float.parseFloat(text1.getText());
			text1.setText("");
			break;
		case "BMultiplicacion":
			llave="BMultiplicacion";
			cofre=Float.parseFloat(text1.getText());
			text1.setText("");
			break;
		case "BSuma":
			llave="BSuma";
			cofre=Float.parseFloat(text1.getText());
			text1.setText("");
			break;
		case "BResta":
			llave="BResta";
			cofre=Float.parseFloat(text1.getText());
			text1.setText("");
			break;
		}
	}

	@FXML
	void Resultado(ActionEvent event) {
	Calculadora bipop=new Calculadora();
	switch(llave)
	{
	case"BDivision":
		text1.setText(String.valueOf(bipop.dividir(cofre, Float.parseFloat(text1.getText()))));
		break;
	case "BMultiplicacion":
		text1.setText(String.valueOf(bipop.multiplicar(cofre, Float.parseFloat(text1.getText()))));
		break;
	case "BSuma":
		text1.setText(String.valueOf(bipop.sumar(cofre, Float.parseFloat(text1.getText()))));
		break;
	case "BResta":
		text1.setText(String.valueOf(bipop.restar(cofre, Float.parseFloat(text1.getText()))));
		break;
	}

}
}