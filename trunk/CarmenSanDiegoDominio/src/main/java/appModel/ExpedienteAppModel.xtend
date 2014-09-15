package appModel

import dominio.Expediente
import dominio.Villano
import org.uqbar.commons.utils.Observable

@Observable
class ExpedienteAppModel {
	
	@Property Expediente expediente
	
	@Property Villano villanoSeleccionado
	
	new(){
		expediente = Expediente.instance
	}
	
	def agregarVillano(){
		var villano = new Villano
		expediente.agregarVillano(villano)
		villano
	}
	
}