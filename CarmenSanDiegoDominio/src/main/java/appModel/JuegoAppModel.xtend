package appModel

import dominio.Detective
import dominio.Pais
import java.util.List
import dominio.Villano

import org.uqbar.commons.utils.Observable
import dominio.Expediente
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.arena.graphics.Image

@Observable
class JuegoAppModel {
	
	@Property Detective detective
	
	@Property List<Pais> destinosFallidos
	
	@Property List<Pais> planDeEscape	
	
	@Property Villano ordenDeArresto
	
	@Property Pais siguientePais

	@Property Image imagen

	new(Detective detective){
		_detective = detective
		_planDeEscape = newArrayList
		planDeEscape += detective.casoActual.ciudadActual
		_destinosFallidos = newArrayList
		_ordenDeArresto = null
		
	}
	
	def getTodosLosVillanos(){
		Expediente.instance.villanos
	}
	
	def viajar(){
		this.agregarALista
		detective.viajarA(siguientePais)
		ObservableUtils.firePropertyChanged(this,"primerLugar",primerLugar)
		ObservableUtils.firePropertyChanged(this,"segundoLugar",segundoLugar)
		ObservableUtils.firePropertyChanged(this,"tercerLugar",tercerLugar)
	}

	def agregarALista(){
		if(detective.perteneceAlPlanDeEscape(siguientePais)){
			if(!planDeEscape.contains(siguientePais)){
				planDeEscape += siguientePais
				ObservableUtils.firePropertyChanged(this,"planDeEscape", planDeEscape)	
			}
		}
		else{
			if(!destinosFallidos.contains(siguientePais)){
				destinosFallidos += siguientePais
				ObservableUtils.firePropertyChanged(this,"destinosFallidos", destinosFallidos)	
			}	
		}
		
	}
	
	def getPrimerLugar(){
		detective.casoActual.ciudadActual.lugaresDeInteres.get(0)
	}
	
	def getSegundoLugar(){
		detective.casoActual.ciudadActual.lugaresDeInteres.get(1)
	}
	
	def getTercerLugar(){
		detective.casoActual.ciudadActual.lugaresDeInteres.get(2)
	}
}
