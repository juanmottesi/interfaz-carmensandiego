package dominio

import dominio.Villano

abstract class Lugar {
	
	def String obtenerPista(Villano villano)
	
}

class Biblioteca extends Lugar{
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

class Club extends Lugar{
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

class Embajada extends Lugar{
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

class Banco extends Lugar{
	
	override String obtenerPista(Villano villano) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}