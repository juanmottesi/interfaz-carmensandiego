package appModel

import dominio.Villano
import dominio.Sexo
import org.uqbar.commons.utils.Observable
import java.util.Arrays
import dominio.Expediente
import org.uqbar.commons.model.ObservableUtils

@Observable
class VillanoAppModel {
	
	@Property Villano villano
	
	@Property String seniaSeleccionada
	@Property String nuevaSeniaParticular
	
	@Property String hobbieSeleccionada
	@Property String nuevoHobbie
	
	new(Villano villanoSeleccionado){
		villano = villanoSeleccionado
	}
	
	def getSexosPosibles(){
		Arrays.asList(Sexo.values)
	}
	
	def agregarSeniaParticular() {
		villano.agregarSeniaParticular(nuevaSeniaParticular)
		nuevaSeniaParticular = null
		ObservableUtils.firePropertyChanged(this, "nuevaSeniaParticular", nuevaSeniaParticular)
	}
	
	def eliminarSeniaParticular() {
		villano.eliminarSeniaParticular(seniaSeleccionada)
	}
	
	def agregarHobbie() {
		villano.agregarHobbie(nuevoHobbie)
		nuevoHobbie = null
		ObservableUtils.firePropertyChanged(this, "nuevoHobbie", nuevoHobbie)
	}
	
	def eliminarHobbie() {
		villano.eliminarHobbie(hobbieSeleccionada)
	}
	
	def esCorrecto() {
		villano.esCorrecto(Expediente.instance.villanos)
	}
	
}