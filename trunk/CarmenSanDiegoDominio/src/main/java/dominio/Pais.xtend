package dominio

import dominio.auxiliar.Random
import java.util.List
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import org.apache.commons.lang.StringUtils

@Observable
class Pais {
	
	@Property String nombreDelPais
	@Property List<String> caracteristicasDelPais
	@Property List<Lugar> lugaresDeInteres
	@Property List<Pais> conexionesAereas
//	
//	//Para Edicion De Caracteristicas
//	@Property String caracteristicaSeleccionada
//	@Property String nuevaCaracteristica
//	
//	//Para Edicion De Conexiones
//	@Property Pais conexionSeleccionada
//	@Property Pais nuevaConexion
//	@Property List<Pais> paises
//	
//	//Para edicion de Lugares
//	@Property Lugar lugarSeleccionado
//	@Property Lugar nuevoLugar
//	@Property List<Lugar> lugaresPosibles
//	
	new(){
		caracteristicasDelPais= newArrayList
		lugaresDeInteres= newArrayList
		conexionesAereas= newArrayList
	}
//	
//	new(String nombreDelPais, List<String> caracteristicasDelPais, 
//		List<Lugar> lugaresDeInteres, List<Pais> conexionesAereas
//	){
//		this.nombreDelPais = nombreDelPais
//		this.caracteristicasDelPais = caracteristicasDelPais
//		this.lugaresDeInteres = lugaresDeInteres
//		this.conexionesAereas = conexionesAereas
//	}
		
	def Pais obtenerSiguientePais(List<Pais> paises) {
		var pais = conexionesAereas.filter[!paises.contains(it)]
		pais.get(Random.obtenerRandom(0, pais.size))
	}
	
	def agregarCaracteristica(String nuevaCaracteristica){		
		if(caracteristicasLowerCase.contains(nuevaCaracteristica.toLowerCase))
			throw new UserException("Característica ya agregada")
		caracteristicasDelPais+= nuevaCaracteristica
		//actualizar
	}
	
	def eliminarCaracteristica(String caracteristicaSeleccionada){
		caracteristicasDelPais -= caracteristicaSeleccionada 
		//actualizar
	}
	
	def void agregarConexion(Pais paisSeleccionado){
		if( conexionesAereas.contains(paisSeleccionado))
			throw new UserException("Conexion ya agregada")
		if(conexionesAereas.size >= 3)
			throw new UserException("Solo puede poseer 3 conexiones")
		conexionesAereas += paisSeleccionado
		paisSeleccionado.conexionesAereas += this
		//actualizar
	}
	
	def void eliminarConexion(Pais paisSeleccionado){
		conexionesAereas -= paisSeleccionado
		paisSeleccionado.conexionesAereas -= this
		//actualizar
	}
	
	def agregarLugar(Lugar nuevoLugar){		
		if(lugaresDeInteres.contains(nuevoLugar))
			throw new UserException("Lugar ya agregado, elija otro")
		if(lugaresDeInteres.size == 3)
			throw new UserException("Solo puede poseer 3 lugares de interés")
		lugaresDeInteres += nuevoLugar
		//actualizar
	}
	
	def eliminarLugar(Lugar lugarSeleccionado) {
		lugaresDeInteres -= lugarSeleccionado
		//actualizar
	}
	
	def caracteristicasLowerCase(){
		caracteristicasDelPais.map[toLowerCase]
	}
	
	def esCorrecto(List<Pais> paises) {
		if (paises.filter[it.nombreDelPais == this.nombreDelPais].size != 1){
			throw new UserException("Pais ya agregado")
		} 
		if(StringUtils.isEmpty(this.nombreDelPais) || StringUtils.isBlank(this.nombreDelPais)){ 
			throw new UserException("Nombre del pais Incorrecto")	
		}
	}
	
}