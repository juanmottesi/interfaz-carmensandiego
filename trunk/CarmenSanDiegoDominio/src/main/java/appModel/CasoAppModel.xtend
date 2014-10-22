package appModel

import dominio.Caso
import java.util.List
import dominio.Pais
import dominio.Villano
import dummyData.DummyData
import dominio.Mapamundi
import dominio.Expediente

class CasoAppModel {
	
	private static CasoAppModel instance = null
	
	@Property List<Pais> paises
	
	static def getInstance() {
		if (instance == null) {
			var dummy = new DummyData().crearJuegoDummy
			dummy.iniciarJuego
			instance = new CasoAppModel(dummy.casoActual)
		}
		instance
	}
	
	@Property Caso casoActual
	@Property List<String> paisesVisitadosCorrectos
	@Property List<String> paisesVisitadosIncorrectos
	@Property Villano ordenEmitida
	
	new(Caso caso){
		casoActual = caso
		paisesVisitadosCorrectos = newArrayList
		paisesVisitadosIncorrectos = newArrayList
		ordenEmitida = null
	}
	
	def CasoAppModel viajar(String nombrePais){
		var paisSeleccionado = Mapamundi.getInstance.getPais(nombrePais)
		if(casoActual.perteneceAlPlanDeEscape(paisSeleccionado)){
			paisesVisitadosCorrectos += nombrePais
		}
		else{
			paisesVisitadosIncorrectos += nombrePais
		}
		
		casoActual.ciudadActual = paisSeleccionado
		this
	}
	
	def String paisActual(){
		casoActual.ciudadActual.nombreDelPais
	}
	
	def  setOrdenDeArresto(String villanoNombre){
		var villano = Expediente.getInstance.villanos.findFirst[nombre == villanoNombre]
		ordenEmitida = villano
	}	
	
	def getOrdenDeArresto(){
		ordenEmitida.nombre
	}
}