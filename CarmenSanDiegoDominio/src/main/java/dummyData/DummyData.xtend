package dummyData

import dominio.Biblioteca
import dominio.Club
import dominio.Detective
import dominio.Embajada
import dominio.Pais
import dominio.Sexo
import dominio.Villano

class DummyData {
	
	def crearJuegoDummy(){
		var detective = new Detective
		detective.expedientes.agregarVillano(new Villano =>[
			nombre = "Carmen San Diego"
			seniasParticulares = #["Gorro","Joyas"]
			hobbies = #["Tenis", "Natacion"]
			sexo = Sexo.Femenino
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
			nombre = "Diego"
			seniasParticulares = #["Gorro","Cicatriz"]
			hobbies = #["Musica", "Croquet"]
			sexo = Sexo.Masculino
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Argentina"
			caracteristicasDelPais = #["Español","Peso"] 
			lugaresDeInteres = newArrayList =>[
				add(new Biblioteca)
				add(new Club)
				add(new Embajada)
			]	
			conexionesAereas = newArrayList		
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Chile"
			caracteristicasDelPais = #["Español","Peso Chileno"] 
			lugaresDeInteres = newArrayList =>[
				add(new Biblioteca)
				add(new Club)
				add(new Embajada)
			]	
			conexionesAereas = newArrayList			
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "España"
			caracteristicasDelPais = #["Español","Euro"] 
			lugaresDeInteres = newArrayList =>[
				add(new Biblioteca)
				add(new Club)
				add(new Embajada)
			]	
			conexionesAereas = newArrayList		
		])
		
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(1))
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(2))
		detective.mapamundi.paises.get(1).agregarConexion(detective.mapamundi.paises.get(2))
		
		detective
	}

}