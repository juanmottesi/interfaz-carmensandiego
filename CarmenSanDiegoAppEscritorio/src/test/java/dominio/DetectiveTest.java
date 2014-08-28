package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import exception.ExceptionFaltanPaises;
import exception.ExceptionFaltanPaisesOVillanos;
import exception.ExceptionPaisRepetido;
import exception.ExceptionVillanoRepetido;

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
		assertEquals(0, detective.getExpedientes().size());
		assertEquals(0, detective.getMapamundi().size());
		assertNull(detective.getCasoActual());
	}

	@Test
	public void testAgregarVillanoCorrecto() {
		detective.agregarVillano(mockVillano);
		assertEquals(1, detective.getExpedientes().size());
	}
	
	@Test(expected=ExceptionVillanoRepetido.class)
	public void testAgregarVillanoIncorrecto() {
		detective.agregarVillano(mockVillano);
		detective.agregarVillano(mockVillano);
		assertEquals(1, detective.getExpedientes().size());
	}
	
	@Test
	public void testAgregarPaisCorrecto() {
		detective.agregarPais(mockPais1);
		assertEquals(1, detective.getMapamundi().size());
	}
	
	@Test(expected=ExceptionPaisRepetido.class)
	public void testAgregarPaisIncorrecto() {
		detective.agregarPais(mockPais1);
		detective.agregarPais(mockPais1);
		assertEquals(1, detective.getMapamundi().size());
	}

	@Test(expected= ExceptionFaltanPaisesOVillanos.class)
	public void testIniciarJuegoIncorrecto(){
		detective.iniciarJuego();
	}
	
	@Test(expected= ExceptionFaltanPaisesOVillanos.class)
	public void testIniciarJuegoIncorrectoConPais(){
		detective.agregarPais(mockPais1);
		detective.iniciarJuego();
	}
	
	@Test(expected= ExceptionFaltanPaisesOVillanos.class)
	public void testIniciarJuegoIncorrectoConVillano(){
		detective.agregarVillano(mockVillano);
		detective.iniciarJuego();
	}
	
	@Test(expected=ExceptionFaltanPaises.class)
	public void testIniciarJuegoCon2Paises(){
		detective.agregarPais(mockPais1);
		detective.agregarPais(mockPais2);
		
		detective.agregarVillano(mockVillano);
		detective.iniciarJuego();
		assertNotNull(detective.getCasoActual());
	}
	
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
