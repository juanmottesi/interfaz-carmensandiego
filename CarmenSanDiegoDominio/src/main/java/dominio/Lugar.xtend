package dominio

import dominio.Villano
import org.uqbar.commons.utils.Observable

abstract class Lugar {
	
	@Property String nombreDelLugar

	def String obtenerPista(Villano villano)
}


@Observable
class Biblioteca extends Lugar{
	
	new(){
		nombreDelLugar = "Biblioteca"
	}
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

@Observable
class Club extends Lugar{
	
	new(){
		nombreDelLugar = "Club"
	}
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

@Observable
class Embajada extends Lugar{
	
	new(){
		nombreDelLugar = "Embajada"
	}
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

@Observable
class Banco extends Lugar{
	
	new(){
		nombreDelLugar = "Banco"
	}
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}