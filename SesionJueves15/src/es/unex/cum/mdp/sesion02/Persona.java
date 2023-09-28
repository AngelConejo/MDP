/**
 * Implementacion de la clase Persona
 * 
 * @author Luis Arevalo
 *
 */

package es.unex.cum.mdp.sesion02;

/**
 * Clase que representa a una persona
 *
 */
public class Persona {
	private String nombre;
	private String dni;
	private int edad;

	 /**
	 *  Constructor por defecto
	 */
	public Persona() {
		nombre = new String();
		dni    = "";
		edad   = 0;
	}

	/**
	 * Constructor parametrizado
	 * @param nombre Nombre de la persona
	 * @param dni DNI de la persona
	 * @param edad Edad de la persona
	 */
	public Persona(String nombre, String dni, int edad) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}

	/**
	 *  Constructor de copia
	 *  
	 *  @param p Persona
	 */
	public Persona(Persona p) {
		nombre = p.nombre;
		dni    = p.dni;
		edad   = p.edad;
	}


	/**
	 * @return El nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre El nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return DNI de la persona
	 */
	public String getDni() {
		return dni;
	}


	/**
	 * @param dni DNI de la persona
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}


	/**
	 * @return Edad de la persona
	 */
	public int getEdad() {
		return edad;
	}


	/**
	 * @param edad Edad de la persona
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}


	/** 
	 * toString
	 */
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
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
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
