package es.unex.cum.mdp.sesion09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Clase ahorcado usada para representar la lógica del juego Tiene un almacen de
 * palabras y para jugar primero debes seleccionar seleccionarPalabra() y luego
 * jugar
 * 
 * @author Luis Arévalo
 *
 */
public class Ahorcado {

	private List<String> lista;
	private boolean[] letras;
	private String seleccionada;
	private int INTENTOS_TOTALES = 7; // Constante con el limite de fallos
	private int intentos = 0;
	private int aciertos = 0;

	/**
	 * Constructor por defecto de Ahorcado
	 */
	public Ahorcado() {
		lista = new ArrayList<String>();
		seleccionada = "";
		intentos = 0;
		aciertos = 0;
		INTENTOS_TOTALES = 5;
	}

	/**
	 * Constructor parametrizado
	 * 
	 * @param max Máximo de intentos
	 */
	public Ahorcado(int max) {
		lista = new ArrayList<String>();
		seleccionada = "";
		intentos = 0;
		aciertos = 0;
		INTENTOS_TOTALES = max;
	}

	/**
	 * Método usado para añadir una palabra al banco de palabras
	 * @param p String con la nueva palabra a añadir
	 * @return Verdadero o falso en el caso que se haya añadido o no.
	 */
	public boolean addPalabra(String p) {
		for (int i = 0; i < lista.size(); i++)
			if (lista.get(i).equals(p))
				return false;
		return lista.add(p);
	}

	/**
	 * Método encargado de seleccionar una palabra del almacen de forma aleatoría
	 * @return Verdadero si se ha podido seleccionar una palabra
	 * @throws Exception En el caso que no se haya podido seleccionar una palabra
	 */
	public boolean seleccionarPalabra() throws Exception {
		Random rnd = new Random();
		if(lista.size()==0)
			throw new Exception("No hay datos");
		int valor = rnd.nextInt(lista.size());
		return seleccionarPalabra(valor);
	}

	/**
	 * Método encargado de seleccionar una palabra del almacen
	 * @param pos Posición de la palabra a seleccionar
	 * @return Verdadero si se ha podido seleccionar una palabra
	 * @throws Exception En el caso que no se haya podido seleccionar una palabra
	 */
	
	public boolean seleccionarPalabra(int pos) throws Exception {
		if (pos < 0 || pos >= lista.size())
			throw new Exception("Posición no válida");
		else {

			seleccionada = lista.get(pos);
			letras = new boolean[seleccionada.length()];
			return true;
		}

	}

	/**
	 * Método encargado de descubrir una letraq
	 * @param letra Carácter recibido para ser buscado en la palabra
	 * @return Indica si el carácter se encuentra o no en la palabra
	 */
	public boolean descubrirLetra(char letra) {

		boolean encontrado = false;
		for (int i = 0; i < seleccionada.length(); i++) {
			if (seleccionada.charAt(i) == letra) {
				encontrado = true;
				letras[i] = true;
			}
		}
		if (!encontrado)
			this.intentos = intentos + 1;
		return encontrado;
	}
	
	/**
	 * Determina si se ha ganado la partida o no
	 * @return Boolean indicando si ha ganado
	 */

	public boolean siGanado() {

		boolean fin = true;
		for (int i = 0; i < letras.length; i++) {
			if (letras[i] == false) {
				fin = false;
			}
		}
		if (fin == false)
			return false;
		else
			return true;
	}

	/**
	 * Determina si ha perdido
	 * @return Booleano indicando si ha perdido
	 */
	public boolean siFin() {

		if (intentos == this.INTENTOS_TOTALES)
			return true;
		else
			return false;
	}

}
