package dominio

import java.util.List
import dominio.auxiliar.Random
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.ObservableUtils

@Observable
class Expediente {
	
	private static Expediente instance = null
	
	@Property List<Villano> villanos
	
	new(){
		villanos = newArrayList
	}
	
	static def getInstance() {
		if (instance == null) {
			instance = new Expediente
		}
		instance
	}
	
	def puedoIniciar() {
		if (!(villanos.size > 0)){
			throw new UserException("Faltan crear mas villanos")		
		}
	}
	
	def obtenerVillano() {
		villanos.get(Random.obtenerRandom(0,villanos.size -1))	
	}
	
	def agregarVillano(Villano nuevoVillano) {
		villanos += nuevoVillano
		ObservableUtils.firePropertyChanged(this,"villanos", villanos)
	}
	
	def eliminarVillano(Villano villano){
		try{
			villanos -= villano
		}catch(Exception e){
			
		}
	}
				
}