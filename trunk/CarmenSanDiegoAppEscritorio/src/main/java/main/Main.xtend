package main

import dominio.Biblioteca
import dominio.Club
import dominio.Detective
import dominio.Embajada
import dominio.Lugar
import dominio.Pais
import dominio.Villano
import java.util.ArrayList

class Main {
		def static void main(String[] args) {

		var detective = new Detective
		var lugares =  new ArrayList<Lugar>()
		lugares+= (new Biblioteca)
		lugares+= (new Club)
		lugares+= (new Embajada)
		var arg = new Pais("Argentina",#["Celeste y Blanca","Asado"], lugares , #[])
		var chl = new Pais("Chile",#["Celeste y Blanca","Asado"], lugares, #[])
		var col = new Pais("Colombia",#["Celeste y Blanca","Asado"], lugares, #[])
		var esp = new Pais("España",#["Celeste y Blanca","Asado"], lugares, #[])
		var itl = new Pais("Italia",#["Celeste y Blanca","Asado"], lugares, #[])
		var fr = new Pais("Francia",#["Celeste y Blanca","Asado"], lugares, #[])
		var ing = new Pais("Inglaterra",#["Celeste y Blanca","Asado"], lugares, #[])
		

		arg.conexionesAereas = #[chl,col,esp,itl,fr,ing]
		chl.conexionesAereas = #[arg,col,esp,itl,fr,ing]
		col.conexionesAereas = #[arg,chl,esp,itl,fr,ing]
		esp.conexionesAereas = #[arg,chl,col,itl,fr,ing]
		itl.conexionesAereas = #[arg,chl,col,esp,fr,ing]
		fr.conexionesAereas  = #[arg,chl,col,esp,itl,ing]
		ing.conexionesAereas = #[arg,chl,col,esp,itl,fr]
		
		
		detective.agregarPais(arg)
		detective.agregarPais(chl)
		detective.agregarPais(col)
		detective.agregarPais(esp)
		detective.agregarPais(itl)
		detective.agregarPais(fr)
		detective.agregarPais(ing)


//		arg.conexionesAereas = #[chl,col]
//		chl.conexionesAereas = #[arg,col]
//		col.conexionesAereas = #[arg,chl]
//
//		
//		juego.agregarPais(arg)
//		juego.agregarPais(chl)
//		juego.agregarPais(col)

		for(r :0..1000){	
		val v1 = new Villano("Pepe",#["Sombrero","Anillos","Celular ultimo modelo"],#["Tenis","Autos","Tejo"],"Masculino")
		
		detective.agregarVillano(v1)
		
		detective.iniciarJuego
		
		System.out.println(detective.casoActual.planDeEscape)
		
		for (int i : 0..(detective.casoActual.planDeEscape.size -1)){
			var e = detective.casoActual.planDeEscape.get(i)
			System.out.print(e.nombreDelPais)
			System.out.print(", ")
		}
		System.out.println("")
	}
	}
}