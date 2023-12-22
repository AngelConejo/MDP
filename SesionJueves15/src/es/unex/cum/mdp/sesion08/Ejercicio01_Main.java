package es.unex.cum.mdp.sesion08;

public class Ejercicio01_Main {
	public static void main(String[]args) {
		Ejercicio01_Main e=new Ejercicio01_Main();
		e.ejecutar();
	}
	
	public void ejecutar() {
		Ejercicio01_Calc c= new Ejercicio01_Calc();
		System.out.println("Antes del try");
		c.divide(10, 0);
		System.out.println("Después de dividir");
		System.out.println("En el catch");
		System.out.println("En el finally");
		
	}
}
