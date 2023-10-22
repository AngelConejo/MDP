package es.unex.cum.mdp.sesion04.circuito.herencia;

import java.text.DecimalFormat; //Clase necesaria para formatear los decimales.

/**
 * Clase Circuito. 
 * @author luis
 */
public class Circuito {

    protected Resistencia []vector;
    protected DecimalFormat formateador;   //Formateador para mostrar decimales
    protected int cont=0;;


    /**
     * Constructor por defecto de la clase. Inicializa todos los atributos y entre ellos inicializamos el formato para números decimales
     * con 3 decimales como mucho.
     */
    public Circuito() {
        vector= new Resistencia[100];
        formateador = new DecimalFormat("####.###");
    }

    /**
     * Método que se encarga de insertar resistencias en la Lista, el valor de la resistencia se pide desde este método.
     * Insertamos por el final para que al recorrer la Lista de Resistencias las primera introducida sea la primera en recorrer.
     * @throws IOException Lanza una excepción si no se mete un dígito numérico.
     */
    public boolean addResistencia(Resistencia r) {
    	if (cont<vector.length) {
    		vector[cont]=r;
    		cont++;
    		return true;
    	}
    	return false;
        
    }

    /**
     * Método para calcular la resistencia total del Circuito. Será implementada en sus subclases.
     * @return Devuelve la ResistenciaTotal del circuito (double)
     */
    public double CalcResTotal() {
    	return 0;
    }

}
