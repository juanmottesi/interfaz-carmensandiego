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
			seniasParticulares = #["Gorro","Joyas"]
			hobbies = #["Tenis", "Natacion"]
			sexo = Sexo.Femenino
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
			nombre = "Diego"
			seniasParticulares = #["Gorro","Cicatriz"]
			hobbies = #["Musica", "Croquet"]
			sexo = Sexo.Masculino
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Argentina"
			caracteristicasDelPais = #["Español","Peso"] 
			lugaresDeInteres = newArrayList =>[
				add(new Biblioteca)
				add(new Club)
				add(new Embajada)
			]	
			conexionesAereas = newArrayList		
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Chile"
			caracteristicasDelPais = #["Español","Peso Chileno"] 
			lugaresDeInteres = newArrayList =>[
				add(new Biblioteca)
				add(new Club)
				add(new Embajada)
			]	
			conexionesAereas = newArrayList			
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "España"
			caracteristicasDelPais = #["Español","Euro"] 
			lugaresDeInteres = newArrayList =>[
				add(new Biblioteca)
				add(new Club)
				add(new Embajada)
			]	
			conexionesAereas = newArrayList		
		])
		
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(1))
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(2))
		detective.mapamundi.paises.get(1).agregarConexion(detective.mapamundi.paises.get(2))
		detective.iniciarJuego
		
		System.out.println(detective.casoActual.ciudadActual.nombreDelPais)
		System.out.println(detective.casoActual.planDeEscape.get(detective.casoActual.planDeEscape.size-1).lugaresDeInteres.get(0).ocupante)
		System.out.println(detective.casoActual.planDeEscape.get(detective.casoActual.planDeEscape.size-1).lugaresDeInteres.get(1).ocupante)
		System.out.println(detective.casoActual.planDeEscape.get(detective.casoActual.planDeEscape.size-1).lugaresDeInteres.get(2).ocupante)
		
		
		
		
	}
	

}