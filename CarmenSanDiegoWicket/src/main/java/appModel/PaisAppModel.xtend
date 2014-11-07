package appModel

import dominio.Pais
import dominio.Lugar
import org.uqbar.commons.utils.Observable
import dominio.Mapamundi
import dominio.Biblioteca
import dominio.Banco
import dominio.Club
import dominio.Embajada
import org.uqbar.commons.model.ObservableUtils

@Observable
class PaisAppModel {
	
	@Property Pais pais
	
	@Property String caracteristicaSeleccionada
	@Property String nuevaCaracteristica
	
	@Property String conexionSeleccionada
	@Property String nuevaConexion
	
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
		nuevaCaracteristica = null
		ObservableUtils.firePropertyChanged(this, "nuevaCaracteristica",nuevaCaracteristica)
	}
	
	def eliminarCaracteristica(){
		pais.eliminarCaracteristica(caracteristicaSeleccionada)
	}
	
	def agregarConexion(){
		pais.agregarConexion(Mapamundi.getInstance.getPais(nuevaConexion))
		ObservableUtils.firePropertyChanged(this,"paisesPosibles",paisesPosibles)
		nuevaConexion = null
		ObservableUtils.firePropertyChanged(this, "nuevaConexion",nuevaConexion)
	}
	
	def eliminarConexion(){
		pais.eliminarConexion(conexionSeleccionada)
	}
	
	def agregarLugar(){
		pais.agregarLugar(nuevoLugar)
		ObservableUtils.firePropertyChanged(this,"lugaresPosibles",lugaresPosibles)
		nuevoLugar = null
		ObservableUtils.firePropertyChanged(this, "nuevoLugar",nuevoLugar)
		
	} 
	
	def eliminarLugar(){
		pais.eliminarLugar(lugarSeleccionada)
		ObservableUtils.firePropertyChanged(this,"lugaresPosibles",lugaresPosibles)
	}
	
	def getPaisesPosibles(){
		Mapamundi.instance.paises.filter[!it.equals(pais)
		].filter[!pais.conexionesAereas.contains(it)].toList.map[nombreDelPais]
	}
	
	def getLugaresPosibles(){
		var lista = #[new Biblioteca, new Banco, new Club, new Embajada]
		lista.filter[
			var aux = pais.lugaresDeInteres.map[nombreDelLugar]
			!aux.contains(it.nombreDelLugar)
		].toList
	}
	
}