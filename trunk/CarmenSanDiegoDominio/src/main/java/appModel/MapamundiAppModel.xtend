package appModel

import dominio.Mapamundi
import dominio.Pais
import org.uqbar.commons.utils.Observable

@Observable
class MapamundiAppModel {
	
	@Property Mapamundi mapamundi
	
	@Property Pais paisSeleccionado
	
	new(){
		mapamundi = Mapamundi.instance
	}
	
	def agregarPais(){
		var pais = new Pais
		mapamundi.agregarPais(pais)
		pais
	}
	
	def eliminarPais(){
		mapamundi.eliminarPais(paisSeleccionado)
	}
}