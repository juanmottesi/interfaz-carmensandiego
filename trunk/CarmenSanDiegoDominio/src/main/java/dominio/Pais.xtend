package dominio

import dominio.auxiliar.Random
import java.util.List
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class Pais implements InterfazPaises {
	
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
	@Property List<Pais> paises
	
	//Para edicion de Lugares
	@Property Lugar lugarSeleccionado
	@Property Lugar nuevoLugar
	@Property List<Lugar> lugaresPosibles
	
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
		
	def Pais obtenerSiguientePais(List<Pais> paises) {
		var pais = conexionesAereas.filter[!paises.contains(it)]
		pais.get(Random.obtenerRandom(0, pais.size))
	}
	
	override agregarCaracteristica(){		
		if(caracteristicasLowerCase.contains(nuevaCaracteristica.toLowerCase))
			throw new UserException("Característica ya agregada")
		caracteristicasDelPais+= nuevaCaracteristica
		actualizar
	}
	
	override eliminarCaracteristica(){
		caracteristicasDelPais -= caracteristicaSeleccionada 
		actualizar
	}
	
	override void agregarConexion(){
		if( conexionesAereas.contains(nuevaConexion))
			throw new UserException("Conexion ya agregada")
		if(conexionesAereas.size >= 3)
			throw new UserException("Solo puede poseer 3 conexiones")
		conexionesAereas += nuevaConexion
		nuevaConexion.conexionesAereas += this
		actualizar
	}
	
	override void eliminarConexion(){
		conexionesAereas -= conexionSeleccionada
		conexionSeleccionada.conexionesAereas -= this
		actualizar
	}
	
	override agregarLugar(){		
		if(lugaresDeInteres.contains(nuevoLugar))
			throw new UserException("Lugar ya agregado, elija otro")
		if(lugaresDeInteres.size == 3)
			throw new UserException("Solo puede poseer 3 lugares de interés")
		lugaresDeInteres += nuevoLugar
		actualizar
	}
	
	override eliminarLugar() {
		lugaresDeInteres -= lugarSeleccionado
		actualizar
	}
	
	override actualizar(){
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
	
	override obtenerInputCaracteristica() {
		"nuevaCaracteristica"
	}
	
	override listaCaracteristicas() {
		"caracteristicasDelPais"
	}
	
	override caracteristicasSeleccionada(){
		"caracteristicaSeleccionada"
	}
		
	override conexionesSeleccionada() {
		"conexionSeleccionada"
	}
	
	override listaConexiones() {
		"conexionesAereas"
	}
	
	override obtenerInputConexiones() {
		"nuevaConexion"
	}
	
	def getPaises(){
		(Mapamundi.instance.paises.filter[each | !(each == this)]).toList
	}
		
	override listaLugares() {
		"lugaresDeInteres"
	}
	
	override obtenerInputLugares() {
		"nuevoLugar"
	}
		
	override lugaresSeleccionada() {
		"lugarSeleccionado"
	}
		
	def getLugaresPosibles(){
		Mapamundi.instance.lugaresPosibles
	}
	
	override obtenerTitulo(){
		"Mapamundi - Editar Pais"
	}
	
	override soyEditar(){
		true
	}
	
	override agregarPais() {
		throw new Exception("Error!")
	}
	
}