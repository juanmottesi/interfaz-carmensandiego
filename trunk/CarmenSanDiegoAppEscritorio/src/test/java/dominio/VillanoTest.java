package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.commons.model.UserException;
//import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

import ui.NuevoVillanoWindow;

public class VillanoTest {

	private Villano villano;
	
	@Before 
	public void setUp(){
		villano = new Villano("Nombre", new ArrayList<String>(), new ArrayList<String>() , "Masculino");
	}
	
	@Test
	public void testConstructor() {
		assertEquals("Nombre",villano.getNombre());
		assertEquals(0,villano.getHobbies().size());
		assertEquals(0,villano.getSeniasParticulares().size());
		assertEquals("Masculino",villano.getSexo());
	}

	
	@Test
	public void obtenerInputHobbie() {
		assertEquals("nuevoHobbie", villano.obtenerInputHobbie());
	}
		
	@Test
	public void testEliminarHobieSeleccionado() {
		villano.setNuevoHobbie("nuevo");
		villano.agregarHobbie();
		villano.setHobbieSeleccionado("nuevo");
		villano.eliminarHobieSeleccionado();
		assertEquals(0, villano.getHobbies().size());
		assertNull(villano.getHobbieSeleccionado());
	}
	
	@Test
	public void testAgregarHobbie() {
		villano.setNuevoHobbie("nuevo");
		villano.agregarHobbie();
		assertEquals(1, villano.getHobbies().size());
		assertNull(villano.getNuevoHobbie());
	}
	
	@Test(expected=UserException.class)
	public void testAgregarHobbieYaExistente() {
		villano.setNuevoHobbie("nuevo");
		villano.agregarHobbie();
		assertEquals(1, villano.getHobbies().size());
		assertNull(villano.getNuevoHobbie());
		villano.setNuevoHobbie("nuevo");
		villano.agregarHobbie();
	}
	
	
	@Test
	public void testListaHobbies() {
		assertEquals("hobbies", villano.listaHobbies());

	}
	
	@Test
	public void testHobbiesSeleccionado() {
		assertEquals("hobbieSeleccionado", villano.hobbiesSeleccionado());
	
	}
		
	@Test
	public void testAgregarSeniasParticulares() {
		villano.setNuevaSeniaParticular("nuevo");
		villano.agregarSeniasParticulares();
		assertEquals(1, villano.getSeniasParticulares().size());
	}
	
	@Test(expected=UserException.class)
	public void testAgregarSeniasParticularesYaExistente() {
		villano.setNuevaSeniaParticular("nuevo");
		villano.agregarSeniasParticulares();
		assertEquals(1, villano.getSeniasParticulares().size());
		villano.setNuevaSeniaParticular("nuevo");
		villano.agregarSeniasParticulares();
	}
	
	@Test
	public void testEliminarSeniasParticularesSeleccionado() {
		villano.setNuevaSeniaParticular("nuevo");
		villano.agregarSeniasParticulares();
		villano.setSeniaParticularSeleccionada("nuevo");
		villano.eliminarSeniasParticularesSeleccionado();
		assertEquals(0, villano.getSeniasParticulares().size());
	}
	
	@Test
	public void testObtenerInputSeniasParticulares() {
		assertEquals("nuevaSeniaParticular", villano.obtenerInputSeniasParticulares());
	}
	
	@Test
	public void testListaSeniasParticulares() {
		assertEquals("seniasParticulares", villano.listaSeniasParticulares());
	
	}
	
	@Test
	public void testSeniasParticularesSeleccionada() {
		assertEquals("seniaParticularSeleccionada", villano.seniasParticularesSeleccionada());
	
	}
	
	@Test
	public void testHobiesLowerCase() {
		villano.setNuevoHobbie("NUEVO");
		villano.agregarHobbie();
		assertEquals("nuevo", villano.hobbiesLowerCase().get(0));		
	}
	
	@Test
	public void testSeniasParticularesLowerCase() {
		villano.setNuevaSeniaParticular("NUEVO");
		villano.agregarSeniasParticulares();
		assertEquals("nuevo", villano.seniasParticularesLowerCase().get(0));
	}
	
	@Test
	public void testAgregarNombreYSexo(){
		NuevoVillanoWindow mockWindow = mock(NuevoVillanoWindow.class);
		Panel mockPanel = mock(Panel.class);
		villano.agregarNombreYSexo(mockPanel, mockWindow);
		verify(mockWindow).agregarPanel(mockPanel, "Nombre: ", "nombre");
		verify(mockWindow).agregarPanel(mockPanel, "Sexo: ", "sexo");		
	}
	
//	@Test
//	public void testAgregarBotonAceptar(){
//		final NuevoVillanoWindow mockWindow = mock(NuevoVillanoWindow.class);
//		Panel mockPanel = mock(Panel.class);
//		 final Procedure0 function = new Procedure0() {
//		      public void apply() {
//		    	  mockWindow.close();
//		      }
//		 };
//		villano.agregarBotonAceptar(mockPanel, mockWindow);
//		verify(mockWindow).agregarBoton(mockPanel, "Aceptar",function);
//	}
}
