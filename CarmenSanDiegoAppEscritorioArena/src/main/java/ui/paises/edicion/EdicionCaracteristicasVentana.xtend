package ui.paises.edicion

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import appModel.PaisAppModel
import acciones.Acciones
import org.uqbar.arena.layout.HorizontalLayout
import ui.edicion.EdicionVentana

class EdicionCaracteristicasVentana extends EdicionVentana<PaisAppModel> {
	
	new(WindowOwner owner, PaisAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		title = "Editar Características"
	}
		
	override agregarInputYBoton(Panel panel) {
		val panelAux = new Panel(panel)
		panelAux.setLayout(new HorizontalLayout)
		Acciones.agregarTexBox(panelAux,"nuevaCaracteristica")
		Acciones.agregarBoton(panelAux,"Agregar",[ | modelObject.agregarCaracteristica])
	}
	
	override agregarBotonEliminar(Panel panel) {
		Acciones.agregarBoton(panel, "Eliminar", [ | modelObject.eliminarCaracteristica])
	}
	
	override agregarLista(Panel panel) {
		Acciones.agregarLista(panel, "Características", "pais.caracteristicasDelPais", "caracteristicaSeleccionada")
	}
	
}