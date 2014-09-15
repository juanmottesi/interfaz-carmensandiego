package dominio

import org.uqbar.commons.utils.Observable
import dominio.auxiliar.Random
import java.util.List

abstract class Lugar {
	
	@Property String nombreDelLugar
	@Property Ocupante ocupante
	
	new(){
		ocupante = new Cuidador
	}

	//def String obtenerPista()
	
	def void generarInformantes(Pais siguientePais, Villano villano)
	
	def generarInformantes() {
		ocupante = new Informante(newArrayList =>[
			add("CUIDADO DETECTIVE!!")
		])
	}
	
	def ubicarVillano(Villano villano) {
		ocupante = villano
	}
}


@Observable
class Biblioteca extends Lugar{
	
	new(){
		super()
		nombreDelLugar = "Biblioteca"
	}
	
	override generarInformantes(Pais siguientePais, Villano villano) {
		ocupante = new Informante(newArrayList =>[
			
			add(siguientePais.obtenerCaracteristica(it))
			add(villano.obtenerSeniaParticular(it))
			if(Random.obtenerRandom(1,11) <= 5){ 
				add(villano.obtenerHobbie(it))				
			}
		])
	}
		
}

@Observable
class Club extends Lugar{
	
	new(){
		super()
		nombreDelLugar = "Club"
	}
	
	override generarInformantes(Pais siguientePais, Villano villano) {
		ocupante = new Informante(newArrayList =>[
			
			add(villano.obtenerSeniaParticular(it))
			add(villano.obtenerSeniaParticular(it))
			
			if(Random.obtenerRandom(1,11) <= 7){ 
				add(villano.obtenerHobbie(it))				
			}
		])
	}
		
}

@Observable
class Embajada extends Lugar{
	
	new(){
		super()
		nombreDelLugar = "Embajada"
	}
	
	override generarInformantes(Pais siguientePais, Villano villano) {
		ocupante = new Informante(newArrayList =>[
			add(siguientePais.obtenerCaracteristica(it))
			add(siguientePais.obtenerCaracteristica(it))
		])
	}
		
}

@Observable
class Banco extends Lugar{
	
	new(){
		super()
		nombreDelLugar = "Banco"
	}
	
	override generarInformantes(Pais siguientePais, Villano villano) {
		ocupante = new Informante(newArrayList =>[	
			add(siguientePais.obtenerCaracteristica(it))
			add(villano.obtenerSeniaParticular(it))
			])
	}
	

	
}