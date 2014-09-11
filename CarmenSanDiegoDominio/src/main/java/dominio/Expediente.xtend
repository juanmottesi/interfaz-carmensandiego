package dominio

import java.util.List
import dominio.auxiliar.Random
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import org.apache.commons.lang.StringUtils
import org.uqbar.commons.model.ObservableUtils

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
		if(nuevoVillano.nombre == null || StringUtils.isEmpty(nuevoVillano.nombre))
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
		ObservableUtils.firePropertyChanged(this,"villanos",villanos)
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