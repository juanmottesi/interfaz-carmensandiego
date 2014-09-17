package ui.juego.acciones

import ui.edicion.EditarJuegoVentana
import org.uqbar.arena.windows.WindowOwner
import appModel.JuegoAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones
import dominio.Lugar

class VisitarLugarVentana extends EditarJuegoVentana{
	
	@Property Lugar lugar
	
	new(WindowOwner owner, JuegoAppModel model, Lugar lugar) {
		super(owner, model)
		_lugar = lugar
	}
	
	override agregarTexto(Panel panel) {
		var ordenPanel = new Panel(panel)
		ordenPanel.layout = new HorizontalLayout
		
		Acciones.agregarTexto(ordenPanel, "Estas visitando: ")
		Acciones.agregarTexto(ordenPanel, lugar.nombreDelLugar)
	}
	
	override obtenerTitulo() {
		title = '''Resolviendo: «modelObject.detective.casoActual.obtenerObjetoRobado»'''
	}
	
	override agregarInput(Panel panel) {
		Acciones.agregarTexto(panel, lugar.pista(modelObject.ordenDeArresto))
	}
	
	override agregarBotones(Panel panel) {
		Acciones.agregarBoton(panel, "Continuar", [ | ])
	}
	
}