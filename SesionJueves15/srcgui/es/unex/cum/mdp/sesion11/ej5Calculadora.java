package es.unex.cum.mdp.sesion11;

import java.math.BigDecimal;

/**
 * La clase ej7Calculadora es una clase donde se tendra el modelo
 * de la calculadora (logica)
 * 
 *
 */
public class ej5Calculadora {
	private float primerOperando;
	private float segundoOperando;
	
	public ej5Calculadora() {
	}
	
	public ej5Calculadora(float primerOperando, float segundoOperando) {
	}

	public float getPrimerOperando() {
		return 0.0F;
	}

	public void setPrimerOperando(float primerOperando) {
	}

	public float getSegundoOperando() {
		return 0.0F;
	}

	public void setSegundoOperando(float segundoOperando) {
	}
	
	public float sumar(float num1, float num2) {
		return 0.0F;
	}

	public float restar(float num1, float num2) {
		return 0.0F;
	}

	public float multiplicar(float num1, float num2) {
		return 0.0F;
	}

	public float dividir(float num1, float num2) {
		return 0.0F;
	}
	
	private float round(float d, int decimalPlace) {
		BigDecimal bd = new BigDecimal(Float.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
}
