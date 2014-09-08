package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.commons.model.UserException;

import ui.NuevoPaisWindow;

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
    public void testCaracteristicasSeleccionada(){
		assertEquals("nuevoPais.caracteristicaSeleccionada", mapamundi.caracteristicasSeleccionada());
	}
	
	@Test
	public void testObtenerInputCaracteristica(){
		assertEquals("nuevoPais.nuevaCaracteristica", mapamundi.obtenerInputCaracteristica());
	}
	
	@Test
	public void testListaCaracteristicas(){
		assertEquals("nuevoPais.caracteristicasDelPais",mapamundi.listaCaracteristicas());
	}

	@Test
	public void testActualizar(){
		mapamundi.setNuevoPais(mockPais);
		mapamundi.actualizar();
		verify(mockPais).actualizar();
	}
		
	@Test
	public void testConexionesSeleccionada(){
		assertEquals("nuevoPais.conexionSeleccionada", mapamundi.conexionesSeleccionada());
	}
	
	@Test
	public void testListaConexiones(){
		assertEquals("nuevoPais.conexionesAereas", mapamundi.listaConexiones());
	}
	
	@Test
	public void testObtenerInputConexiones(){
		assertEquals("nuevoPais.nuevaConexion", mapamundi.obtenerInputConexiones());
	}
	
	@Test
	public void testListaLugares(){
		assertEquals("nuevoPais.lugaresDeInteres", mapamundi.listaLugares());
	}
	
	@Test
	public void testObtenerInputLugares(){
		assertEquals("nuevoPais.nuevoLugar", mapamundi.obtenerInputLugares());
	}
		
	@Test
	public void testLugaresSeleccionada(){
		assertEquals("nuevoPais.lugarSeleccionado",mapamundi.lugaresSeleccionada());
	}
	
	@Test
	public void testAgregarLugares(){
		mapamundi.setNuevoPais(mockPais);
		mapamundi.agregarLugar();
		verify(mockPais).agregarLugar();
	}
		
	@Test
	public void testObtenerTitulo(){
		assertEquals("Mapamundi - Nuevo Pais", mapamundi.obtenerTitulo());
	}
	
	@Test
	public void testAgregarNombreDelPais(){
		NuevoPaisWindow mockWindow = mock(NuevoPaisWindow.class);
		Panel mockPanel = mock(Panel.class);
		mapamundi.agregarNombreDelPais(mockPanel, mockWindow);
		verify(mockWindow).agregarTexBox(mockPanel, "Nombre: ", "nuevoPais.nombreDelPais");
	}
	
	@Test
	public void testAgregarCaracterisitca(){
		mapamundi.setNuevoPais(mockPais);
		mapamundi.agregarCaracteristica();
		verify(mockPais).agregarCaracteristica();
	}
	
	@Test
	public void testAgregarConexion(){
		mapamundi.setNuevoPais(mockPais);
		mapamundi.agregarConexion();
		verify(mockPais).agregarConexion();
	}
	
	@Test
	public void testEliminarCaracteristica(){
		mapamundi.setNuevoPais(mockPais);
		mapamundi.agregarCaracteristica();
		mapamundi.setNuevoPais(mockPais);
		mapamundi.eliminarCaracteristica();
		verify(mockPais).eliminarCaracteristica();
	}
	
	@Test
	public void testEliminarConexion(){
		mapamundi.setNuevoPais(mockPais);
		mapamundi.agregarConexion();
		mapamundi.setNuevoPais(mockPais);
		mapamundi.eliminarConexion();
		verify(mockPais).eliminarConexion();
	}
	
	@Test
	public void testEliminarLugar(){
		mapamundi.setNuevoPais(mockPais);
		mapamundi.agregarLugar();
		mapamundi.setNuevoPais(mockPais);
		mapamundi.eliminarLugar();
		verify(mockPais).eliminarLugar();
	}
	
//	@Test
//	public void testAgregarBotonAceptar(){
//		
//	}
}
