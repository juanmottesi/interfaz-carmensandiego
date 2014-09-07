package ui

import dominio.InterfazPaises
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.bindings.PropertyAdapter
import dominio.Pais

class EdicionConexionesWindow extends TemplateEdicion<InterfazPaises>{
	
	new(WindowOwner owner, InterfazPaises model) {
		super(owner, model)
	}
	
	override agregarEliminar(Panel mainPanel) {
		agregarBoton(mainPanel, "Eliminar",modelObject.botonEliminarConexiones,[ | modelObject.eliminarConexionSeleccionada()])
	}
	
	override agregarInput(Panel mainPanel) {
		new Selector(mainPanel) =>[
			bindItemsToProperty("paises").adapter= new PropertyAdapter(Pais, "nombreDelPais")
			bindValueToProperty(modelObject.obtenerInputConexiones)
		]
		
	}
	
	override obtenerTitulo() {
		this.setTitle("Editar Conexiones")
	}
		
	override agregarBotones(Panel panel) {
		agregarBoton(panel,"Aceptar", [ | this.close
				modelObject.actualizar])
	}
		
	override def agregarLista(Panel panel){
		agregarLabel(panel,"Conexiones", 203)
		new List(panel) =>[
			bindItemsToProperty(modelObject.listaConexiones).adapter= new PropertyAdapter(Pais, "nombreDelPais")
			bindValueToProperty(modelObject.conexionesSeleccionada)
			width= 180
		]
	}
	
	override agregarAgregar(Panel panel) {
		agregarBoton(panel, "Agregar", [ | modelObject.agregarConexion])
	}
	
	override agregarCaracteristicas(Panel panel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}