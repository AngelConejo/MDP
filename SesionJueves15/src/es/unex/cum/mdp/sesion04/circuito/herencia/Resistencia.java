/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unex.cum.mdp.sesion04.circuito.herencia;

/**
 * Clase Resistencia, cuyos objetos sólo estarán compuesto de una atributo int con el valor de la Resistencia y unos métodos básicos para darle
 * un comportamiento.
 * @author luis
 */
class Resistencia {
    private int _valor;

    /**
     * Constructor por defecto de la clase, pone a 0 el valor del objeto.
     */
    public Resistencia() {
        _valor=0;
    }

    /**
     * Constructor parametrizado de la clase. Da a _valor el valor recibido.
     * @param valor
     */
    public Resistencia(int valor) {
        _valor=valor;
    }

    /**
     * Constructor copia de la clase. Copia el valor del objeto recibido.
     * @param r Objeto Resistencia recibido.
     */
    public Resistencia(Resistencia r) {
        _valor=r._valor;
    }

    /**
     * Método encargado de devolver el valor de _valor.
     * @return El valor de la resistencia (_valor).
     */
    public int get_valor() { return _valor; }

    /**
     * Método encargado de comparar dos objetos tipo Resistencia.
     * @param r Objeto con el que se comparará la Resistencia.
     * @return TRUE si son iguales,. FALSE si no.
     */
    public boolean equals(Resistencia r) { return (_valor==r._valor); }

    /**
     * Método encargado de pasar a cadena el valor del objeto. Se pasa el valor de _valor.
     * @return El valor de la Resistencia (_valor)
     */
    public String toString() {return (""+_valor) ;}
}
