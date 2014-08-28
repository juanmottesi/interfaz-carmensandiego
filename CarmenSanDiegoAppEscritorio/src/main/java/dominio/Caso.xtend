package dominio

import java.util.List
import dominio.auxiliar.Random

class Caso {
	
	@Property List<Pais> planDeEscape
	@Property Villano villano
	@Property String reporte
	@Property String objetoRobado
	
	new(List<Pais> paises, List<Villano> villanos){
		this.villano =  obtenerVillano(villanos)
		this.planDeEscape = obtenerPlanDeEscape(paises)
		this.objetoRobado = obtenerObjetoRobado
		this.reporte = obtenerReporte		
		
	}
		
	def obtenerVillano(List<Villano> villanos){
		villanos.get(Random.obtenerRandom(0, villanos.size))
	}
	
	def obtenerPlanDeEscape(List<Pais>paises){
		var nRandom = Random.obtenerRandom(2, paises.size)  -1
		var ret = newArrayList
		ret.add(primerPais(paises))
		for(i : 0..nRandom){
			var Pais p = ret.get(ret.size -1)
			ret.add(p.obtenerSiguientePais(ret))
		}
		ret
	}
	
	def primerPais(List<Pais> paises){
		paises.get(Random.obtenerRandom(0, paises.size))
	}
	
	def obtenerReporte(){
		"Detective, tenemos un caso para usted!" + 
		"A las 10 de la mañana en la ciudad " + planDeEscape.get(0).nombreDelPais + 
		"la comunidad  fue conmovida  al darse cuenta del faltante de gran valor!" + 
		objetoRobado
	}
	
	def obtenerObjetoRobado(){
		"La Cuchara real"
	}
	
}