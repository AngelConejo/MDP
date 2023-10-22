package es.unex.cum.mdp.sesion05;


import java.util.Objects;

public class Vehiculo {
	String marca,modelo;
	Persona propietario;
	int cont;
	Integer bastidor;
	Pieza[] Piezas;

	public Vehiculo(String marca, String modelo, Persona propietario, int cont, Integer bastidor,int tamanoarray) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.propietario = propietario;
		this.cont = cont;
		this.bastidor = bastidor;
		Piezas= new Pieza[tamanoarray];
		for(int i = 0; i < Piezas.length; i++) {
            Piezas[i] = new Pieza();
        }
	}
	public Vehiculo(String marca, String modelo, Persona p, int bastidor,int arrayt) {
		this.marca=marca;
		this.modelo=modelo;
		propietario=p;
		cont=0;
		this.bastidor=bastidor;
		Piezas=new Pieza[arrayt];
		 for(int i = 0; i < Piezas.length; i++) {
	            Piezas[i] = new Pieza();
	        }
	}
	public Vehiculo(int x) {
		marca="";
		modelo="";
		propietario=new Persona();
		cont=0;
		bastidor=0;
		Piezas=new Pieza[x];
		 for(int i = 0; i < Piezas.length; i++) {
	            Piezas[i] = new Pieza();
	        }
	}
		 
	public Vehiculo() {
		marca="";
		modelo="";
		propietario=new Persona();
		cont=0;
		bastidor=0;
		Piezas=new Pieza[3];
		 for(int i = 0; i < Piezas.length; i++) {
	            Piezas[i] = new Pieza();
	        }
	}
	public Vehiculo(String marca, String modelo, Persona p) {
		this.marca=marca;
		this.modelo=modelo;
		this.propietario=p;
		cont=0;
		bastidor=0;
		Piezas=new Pieza[3];
		for(int i = 0; i < Piezas.length; i++) {
            Piezas[i] = new Pieza();
        }
		
		
	}
	public Vehiculo(String marca, String modelo, Persona p,int cont) {
		this.marca=marca;
		this.modelo=modelo;
		this.propietario=p;
		this.cont=cont;
		bastidor=0;
		Piezas=new Pieza[3];
		for(int i = 0; i < Piezas.length; i++) {
            Piezas[i] = new Pieza();
        }
	}
		
	public Vehiculo(Vehiculo v) {
		marca=v.getMarca();
		modelo=v.getModelo();
		propietario=v.getPropietario();
		cont=v.getCont();
		bastidor=v.getBastidor();
		Piezas=new Pieza[3];
		for (int i=0;i<Piezas.length;i++) {
			Piezas[i]=v.getPiezasV(i);
		}
				
		
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Persona getPropietario() {
		return propietario;
	}
	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	public Integer getBastidor() {
		return bastidor;
	}
	public void setBastidor(Integer bastidor) {
		this.bastidor = bastidor;
	}
	public Pieza[] getPiezas() {
		return Piezas;
	}
	public Pieza[] getPiezasV() {
		return Piezas;
	}
	public Pieza getPiezas(int i) {
		return Piezas[i];
	}
	public Pieza getPiezasV(int i) {
		return Piezas[i];
	}
	public void setPiezasV(Pieza[] Piezas) {
		this.Piezas = Piezas;
	}
	public boolean addPiezaV(Pieza p) {
	    for (int i = 0; i < Piezas.length; i++) {
	        if (Piezas[i] != null && Piezas[i].getId().equals(p.getId())) {
	            Piezas[i].setStock(Piezas[i].getStock() + 1);
	            return true;
	        }
	    }

	    // Si la pieza no está en el array, encontrar un espacio vacío o ampliar el array si es necesario
	    for (int i = 0; i < Piezas.length; i++) {
	        if (Piezas[i] == null) {
	            Piezas[i] = p;
	            return true;
	        }
	    }

	    // Si el array está lleno, crear un nuevo array más grande
	    Pieza[] nuevoArray = new Pieza[Piezas.length + 1];
	    System.arraycopy(Piezas, 0, nuevoArray, 0, Piezas.length);
	    nuevoArray[Piezas.length] = p;
	    Piezas = nuevoArray;
	    return true;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bastidor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(bastidor, other.bastidor);
	}
	public Pieza getPiezaV(int i) {
		if (i >= 0 && i < Piezas.length)
		{
			return Piezas[i];
		}
		else {
			return null;
		}
		
	}
	public boolean setPieza(Pieza p, int x){
		
		if(x<0 || x>Piezas.length)
		{
			return false;
		}
		else
		{
			Piezas[x]=p;
		}
		
		return false;
	}
	
}
