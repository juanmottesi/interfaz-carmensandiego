package dominio

class Detective {
	
	@Property Expediente expedientes
	@Property Mapamundi mapamundi
	@Property Caso casoActual
	
	new(){
		this.expedientes = new Expediente
		this.mapamundi = Mapamundi.instance
	}
		
	def void iniciarJuego(){
		mapamundi.puedoIniciar
		expedientes.puedoIniciar
		
		casoActual = new Caso(mapamundi, expedientes)
		
		
	}
	

}