package src.es.unex.cum.mdp.sesion03;

import java.util.Objects;

public class Pieza {
	String id,nombre;
	int stock;
	public Pieza()
	{
		this.id =null;
		this.nombre = null;
		this.stock = 0;
	}
	public Pieza(Pieza p) {
		id=p.getId();
		nombre=p.getNombre();
		stock=p.getStock();
	}

	public Pieza(String id, String nombre, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Pieza [id=" + id + ", nombre=" + nombre + ", stock=" + stock + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, stock);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pieza other = (Pieza) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre) && stock == other.stock;
	}
	
}
