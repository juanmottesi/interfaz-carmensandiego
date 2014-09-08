package ui

import dominio.InterfazVillanos
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.List

class EdicionSeniasParticularesWindow extends TemplateEdicion<InterfazVillanos>{
	
	new(WindowOwner owner, InterfazVillanos model) {
		super(owner, model)
	}
	
	override agregarAgregar(Panel panel) {
		agregarBoton(panel, "Agregar", [ | modelObject.agregarSeniasParticulares])
	}
	
	override agregarEliminar(Panel mainPanel) {
		agregarBoton(mainPanel, "Eliminar",modelObject.seniasParticularesSeleccionada,[ | modelObject.eliminarSeniasParticularesSeleccionado()])
	}
	
	override agregarInput(Panel mainPanel) {
		new TextBox(mainPanel)=>[
			width= 100
			bindValueToProperty(modelObject.obtenerInputSeniasParticulares)
		]
	}
	
	override obtenerTitulo() {
		this.setTitle("Editar Señas Particulares")
	}
	
	override agregarLista(Panel panel) {
		agregarLabel(panel,"Señas Particulares", 203)
		new List(panel) =>[
			bindItemsToProperty(modelObject.listaSeniasParticulares)
			bindValueToProperty(modelObject.seniasParticularesSeleccionada)
			width= 180
		]	}
	
	override agregarBotones(Panel panel) {
		agregarBoton(panel,"Aceptar", [ | this.close
				modelObject.actualizar])
	}
	
	override agregarCaracteristicas(Panel panel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}