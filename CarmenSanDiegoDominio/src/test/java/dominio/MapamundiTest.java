package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MapamundiTest {
	
	private Mapamundi mapamundi;
	private List<Pais> mockList;
	private Pais mockPais;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp(){
		mapamundi = Mapamundi.getInstance();
		mockList = mock(List.class);
		mockPais = mock(Pais.class);
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
		mapamundi.agregarPais(mockPais);
		assertEquals(1, mapamundi.getPaises().size());		
	}
			
	@Test
	public void testEliminarPais() {
		mapamundi.setPaises(new ArrayList<Pais>());
		when(mockPais.getConexionesAereas()).thenReturn(new ArrayList<Pais>());
		mapamundi.agregarPais(mockPais);
		mapamundi.eliminarPais(mockPais);
		assertEquals(0, mapamundi.getPaises().size());		
	}

}
