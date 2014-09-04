package dominio

import java.util.List
import dominio.auxiliar.Random
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class Mapamundi {
	
	@Property List<Pais> paises
	@Property Pais paisSeleccionado
	
	new(){
		paises = newArrayList
	}
	
	def puedoIniciar() {
		if (!(paises.size >= 3)){
			throw new UserException("Faltan crear mas paises")		
		}
	}
	
	def agregar(Pais pais) {
		if(!paises.contains(pais)){
			paises += pais
		}
		else{
			throw new UserException("Pais ya agregado")
		}		
	}
	
	
	def primerPais(){
		paises.get(Random.obtenerRandom(0, paises.size))
	}
	
	
	def planDeEscape() {

		var nRandom = Random.obtenerRandom(2, paises.size)  -1
		var ret = newArrayList
		ret.add(primerPais)
		for(i : 0..nRandom){
			var Pais p = ret.get(ret.size -1)
			ret.add(p.obtenerSiguientePais(ret))
		}
		ret
		
	}
	
	
	
}