package dominio

import java.util.List
import org.uqbar.commons.utils.Observable

@Observable
class Villano {
	@Property String nombre
	@Property List<String> seniasParticulares
	@Property List<Hobbie> hobbies
	@Property String sexo
	
	new(){
		this.seniasParticulares = newArrayList
		this.hobbies = newArrayList
	}
	
	new(String nombre, List<String> seniasParticulares, List<Hobbie> hobbies, String sexo){
		this.nombre = nombre
		this.seniasParticulares = seniasParticulares
		this.hobbies = hobbies
		this.sexo = sexo
	}
	
}