package ui

import dummyData.DummyData
import org.uqbar.arena.Application

class CarmenSanDiegoApp extends Application {
	
	override protected createMainWindow() {
		var model = new DummyData().crearJuegoDummy
		new PrimeraVentana(this, model) 
	}
	
	def static void main(String[] args) {
		new CarmenSanDiegoApp().start()
	}
	
}