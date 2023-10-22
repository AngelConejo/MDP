
package es.unex.cum.mdp.sesion04.circuito.interfaces;

import java.text.DecimalFormat; //Clase necesaria para formatear los decimales.

/**
 * Interface Circuito. Compuesta de una Lista de resistencias y los atributos necesarios para la entrada/salida y formateo de datos
 * para la jerarquía que forma.
 * @author luis
 */
public interface Circuito {
	
	//Este método es igual para serie y paralelo para, al ser interfaces, se debe hacer en las dos clases. 
	public boolean addResistencia(Resistencia r);
	
    public double CalcResTotal();
   
}
