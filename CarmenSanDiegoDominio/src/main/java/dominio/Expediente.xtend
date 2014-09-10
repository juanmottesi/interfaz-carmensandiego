package dominio

import java.util.List
import dominio.auxiliar.Random
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class Expediente implements InterfazVillanos {
	
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
	
	def puedoIniciar() {
		if (!(villanos.size > 0)){
			throw new UserException("Faltan crear mas villanos")		
		}
	}
	
	def obtenerVillano() {
		villanos.get(Random.obtenerRandom(0,villanos.size -1))	
	}
	
	override agregarVillano() {
		
		if(nuevoVillano.nombre == null || !(nuevoVillano.nombre.length > 0))
			throw new UserException("Debe ingresar el nombre del Villano")
		if(villanosNombreLowerCase.contains(nuevoVillano.nombre.toLowerCase))
			throw new UserException("Villano ya agregado")
		if(nuevoVillano.sexo == null) throw new UserException("El sexo del villano tiene que ser femenino o masculino")
		nuevoVillano.sexo = nuevoVillano.sexo.toLowerCase
		if(nuevoVillano.sexo != "masculino"){
			if(nuevoVillano.sexo != "femenino") throw new UserException("El sexo del villano tiene que ser femenino o masculino")
		}
			
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
	
	override obtenerInputHobbie() {
		"nuevoVillano.nuevoHobbie"
	}
		
	override eliminarHobieSeleccionado() {
		nuevoVillano.eliminarHobieSeleccionado
	}
	
	override agregarHobbie() {
		nuevoVillano.agregarHobbie
	}
	
	override listaHobbies() {
		"nuevoVillano.hobbies"
	}
	
	override hobbiesSeleccionado() {
		"nuevoVillano.hobbieSeleccionado"
	}
	
	override actualizar() {
		nuevoVillano.actualizar
	}
	
	override agregarSeniasParticulares() {
		nuevoVillano.agregarSeniasParticulares
	}
		
	override eliminarSeniasParticularesSeleccionado() {
		nuevoVillano.eliminarSeniasParticularesSeleccionado
	}
	
	override obtenerInputSeniasParticulares() {
		"nuevoVillano.nuevaSeniaParticular"
	}
	
	override listaSeniasParticulares() {
		"nuevoVillano.seniasParticulares"
	}
	
	override seniasParticularesSeleccionada() {
		"nuevoVillano.seniaParticularSeleccionada"
	}
	
	override soyEditar() {
		false
	}
	
	override obtenerTitulo() {
		"Expediente - Nuevo Villano"	
	}
	
	
}