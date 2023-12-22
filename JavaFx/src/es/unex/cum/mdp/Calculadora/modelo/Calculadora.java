package es.unex.cum.mdp.Calculadora.modelo;

import java.math.BigDecimal;

/**
 * La clase ej7Calculadora es una clase donde se tendra el modelo
 * de la calculadora (logica)
 * 
 *
 */
public class Calculadora {
	private float primerOperando;
	private float segundoOperando;
	
	public Calculadora() {
	}
	
	public Calculadora(float primerOperando, float segundoOperando) {
	}

	public float getPrimerOperando() {
		return primerOperando;
	}

	public void setPrimerOperando(float primerOperando) {
	this.primerOperando=primerOperando;
	}

	public float getSegundoOperando() {
		return segundoOperando;
	}

	public void setSegundoOperando(float segundoOperando) {
	this.segundoOperando=segundoOperando;
	}
	
	public float sumar(float num1, float num2) {
		return num1+num2;
	}

	public float restar(float num1, float num2) {
		return num1-num2;
	}

	public float multiplicar(float num1, float num2) {
		return num1*num2;
	}

	public float dividir(float num1, float num2) {
		return num1/num2;
	}
	
	private float round(float d, int decimalPlace) {
		BigDecimal bd = new BigDecimal(Float.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
}
