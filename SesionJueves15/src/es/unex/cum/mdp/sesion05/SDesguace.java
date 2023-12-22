package es.unex.cum.mdp.sesion05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class SDesguace {

	private String nombre;
	private ArrayList<Vehiculo> vehiculos;
	private TreeSet<Pieza> piezas;
	private HashMap<String,Empleado> empleados;
	private static SDesguace sg=null;
	public static SDesguace getInstance(){
		if(sg==null) sg=new SDesguace();
		return sg;
	}
	
	public SDesguace(String nombre, int numero) {
	
		super();
		this.nombre = nombre;
		vehiculos=new ArrayList<Vehiculo>(numero);
		piezas= new TreeSet<Pieza>();
		empleados= new HashMap<String,Empleado>();
	}
	private SDesguace() {
		nombre = "";
		vehiculos = new ArrayList<Vehiculo>();
		piezas = new TreeSet<Pieza>();
		empleados= new HashMap<String,Empleado>();
	}

	private SDesguace(String nombre, ArrayList<Vehiculo> vehiculos) {
		super();
		this.nombre = nombre;
		this.vehiculos = vehiculos;
		piezas= new TreeSet<Pieza>();
		empleados= new HashMap<String,Empleado>();
	}
	private SDesguace(String nombre, ArrayList<Vehiculo> vehiculos,TreeSet<Pieza>piezas) {
		super();
		this.nombre = nombre;
		this.vehiculos = vehiculos;
		this.piezas= piezas;
		empleados= new HashMap<String,Empleado>();
	}
	private SDesguace(String nombre, TreeSet<Pieza>piezas) {
		super();
		this.nombre = nombre;
		vehiculos=new ArrayList<Vehiculo>();
		piezas= new TreeSet<Pieza>();
		empleados= new HashMap<String,Empleado>();
	}

	private SDesguace(String nombre) {
		super();
		this.nombre = nombre;
		this.vehiculos = new ArrayList<Vehiculo>();
		piezas=new TreeSet<Pieza>();
		empleados= new HashMap<String,Empleado>();
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, vehiculos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SDesguace other = (SDesguace) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(vehiculos, other.vehiculos);
	}

	@Override
	public String toString() {
		return "Desguace [nombre=" + nombre + "]";
	}

	public boolean addVehiculo(Vehiculo v) {

		Iterator<Vehiculo> it = vehiculos.iterator();
		while (it.hasNext()) {
			if (it.next().equals(v)) {
				return false;
			}

		}
		vehiculos.add(v);
		return true;

	}

	public Vehiculo getVehiculoBastidor(Integer bastidor) {
		Iterator<Vehiculo> it = vehiculos.iterator();
		while (it.hasNext()) {
			Vehiculo aux = it.next();
			if (aux.getBastidor().equals(bastidor)) {
				return aux;
			}
		}

		return null;

	}

	public boolean addPiezaVehiculo(Pieza p, Integer bastidor) {
        if(p==null || bastidor==null) return false;
		
		Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo aux = it.next();
            if (aux.getBastidor().equals(bastidor)) {
                for (int i = 0; i < aux.getPiezas().length; i++) {
                    if (aux.getPiezas(i).getId().equals(p.getId())) {
                        Pieza pieza = aux.getPiezas(i);
                        pieza.setStock(pieza.getStock() + 1);
                        aux.setPieza(pieza, i);
                        return true;
                    }
                }
                return aux.addPiezaV(p);
            }
        }
        return false;
    }


	Pieza getPiezaVehiculo(String id, Integer bastidor) {

		Iterator<Vehiculo> it = vehiculos.iterator();
		while (it.hasNext()) {
			Vehiculo aux = it.next();

			if (aux.getBastidor().equals(bastidor)) {

				for (int i = 0; i < aux.getPiezas().length; i++) {

					if (aux.getPiezasV()[i].getId().equals(id)) {

						return aux.getPiezas()[i];

					}

				}
			}


		}
		return null;

	}


	public boolean addPiezaVehiculo(String id, Integer bastidor) {
	   
	    if (id == null || bastidor == null) return false;

	    Iterator<Pieza> it = piezas.iterator();
	    while(it.hasNext()) {
	        Pieza aux = it.next();
	        if (aux.getId().equals(id)) {
	            Vehiculo vehiculo = getVehiculoBastidor(bastidor);
	            
	            
	            if (vehiculo != null && vehiculo.addPiezaV(aux)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
	public boolean addPiezaAlmacen(Pieza p)
	{
		return piezas.add(p);
	}
	public Pieza getPiezaAlmacen(String id)
	{
		Iterator<Pieza> it = piezas.iterator();
		
			while (it.hasNext())
			{
				Pieza pieza=it.next();
				if(pieza.getId().equals(id))
				{
					return pieza;
			}
		}
			return null;
	}
	public boolean addEmpleado(Empleado e)
	{
		if (empleados.containsKey(e.getDni()))
		{
			return false;
		}
		empleados.put(e.getDni(),e);
		return true;
	}
	public Empleado getEmpleado(String dni)
	{
		return empleados.get(dni);
	}
	public float getMediaSueldo()
	{
		if (empleados.isEmpty())
		{
			return 0.0f;
		}
		float suma=0.0f;
		Iterator <Empleado> it = empleados.values().iterator();
		while (it.hasNext())
		{
			Empleado empleado=it.next();
			suma+=empleado.getSueldo();
		}
		return suma/empleados.size();
	}
	public Vehiculo mayorStock() {
	    if (vehiculos.isEmpty()) {
	        return null;
	    }

	    Collections.sort(vehiculos, new Comparator<Vehiculo>() {
	        public int compare(Vehiculo v1, Vehiculo v2) {
	            int stockv1 = 0;
	            Pieza[] piezasv1 = v1.getPiezas();
	            for (int i = 0; i < piezasv1.length; i++) {
	                stockv1 += piezasv1[i].getStock();
	            }
	            
	            int stockv2 = 0;
	            Pieza[] piezasv2 = v2.getPiezas();
	            for (int i = 0; i < piezasv2.length; i++) {
	                stockv2 += piezasv2[i].getStock();
	            }
	            
	            return Integer.compare(stockv2, stockv1);  // Notar que hemos invertido v2 y v1 aquí
	        }
	    });

	    return vehiculos.get(0);  // Ahora, el vehículo con el mayor stock estará al principio de la lista.
	}
	public class ComparatorVehiculoPieza implements Comparator<Vehiculo> {
	    public int compare(Vehiculo v1, Vehiculo v2) {
	        return Integer.compare(v2.getPiezas().length, v1.getPiezas().length); 
	    }
	}
	public Vehiculo mayorPieza() {
	    Vehiculo vehiculoConMasTipos = null;
	    int maxTipos = 0;

	    for (Vehiculo vehiculo : vehiculos) {
	        Pieza[] piezasDelVehiculo = vehiculo.getPiezas();
	        
	        // Usamos una lista para almacenar los IDs únicos de las piezas.
	        List<String> idsUnicos = new ArrayList<>();

	        for (Pieza pieza : piezasDelVehiculo) {
	            if (!idsUnicos.contains(pieza.getId())) {
	                idsUnicos.add(pieza.getId());
	            }
	        }

	        if (idsUnicos.size() > maxTipos) {
	            maxTipos = idsUnicos.size();
	            vehiculoConMasTipos = vehiculo;
	        }
	    }

	    return vehiculoConMasTipos;
	}
	public class PiezaComparator implements Comparator<Pieza> {
        @Override
        public int compare(Pieza p1, Pieza p2) {
            return p1.getId().compareTo(p2.getId());
        }
    }
	
	
	
}