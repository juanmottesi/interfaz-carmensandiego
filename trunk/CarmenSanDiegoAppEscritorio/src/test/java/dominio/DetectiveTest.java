package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.commons.model.UserException;

public class DetectiveTest {

	private Detective detective;
	private Pais mockPais1;
	private Pais mockPais2;
	private Pais mockPais3;
	private Villano mockVillano;
	
	@Before
	public void setUp(){
		detective= new Detective();
		mockPais1 = mock(Pais.class);
		mockPais2 = mock(Pais.class);
		mockPais3 = mock(Pais.class);
		mockVillano = mock(Villano.class);
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(detective.getExpedientes());
		assertNotNull(detective.getMapamundi());
		assertNull(detective.getCasoActual());
	}

	@Test
	public void testAgregarVillanoCorrecto() {
		detective.agregarVillano(mockVillano);
		assertEquals(1, detective.getExpedientes().getVillanos().size());
	}
	
	@Test(expected=UserException.class)
	public void testAgregarVillanoIncorrecto() {
		detective.agregarVillano(mockVillano);
		detective.agregarVillano(mockVillano);
	}
	
	@Test
	public void testAgregarPaisCorrecto() {
		detective.agregarPais(mockPais1);
		assertEquals(1, detective.getMapamundi().getPaises().size());
	}
	
	@Test(expected=UserException.class)
	public void testAgregarPaisIncorrecto() {
		detective.agregarPais(mockPais1);
		detective.agregarPais(mockPais1);
	}

	@Test(expected= UserException.class)
	public void testIniciarJuegoIncorrecto(){
		detective.iniciarJuego();
	}
	
	@Test(expected= UserException.class)
	public void testIniciarJuegoIncorrectoConPais(){
		detective.agregarPais(mockPais1);
		detective.iniciarJuego();
	}
	
	@Test(expected= UserException.class)
	public void testIniciarJuegoIncorrectoConVillano(){
		detective.agregarVillano(mockVillano);
		detective.iniciarJuego();
	}
	
	@Test(expected=UserException.class)
	public void testIniciarJuegoCon2Paises(){
		detective.agregarPais(mockPais1);
		detective.agregarPais(mockPais2);
		
		detective.agregarVillano(mockVillano);
		detective.iniciarJuego();
		assertNotNull(detective.getCasoActual());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testIniciarJuego(){
		detective.agregarPais(mockPais1);
		detective.agregarPais(mockPais2);
		detective.agregarPais(mockPais3);
		detective.agregarVillano(mockVillano);
		
		when(mockPais1.obtenerSiguientePais(anyList())).thenReturn(mockPais2);
		when(mockPais2.obtenerSiguientePais(anyList())).thenReturn(mockPais3);
		when(mockPais3.obtenerSiguientePais(anyList())).thenReturn(mockPais1);
		
		
		detective.iniciarJuego();
		assertNotNull(detective.getCasoActual());
	}
	
	
}
