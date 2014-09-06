package dominio

import java.util.List
import dominio.auxiliar.Random
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class Expediente {
	
	@Property List<Villano> villanos
	@Property Villano villanoSeleccionado
	
	new(){
		villanos = newArrayList
	}
	
	def agregar(Villano villano) {
		if(!villanos.contains(villano)){
			villanos += villano
		}
		else{
			throw new UserException("Villano ya agregado")
		}	
	}
	
	def puedoIniciar() {
		if (!(villanos.size > 0)){
			throw new UserException("Faltan crear mas villanos")		
		}
	}
	
	def obtenerVillano() {
		villanos.get(Random.obtenerRandom(0,villanos.size -1))	
	}
	
}