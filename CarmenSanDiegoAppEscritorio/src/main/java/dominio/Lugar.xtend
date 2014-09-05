package dominio

import dominio.Villano

abstract class Lugar {
	
	@Property String nombreDelLugar

	def String obtenerPista(Villano villano)
	
}

class Biblioteca extends Lugar{
	
	new(){
		nombreDelLugar = "Biblioteca"
	}
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

class Club extends Lugar{
	
	new(){
		nombreDelLugar = "Club"
	}
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

class Embajada extends Lugar{
	
	new(){
		nombreDelLugar = "Embajada"
	}
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

class Banco extends Lugar{
	
	new(){
		nombreDelLugar = "Banco"
	}
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}