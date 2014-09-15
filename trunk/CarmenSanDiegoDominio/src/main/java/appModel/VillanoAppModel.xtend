package appModel

import dominio.Villano
import dominio.Sexo
import org.uqbar.commons.utils.Observable
import java.util.Arrays

@Observable
class VillanoAppModel {
	
	@Property Villano villano
	
	@Property String seniaSeleccionada
	@Property String nuevaSeniaParticular
	
	@Property String HobbieSeleccionada
	@Property String nuevoHobbie
	
	new(Villano villanoSeleccionado){
		villano = villanoSeleccionado
	}
	
	def getSexosPosibles(){
		Arrays.asList(Sexo.values)
	}
	
}