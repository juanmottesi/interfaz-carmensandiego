package appModel

import dominio.Pais
import java.util.List
import java.io.Serializable

class MapamundiWicket implements Serializable {
	
	@Property List<Pais> paises
	@Property Pais paisSeleccionado
	
	def void eliminarPaisSeleccionado() {
		getHomePaises().delete(getPaisSeleccionado)
		
		paisSeleccionado = null
	}
	
	def HomeCelulares getHomeCelulares() {
		ApplicationContext::instance.getSingleton(typeof(Celular))
	}
	
	
}