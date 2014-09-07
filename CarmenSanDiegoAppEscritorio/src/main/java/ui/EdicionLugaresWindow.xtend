package ui

import dominio.InterfazPaises
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.WindowOwner
import dominio.Lugar

class EdicionLugaresWindow extends TemplateEdicion<InterfazPaises>{
	
	new(WindowOwner owner, InterfazPaises model) {
		super(owner, model)
	}
	
	override agregarEliminar(Panel mainPanel) {
		agregarBoton(mainPanel, "Eliminar",modelObject.botonEliminarLugares,[ | modelObject.eliminarLugarSeleccionado()])
	}
	
	override agregarInput(Panel mainPanel) {
		new Selector(mainPanel) =>[
			bindItemsToProperty("lugaresPosibles").adapter= new PropertyAdapter(Lugar, "nombreDelLugar")
			bindValueToProperty(modelObject.obtenerInputLugares)
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
			bindItemsToProperty(modelObject.listaLugares).adapter= new PropertyAdapter(Lugar, "nombreDelLugar")
			bindValueToProperty(modelObject.lugaresSeleccionada)
			width= 180
		]
	}
	
	override agregarAgregar(Panel panel) {
		agregarBoton(panel, "Agregar", [ | modelObject.agregarLugares])
	}
	
	override agregarCaracteristicas(Panel panel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
			
	
}