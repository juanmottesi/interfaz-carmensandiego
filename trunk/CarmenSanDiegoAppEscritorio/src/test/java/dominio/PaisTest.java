package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import dominio.Lugar;
import exception.ExceptionPaisYaAgregado;

public class PaisTest {

	private Pais pais;
	private Pais mockPais;
	
	
	@Before
	public void setUp(){
		pais = new Pais("nombrePais",new ArrayList<String>(), new ArrayList<Lugar>(),
			            new ArrayList<Pais>());
		mockPais = mock(Pais.class);
	}

	@Test
	public void testConstructor() {
		assertEquals("nombrePais", pais.getNombreDelPais());
		assertEquals(0, pais.getCaracteristicasDelPais().size());
		assertEquals(0, pais.getLugaresDeInteres().size());
		assertEquals(0, pais.getConexionesAereas().size());
	}
	
	@Test
	public void testAgregarConeccionA(){
		pais.agregarConeccionA(mockPais);
		assertEquals(1, pais.getConexionesAereas().size());
		verify(mockPais).getConexionesAereas();
	}
	
	@Test(expected=ExceptionPaisYaAgregado.class)
	public void testAgregarConeccionAThrowException(){
		pais.agregarConeccionA(mockPais);
		pais.agregarConeccionA(mockPais);
		fail("error no salto la excepcion");
	}
	
	@Test
	public void testObtenerSiguientePais(){
		pais.agregarConeccionA(mockPais);
		assertEquals(mockPais, pais.obtenerSiguientePais(new ArrayList<Pais>()));
	}
	
	
	
}
