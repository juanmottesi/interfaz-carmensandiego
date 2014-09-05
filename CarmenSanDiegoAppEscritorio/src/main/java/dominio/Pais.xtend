package dominio

import dominio.auxiliar.Random
import java.util.List
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class Pais {
	
	@Property String nombreDelPais
	@Property List<String> caracteristicasDelPais
	@Property List<Lugar> lugaresDeInteres
	@Property List<Pais> conexionesAereas
	
	//Para Edicion De Caracteristicas
	@Property String caracteristicaSeleccionada
	@Property String nuevaCaracteristica
	
	//Para Edicion De Conexiones
	@Property Pais conexionSeleccionada
	@Property Pais nuevaConexion
	
	//Para edicion de Lugares
	@Property Lugar lugarSeleccionado
	@Property Lugar nuevoLugar
	
	new(){
		caracteristicasDelPais= newArrayList
		lugaresDeInteres= newArrayList
		conexionesAereas= newArrayList
	}
	
	new(String nombreDelPais, List<String> caracteristicasDelPais, 
		List<Lugar> lugaresDeInteres, List<Pais> conexionesAereas
	){
		this.nombreDelPais = nombreDelPais
		this.caracteristicasDelPais = caracteristicasDelPais
		this.lugaresDeInteres = lugaresDeInteres
		this.conexionesAereas = conexionesAereas
	}
	
	def eliminarConexion(Pais pais){
		conexionesAereas-= pais
	}
	
	def Pais obtenerSiguientePais(List<Pais> paises) {
		var pais = conexionesAereas.filter[!paises.contains(it)]
		pais.get(Random.obtenerRandom(0, pais.size))
	}
	
	def agregarCaracteristica(){		
		if(caracteristicasLowerCase.contains(nuevaCaracteristica.toLowerCase))
			throw new UserException("Característica ya agregada")
		caracteristicasDelPais+= nuevaCaracteristica
		actualizar
	}
	
	def eliminarCaracteristica(){
		caracteristicasDelPais -= caracteristicaSeleccionada 
		actualizar
	}
	
	def void agregarConexion(){
		if( conexionesAereas.contains(nuevaConexion))
			throw new UserException("Conexion ya agregada")
		if(conexionesAereas.size >= 3)
			throw new UserException("Solo puede poseer 3 conexiones")
		conexionesAereas += nuevaConexion
		nuevaConexion.conexionesAereas += this
		actualizar
	}
	
	def void eliminarConexion(){
		conexionesAereas -= conexionSeleccionada
		conexionSeleccionada.conexionesAereas -= this
		actualizar
	}
	
	def agregarLugar(){		
		if(lugaresDeInteres.contains(nuevoLugar))
			throw new UserException("Lugar ya agregado, elija otro")
		if(lugaresDeInteres.size == 3)
			throw new UserException("Solo puede poseer 3 lugares de interés")
		lugaresDeInteres += nuevoLugar
		actualizar
	}
	
	def eliminarLugar() {
		lugaresDeInteres -= lugarSeleccionado
		actualizar
	}
	
	def actualizar(){
		//Actualizar caracteristicas
		var carac= caracteristicasDelPais 
		caracteristicasDelPais= null
		caracteristicasDelPais= carac  
		caracteristicaSeleccionada= null
		nuevaCaracteristica= null
		//Actualizar Conexiones
		var conex= conexionesAereas
		conexionesAereas= null
		conexionesAereas= conex
		nuevaConexion= null
		conexionSeleccionada= null
		//Actualizar Lugares
		var lugares= lugaresDeInteres
		lugaresDeInteres= null
		lugaresDeInteres= lugares
		nuevoLugar= null
		lugarSeleccionado= null
	}
	
	def caracteristicasLowerCase(){
		caracteristicasDelPais.map[toLowerCase]
	}
	
}