package appModel

import dominio.Detective
import dominio.Pais
import java.util.List
import dominio.Villano

import org.uqbar.commons.utils.Observable

@Observable
class JuegoAppModel {
	
	@Property Detective detective
	
	@Property List<Pais> destinosFallidos	
	
	@Property Villano ordenDeArresto

	new(Detective detective){
		_detective = detective
	}


}