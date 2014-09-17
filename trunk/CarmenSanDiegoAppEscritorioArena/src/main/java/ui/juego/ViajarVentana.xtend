package ui.juego

import appModel.JuegoAppModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones
import org.uqbar.arena.bindings.PropertyAdapter
import dominio.Pais

class ViajarVentana extends EditarJuegoVentana{
	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		title = "Viajar"
	}
		
	override agregarTexto(Panel panel) {
		var panelAux = new Panel(panel)
		panelAux.layout = new HorizontalLayout
		
		Acciones.agregarTexto(panelAux, "Estas en: ")
		Acciones.agregarTextoProperty(panelAux,"detective.casoActual.ciudadActual.nombreDelPais")
		
	}
	
	override agregarInput(Panel panel) {
		Acciones.agregarLista(panel, "Posibles destinos", "detective.casoActual.ciudadActual.conexionesAereas","siguientePais", new PropertyAdapter(Pais,"nombreDelPais"))
	}
	
	override agregarBotones(Panel panel) {
		var panelAux = new Panel(panel)
		panelAux.layout = new HorizontalLayout
		
		Acciones.agregarBoton(panelAux,"Volver al País anterior", [ | this.close ])
		Acciones.agregarBoton(panelAux,"Viajar", [ | modelObject.viajar this.close ])
	}
	
}