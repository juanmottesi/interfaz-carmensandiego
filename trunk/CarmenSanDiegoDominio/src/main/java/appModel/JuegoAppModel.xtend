package appModel

import dominio.Detective
import dominio.Pais
import java.util.List
import dominio.Villano

class JuegoAppModel {
	
	@Property Detective detective
	
	@Property List<Pais> destinosFallidos	
	
	@Property Villano ordenDeArresto

	new(Detective detective){
		_detective = detective
	}


}