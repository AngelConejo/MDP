package es.unex.cum.mdp.sesion05;

import java.util.Objects;

public class Camion extends Vehiculo{

    private int tonelada;

    public Camion() {
        super();
    }

    public Camion(int tonelada) {
        super();
        this.tonelada = tonelada;
    }

    public Camion (String marca, String modelo, Persona propietario, int tam, int bastidor,int tonelada) {
        super(marca,modelo,propietario,bastidor,tam);
        this.tonelada = tonelada;
    }

    public int getTonelada() {
        return tonelada;
    }

    public void setTonelada(int tonelada) {
        this.tonelada = tonelada;
    }

    @Override
    public String toString() {
        return "Camion [tonelada=" + tonelada + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(tonelada);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Camion other = (Camion) obj;
        return tonelada == other.tonelada;
    }



}