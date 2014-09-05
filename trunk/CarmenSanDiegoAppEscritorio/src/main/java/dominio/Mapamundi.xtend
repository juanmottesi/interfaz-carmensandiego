package dominio

import dominio.auxiliar.Random
import java.util.List
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class Mapamundi {
	
	@Property List<Pais> paises
	@Property List<Lugar> lugaresPosibles
	
	//Para agregar y editar Pais
	@Property Pais paisSeleccionado
	@Property Pais nuevoPais
	
	new(){
		paises = newArrayList
		lugaresPosibles= newArrayList
		lugaresPosibles.addAll(#[(new Embajada), (new Banco), (new Biblioteca), (new Club)])
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
	

	def agregarPais(){
		if(paisesNombreLowerCase.contains(nuevoPais.nombreDelPais.toLowerCase))
			throw new UserException("Pais ya agregado")
		if(nuevoPais.nombreDelPais == null)
			throw new UserException("Debe ingresar el nombre del Pais")
		if(nuevoPais.lugaresDeInteres.size < 3)
			throw new UserException("Debe seleccionar 3 lugares de Interés")
		paises += nuevoPais
		actualizarPaises
	}

	def editar() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}


	def eliminar() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	
	def nuevo() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	
	def eliminarPais() {
		paisSeleccionado.conexionesAereas.forEach[ each| each.eliminarConexion(paisSeleccionado)]
		paises -= paisSeleccionado
		actualizarPaises
	}

	def actualizarPaises() {
		var p= paises
		paises= null
		paises= p
		paisSeleccionado= null
		nuevoPais= null
	}
	
	def paisesNombreLowerCase(){
		paises.map[nombreDelPais.toLowerCase]		
	}
}