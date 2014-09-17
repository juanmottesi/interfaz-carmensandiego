package dominio

import java.util.List


interface Ocupante {
	
	def List<String> pista(Villano villano)
	
	def boolean esVillano()
	
}

class Cuidador implements Ocupante {
	
	override pista(Villano villano) {
		#["Lo siento, creo que se ha equivocado de Ciudad, no hay nadie con esas caracteristicas"]
	}
	
	override esVillano() {
		false
	}
	
}

class Informante implements Ocupante{
	@Property List<String> informacion
	
	new(List<String> info) {
		informacion = info
	}
	
	override pista(Villano villano) {
		informacion
	}
	
	override esVillano() {
		false
	}
	
}