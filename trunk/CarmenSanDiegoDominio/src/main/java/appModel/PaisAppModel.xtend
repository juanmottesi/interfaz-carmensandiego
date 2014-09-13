package appModel

import dominio.Pais
import dominio.Lugar
import org.uqbar.commons.utils.Observable
import dominio.Mapamundi

@Observable
class PaisAppModel {
	
	@Property Pais pais
	
	@Property String caracteristicaSeleccionada
	@Property String nuevaCaracteristica
	
	@Property Pais conexionSeleccionada
	@Property Pais nuevaConexion
	
	@Property Lugar lugarSeleccionada
	@Property Lugar nuevoLugar
	
	new(Pais paisSeleccionado){
		pais = paisSeleccionado
	}
	
	def esCorrecto() {
		pais.esCorrecto(Mapamundi.instance.paises)
	}
	
	def agregarCaracteristica(){
		pais.agregarCaracteristica(nuevaCaracteristica)
	}
	
	def eliminarCaracteristica(){
		pais.eliminarCaracteristica(caracteristicaSeleccionada)
	}
	
	def agregarConexion(){
		pais.agregarConexion(nuevaConexion)
	}
	
	def eliminarConexion(){
		pais.eliminarConexion(conexionSeleccionada)
	}
	
	def agregarLugar(){
		pais.agregarLugar(nuevoLugar)
	} 
	
	def eliminarLugar(){
		pais.eliminarLugar(lugarSeleccionada)
	}
}