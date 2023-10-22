package es.unex.cum.mdp.sesion05;

import java.util.Objects;

public class Moto extends Vehiculo{

    private int cilindrada;

    public Moto() {
        super();
    }

    public Moto(int cilindrada) {
        super();
        this.cilindrada = cilindrada;
    }

    public Moto (String marca, String modelo, Persona propietario, int tam, int bastidor,int cilindrada) {
        super(marca,modelo,propietario,tam,bastidor);
        this.cilindrada = cilindrada;
    }

    public int getcilindrada() {
        return cilindrada;
    }

    public void setcilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto [cilindrada=" + cilindrada + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(cilindrada);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Moto other = (Moto) obj;
        return cilindrada == other.cilindrada;
    }



}