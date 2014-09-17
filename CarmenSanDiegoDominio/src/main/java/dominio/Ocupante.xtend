package dominio

import java.util.List

interface Ocupante {
	
	def String pista(Villano villano)
	
}

class Cuidador implements Ocupante {
	
	override pista(Villano villano) {
		"Lo siento, creo que se ha equivocado de Ciudad, no hay nadie con esas caracteristicas"
	}
	
}

class Informante implements Ocupante{
	@Property List<String> informacion
	
	new(List<String> info) {
		informacion = info
	}
	
	override pista(Villano villano) {
		var ret = ""
		for(var i = 0; i < informacion.size ; i++){
			ret += informacion.get(i)
		}
		ret
	}
	
}