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
			"La bandera consta de tres franjas dos celestes y una blanca",
			"Es reconocida por su gran pasión por el fútbol"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "China"
			caracteristicasDelPais = newArrayList =>[addAll(#["Estado soberano situado en Asia Oriental",
			"Es el país más poblado del mundo",
			"La moneda oficial es el Yuan"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Banco])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Nigeria"
			caracteristicasDelPais = newArrayList =>[addAll(#["La moneda oficial es Naira",
			"Es el país más poblado de África",
			"La bandera consta de tres franjas dos verdes y una blanca"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Brasil"
			caracteristicasDelPais = newArrayList =>[addAll(#["El idioma oficial es el portugués",
			"La moneda oficial es el real",
			"Al norte del país se encuentra la cuenca amazónica"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Mexico"
			caracteristicasDelPais = newArrayList =>[addAll(#["La bandera tiene 3 colores verde, blanco y rojo",
			"Introdujo el chocolate, el chile y el maíz al resto del mundo ",
			"Es el mayor productor de plata en el mundo"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Estados Unidos"
			caracteristicasDelPais = newArrayList =>[addAll(#["Capital Washington D. C.",
			"Moneda oficial el Dolar",
			"La bandera tiene 50 estrellas"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "España"
			caracteristicasDelPais = newArrayList =>[addAll(#["La moneda oficial es el Euro",
			"La bandera tiene 2 franjas rojas, una amarilla y un escudo",
			"Capital Madrid"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Italia"
			caracteristicasDelPais = newArrayList =>[addAll(#["Capital Roma","Moneda oficial es el Euro",
			"La bandera tiene 3 colores verde, blanco y rojo"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.agregarPais(new Pais =>[
			nombreDelPais = "Alemania"
			caracteristicasDelPais = newArrayList =>[addAll(#["La moneda oficial es el Euro",
			"La bandera tiene 3 colores negro, rojo y amarillo",
			"Capital Berling"])]
			lugaresDeInteres = newArrayList =>[addAll(#[new Biblioteca, new Club, new Embajada])]
		])
		
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(1))
	 	detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(2))
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(3))
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(4))
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(5))
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(6))
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(7))
		detective.mapamundi.paises.get(0).agregarConexion(detective.mapamundi.paises.get(8))
	 	detective.mapamundi.paises.get(1).agregarConexion(detective.mapamundi.paises.get(2))
		detective.mapamundi.paises.get(1).agregarConexion(detective.mapamundi.paises.get(3))
		detective.mapamundi.paises.get(1).agregarConexion(detective.mapamundi.paises.get(4))
		detective.mapamundi.paises.get(1).agregarConexion(detective.mapamundi.paises.get(5))
		detective.mapamundi.paises.get(1).agregarConexion(detective.mapamundi.paises.get(6))
		detective.mapamundi.paises.get(1).agregarConexion(detective.mapamundi.paises.get(7))
		detective.mapamundi.paises.get(1).agregarConexion(detective.mapamundi.paises.get(8))
		detective.mapamundi.paises.get(2).agregarConexion(detective.mapamundi.paises.get(3))
		detective.mapamundi.paises.get(2).agregarConexion(detective.mapamundi.paises.get(4))
		detective.mapamundi.paises.get(2).agregarConexion(detective.mapamundi.paises.get(5))
		detective.mapamundi.paises.get(2).agregarConexion(detective.mapamundi.paises.get(6))
		detective.mapamundi.paises.get(2).agregarConexion(detective.mapamundi.paises.get(7))
		detective.mapamundi.paises.get(2).agregarConexion(detective.mapamundi.paises.get(8))
		detective.mapamundi.paises.get(3).agregarConexion(detective.mapamundi.paises.get(4))
		detective.mapamundi.paises.get(3).agregarConexion(detective.mapamundi.paises.get(5))
		detective.mapamundi.paises.get(3).agregarConexion(detective.mapamundi.paises.get(6))
		detective.mapamundi.paises.get(3).agregarConexion(detective.mapamundi.paises.get(7))
		detective.mapamundi.paises.get(3).agregarConexion(detective.mapamundi.paises.get(8))
		detective.mapamundi.paises.get(4).agregarConexion(detective.mapamundi.paises.get(5))
		detective.mapamundi.paises.get(4).agregarConexion(detective.mapamundi.paises.get(6))
		detective.mapamundi.paises.get(4).agregarConexion(detective.mapamundi.paises.get(7))
		detective.mapamundi.paises.get(4).agregarConexion(detective.mapamundi.paises.get(8))
		detective.mapamundi.paises.get(5).agregarConexion(detective.mapamundi.paises.get(6))
		detective.mapamundi.paises.get(5).agregarConexion(detective.mapamundi.paises.get(7))
		detective.mapamundi.paises.get(5).agregarConexion(detective.mapamundi.paises.get(8))
		detective.mapamundi.paises.get(6).agregarConexion(detective.mapamundi.paises.get(7))
		detective.mapamundi.paises.get(6).agregarConexion(detective.mapamundi.paises.get(8))
		detective.mapamundi.paises.get(7).agregarConexion(detective.mapamundi.paises.get(8))
		
	}
	
	def crearVillanos(Detective detective) {
		detective.expedientes.agregarVillano(new Villano =>[
				nombre = "Jerónimo"
				seniasParticulares = newArrayList =>[addAll(#["Alto","Pelado","Corpulento"])]
				hobbies = newArrayList =>[addAll(#["El futbol","Pesca","Autos"])]
	 			sexo = Sexo.Masculino	
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
				nombre = ""
				seniasParticulares = newArrayList =>[addAll(#["Alto","Flaco","Pelo castaño"])]
				hobbies = newArrayList =>[addAll(#["Surf","El futbol","Rafting"])]
	 			sexo = Sexo.Masculino	
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
				nombre = "Agata"
				seniasParticulares = newArrayList =>[addAll(#["Usa vestidos","Es Fumadora","Usa jayas"])]
				hobbies = newArrayList =>[addAll(#["Pintura","La fotografia","Hockey"])]
	 			sexo = Sexo.Femenino	
		])
		
		detective.expedientes.agregarVillano(new Villano =>[
				nombre = "Madame Green"
				seniasParticulares = newArrayList =>[addAll(#["Delgada","Alta","Pelo largo de color verde oscuro"])]
				hobbies = newArrayList =>[addAll(#["Lectura","Tiro con arco","Baile"])]
	 			sexo = Sexo.Femenino	
		])
	}
	
	

}