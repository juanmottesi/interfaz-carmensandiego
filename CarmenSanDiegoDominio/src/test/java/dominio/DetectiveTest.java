package dominio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DetectiveTest {

	private Detective detective;
	private Mapamundi mockMapamundi;
	private Expediente mockExpedientes;
	private Pais mockPais;
	
	@Before
	public void setUp(){
		mockExpedientes = mock(Expediente.class);
		mockMapamundi = mock(Mapamundi.class);
		mockPais = mock(Pais.class);
		detective= new Detective();
		detective.setExpedientes(mockExpedientes);
		detective.setMapamundi(mockMapamundi);
	}
	
	


	@Test
	public void testIniciarJuego(){
		ArrayList<Pais> lista = new ArrayList<Pais>();
		lista.add(mockPais);
		when(mockMapamundi.planDeEscape()).thenReturn(lista);
		when(mockExpedientes.obtenerVillano()).thenReturn(new Villano());
		detective.iniciarJuego();
	}
	

	

	
}
