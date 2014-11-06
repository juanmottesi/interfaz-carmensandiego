package appModel

import dominio.Pais
import java.util.List
import java.io.Serializable
import dominio.Mapamundi

class MapamundiWicket implements Serializable {
	
	@Property Pais paisSeleccionado
	@Property List<Pais> paises
	
	def void eliminarPaisSeleccionado() {
		Mapamundi.getInstance.eliminarPais(paisSeleccionado)
		
		paisSeleccionado = null
	}
	
	def void buscarPaises() {
		paises = newArrayList 
		paises = Mapamundi.getInstance.paises 
	}
}