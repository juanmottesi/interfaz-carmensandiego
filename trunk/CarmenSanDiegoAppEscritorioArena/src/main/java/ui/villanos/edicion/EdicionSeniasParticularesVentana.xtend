package ui.villanos.edicion

import org.uqbar.arena.windows.WindowOwner
import ui.edicion.EdicionVentana
import appModel.VillanoAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones

class EdicionSeniasParticularesVentana extends EdicionVentana<VillanoAppModel>{
	
	new(WindowOwner owner, VillanoAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Editar Señas Particulares")
	}
	

	override agregarInputYBoton(Panel panel) {
		val panelAux = new Panel(panel)
		panelAux.setLayout(new HorizontalLayout)
		Acciones.agregarTexBox(panelAux,"nuevaSeniaParticular")
		Acciones.agregarBoton(panelAux,"Agregar",[ | modelObject.agregarSeniaParticular])
	}
	
	override agregarBotonEliminar(Panel panel) {
		Acciones.agregarBoton(panel, "Eliminar", [ | modelObject.eliminarSeniaParticular])
	}
	
	override agregarLista(Panel panel) {
		Acciones.agregarLista(panel, "Seña", "villano.seniasParticulares", "seniaSeleccionada")
	}
	
}