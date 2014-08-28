package dominio

import java.util.List

class Villano {
	@Property String nombre
	@Property List<String> seniasParticulares
	@Property List<String> hobbies
	@Property String sexo
	
	new(String nombre, List<String> seniasParticulares, List<String> hobbies, String sexo){
		this.nombre = nombre
		this.seniasParticulares = seniasParticulares
		this.hobbies = hobbies
		this.sexo = sexo
	}
	
}