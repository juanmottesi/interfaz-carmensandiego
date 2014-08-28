package dominio

import java.util.List
import exception.ExceptionVillanoRepetido
import exception.ExceptionPaisRepetido
import exception.ExceptionFaltanPaisesOVillanos
import exception.ExceptionFaltanPaises

class Detective {
	
	@Property List<Villano> expedientes
	@Property List<Pais> mapamundi
	@Property Caso casoActual
	
	new(){
		this.expedientes = newArrayList
		this.mapamundi = newArrayList
	}
	
	def void agregarVillano(Villano villano){
		if(expedientes.contains(villano)){
			throw new ExceptionVillanoRepetido	
		}
		expedientes += villano
	}
	
	def void agregarPais(Pais pais){
		if(mapamundi.contains(pais)){
			throw new ExceptionPaisRepetido	
		}
		mapamundi += pais
	}
	
	def void iniciarJuego(){
		if(mapamundi.size == 0 || expedientes.size == 0){
			throw new ExceptionFaltanPaisesOVillanos
		}
		if(mapamundi.size < 3){
			throw new ExceptionFaltanPaises
		}
		casoActual = new Caso(mapamundi,expedientes)	
	}
	

}