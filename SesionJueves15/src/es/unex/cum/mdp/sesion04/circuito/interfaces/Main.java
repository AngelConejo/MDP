
package es.unex.cum.mdp.sesion04.circuito.interfaces;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Clase principal del programa. 
 * @author luis
 */
public class Main {

    /**
     * Método principal del programa, será el primero en ejecutarse. Creamos un Main m y lo inicializamos. Luego llamamos a ejecutar de c.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    	
    	//Al ser abstracto no se puede instanciar
    	
    	//Circuito c1= new Circuito();
    	
        Serie c = new Serie();
        Random r= new Random(new Date().getTime());
        for (int i=0;i<10;i++) {
        	c.addResistencia(new Resistencia (r.nextInt(100)));
        }
        
        System.out.println(c.toString());
        
        System.out.println(c.CalcResTotal());
  
    }
}
