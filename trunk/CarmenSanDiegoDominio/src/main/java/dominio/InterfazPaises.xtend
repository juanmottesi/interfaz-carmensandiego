package dominio

interface InterfazPaises {
	
	def String caracteristicasSeleccionada()
	
	def String obtenerInputCaracteristica()
	
	def String listaCaracteristicas()
	
	def void eliminarCaracteristica()
	
	def void agregarCaracteristica()
	
	def void actualizar()
		
	def void eliminarConexion()
	
	def String conexionesSeleccionada()
	
	def String listaConexiones()
	
	def String obtenerInputConexiones()
	
	def void agregarConexion()
	
	def String listaLugares()
	
	def String obtenerInputLugares()
	
	def void eliminarLugar()
	
	def String lugaresSeleccionada()
	
	def void agregarLugar()
	
	def String obtenerTitulo()
		
	def Boolean soyEditar()
	
	def void agregarPais()
	
}