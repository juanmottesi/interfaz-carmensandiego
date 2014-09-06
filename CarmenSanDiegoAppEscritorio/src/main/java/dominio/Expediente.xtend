package dominio

import java.util.List
import dominio.auxiliar.Random
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class Expediente {
	
	private static Expediente instance = null
	
	@Property List<Villano> villanos
	
	
	//Para agregar y editar Villano
	@Property Villano villanoSeleccionado
	@Property Villano nuevoVillano
	
	new(){
		villanos = newArrayList
	}
	
	static def getInstance() {
		if (instance == null) {
			instance = new Expediente
		}
		instance
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
	
	def agregarVillano() {
		if(nuevoVillano.nombre == null || !(nuevoVillano.nombre.length > 0))
			throw new UserException("Debe ingresar el nombre del Villano")
		if(villanosNombreLowerCase.contains(nuevoVillano.nombre.toLowerCase))
			throw new UserException("Villano ya agregado")		
		villanos += nuevoVillano
		actualizarVillanos
	}
	
	def villanosNombreLowerCase() {
		villanos.map[nombre.toLowerCase]
	}
	
	def actualizarVillanos() {
		var p= villanos
		villanos= null
		villanos= p
		villanoSeleccionado= null
		nuevoVillano= null
	}
	
}