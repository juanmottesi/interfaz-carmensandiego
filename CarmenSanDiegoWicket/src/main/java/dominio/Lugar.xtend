package dominio

import org.uqbar.commons.utils.Observable
import dominio.auxiliar.Random
import java.util.List
import org.uqbar.commons.model.Entity


abstract class Lugar extends Entity {
	
	@Property String nombreDelLugar
	@Property Ocupante ocupante
	@Property String imagen
	
	new(){
		ocupante = new Cuidador
	}
	
	def void generarInformantes(Pais siguientePais, Villano villano)
	
	def generarInformantes() {
		ocupante = new Informante(newArrayList =>[
			add("CUIDADO DETECTIVE!!")
		])
	}
	
	def ubicarVillano(Villano villano) {
		ocupante = villano
	}
	
	def List<String> pista(Villano villano){
		ocupante.pista(villano)
	}
	
}


@Observable
class Biblioteca extends Lugar{
	
	new(){
		super()
		nombreDelLugar = "Biblioteca"
		imagen = "images/biblioteca.jpg"
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
		imagen = "images/club.jpg"
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
		imagen = "images/embajada.jpg"
	}
	
	override generarInformantes(Pais siguientePais, Villano villano) {
		var lista = newArrayList
		lista.add(siguientePais.obtenerCaracteristica(lista))
		lista.add(siguientePais.obtenerCaracteristica(lista))
		ocupante = new Informante(lista)
	}
		
}

@Observable
class Banco extends Lugar{
	
	new(){
		super()
		nombreDelLugar = "Banco"
		imagen = "images/banco.jpg"
	}
	
	override generarInformantes(Pais siguientePais, Villano villano) {
		var lista = newArrayList
		lista.add(siguientePais.obtenerCaracteristica(lista))
		lista.add(villano.obtenerSeniaParticular(lista))
		ocupante = new Informante(lista)
	}
	

	
}