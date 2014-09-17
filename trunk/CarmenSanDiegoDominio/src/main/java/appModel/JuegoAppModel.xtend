package appModel

import dominio.Detective
import dominio.Pais
import java.util.List
import dominio.Villano

import org.uqbar.commons.utils.Observable
import dominio.Expediente
import org.uqbar.commons.model.ObservableUtils

@Observable
class JuegoAppModel {
	
	@Property Detective detective
	
	@Property List<Pais> destinosFallidos
	
	@Property List<Pais> planDeEscape	
	
	@Property Villano ordenDeArresto
	
	@Property Pais siguientePais

	new(Detective detective){
		_detective = detective
		_planDeEscape = newArrayList
		_destinosFallidos = newArrayList
	}
	
	def getTodosLosVillanos(){
		Expediente.instance.villanos
	}
	
	def viajar(){
		this.agregarALista
		detective.viajarA(siguientePais)
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

}