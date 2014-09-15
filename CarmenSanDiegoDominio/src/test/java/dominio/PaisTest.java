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
		pais = new Pais();
		mockPais = mock(Pais.class);
		mockLugar = mock(Lugar.class);
	}
	
	@Test
	public void testObtenerSiguientePais() {
		pais.agregarConexion(mockPais);		
		assertEquals(mockPais, pais.obtenerSiguientePais(new ArrayList<Pais>()));
	}
	
	@Test
	public void testAgregarCaracteristica(){
		pais.agregarCaracteristica("nueva");
		assertEquals("nueva", pais.getCaracteristicasDelPais().get(0));
	}		

	@Test(expected= UserException.class)
	public void testAgregarCaracteristicaConLaMismaCaracteristicaQueYaTenia(){
		pais.agregarCaracteristica("nueva");
		pais.agregarCaracteristica("nueva");
		assertEquals(1, pais.getCaracteristicasDelPais());
	}	
	
	@Test
	public void testEliminarCaracteristica(){
		pais.agregarCaracteristica("nueva");
		pais.eliminarCaracteristica("nueva");
		assertEquals(0, pais.getCaracteristicasDelPais().size());
	}
	
	@Test
	public void testAgregarConexion(){
		pais.agregarConexion(mockPais);
		assertEquals(1, pais.getConexionesAereas().size());
		
	}
	
	@Test(expected = UserException.class)
	public void testAgregarConexionConElMismoPaisQueYaTenia(){
		pais.agregarConexion(mockPais);
		pais.agregarConexion(mockPais);
		assertEquals(1, pais.getConexionesAereas());
	}
	
	@Test(expected = UserException.class)
	public void testAgregarConexionConMasDeTresConexiones(){
		Pais p1 = mock(Pais.class);
		Pais p2 = mock(Pais.class);
		Pais p3 = mock(Pais.class);		
		pais.agregarConexion(mockPais);		
		pais.agregarConexion(p1);		
		pais.agregarConexion(p2);		
		pais.agregarConexion(p3);
		assertEquals(3, pais.getConexionesAereas().size());
	}
	
	@Test
	public void testEliminarConexion(){
		pais.agregarConexion(mockPais);		
		pais.eliminarConexion(mockPais);
		assertEquals(0, pais.getConexionesAereas().size());		
	}
	
	@Test
	public void testAgregarLugar(){
		pais.agregarLugar(mockLugar);
		assertEquals(1, pais.getLugaresDeInteres().size());
	}
	
	@Test(expected=UserException.class)
	public void testAgregarLugarConElMismoLugarQueYaTenia(){
		pais.agregarLugar(mockLugar);		
		pais.agregarLugar(mockLugar);
		assertEquals(1, pais.getLugaresDeInteres());
	}
	
	@Test(expected=UserException.class)
	public void testAgregarLugarConMasDeTresLugares(){
		Lugar l1 = mock(Lugar.class);
		Lugar l2 = mock(Lugar.class);
		Lugar l3 = mock(Lugar.class);
		
		pais.agregarLugar(mockLugar);
		pais.agregarLugar(l1);
		pais.agregarLugar(l2);
		pais.agregarLugar(l3);
		assertEquals(3, pais.getLugaresDeInteres().size());
	}
	
	@Test
	public void testEliminarLugar(){
		pais.agregarLugar(mockLugar);
		pais.eliminarLugar(mockLugar);
		assertEquals(0, pais.getLugaresDeInteres().size());
	}
	
	@Test
	public void testCaracteristicasLowerCase(){
		pais.agregarCaracteristica("NUEVA");
		assertEquals("nueva", pais.caracteristicasLowerCase().get(0));
	}
	
	@Test
	public void testEliminarConexionConPaisQueYaTenia(){
		pais.agregarConexion(mockPais);
		pais.eliminarConexion(mockPais);
		assertEquals(0,pais.getConexionesAereas().size());
	}
	
}
