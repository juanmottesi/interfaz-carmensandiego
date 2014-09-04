package dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CasoTest {
	
	private Mapamundi mockMapamundi;
	private Expediente mockExpedientes;
	private Villano mockVillano;
	private Pais mockPais;
	private Caso caso;

	
	@Before
	public void setUp(){
		
		mockMapamundi = mock(Mapamundi.class);
		mockExpedientes = mock(Expediente.class);	
		mockVillano = mock(Villano.class);
		mockPais = mock(Pais.class);
		ArrayList<Pais> lista = new ArrayList<Pais>();
		lista.add(mockPais);
		when(mockMapamundi.planDeEscape()).thenReturn(lista);
		when(mockExpedientes.obtenerVillano()).thenReturn(mockVillano);
		when(mockPais.getNombreDelPais()).thenReturn("PAIS");
		
		caso = new Caso(mockMapamundi, mockExpedientes);
		
	}

	@Test
	public void testConstructor() {
		
		String ret = "Detective, tenemos un caso para usted!" + 
				"A las 10 de la mañana en la ciudad " + "PAIS" + 
				"la comunidad  fue conmovida  al darse cuenta del faltante de gran valor!" + 
				"La Cuchara real";
		
		assertEquals(ret, caso.getReporte());
		assertEquals("La Cuchara real", caso.getObjetoRobado());
		
	}
	

}
