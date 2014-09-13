package appModel

import dominio.Pais
import dominio.Lugar
import org.uqbar.commons.utils.Observable
import dominio.Mapamundi
import dominio.Biblioteca
import dominio.Banco
import dominio.Club
import dominio.Embajada

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
		nuevaCaracteristica
	}
	
	def eliminarCaracteristica(){
		pais.eliminarCaracteristica(caracteristicaSeleccionada)
	}
	
	def agregarConexion(){
		pais.agregarConexion(nuevaConexion)
		nuevaConexion
	}
	
	def eliminarConexion(){
		pais.eliminarConexion(conexionSeleccionada)
	}
	
	def agregarLugar(){
		pais.agregarLugar(nuevoLugar)
		nuevoLugar
	} 
	
	def eliminarLugar(){
		pais.eliminarLugar(lugarSeleccionada)
	}
	
	def getPaisesPosibles(){
		Mapamundi.instance.paises.filter[!it.equals(pais)].toList
	}
	
	def getLugaresPosibles(){
		#[new Biblioteca, new Banco, new Club, new Embajada].filter[!pais.lugaresDeInteres.contains(it)].toList
	}
}