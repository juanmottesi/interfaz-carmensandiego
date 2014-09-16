package dominio

import java.util.List
import org.uqbar.commons.utils.Observable
import org.apache.commons.lang.StringUtils
import org.uqbar.commons.model.UserException
import org.uqbar.commons.model.ObservableUtils
import java.util.ArrayList
import dominio.auxiliar.Random

@Observable
class Villano implements Ocupante{
	@Property String nombre
	@Property List<String> seniasParticulares
	@Property List<String> hobbies
	@Property Sexo sexo

	new(){
		this.seniasParticulares = newArrayList
		this.hobbies = newArrayList
	}
	
	def agregarSeniaParticular(String nuevaSeniaParticular) {
		if(StringUtils.isBlank(nuevaSeniaParticular)){
			throw new UserException("Senia Particular no valida")
		}	
		if(seniasParticularLowerCase.contains(nuevaSeniaParticular.toLowerCase)){
			throw new UserException("Senia Particular ya agregada")
		}
		seniasParticulares+= nuevaSeniaParticular
		ObservableUtils.firePropertyChanged(this,"seniasParticulares", seniasParticulares)
	}
		
	def eliminarSeniaParticular(String seniaSeleccionada) {
		seniasParticulares -= seniaSeleccionada 
		ObservableUtils.firePropertyChanged(this,"seniasParticulares", seniasParticulares)
	}
	
	def eliminarHobbie(String hobbieSeleccionada) {
		hobbies -= hobbieSeleccionada 
		ObservableUtils.firePropertyChanged(this,"hobbies", hobbies)
	}
	
	def agregarHobbie(String nuevoHobbie) {
		if(StringUtils.isBlank(nuevoHobbie)){
			throw new UserException("Hobbie no valido")
		}	
		if(hobbiesLowerCase.contains(nuevoHobbie.toLowerCase)){
			throw new UserException("Hobbie ya agregada")
		}
		hobbies+= nuevoHobbie
		ObservableUtils.firePropertyChanged(this,"hobbies", hobbies)
	}

	def seniasParticularLowerCase() {
		seniasParticulares.map[toLowerCase]		
	}

	def hobbiesLowerCase() {
		hobbies.map[toLowerCase]		
	}
	
	def esCorrecto(List<Villano> villanos) {
		if (StringUtils.isBlank(this.nombre)){ 
			throw new UserException("Nombre del Villano Incorrecto")	
		}
		if (villanos.filter[it.nombre == this.nombre].size != 1){
			throw new UserException("Villano ya agregado")
		} 

	}
	
	def String obtenerSeniaParticular(ArrayList<String> lista) {
		var aux = seniasParticulares.get(Random.obtenerRandom(0,seniasParticulares.size))
		if(lista.contains(aux)){obtenerSeniaParticular(lista)}
		aux
	}
	
	def String obtenerHobbie(ArrayList<String> lista) {
		var aux = hobbies.get(Random.obtenerRandom(0,hobbies.size-1))
		if(lista.contains(aux)){obtenerHobbie(lista)}
		aux
	}

}