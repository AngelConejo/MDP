package es.unex.cum.mdp.sesion09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AhorcadoTest {
	private Ahorcado A;
	private Ahorcado Ap;
	@BeforeEach
	void setUp() throws Exception {
		A=new Ahorcado();
		Ap=new Ahorcado(3);
	}	

	@AfterEach
	void tearDown() throws Exception {
		A=null;
	}

	@Test
	void testAhorcado() {
		assertNotNull(A);
		assertNotNull(Ap);
	}

	@Test
	void testAddPalabra() {
		
		assertTrue(A.addPalabra("coche"));
		assertFalse(A.addPalabra("coche"));
		assertTrue(A.addPalabra("avion"));
	}

	@Test
	void testSeleccionarPalabra() {
		A.addPalabra("casa");
		A.addPalabra("Camion");
		A.addPalabra("Luna");
		try {
			assertTrue(A.seleccionarPalabra());
			
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	void testSeleccionarPalabraInt() {
		A.addPalabra("casa");
		A.addPalabra("Camion");
		A.addPalabra("Luna");
		try {
			A.seleccionarPalabra(-1);
			fail();
		} catch (Exception e) {
			//Aqui iria bien
		}
		try {
			assertTrue(A.seleccionarPalabra(40));
			fail();
		} catch (Exception e) {
			
		}
		try
		{
			A.seleccionarPalabra(1);
		}catch (Exception e) {
			fail();
		}
	}

	@Test
	void testDescubrirLetra() {
		A.addPalabra("casa");
		A.addPalabra("Camion");
		A.addPalabra("Luna");
		try {
		A.seleccionarPalabra(0);
		}catch(Exception e){
			fail();
		}
		assertTrue(A.descubrirLetra('a'));
		assertTrue(A.descubrirLetra('s'));
		assertFalse(A.descubrirLetra('x'));
	}

	@Test
	void testSiGanado() {
		A.addPalabra("casa");
		A.addPalabra("Camion");
		A.addPalabra("Luna");
		try {
		A.seleccionarPalabra(0);
		}catch(Exception e){
			
		}
		A.descubrirLetra('c');
		assertFalse(A.siGanado());
		A.descubrirLetra('a');
		assertFalse(A.siGanado());
		A.descubrirLetra('s');
		assertTrue(A.siGanado());
		A.descubrirLetra('a');
		assertTrue(A.siGanado());
	}

	@Test
	void testSiFin() {
		A.addPalabra("casa");
		A.addPalabra("Camion");
		A.addPalabra("Luna");
		try {
		A.seleccionarPalabra(0);
		}catch(Exception e){
			
		}
		A.descubrirLetra('x');
		assertFalse(A.siFin());
		A.descubrirLetra('z');
		assertFalse(A.siFin());
		A.descubrirLetra('k');
		assertFalse(A.siFin());
		A.descubrirLetra('ñ');
		assertFalse(A.siFin());
		A.descubrirLetra('ñ');
		assertTrue(A.siFin());
		
		Ap.addPalabra("casa");
		Ap.addPalabra("Camion");
		Ap.addPalabra("Luna");
		try {
		Ap.seleccionarPalabra(0);
		}catch(Exception e){
			
		}
		Ap.descubrirLetra('x');
		assertFalse(Ap.siFin());
		Ap.descubrirLetra('z');
		assertFalse(Ap.siFin());
		Ap.descubrirLetra('k');
		assertTrue(Ap.siFin());
	
		
	}

}
