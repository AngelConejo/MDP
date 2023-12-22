package es.unex.cum.mdp.sesion05;

public class FactoriaVehiculo {

	public Vehiculo buildVehiculo(int tipo, String m, String mo, Integer b, String infoDer) {
		//TODO
		if (tipo==1) {
			return new Coche(m, mo, null, b,3,infoDer);
		}
		else if (tipo==2) {
			return new Moto(m, mo, null, b,3,Integer.parseInt(infoDer));
		}
		else {
			return new Camion(m, mo, null, b,3,Integer.parseInt(infoDer));
		}
	}
	
}
