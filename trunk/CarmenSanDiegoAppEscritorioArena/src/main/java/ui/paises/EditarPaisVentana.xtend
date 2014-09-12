package ui.paises

import org.uqbar.arena.windows.WindowOwner
import appModel.PaisAppModel
import org.uqbar.arena.widgets.Panel
import acciones.Acciones
import org.uqbar.arena.layout.HorizontalLayout

class EditarPaisVentana extends PaisVentana{
	
	new(WindowOwner owner, PaisAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		title = "Mapamundi - Editar Pais" 
	}
	
	override agregarNombre(Panel panel) {
		val panelAux = new Panel (panel)
		panelAux.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(panelAux, "Nombre: ")
		Acciones.agregarTextoProperty(panelAux, "pais.nombreDelPais")
		
	}
	
}