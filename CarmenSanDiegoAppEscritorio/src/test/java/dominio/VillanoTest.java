package dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class VillanoTest {

	private Villano villano;
	
	@Before 
	public void setUp(){
		villano = new Villano("Nombre", new ArrayList<String>(), new ArrayList<Hobbie>() , "Masculino");
	}
	
	@Test
	public void testConstructor() {
		assertEquals("Nombre",villano.getNombre());
		assertEquals(0,villano.getHobbies().size());
		assertEquals(0,villano.getSeniasParticulares().size());
		assertEquals("Masculino",villano.getSexo());
	}

}
