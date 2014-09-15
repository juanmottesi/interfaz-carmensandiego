package ui.villanos.edicion

import org.uqbar.arena.windows.WindowOwner
import ui.edicion.EdicionVentana
import appModel.VillanoAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones

class EdicionHobbiesVentana extends EdicionVentana<VillanoAppModel> {
	
	new(WindowOwner owner, VillanoAppModel model) {
		super(owner, model)
	}

	override obtenerTitulo() {
		this.setTitle("Editar Hobbies")
	}
	
	override agregarInputYBoton(Panel panel) {
		val panelAux = new Panel(panel)
		panelAux.setLayout(new HorizontalLayout)
		Acciones.agregarTexBox(panelAux,"nuevoHobbie")
		Acciones.agregarBoton(panelAux,"Agregar",[ | modelObject.agregarHobbie])
	}
	
	override agregarBotonEliminar(Panel panel) {
		Acciones.agregarBoton(panel, "Eliminar", [ | modelObject.eliminarHobbie])
	}
	
	override agregarLista(Panel panel) {
		Acciones.agregarLista(panel, "Hobbie", "villano.hobbies", "hobbieSeleccionada")
	}
	
}