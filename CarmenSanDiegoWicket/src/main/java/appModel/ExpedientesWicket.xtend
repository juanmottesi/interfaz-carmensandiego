package appModel

import dominio.Villano
import java.util.List
import dominio.Expediente

class ExpedientesWicket {
	
	@Property Villano villanoSeleccionado
	@Property List<Villano> villanos
	
	public new(){}
	
	def void eliminarVillanoSeleccionado() {
		Expediente.getInstance.eliminarVillano(villanoSeleccionado)
		
		villanoSeleccionado = null
	}
	
	def void buscarVillanos() {
		villanos = newArrayList 
		villanos = Expediente.getInstance.villanos 
	}
	
}