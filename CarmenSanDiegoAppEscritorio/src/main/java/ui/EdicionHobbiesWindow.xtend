package ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import dominio.InterfazVillanos
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.List

class EdicionHobbiesWindow extends TemplateEdicion<InterfazVillanos> {
	
	new(WindowOwner owner, InterfazVillanos model) {
		super(owner, model)
	}
	
	override agregarAgregar(Panel panel) {
		agregarBoton(panel, "Agregar", [ | modelObject.agregarHobbie])
	}
	
	override agregarEliminar(Panel mainPanel) {
		agregarBoton(mainPanel, "Eliminar",modelObject.botonEliminarHobbie,[ | modelObject.eliminarHobieSeleccionado()])
	}
	
	override agregarInput(Panel mainPanel) {
		new TextBox(mainPanel)=>[
			width= 100
			bindValueToProperty(modelObject.obtenerInputHobbie)
		]
	}
	
	override obtenerTitulo() {
		this.setTitle("Editar Hobbies")
	}
	
	override agregarLista(Panel panel) {
		agregarLabel(panel,"Hobbie", 203)
		new List(panel) =>[
			bindItemsToProperty(modelObject.listaHobbies)
			bindValueToProperty(modelObject.hobbiesSeleccionado)
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