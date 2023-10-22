package es.unex.cum.mdp.sesion03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Desguace {

    private String nombre;
    private ArrayList<Vehiculo> vehiculos;

    public Desguace() {
        nombre = "";
        vehiculos = new ArrayList<Vehiculo>();
    }

    public Desguace(String nombre, ArrayList<Vehiculo> vehiculos) {
        super();
        this.nombre = nombre;
        this.vehiculos = vehiculos;
    }

    public Desguace(String nombre) {
        super();
        this.nombre = nombre;
        this.vehiculos = new ArrayList<Vehiculo>();
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
        Desguace other = (Desguace) obj;
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


        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo aux = it.next();

            if (aux.getBastidor().equals(bastidor)) {

                for (int i = 0; i < aux.getPiezas().length; i++) {

                    if (aux.getPiezas(i).getId().equals(p.getId())) {
                        
                        Pieza pieza = aux.getPiezas(i);
                        pieza.setStock(pieza.getStock()+1);
                        aux.setPieza(pieza, i);
                        return true; 

                    }
    
                }

               
                return  aux.addPiezaV(p); 

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
} 
