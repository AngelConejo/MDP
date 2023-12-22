package es.unex.cum.mdp.sesion04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDesguace {
	// Tamaño de piezas de vehiculo 5
	private Desguace d;
	private Vehiculo v1, v2, v3;
	private Persona p;

	@Before
	public void setUp() {
		// test vehiculo
		p = new Persona("Luis", "4", 4);

		d = new Desguace("Hermanos Taller");
		Persona p1 = new Persona("Luis", "4", 4);
		v1 = new Coche("Scania", "Majestuoso", p1, 123, 3, "Rojo");
		Persona p2 = new Persona("Juan", "5", 4);
		v2 = new Moto("Yamaha", "1000h", p2, 1234, 3, 1000);
		Persona p3 = new Persona("Ana", "6", 4);
		v3 = new Camion("Man", "Max", p3, 321, 3, 24);
	}

	@After
	public void tearDown() {
		d = null;
		v1 = null;
		v2 = null;
		v3 = null;
		p = null;
	}

	/******
	 * Test Desguace
	 */

	@Test
	public void testDesguace() {
		assertNotNull(d);
	}

	@Test
	public void testGetInfoDerivada() {
		assertNull(d.getInfoDerivada(0));
		d.addVehiculo(v1);
		d.addVehiculo(v2);
		d.addVehiculo(v3);
		assertEquals(d.getInfoDerivada(0), "Rojo");
		assertEquals(d.getInfoDerivada(1), "1000");
		assertEquals(d.getInfoDerivada(2), "24");
		assertNull(d.getInfoDerivada(3));
		assertNull(d.getInfoDerivada(-1));
	}
}
