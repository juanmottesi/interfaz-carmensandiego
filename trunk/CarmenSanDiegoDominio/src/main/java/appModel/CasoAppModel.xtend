package appModel

import dominio.Caso
import java.util.List
import dominio.Villano
import dummyData.DummyData
import dominio.Mapamundi
import dominio.Expediente
import java.util.ArrayList

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
	
	new(Caso caso){
		casoActual = caso
		paisesVisitadosCorrectos = newArrayList
		paisesVisitadosCorrectos+= caso.ciudadActual.nombreDelPais
		paisesVisitadosIncorrectos = newArrayList
		ordenEmitida = new Villano("null")
		villanos = Expediente.getInstance.villanos
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

		
		this
	}
	
	def List<List<String>> generarPistas(){
		val pistas = new ArrayList<List<String>>()
		casoActual.ciudadActual.lugaresDeInteres.forEach[lugar | pistas += lugar.ocupante.pista(casoActual.villano)]
		pistas	
	}
	
	def  ordenDeArresto(String villanoNombre){
		var villano = Expediente.getInstance.villanos.findFirst[nombre == villanoNombre]
		ordenEmitida = villano
	}	
		
	def esFinal(){
		if(ordenEmitida == casoActual.villano){
			return "Ganaste!! =D"
		}
		return "Perdiste T_T"
	}
	
	def getStringPaisesVisitadosIncorrectos(){
		transformListToString(paisesVisitadosIncorrectos)
	}
	
	def getStringPaisesVisitadosCorrectos(){
		transformListToString(paisesVisitadosCorrectos)
	}
	
	def transformListToString(List<String> ls){
		var ret = ls.toString
		ret = ret.substring(1,ret.length-1)
		ret = ret.replace(", ", " -> ")
		ret
	}
	
	def generarPistasAppModel(){
		var ret = newArrayList()
		var primero = casoActual.ciudadActual.lugaresDeInteres.get(0)
		ret.add(new PistaAppModel(primero.nombreDelLugar, new Tupla(primero.ocupante.pista(casoActual.villano), primero.ocupante.esVillano)))
		var segundo = casoActual.ciudadActual.lugaresDeInteres.get(1)
		ret.add(new PistaAppModel(segundo.nombreDelLugar, new Tupla(segundo.ocupante.pista(casoActual.villano), segundo.ocupante.esVillano)))
		var tercero = casoActual.ciudadActual.lugaresDeInteres.get(2)
		ret.add(new PistaAppModel(tercero.nombreDelLugar, new Tupla(tercero.ocupante.pista(casoActual.villano), tercero.ocupante.esVillano)))
		
		ret	
	}
	
	def generarPistasAppModel(String pais){
		val pActual = Mapamundi.getInstance.getPais(pais)
		newArrayList() =>[
			add(new PistaAppModel((pActual.lugaresDeInteres.get(0).nombreDelLugar),(new Tupla((pActual.lugaresDeInteres.get(0).ocupante.pista(casoActual.villano)),(pActual.lugaresDeInteres.get(0).ocupante.esVillano)))))
			add(new PistaAppModel((pActual.lugaresDeInteres.get(1).nombreDelLugar),(new Tupla((pActual.lugaresDeInteres.get(1).ocupante.pista(casoActual.villano)),(pActual.lugaresDeInteres.get(1).ocupante.esVillano)))))
			add(new PistaAppModel((pActual.lugaresDeInteres.get(2).nombreDelLugar),(new Tupla((pActual.lugaresDeInteres.get(2).ocupante.pista(casoActual.villano)),(pActual.lugaresDeInteres.get(2).ocupante.esVillano)))))
		]
	}
	
	def nuevoCaso(){
		instance = null
		getInstance
	}
}