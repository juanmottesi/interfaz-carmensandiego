package dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.commons.model.UserException;

public class VillanoTest {

	private Villano villano;
	
	@Before 
	public void setUp(){
		villano = new Villano();
	}
	
	@Test
    public void testAgregarSeniaParticular() {
		villano.agregarSeniaParticular("nueva");
		assertEquals("nueva", villano.getSeniasParticulares().get(0));
		assertEquals(1, villano.getSeniasParticulares().size());
	}

	@Test(expected=UserException.class)
    public void testAgregarSeniaParticularConLaMismaSeniaQueYaTenia() {
		villano.agregarSeniaParticular("nueva");
		villano.agregarSeniaParticular("nueva");
		assertEquals("nueva", villano.getSeniasParticulares().get(0));
		assertEquals(1, villano.getSeniasParticulares().size());
	}
	
    @Test
	public void testEliminarSeniaParticular() {
    	villano.agregarSeniaParticular("nueva");		
    	villano.eliminarSeniaParticular("nueva");
		assertEquals(0, villano.getSeniasParticulares().size());		
    }

	@Test
	public void testEliminarHobbie() {
    	villano.agregarHobbie("nueva");		
    	villano.eliminarHobbie("nueva");
		assertEquals(0, villano.getHobbies().size());	
	}

	@Test
	public void testAgregarHobbie() {
		villano.agregarHobbie("nueva");
		assertEquals("nueva", villano.getHobbies().get(0));
		assertEquals(1, villano.getHobbies().size());
	}
	
	@Test(expected= UserException.class)
	public void testAgregarHobbieConElMismoHobbieQueYaTenia() {
		villano.agregarHobbie("nueva");
		villano.agregarHobbie("nueva");
		assertEquals("nueva", villano.getHobbies().get(0));
		assertEquals(1, villano.getHobbies().size());
	}
	

    @Test
	public void testSeniasParticularLowerCase() {
    	villano.agregarSeniaParticular("NUEVA");
		assertEquals("nueva", villano.seniasParticularLowerCase().get(0));
    }

    @Test
	public void testHobbiesLowerCase() {
    	villano.agregarHobbie("NUEVA");
		assertEquals("nueva", villano.hobbiesLowerCase().get(0));
    }

}
