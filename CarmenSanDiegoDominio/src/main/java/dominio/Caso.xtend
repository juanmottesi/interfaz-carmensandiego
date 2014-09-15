package dominio

import java.util.List

class Caso {
	
	@Property List<Pais> planDeEscape
	@Property Villano villano
	@Property Pais ciudadActual
	
	new(Mapamundi mapamundi, Expediente expediente){
		this.villano =  expediente.obtenerVillano
		this.planDeEscape = mapamundi.planDeEscape
		this.generarInformantes()
		this.ciudadActual = planDeEscape.get(0)
		this.planDeEscape -= planDeEscape.get(0)	
		
	}
	
	def getObtenerReporte(){
		"A las 10 de la mañana en la ciudad " + planDeEscape.get(0).nombreDelPais + 
		"la comunidad  fue conmovida  al darse cuenta del faltante de gran valor!" + 
		obtenerObjetoRobado
	}
	
	def getObtenerObjetoRobado(){
		"El Santo Grial"
	}
	
	def generarInformantes(){
		for(var i=0; i < planDeEscape.size -1; i++){
			planDeEscape.get(i).generarInformantes(planDeEscape.get(i+1), villano)
		}
		planDeEscape.get(planDeEscape.size -1).colocarVillanoEInformantes(villano)
	}
	
//	def visitar(Lugar lugar){
//		
//	}
	
}