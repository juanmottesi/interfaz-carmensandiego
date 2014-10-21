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
			instance = new CasoAppModel(new DummyData().crearJuegoDummy.casoActual)
		}
		instance
	}
	
	@Property Caso casoActual
	@Property List<Pais> paisesVisitadosCorrectos
	@Property List<Pais> paisesVisitadosIncorrectos
	@Property Villano ordenEmitida
	
	new(Caso caso){
		casoActual = caso
		paisesVisitadosCorrectos = newArrayList
		paisesVisitadosCorrectos = newArrayList
		ordenEmitida = null
	}
	
	def CasoAppModel viajar(String nombrePais){
		var paisSeleccionado = Mapamundi.getInstance.paises.findFirst[nombrePais == nombrePais]
		if(casoActual.perteneceAlPlanDeEscape(paisSeleccionado)){
			paisesVisitadosCorrectos += paisSeleccionado
		}
		else{
			paisesVisitadosIncorrectos += paisSeleccionado
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