package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.commons.model.UserException;

import dominio.Lugar;

public class PaisTest {

	private Pais pais;
	private Pais mockPais;
	private Lugar mockLugar;
	
	
	@Before
	public void setUp(){
		pais = new Pais("nombrePais",new ArrayList<String>(), new ArrayList<Lugar>(),
			            new ArrayList<Pais>());
		mockPais = mock(Pais.class);
		mockLugar = mock(Lugar.class);
	}

	@Test
	public void testConstructor() {
		assertEquals("nombrePais", pais.getNombreDelPais());
		assertEquals(0, pais.getCaracteristicasDelPais().size());
		assertEquals(0, pais.getLugaresDeInteres().size());
		assertEquals(0, pais.getConexionesAereas().size());
	}
	
	@Test
	public void testObtenerSiguientePais() {
		pais.setNuevaConexion(mockPais);
		pais.agregarConexion();
		
		assertEquals(mockPais, pais.obtenerSiguientePais(new ArrayList<Pais>()));
	}
	
	@Test
	public void testAgregarCaracteristica(){
		pais.setNuevaCaracteristica("nueva");
		pais.agregarCaracteristica();
		assertEquals("nueva", pais.getCaracteristicasDelPais().get(0));
	}		

	@Test(expected= UserException.class)
	public void testAgregarCaracteristicaConException(){
		pais.setNuevaCaracteristica("nueva");
		pais.agregarCaracteristica();
		pais.setNuevaCaracteristica("nueva");
		pais.agregarCaracteristica();
	}	
	
	@Test
	public void testEliminarCaracteristica(){
		pais.setNuevaCaracteristica("nueva");
		pais.agregarCaracteristica();
		pais.setCaracteristicaSeleccionada("nueva");
		pais.eliminarCaracteristica();
		
		assertEquals(0, pais.getCaracteristicasDelPais().size());
	}
	
	@Test
	public void testAgregarConexion(){
		pais.setNuevaConexion(mockPais);
		pais.agregarConexion();
		assertEquals(1, pais.getConexionesAereas().size());
		
	}
	
	@Test(expected = UserException.class)
	public void testAgregarConexionExepcionPrimera(){
		pais.setNuevaConexion(mockPais);
		pais.agregarConexion();
		pais.setNuevaConexion(mockPais);
		pais.agregarConexion();
	}
	
	@Test(expected = UserException.class)
	public void testAgregarConexionExepcionSegunda(){
		Pais p1 = mock(Pais.class);
		Pais p2 = mock(Pais.class);
		Pais p3 = mock(Pais.class);
		pais.setNuevaConexion(mockPais);
		pais.agregarConexion();
		pais.setNuevaConexion(p1);
		pais.agregarConexion();
		pais.setNuevaConexion(p2);
		pais.agregarConexion();
		pais.setNuevaConexion(p3);
		pais.agregarConexion();
	}
	
	@Test
	public void testEliminarConexion(){
		pais.setNuevaConexion(mockPais);
		pais.agregarConexion();
		pais.setConexionSeleccionada(mockPais);
		pais.eliminarConexion();
		assertEquals(0, pais.getConexionesAereas().size());
		
	}
	
	@Test
	public void testAgregarLugar(){
		pais.setNuevoLugar(mockLugar);
		pais.agregarLugar();
		assertEquals(1, pais.getLugaresDeInteres().size());
	}
	
	@Test(expected=UserException.class)
	public void testAgregarLugarExceptionPrimera(){
		pais.setNuevoLugar(mockLugar);
		pais.agregarLugar();
		pais.setNuevoLugar(mockLugar);
		pais.agregarLugar();
	}
	
	@Test(expected=UserException.class)
	public void testAgregarLugarExceptionSegunda(){
		Lugar l1 = mock(Lugar.class);
		Lugar l2 = mock(Lugar.class);
		Lugar l3 = mock(Lugar.class);
		
		pais.setNuevoLugar(mockLugar);
		pais.agregarLugar();
		pais.setNuevoLugar(l1);
		pais.agregarLugar();
		pais.setNuevoLugar(l2);
		pais.agregarLugar();
		pais.setNuevoLugar(l3);
		pais.agregarLugar();
	}
	
	@Test
	public void testEliminarLugar(){
		pais.setNuevoLugar(mockLugar);
		pais.agregarLugar();
		pais.setLugarSeleccionado(mockLugar);
		pais.eliminarLugar();
		assertEquals(0, pais.getLugaresDeInteres().size());
	}
	
	@Test
	public void testCaracteristicasLowerCase(){
		pais.setNuevaCaracteristica("NUEVA");
		pais.agregarCaracteristica();
		assertEquals("nueva", pais.caracteristicasLowerCase().get(0));
	}
	
	@Test
	public void testEliminarConexionConPais(){
		pais.setNuevaConexion(mockPais);
		pais.agregarConexion();
		pais.eliminarConexion(mockPais);
		assertEquals(0,pais.getConexionesAereas().size());
	}
	
	
}
