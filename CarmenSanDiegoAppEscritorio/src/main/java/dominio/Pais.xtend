package dominio

import java.util.List
import dominio.auxiliar.Random
import exception.ExceptionPaisYaAgregado
import org.uqbar.commons.utils.Observable

@Observable
class Pais {
	
	@Property String nombreDelPais
	@Property List<String> caracteristicasDelPais
	@Property List<Lugar> lugaresDeInteres
	@Property List<Pais> conexionesAereas
	
	new(){}
	
	new(String nombreDelPais, List<String> caracteristicasDelPais, 
		List<Lugar> lugaresDeInteres, List<Pais> conexionesAereas
	){
		this.nombreDelPais = nombreDelPais
		this.caracteristicasDelPais = caracteristicasDelPais
		this.lugaresDeInteres = lugaresDeInteres
		this.conexionesAereas = conexionesAereas
	}
	
	def void agregarConeccionA(Pais p){
		if(!conexionesAereas.contains(p)){
			conexionesAereas += p
			p.conexionesAereas += this
			
		}
		else
			throw new ExceptionPaisYaAgregado
	}
	
	def Pais obtenerSiguientePais(List<Pais> paises) {
		var pais = conexionesAereas.filter[!paises.contains(it)]
		pais.get(Random.obtenerRandom(0, pais.size))
	}
	
}