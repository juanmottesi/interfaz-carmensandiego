package ui.paises

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import appModel.PaisAppModel
import acciones.Acciones
import org.uqbar.arena.layout.HorizontalLayout

class NuevoPaisVentana extends PaisVentana{
	
	new(WindowOwner owner, PaisAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		title = "Mapamundi - Nuevo Pais" 
	}
	
	override agregarNombre(Panel panel) {
		var panelAux = new Panel(panel)
		panelAux.setLayout(new HorizontalLayout)
		Acciones.agregarTexto(panelAux, "Nombre: ")
		Acciones.agregarTexBox(panelAux, "pais.nombreDelPais")
	}
	
}