package es.unex.cum.mdp.sesion05;

import java.util.Objects;

public class Coche extends Vehiculo{

    private String color;

    public Coche() {
        super();
    }

    public Coche(String color) {
        super();
        this.color = color;
    }

    public Coche (String marca, String modelo, Persona propietario, int tam, int bastidor,String color) {
        super(marca,modelo,propietario,bastidor,tam);
        this.color = color;
    }
    public Coche (int tam) {
        super(tam);
    }

    public String getcolor() {
        return color;
    }

    public void setcolor(int color) {
        this.color = "color";
    }

    @Override
    public String toString() {
        return "Coche [color=" + color + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coche other = (Coche) obj;
        return color == other.color;
    }



}