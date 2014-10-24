package appModel

import dominio.Caso
import java.util.List
import dominio.Villano
import dummyData.DummyData
import dominio.Mapamundi
import dominio.Expediente

class CasoAppModel {
	
	private static CasoAppModel instance = null
		
	static def getInstance() {
		if (instance == null) {
			var dummyDetective = new DummyData().crearJuegoDummy
			dummyDetective.iniciarJuego
			instance = new CasoAppModel(dummyDetective.casoActual)
		}
		instance
	}
	
	@Property Caso casoActual
	@Property List<String> paisesVisitadosCorrectos
	@Property List<String> paisesVisitadosIncorrectos
	@Property Villano ordenEmitida
	@Property List<Villano> villanos
	@Property List<List<String>> pistas	
	
	new(Caso caso){
		casoActual = caso
		paisesVisitadosCorrectos = newArrayList
		paisesVisitadosCorrectos+= caso.ciudadActual.nombreDelPais
		paisesVisitadosIncorrectos = newArrayList
		ordenEmitida = new Villano("null")
		villanos = Expediente.getInstance.villanos
		generarPistas()
	}
	
	def CasoAppModel viajar(String nombrePais){
		var paisSeleccionado = Mapamundi.getInstance.getPais(nombrePais)
		if(casoActual.perteneceAlPlanDeEscape(paisSeleccionado)){
			if(!paisesVisitadosCorrectos.contains(nombrePais)){
				paisesVisitadosCorrectos += nombrePais
			}
		}
		else{
			if(!paisesVisitadosIncorrectos.contains(nombrePais)){
				paisesVisitadosIncorrectos += nombrePais
			}
		}
		
		casoActual.ciudadActual = paisSeleccionado
		generarPistas()
		
		this
	}
	
	def generarPistas(){
		pistas = newArrayList
		casoActual.ciudadActual.lugaresDeInteres.forEach[lugar | pistas += lugar.ocupante.pista(casoActual.villano)]
	}
	
	def String paisActual(){
		casoActual.ciudadActual.nombreDelPais
	}
	
	def  ordenDeArresto(String villanoNombre){
		var villano = Expediente.getInstance.villanos.findFirst[nombre == villanoNombre]
		ordenEmitida = villano
	}	
	
	def ordenDeArresto(){
		ordenEmitida.nombre
	}
	
	def esFinal(){
		if(ordenEmitida == casoActual.villano){
			return "Ganaste!! =D"
		}
		return "Perdiste T_T"
	}
}