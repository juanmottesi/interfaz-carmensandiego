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
	
	def String botonEliminarLugares()
	
	def String listaLugares()
	
	def String obtenerInputLugares()
	
	def void eliminarLugarSeleccionado()
	
	def String lugaresSeleccionada()
	
	def void agregarLugares()
	
}