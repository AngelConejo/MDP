
package es.unex.cum.mdp.sesion04.circuito.herencia;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Clase principal del programa. Tiene un atributo CircuitoMixto compuesto de una Lista de Circuitos y un voltaje. Los métodos del atributo
 * se encargarán de gestionar pa práctica.
 * @author luis
 */
public class Main {

    /**
     * Método principal del programa, será el primero en ejecutarse. Creamos un Main m y lo inicializamos. Luego llamamos a ejecutar de c.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
    	//Al ser herencia se podría hacer 
    	//Circuito c1= new Circuito();
    	
    	
    	Circuito c = new Serie();
        Random r= new Random(new Date().getTime());
        for (int i=0;i<10;i++) {
        	c.addResistencia(new Resistencia (r.nextInt(100)));
        }
        
        System.out.println("Resistencia total: "+c.toString());
        
        System.out.println(c.CalcResTotal());
        
    }
}
