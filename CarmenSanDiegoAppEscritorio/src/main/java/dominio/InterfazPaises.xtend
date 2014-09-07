package dominio

interface InterfazPaises {
	
	def String botonEliminarCaracteristicas()
	
	def String caracteristicasSeleccionada()
	
	def String obtenerInputCaracteristica()
	
	def String listaCaracteristicas()
	
	def void eliminarCaracteristicaSeleccionada()
	
	def void agregarCaracteristica()
	
	def void actualizar()
}