package dominio

import dominio.auxiliar.Random
import java.util.List
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import org.apache.commons.lang.StringUtils
import org.uqbar.commons.model.ObservableUtils

@Observable
class Pais {
	
	@Property String nombreDelPais
	@Property List<String> caracteristicasDelPais
	@Property List<Lugar> lugaresDeInteres
	@Property List<Pais> conexionesAereas

	new(){
		caracteristicasDelPais= newArrayList
		lugaresDeInteres= newArrayList
		conexionesAereas= newArrayList
	}
		
	def Pais obtenerSiguientePais(List<Pais> paises) {
		var pais = conexionesAereas.filter[!paises.contains(it)]
		pais.get(Random.obtenerRandom(0, pais.size))
	}
	
	def agregarCaracteristica(String nuevaCaracteristica){	
		if(StringUtils.isBlank(nuevaCaracteristica)){
			throw new UserException("Característica no valida")
		}	
		if(caracteristicasLowerCase.contains(nuevaCaracteristica.toLowerCase)){
			throw new UserException("Característica ya agregada")
		}
		caracteristicasDelPais+= nuevaCaracteristica
		ObservableUtils.firePropertyChanged(this,"caracteristicasDelPais", caracteristicasDelPais)
	}
	
	def eliminarCaracteristica(String caracteristicaSeleccionada){
		caracteristicasDelPais -= caracteristicaSeleccionada 
		ObservableUtils.firePropertyChanged(this,"caracteristicasDelPais", caracteristicasDelPais)
	}
	
	def void agregarConexion(Pais paisSeleccionado){
		if( conexionesAereas.contains(paisSeleccionado))
			throw new UserException("Conexion ya agregada")
		if(conexionesAereas.size >= 3)
			throw new UserException("Solo puede poseer 3 conexiones")
		conexionesAereas += paisSeleccionado
		paisSeleccionado.conexionesAereas += this
		ObservableUtils.firePropertyChanged(this,"conexionesAereas", conexionesAereas)
	}
	
	def void eliminarConexion(Pais paisSeleccionado){
		conexionesAereas -= paisSeleccionado
		paisSeleccionado.conexionesAereas -= this
		ObservableUtils.firePropertyChanged(this,"conexionesAereas", conexionesAereas)
	}
	
	def agregarLugar(Lugar nuevoLugar){		
		if(lugaresDeInteres.contains(nuevoLugar))
			throw new UserException("Lugar ya agregado, elija otro")
		if(lugaresDeInteres.size == 3)
			throw new UserException("Solo puede poseer 3 lugares de interés")
		lugaresDeInteres += nuevoLugar
		ObservableUtils.firePropertyChanged(this,"lugaresDeInteres", lugaresDeInteres)
	}
	
	def eliminarLugar(Lugar lugarSeleccionado) {
		lugaresDeInteres -= lugarSeleccionado
		ObservableUtils.firePropertyChanged(this,"lugaresDeInteres", lugaresDeInteres)
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
		if (lugaresDeInteres.size != 3){
			throw new UserException("Se necesitan tres Lugares de Interés")
		}
	}
	
}