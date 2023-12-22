package es.unex.cum.mdp.sesion09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	private Calculator c;
	@BeforeEach
	void setUp() throws Exception {
		c=new Calculator();
	}
		
	@AfterEach
	void tearDown() throws Exception {
		c=null;
	}

	@Test
	void testAdd() {
		assertTrue(c.add(4, 2)==6);
		assertEquals(c.add(4,2),6);
	}
	@Test
	void testSubtract() {
		assertTrue(c.subtract(2, 2)==0);
	}

	@Test
	void testMultiply() {
		assertTrue(c.multiply(4, 4)==16);
	}

	@Test
	void testDivide() {
		try {
			assertTrue(c.divide(10, 0)==1234);
			fail();
		} catch (Exception e) {
			
		}
		try {
			assertTrue(c.divide(10, 2)==5);
		} catch (Exception e) {
			fail();
		}
	}

}
