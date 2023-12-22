package es.unex.cum.mdp.sesion09;

import java.util.Date;

public class Persona {
	private String nombre;
	private Date fechaNac;

	public Persona() {
		super();
		nombre = "";
		fechaNac = new Date();
	}

	/**
	 * Constructor parametrizado
	 * @param nombre
	 * @param fechaNac
	 */
	public Persona(String nombre, Date fechaNac) {
		super();
		this.nombre = nombre;
		this.fechaNac = fechaNac;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public String toString() {
		return "Prueba [nombre=" + nombre + ", fechaNac=" + fechaNac + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (fechaNac == null) {
			if (other.fechaNac != null)
				return false;
		} else if (!fechaNac.equals(other.fechaNac))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public long calcularEdad(Date f2) throws ExceptionNacimiento {
		// Caso que la fecha dada es menor
		if (fechaNac.compareTo(f2) >= 0)
			throw new ExceptionNacimiento();
			
		long difference_In_Time = f2.getTime() - fechaNac.getTime();
		long difference_In_Seconds = (difference_In_Time / 1000) % 60;

		long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;

		long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

		long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));

		long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

		System.out.print("Difference " + "between two dates is: ");

		System.out.println(difference_In_Years + " years, " + difference_In_Days + " days, " + difference_In_Hours
				+ " hours, " + difference_In_Minutes + " minutes, " + difference_In_Seconds + " seconds");
		return difference_In_Years;
	}

}
