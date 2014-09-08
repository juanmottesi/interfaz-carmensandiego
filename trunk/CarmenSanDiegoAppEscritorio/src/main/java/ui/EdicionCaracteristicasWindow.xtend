package ui

import dominio.InterfazPaises
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner

class EdicionCaracteristicasWindow extends TemplateEdicion<InterfazPaises> {
	
	new(WindowOwner owner, InterfazPaises model) {
		super(owner, model)
	}
	
	override agregarEliminar(Panel mainPanel) {
		agregarBoton(mainPanel, "Eliminar",modelObject.caracteristicasSeleccionada,[ | modelObject.eliminarCaracteristica()])
	}
	
	override agregarInput(Panel mainPanel) {
		new TextBox(mainPanel)=>[
			width= 100
			bindValueToProperty(modelObject.obtenerInputCaracteristica)
		]
		
	}
	
	override obtenerTitulo() {
		this.setTitle("Editar Caracteristicas")
	}
		
	override agregarBotones(Panel panel) {
		agregarBoton(panel,"Aceptar", [ | this.close
				modelObject.actualizar])
	}
		
	override def agregarLista(Panel panel){
		agregarLabel(panel,"Características", 203)
		new List(panel) =>[
			bindItemsToProperty(modelObject.listaCaracteristicas)
			bindValueToProperty(modelObject.caracteristicasSeleccionada)
			width= 180
		]
	}
	
	override agregarAgregar(Panel panel) {
		agregarBoton(panel, "Agregar", [ | modelObject.agregarCaracteristica])
	}
	
	override agregarCaracteristicas(Panel panel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
			
}