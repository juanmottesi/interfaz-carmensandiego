package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.commons.model.UserException;

public class MapamundiTest {
	
	private Mapamundi mapamundi;
	private List<Pais> mockList;
	private Pais mockPais;
	private List<Lugar> mockListLugar;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp(){
		mapamundi = Mapamundi.getInstance();
		mockList = mock(List.class);
		mockPais = mock(Pais.class);
		mockListLugar = mock(List.class);
	}


	@Test
	public void testPuedoIniciar() {
		mapamundi.setPaises(mockList);
		when(mockList.size()).thenReturn(4);	
		mapamundi.puedoIniciar();
	}
	
	@Test(expected= UserException.class)
	public void testPuedoIniciarException() {
		mapamundi.setPaises(mockList);
		when(mockList.size()).thenReturn(1);	
		mapamundi.puedoIniciar();
	}
	
	@Test
	public void testPrimerPais(){
		mapamundi.setPaises(mockList);
		when(mockList.get(0)).thenReturn(mockPais);
		when(mockList.size()).thenReturn(1);
		assertEquals(mockPais, mapamundi.primerPais());		
	}
	
	@SuppressWarnings({ "serial", "unchecked" })
	@Test
	public void testPlanDeEscape() {
		final Pais p1 = mock(Pais.class);
		final Pais p2 = mock(Pais.class);
		ArrayList<Pais> lista = new ArrayList<Pais>(){
			{
				add(mockPais);
				add(p1);
				add(p2);
			}
		};
		mapamundi.setPaises(lista);
		
		when(mockPais.obtenerSiguientePais(anyList())).thenReturn(p1);
		when(p1.obtenerSiguientePais(anyList())).thenReturn(p2);
		when(p2.obtenerSiguientePais(anyList())).thenReturn(mockPais);
		
		assertEquals(3, mapamundi.planDeEscape().size());	
	}

	@Test
	public void testAgregarPais(){
		mapamundi.setPaises(new ArrayList<Pais>());
		mapamundi.setNuevoPais(mockPais);
		when(mockPais.getNombreDelPais()).thenReturn("pais");
		when(mockPais.getLugaresDeInteres()).thenReturn(mockListLugar);
		when(mockListLugar.size()).thenReturn(3);
		mapamundi.agregarPais();
		
		assertEquals(1, mapamundi.getPaises().size());
		
	}
	
	@Test(expected=UserException.class)
	public void testAgregarPaisExceptionPrimera(){
		mapamundi.setPaises(new ArrayList<Pais>());
		mapamundi.setNuevoPais(mockPais);
		when(mockPais.getNombreDelPais()).thenReturn(null);
		when(mockPais.getLugaresDeInteres()).thenReturn(mockListLugar);
		when(mockListLugar.size()).thenReturn(3);
		mapamundi.agregarPais();
							
	}
	
	
	@Test(expected=UserException.class)
	public void testAgregarPaisExceptionSegunda(){
		mapamundi.setPaises(new ArrayList<Pais>());
		mapamundi.setNuevoPais(mockPais);
		when(mockPais.getNombreDelPais()).thenReturn("pais");
		when(mockPais.getLugaresDeInteres()).thenReturn(mockListLugar);
		when(mockListLugar.size()).thenReturn(3);
		mapamundi.agregarPais();
		
		mapamundi.setNuevoPais(mockPais);
		when(mockPais.getNombreDelPais()).thenReturn("pais");
		when(mockPais.getLugaresDeInteres()).thenReturn(mockListLugar);
		when(mockListLugar.size()).thenReturn(3);
		mapamundi.agregarPais();
					
	}
	
	@Test(expected=UserException.class)
	public void testAgregarPaisExceptionTercera(){
		mapamundi.setPaises(new ArrayList<Pais>());
		mapamundi.setNuevoPais(mockPais);
		when(mockPais.getNombreDelPais()).thenReturn("pais");
		when(mockPais.getLugaresDeInteres()).thenReturn(mockListLugar);
		when(mockListLugar.size()).thenReturn(2);
		mapamundi.agregarPais();			
	}
	
	@Test
	public void testEliminarPais() {
		mapamundi.setPaises(new ArrayList<Pais>());
		mapamundi.setNuevoPais(mockPais);
		when(mockPais.getNombreDelPais()).thenReturn("pais");
		when(mockPais.getLugaresDeInteres()).thenReturn(mockListLugar);
		when(mockListLugar.size()).thenReturn(3);
		mapamundi.agregarPais();
		
		mapamundi.setPaisSeleccionado(mockPais);
		mapamundi.eliminarPais();
		
		assertEquals(0, mapamundi.getPaises().size());
		
	}

	@Test
	public void testPaisesNombreLowerCase(){
		mapamundi.setPaises(new ArrayList<Pais>());
		mapamundi.setNuevoPais(mockPais);
		when(mockPais.getNombreDelPais()).thenReturn("PAIS");
		when(mockPais.getLugaresDeInteres()).thenReturn(mockListLugar);
		when(mockListLugar.size()).thenReturn(3);
		mapamundi.agregarPais();
		
		assertEquals("pais", mapamundi.paisesNombreLowerCase().get(0));
	}
	
	@Test
    public void testCaracteristicasSeleccionada(){}
	@Test
	public void testObtenerInputCaracteristica(){}
	@Test
	public void testListaCaracteristicas(){}
	@Test
	public void testEliminarCaracteristicaSeleccionada(){}
	@Test
	public void testAgregarCaracteristica(){}
	@Test
	public void testActualizar(){}
	@Test
	public void testEliminarConexionSeleccionada(){}
	@Test
	public void testConexionesSeleccionada(){}
	@Test
	public void testListaConexiones(){}
	@Test
	public void testObtenerInputConexiones(){}
	@Test
	public void testAgregarConexion(){}
	@Test
	public void testListaLugares(){}
	@Test
	public void testObtenerInputLugares(){}
	@Test
	public void testEliminarLugarSeleccionado(){}
	@Test
	public void testLugaresSeleccionada(){}
	@Test
	public void testAgregarLugares(){}
	@Test
	public void testObtenerTitulo(){}
	@Test
	public void testAgregarBotonAceptar(){}
	@Test
	public void testAgregarNombreDelPais(){}
	
}
