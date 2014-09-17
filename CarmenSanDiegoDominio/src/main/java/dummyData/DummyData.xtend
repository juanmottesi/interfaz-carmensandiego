package dummyData

import dominio.Biblioteca
import dominio.Club
import dominio.Detective
import dominio.Embajada
import dominio.Pais
import dominio.Sexo
import dominio.Villano
import dominio.Banco

class DummyData {
	
	def crearJuegoDummy(){
		var detective = new Detective
		detective.expedientes.agregarVillano(new Villano =>[
			nombre = "Carmen San Diego"
			seniasParticulares = newArrayList =>[add("Gorro") add("Joyas")]
			hobbies = newArrayList =>[addAll(#["Tenis", "Natacion"])]
			sexo = Sexo.Femenino
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
			nombre = "Diego"
			seniasParticulares = newArrayList =>[addAll(#["Tenis", "Natacion"])]
			hobbies = newArrayList =>[addAll(#["Tenis", "Natacion"])]
			sexo = Sexo.Masculino
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
			nombre = "Pepe"
			seniasParticulares = newArrayList =>[addAll(#["Ojos verdes","Cicatriz"])]
			hobbies = newArrayList =>[addAll(#["Tenis", "Natacion"])]
			sexo = Sexo.Masculino
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Argentina"
			caracteristicasDelPais = newArrayList =>[addAll(#["Español","Peso"])] 
			lugaresDeInteres = newArrayList =>[
				add(new Club)
				add(new Embajada)
				add(new Biblioteca)
			]	
			conexionesAereas = newArrayList		
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Chile"
			caracteristicasDelPais = newArrayList =>[addAll(#["Español","Peso Chileno"])] 
			lugaresDeInteres = newArrayList =>[
				add(new Biblioteca)
				add(new Club)
				add(new Embajada)
			]	
			conexionesAereas = newArrayList			
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "España"
			caracteristicasDelPais =newArrayList =>[add("Español") add("Euro")]  
			lugaresDeInteres = newArrayList =>[
				add(new Biblioteca)
				add(new Banco)
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