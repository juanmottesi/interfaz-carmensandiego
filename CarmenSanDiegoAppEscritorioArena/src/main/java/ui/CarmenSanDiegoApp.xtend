package ui

import org.uqbar.arena.Application
import dominio.Detective
import dummyData.DummyData

class CarmenSanDiegoApp extends Application {
	
	override protected createMainWindow() {
		var model = new Detective
		model = new DummyData().crearJuegoDummy
		new PrimeraVentana(this, model) 
	}
	
	def static void main(String[] args) {
		new CarmenSanDiegoApp().start()
	}
	
}