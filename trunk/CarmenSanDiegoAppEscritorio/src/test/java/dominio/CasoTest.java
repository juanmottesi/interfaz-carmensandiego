package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CasoTest {
	
	private List<Pais> mapamundi;
	private List<Villano> expedientes;
	private Caso caso;
	private Villano mockVillano;
	private Pais mockPais;
	
	
	@Before
	public void setUp(){
		mapamundi = new ArrayList<Pais>();
		expedientes = new ArrayList<Villano>();
		
		mockVillano = mock(Villano.class);
		mockPais = mock(Pais.class);
		
		expedientes.add(mockVillano);
		mapamundi.add(mockPais);
		mapamundi.add(mockPais);
		mapamundi.add(mockPais);
		when(mockPais.obtenerSiguientePais(anyList())).thenReturn(mockPais);
		when(mockPais.getNombreDelPais()).thenReturn("PAIS");
		
		caso = new Caso(mapamundi, expedientes);
	}

	@Test
	public void testConstructor() {
		assertEquals(mockVillano, caso.getVillano());
		assertEquals(3, caso.getPlanDeEscape().size());
		assertEquals("La Cuchara real", caso.getObjetoRobado());
		String ret = "Detective, tenemos un caso para usted!" + 
				"A las 10 de la mañana en la ciudad " + "PAIS" + 
				"la comunidad  fue conmovida  al darse cuenta del faltante de gran valor!" + 
				"La Cuchara real";
		assertEquals(ret, caso.getReporte());
	}
	

}
