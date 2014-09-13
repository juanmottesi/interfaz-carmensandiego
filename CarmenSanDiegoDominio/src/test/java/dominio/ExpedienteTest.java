package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.commons.model.UserException;


public class ExpedienteTest {

	private Expediente exp;
	private List<Villano> mockList;
	private Villano mockVillano;
	
	@SuppressWarnings("unchecked")
	@Before 
	public void setUp(){
		exp = Expediente.getInstance();
		mockList = mock(List.class);
		mockVillano = mock(Villano.class);
	}
	
	@Test
	public void testPuedoIniciar() {
		exp.setVillanos(mockList);
		when(mockList.size()).thenReturn(2);
		exp.puedoIniciar();
	}
	
	@Test(expected=UserException.class)
	public void testPuedoIniciarConException() {
		exp.setVillanos(mockList);
		when(mockList.size()).thenReturn(0);
		exp.puedoIniciar();
	}
	@Test
	public void testObtenerVillano() {
		exp.setVillanos(mockList);
		when(mockList.size()).thenReturn(1);
		when(mockList.get(0)).thenReturn(mockVillano);
		assertEquals(mockVillano, exp.obtenerVillano());	
	}
	
	@Test
	public void testAgregarVillano() {
		exp.setNuevoVillano(mockVillano);
		when(mockVillano.getSexo()).thenReturn(Sexo.Masculino);
		when(mockVillano.getNombre()).thenReturn("nombre");
		exp.agregarVillano();
		assertEquals(1, exp.getVillanos().size());
	}
	
	@Test(expected=UserException.class)
	public void testAgregarVillanoPrimerExeption() {
		exp.setNuevoVillano(mockVillano);
		when(mockVillano.getSexo()).thenReturn(Sexo.Masculino);
		when(mockVillano.getNombre()).thenReturn(null);
		exp.agregarVillano();
	}
	
	@Test(expected=UserException.class)
	public void testNoSePuedeAgregarVillanoSinNombre() {
		exp.setNuevoVillano(mockVillano);
		when(mockVillano.getSexo()).thenReturn(Sexo.Masculino);
		when(mockVillano.getNombre()).thenReturn("");
		exp.agregarVillano();
	}
	
	@Test(expected=UserException.class)
	public void testAgregarVillanoSegundaExeption() {
		exp.setNuevoVillano(mockVillano);
		exp.setVillanos(new ArrayList<Villano>());
		when(mockVillano.getSexo()).thenReturn(Sexo.Masculino);
		when(mockVillano.getNombre()).thenReturn("nombre");
		exp.agregarVillano();
		exp.setNuevoVillano(mockVillano);
		when(mockVillano.getSexo()).thenReturn(Sexo.Masculino);
		when(mockVillano.getNombre()).thenReturn("nombre");
		exp.agregarVillano();
	}
	
	@Test(expected=UserException.class)
	public void testAgregarVillanoTerceraExeptionFemenino() {
		exp.setNuevoVillano(mockVillano);
		when(mockVillano.getSexo()).thenReturn(Sexo.Femenino);
		when(mockVillano.getNombre()).thenReturn("");
		exp.agregarVillano();
		assertEquals(1, exp.getVillanos().size());
	}
	
	@Test
	public void testVillanosNombreLowerCase() {
		exp.setNuevoVillano(mockVillano);
		exp.setVillanos(new ArrayList<Villano>());
		when(mockVillano.getNombre()).thenReturn("NOMBRE");	
		when(mockVillano.getSexo()).thenReturn(Sexo.Femenino);
		exp.agregarVillano();

		assertEquals("nombre", exp.villanosNombreLowerCase().get(0));	
	}
	

	@Test
	public void testObtenerInputHobbie() {
		assertEquals("nuevoVillano.nuevoHobbie",exp.obtenerInputHobbie());
	}
	
	@Test
	public void testEliminarHobieSeleccionado() {
		exp.setNuevoVillano(mockVillano);
		exp.eliminarHobieSeleccionado();
		verify(mockVillano).eliminarHobieSeleccionado();

	}
	
	@Test
	public void testAgregarHobbie() {
		exp.setNuevoVillano(mockVillano);
		exp.agregarHobbie();
		verify(mockVillano).agregarHobbie();

	}
	
	@Test
	public void testListaHobbies() {
		assertEquals("nuevoVillano.hobbies", exp.listaHobbies());
	}
	
	@Test
	public void testHobbiesSeleccionado() {
		assertEquals("nuevoVillano.hobbieSeleccionado", exp.hobbiesSeleccionado());
	}
	
	
	
	@Test
	public void testAgregarSeniasParticulares() {
		exp.setNuevoVillano(mockVillano);
		exp.agregarSeniasParticulares();
		verify(mockVillano).agregarSeniasParticulares();
		
	}
	
	@Test
	public void testEliminarSeniasParticularesSeleccionado() {
		exp.setNuevoVillano(mockVillano);
		exp.eliminarSeniasParticularesSeleccionado();
		verify(mockVillano).eliminarSeniasParticularesSeleccionado();
		
	}
	
	@Test
	public void testObtenerInputSeniasParticulares() {
		assertEquals("nuevoVillano.nuevaSeniaParticular", exp.obtenerInputSeniasParticulares());
	}
	
	@Test
	public void testListaSeniasParticulares() {
		assertEquals("nuevoVillano.seniasParticulares" , exp.listaSeniasParticulares());
	}
	
	@Test
	public void testSeniasParticularesSeleccionada() {
		assertEquals("nuevoVillano.seniaParticularSeleccionada", exp.seniasParticularesSeleccionada());
	}
	
	@Test
	public void testActualizar(){
		exp.setNuevoVillano(mockVillano);
		List<Villano> lista = new ArrayList<Villano>();
		exp.setVillanos(lista);
		exp.actualizar();
		assertEquals(lista, exp.getVillanos());
	}
	
	@Test
	public void testSoyEditar(){
		assertFalse(exp.soyEditar());
	}

}
