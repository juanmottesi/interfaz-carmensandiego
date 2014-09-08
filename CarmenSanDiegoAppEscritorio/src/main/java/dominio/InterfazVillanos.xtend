package dominio

interface InterfazVillanos {
	
	abstract def String obtenerInputHobbie()
	
	abstract def String botonEliminarHobbie()
	
	abstract def void eliminarHobieSeleccionado()
	
	abstract def void agregarHobbie()
	
	def String listaHobbies()
	
	def String hobbiesSeleccionado()
	
	def void actualizar()
	
	def void agregarSeniasParticulares()
	
	def String botonEliminarSeniasParticulares()
	
	def void eliminarSeniasParticularesSeleccionado()
	
	def String obtenerInputSeniasParticulares()
	
	def String listaSeniasParticulares()
	
	def String seniasParticularesSeleccionada()
	
}