package dominio

interface InterfazVillanos {
	
	abstract def String obtenerInputHobbie()
		
	abstract def void eliminarHobieSeleccionado()
	
	abstract def void agregarHobbie()
	
	def String listaHobbies()
	
	def String hobbiesSeleccionado()
	
	def void actualizar()
	
	def void agregarSeniasParticulares()
		
	def void eliminarSeniasParticularesSeleccionado()
	
	def String obtenerInputSeniasParticulares()
	
	def String listaSeniasParticulares()
	
	def String seniasParticularesSeleccionada()
		
	def Boolean soyEditar()
	
	def void agregarVillano()
	
	
}