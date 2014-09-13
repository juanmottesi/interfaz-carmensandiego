package dominio.auxiliar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RandomTest {

	private Random random;
	@Before
	public void setUp(){
		random = new Random();
	}
		
	@SuppressWarnings("static-access")
	@Test
	public void testObtenerRandomCorrecto() {
		int n = random.obtenerRandom(0, 2);
		assertTrue(n>=0 && n<=2);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testObtenerRandomIncorrecto() {
		int n = random.obtenerRandom(4, 2);
		assertEquals(4, n);
	}

}
