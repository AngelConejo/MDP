package es.unex.cum.mdp.sesion09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaTest {
	private Persona p;
	@BeforeEach
	void setUp() throws Exception {
		p=new Persona("Angel", new Date("2020/11/23"));
	}

	@AfterEach
	void tearDown() throws Exception {
		p=null;
	}

	@Test
	void testCalcularEdad() {
		//Fecha normal
		
		try {
			p.calcularEdad(new Date("2020/11/22"));
			fail();
		} catch (ExceptionNacimiento e) {
			//Aqui iria bien
		}
		try {
			assertEquals(p.calcularEdad(new Date("2021/11/22")),0);
			assertEquals(p.calcularEdad(new Date("2021/11/23")),1);
			assertEquals(p.calcularEdad(new Date("2024/08/08")),3);
			
		} catch (ExceptionNacimiento e) {
			fail();
		}
		
	}

}
