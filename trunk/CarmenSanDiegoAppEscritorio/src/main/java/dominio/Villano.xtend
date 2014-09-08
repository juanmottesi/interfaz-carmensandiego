package dominio

import java.util.List
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException

@Observable
class Villano implements InterfazVillanos{
	@Property String nombre
	@Property List<String> seniasParticulares
	@Property List<String> hobbies
	@Property String sexo
	
	//Para Edicion De Hobbie
	@Property String hobbieSeleccionado
	@Property String nuevoHobbie
	
	//Para Edicion de Senias Particulares
	@Property String nuevaSeniaParticular
	@Property String seniaParticularSeleccionada
	
	new(){
		this.seniasParticulares = newArrayList
		this.hobbies = newArrayList
	}
	
	new(String nombre, List<String> seniasParticulares, List<String> hobbies, String sexo){
		this.nombre = nombre
		this.seniasParticulares = seniasParticulares
		this.hobbies = hobbies
		this.sexo = sexo
	}
	
	override obtenerInputHobbie() {
		"nuevoHobbie"
	}
	
	override botonEliminarHobbie() {
		"hobbieSeleccionado"
	}
	
	override eliminarHobieSeleccionado() {
		hobbies -= hobbieSeleccionado
		actualizar
	}
	
	override agregarHobbie() {
		if(hobbiesLowerCase.contains(nuevoHobbie.toLowerCase))
			throw new UserException("Hobbie ya agregada")
		hobbies += nuevoHobbie
		actualizar
	}
	
	override listaHobbies() {
		"hobbies"
	}
	
	override hobbiesSeleccionado() {
		"hobbieSeleccionado"
	}
	
	override actualizar() {
		//Actualizar Hobbies
		var hob= hobbies 
		hobbies= null
		hobbies= hob  
		hobbieSeleccionado= null
		nuevoHobbie= null
		//Actualizar Senias Particulares
		var sp= seniasParticulares
		seniasParticulares= null
		seniasParticulares= sp  
		hobbieSeleccionado= null
		nuevoHobbie= null
		
	}
	
	override agregarSeniasParticulares() {
		if(seniasParticularesLowerCase.contains(nuevaSeniaParticular.toLowerCase))
			throw new UserException("Seña Particular ya agregada")
		seniasParticulares += nuevaSeniaParticular
		actualizar
	}
		
	override botonEliminarSeniasParticulares() {
		"seniaParticularSeleccionada"
	}
	
	override eliminarSeniasParticularesSeleccionado() {
		seniasParticulares-= seniaParticularSeleccionada
		actualizar
	}
	
	override obtenerInputSeniasParticulares() {
		"nuevaSeniaParticular"
	}
	
	override listaSeniasParticulares() {
		"seniasParticulares"
	}
	
	override seniasParticularesSeleccionada() {
		"seniaParticularSeleccionada"
	}
	
	def hobbiesLowerCase() {
		hobbies.map[toLowerCase]		
	}
	
	def seniasParticularesLowerCase() {
		seniasParticulares.map[toLowerCase]
	}
}