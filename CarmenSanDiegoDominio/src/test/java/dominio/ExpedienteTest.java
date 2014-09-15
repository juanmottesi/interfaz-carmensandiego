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
	public void testPuedoIniciarSinVillanos() {
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
		exp.setVillanos(new ArrayList<Villano>());
		exp.agregarVillano(mockVillano);
		assertEquals(1, exp.getVillanos().size());
	}
	
}
