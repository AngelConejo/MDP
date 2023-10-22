/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unex.cum.mdp.sesion04.circuito.interfaces;

import java.text.DecimalFormat;

/**
 * Clase Serie que hereda de Circuito. Tiene un comportamiento equivalente a un Circuito serie en cuestión de cálculos de Resistencias, Intensidad y Voltaje.
 * @author luis
 */
public class Serie implements Circuito {
	
    protected Resistencia []vector;
    protected DecimalFormat formateador;   //Formateador para mostrar decimales
    protected int cont=0;;

	
	public boolean addResistencia(Resistencia r) {
    	if (cont<vector.length) {
    		vector[cont]=r;
    		cont++;
    		return true;
    	}
    	return false;
        
    }


     /**
     * Constructor por defecto de Serie. Llama al constructor por defecto de Circuito.
     */
    public Serie() {
        vector= new Resistencia[100];
        formateador = new DecimalFormat("####.###");
        
    }

     /**
     * Método de la clase encargado de pasar a cadena todos los valores de las Resistencias que componen el circuito Serie.
     * Va recorriendo la Lista heredada y concatenando los valores en una cadena.
     * @return Una cadena con todos los valores.
     */
    public String toString() {
        StringBuffer salida = new StringBuffer();
        int i = 0;
        
        salida.append(" /-------------------------------");
        while (i<cont) {            
            salida.append("\n| Resistencia " + i + ": ");
            Resistencia res=(Resistencia)vector[i];
            salida.append(res + " Ohmios.");
            i += 1;
        }
        salida.append("\n--------------------------------");
        return salida.toString();
    }

    /**
     * Método de la clase encargado de calcular la resistencia total del Circuito Serie.
     * Va sumando los valores de todas las resistencias.
     * @return El valor de la resistencia total del Circuito Serie.
     */
    public double CalcResTotal() {
        double total = 0;
        int i=0;
        while (i<cont) {
            Resistencia res=(Resistencia)vector[i];
            total = total + res.get_valor();
            i++;
        }
        return total;
    }

}
