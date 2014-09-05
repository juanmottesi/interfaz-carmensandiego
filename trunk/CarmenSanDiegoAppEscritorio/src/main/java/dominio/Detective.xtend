package dominio

class Detective {
	
	@Property Expediente expedientes
	@Property Mapamundi mapamundi
	@Property Caso casoActual
	
	new(){
		this.expedientes = new Expediente
		this.mapamundi = Mapamundi.instance
	}
	
	def void agregarVillano(Villano villano){
		expedientes.agregar(villano)	
	}
	
	def void agregarPais(Pais pais){
		mapamundi.agregar(pais)
	}
	
	def void iniciarJuego(){
		mapamundi.puedoIniciar
		expedientes.puedoIniciar
		
		casoActual = new Caso(mapamundi, expedientes)
		
		
	}
	

}