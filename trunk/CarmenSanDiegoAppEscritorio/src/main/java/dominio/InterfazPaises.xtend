package dominio

interface InterfazPaises {
	
	def String botonEliminarCaracteristicas()
	
	def String caracteristicasSeleccionada()
	
	def String obtenerInputCaracteristica()
	
	def String listaCaracteristicas()
	
	def void eliminarCaracteristicaSeleccionada()
	
	def void agregarCaracteristica()
	
	def void actualizar()
	
	def String botonEliminarConexiones()
	
	def void eliminarConexionSeleccionada()
	
	def String conexionesSeleccionada()
	
	def String listaConexiones()
	
	def String obtenerInputConexiones()
	
	def void agregarConexion()
	
}