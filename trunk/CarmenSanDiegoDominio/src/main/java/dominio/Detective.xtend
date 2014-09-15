package dominio

class Detective {
	
	@Property Expediente expedientes
	@Property Mapamundi mapamundi
	@Property Caso casoActual
	
	new(){
		this.expedientes = Expediente.instance
		this.mapamundi = Mapamundi.instance
	}
		
	def void iniciarJuego(){
		mapamundi.puedoIniciar
		expedientes.puedoIniciar
		casoActual = new Caso(mapamundi, expedientes)
	}
	
	
//	def generarOrdenDeArresto(Villano villano){
//		
//	}
//	
//	def viajar(Pais pais){
//		
//	}
//	
//	def visitar(Lugar lugar){
//		casoActual.visitar(lugar)
//	}

}