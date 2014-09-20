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
		this.crearVillanos(detective)
		this.crearPaises(detective)
		detective
		
	}
	
	def crearPaises(Detective detective) {
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Argentina"
			caracteristicasDelPais = newArrayList =>[addAll(#["Se constituye de 24 entidades, 23 provincias y una ciudad autónoma",
			"En el interior del país la música popular es el folklore",
			"Es reconocida por su gran pasión por el fútbol"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = ""
			caracteristicasDelPais = newArrayList =>[addAll(#["",
			"",
			""])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = ""
			caracteristicasDelPais = newArrayList =>[addAll(#["","",""])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Brasil"
			caracteristicasDelPais = newArrayList =>[addAll(#["El idioma oficial es el portugués",
			"El carnaval es una celebración que se vive como toda una verdadera fiesta nacional",
			"Al norte del país se encuentra la cuenca amazónica"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Mexico"
			caracteristicasDelPais = newArrayList =>[addAll(#["La bandera tiene 3 colores de manera vertical: verde, blanco y rojo",
			"Introdujo el chocolate, el chile y el maíz al resto del mundo ",
			"Es el mayor productor de plata en el mundo"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Estados Unidos"
			caracteristicasDelPais = newArrayList =>[addAll(#["","",""])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "España"
			caracteristicasDelPais = newArrayList =>[addAll(#["","",""])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Italia"
			caracteristicasDelPais = newArrayList =>[addAll(#["","",""])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Alemania"
			caracteristicasDelPais = newArrayList =>[addAll(#["","",""])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
	}
	
	def crearVillanos(Detective detective) {
		detective.expedientes.agregarVillano(new Villano =>[
				nombre = ""
				seniasParticulares = newArrayList =>[addAll(#["","",""])]
				hobbies = newArrayList =>[addAll(#["","",""])]
	 			sexo = Sexo.Masculino	
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
				nombre = ""
				seniasParticulares = newArrayList =>[addAll(#["","",""])]
				hobbies = newArrayList =>[addAll(#["","",""])]
	 			sexo = Sexo.Masculino	
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
				nombre = ""
				seniasParticulares = newArrayList =>[addAll(#["","",""])]
				hobbies = newArrayList =>[addAll(#["","",""])]
	 			sexo = Sexo.Femenino	
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
				nombre = ""
				seniasParticulares = newArrayList =>[addAll(#["","",""])]
				hobbies = newArrayList =>[addAll(#["","",""])]
	 			sexo = Sexo.Femenino	
		])
	}
	
	

}