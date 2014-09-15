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

	def static void main(String[] args) {
		var detective = new Detective
		detective.expedientes.agregarVillano(new Villano =>[
			nombre = "Carmen San Diego"
			seniasParticulares = #["Usa gorro","Usa limusina"]
			hobbies = #["juega tenis", "corre todas las mañanas"]
			sexo = Sexo.Femenino
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
			nombre = "Diego"
			seniasParticulares = #["Usa gorro","Usa limusina"]
			hobbies = #["juega tenis", "corre todas las mañanas"]
			sexo = Sexo.Masculino
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Argentina"
			caracteristicasDelPais 
			lugaresDeInteres
			conexionesAereas

			
		])
		
	}
	

}