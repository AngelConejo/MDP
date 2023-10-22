package es.unex.cum.mdp.sesion05;

import java.util.Date;
import java.util.Objects;

public class Empleado extends Persona{

    private float sueldo;
    private Date fechaAlta;

    public Empleado() {

        this.sueldo = 0F;
        this.fechaAlta = new Date();

    }

    public Empleado(Persona p, float sueldo, Date fechaAlta) {

        super(p);
        this.sueldo = sueldo;
        this.fechaAlta = fechaAlta;

    }
    public Empleado(String nombre, String dni, int edad, float sueldo, Date fechaAlta) {

        super(nombre,dni,edad);
        this.sueldo = sueldo;
        this.fechaAlta = fechaAlta;

    }
    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Empleado [sueldo=" + sueldo + ", fechaAlta=" + fechaAlta + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaAlta, sueldo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        return Objects.equals(fechaAlta, other.fechaAlta)
                && Float.floatToIntBits(sueldo) == Float.floatToIntBits(other.sueldo);
    }

}