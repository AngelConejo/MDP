package es.unex.cum.mdp.sesion05;

import java.util.Objects;

public class Persona {
	private String nombre;
	private String dni;
	private int edad;
	
	public Persona (Persona p) {
		this.nombre=p.nombre;
		this.dni=p.dni;
		this.edad=p.edad;
	}
	public Persona(String nombre, String dni)
	{
		this.nombre=nombre;
		this.dni=dni;
		edad=0;
	}
	public Persona() {
		super();
	}
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad
				+ "]";
	}
	public Persona(String nombre, String dni, int edad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	public int hashCode() {
		return Objects.hash(dni, edad, nombre);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && edad == other.edad && Objects.equals(nombre, other.nombre);
	}
	
	
}
