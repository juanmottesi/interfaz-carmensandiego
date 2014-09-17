package dominio


import org.uqbar.commons.utils.Observable

@Observable
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
	
	def viajarA(Pais pais) {
		casoActual.setCiudadActual(pais)
	}
	
	def perteneceAlPlanDeEscape(Pais pais) {
		casoActual.perteneceAlPlanDeEscape(pais)
	}
	

}