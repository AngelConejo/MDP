package es.unex.cum.mdp.sesion09;

import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String []args) throws IOException{
	    Teclado t= new Teclado();
	    int maximo=t.literalConEntero("Dime el máximo de intentos");
		Ahorcado a= new Ahorcado(maximo);	
		a.addPalabra(new String("luna"));
		a.addPalabra(new String("casa"));
		a.addPalabra(new String("bicicleta"));
	
		
		try {
			a.seleccionarPalabra(1);
		} catch (Exception e) {
			return; 
		}
		while (!(a.siFin()) && !(a.siGanado())){
			char letra=t.literalConCaracter("Introduce una letra: ");
			if (a.descubrirLetra(letra)){
				System.out.println("Has acertado");
			} else {
				System.out.println("NO Has acertado");
			}
		}
		if (a.siGanado())
			System.out.println("HAS GANADO");
		else 
		    System.out.println("Otra vez sera");
	}
}
