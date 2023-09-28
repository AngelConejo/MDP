/**
 * Implementación de la clase Casa, constituida por un array de Personas denominadas Hab.
 */
package es.unex.cum.mdp.sesion02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Arevalo
 *
 */
public class Casa {
	private Persona[] hab;
	public Casa() {
		hab=new Persona [10];
		//TODO
		
	}
	public Casa(int tam) {
		hab=new Persona [tam];
	}
	public boolean add(Persona p)	{
		//TODO
		int i=0;
		while (hab[i]!=null && i<hab.length)
			{
			i++;
			}
		if(i==hab.length)
		{
		return false;
		}
		hab[i]p;
		return true;
		
	}
	public void mostrar() {
		for (int i=0;i<hab.length;i++) {
			if (hab[i]!=null) {
				System.out.println();
			}
		}
		//TODO
	}
	public boolean borrar(int pos) {
		
		return false;
	}
	public int contarPares() {
		//TODO
		return 0;
	}	
	public static void main(String[] args) {
		Casa m= new Casa(5);
		m.add(new Persona("Juan","10",10));
		m.add(new Persona("Ana","20",20));
		m.add(new Persona("Andres","30",30));
		m.mostrar();
		System.out.println("Procedo a borrar");
		m.borrar(1);
		m.mostrar();
		System.out.println(m.contarPares());
	}
}
