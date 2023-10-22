/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unex.cum.mdp.sesion04.circuito.herencia;

import java.text.DecimalFormat;

/**
 * Clase Paralelo que hereda de Circuito. Tiene un comportamiento equivalente a un Circuito paralelo en cuestión de cálculos de Resistencias, Intensidad y Voltaje.
 * @author luis
 */
class Paralelo extends Circuito {

    /**
     * Constructor por defecto de Paralelo. Llama al constructor por defecto de Circuito.
     */
    public Paralelo() {
        vector= new Resistencia[100];
        formateador = new DecimalFormat("####.###");
    }

    /**
     * Método de la clase encargado de pasar a cadena todos los valores de las Resistencias que componen el circuito Paralelo.
     * Va recorriendo la Lista heredada y concatenando los valores en una cadena.
     * @return Una cadena con todos los valores.
     */
    public String toString() {
        StringBuffer salida = new StringBuffer();
        int i = 0;
        salida.append(" /-------------------------------");
        while (i<cont) {
            i += 1;
            salida.append("\n| Resistencia " + i + ": ");
            Resistencia res=(Resistencia)vector[i];
            salida.append(res+ " Ohmios.");
            i++;
        }
        salida.append("\n--------------------------------");
        return salida.toString();
    }

    /**
     * Método de la clase encargado de calcular la resistencia total del Circuito Paralelo.
     * Va sumando las inversas de los valores de todas las resistencias y luego hace la inversa del valor obtenido.
     * @return El valor de la resistencia total del Circuito Paralelo.
     */
    public double CalcResTotal() {
        double total = 0;
        int i=0;
        while (i<cont) {
            Resistencia res=(Resistencia)vector[i];
            double divisor=res.get_valor();
            total =(double)(1/divisor) + total;
            i++;
        }
        total=1/total;
        return total;
    }


}
