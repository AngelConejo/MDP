// En ComparatorVehiculoPieza.java
import java.util.Comparator;

public class VehiculoComparatorNumPieza implements Comparator<Vehiculo> {
    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        return Integer.compare(v2.getPiezas().length, v1.getPiezas().length); 
    }
}