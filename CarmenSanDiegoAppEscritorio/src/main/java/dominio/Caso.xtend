package dominio

import java.util.List

class Caso {
	
	@Property List<Pais> planDeEscape
	@Property Villano villano
	@Property String reporte
	@Property String objetoRobado
	
	new(Mapamundi mapamundi, Expediente expediente){
		this.villano =  expediente.obtenerVillano
		this.planDeEscape = mapamundi.planDeEscape
		this.objetoRobado = obtenerObjetoRobado
		this.reporte = obtenerReporte		
		
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