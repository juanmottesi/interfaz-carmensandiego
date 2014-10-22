package dominio

import dominio.auxiliar.Random
import java.util.List
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.ObservableUtils

@Observable
class Mapamundi {
	
	private static Mapamundi instance = null
	
	@Property List<Pais> paises

	private new(){
		paises = newArrayList
}
	
	static def getInstance() {
		if (instance == null) {
			instance = new Mapamundi
		}
		instance
	}
	
	def puedoIniciar() {
		if (paises.size < 3){
			throw new UserException("Faltan crear mas paises")		
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

	def agregarPais(Pais nuevoPais){
		paises += nuevoPais
		ObservableUtils.firePropertyChanged(this,"paises", paises)
	}
	
	def eliminarPais(Pais paisSeleccionado) {
		paisSeleccionado.conexionesAereas.forEach[ each| Mapamundi.getInstance.getPais(each).conexionesAereas -= paisSeleccionado.nombreDelPais]
		paises -= paisSeleccionado
		ObservableUtils.firePropertyChanged(this,"paises",paises)
	}
	
	def Pais getPais(String nombrePais){
		return paises.findFirst[nombreDelPais == nombrePais]
	}
	
}