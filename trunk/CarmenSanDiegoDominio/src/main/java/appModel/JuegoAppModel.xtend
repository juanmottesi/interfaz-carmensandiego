package appModel

import dominio.Detective
import dominio.Pais
import java.util.List
import dominio.Villano

import org.uqbar.commons.utils.Observable
import dominio.Expediente

@Observable
class JuegoAppModel {
	
	@Property Detective detective
	
	@Property List<Pais> destinosFallidos	
	
	@Property Villano ordenDeArresto

	new(Detective detective){
		_detective = detective
	}
	
	def getTodosLosVillanos(){
		Expediente.instance.villanos
	}


}