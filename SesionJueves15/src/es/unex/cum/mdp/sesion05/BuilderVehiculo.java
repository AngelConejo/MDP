package es.unex.cum.mdp.sesion05;

public class BuilderVehiculo {
	private Vehiculo v;

	public BuilderVehiculo(int tipo, int tam) {
		if (tipo == 0)
			v = new Coche(tam);
		else if (tipo == 1)
			v = new Moto(tam);
		else
			v = new Camion(tam);
	}

	public BuilderVehiculo withMarca(final String m) {
		this.v.setMarca(m);
		return this;
	}

	public BuilderVehiculo withModelo(final String m) {
		this.v.setModelo(m);
		return this;
	}

	public BuilderVehiculo withPropietario(final Persona p) {
		this.v.setPropietario(p);
		return this;
	}

	public BuilderVehiculo withBastidor(final Integer b) {
		this.v.setBastidor(b);
		return this;
	}

	public BuilderVehiculo withDerivada(final String s) {
		if (v.getClass().equals(Coche.class)) {
			((Coche) v).setColor(s);
		} else if (v.getClass().equals(Moto.class)) {
			((Moto) v).setPotencia(Integer.parseInt(s));
		} else {
			((Camion) v).setTonelaje(Integer.parseInt(s));
		}
		return this;
	}

	public Vehiculo build() {
		return v;
	}	
}
