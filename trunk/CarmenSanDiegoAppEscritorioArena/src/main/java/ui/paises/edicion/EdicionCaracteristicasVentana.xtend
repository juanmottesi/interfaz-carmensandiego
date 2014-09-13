package ui.paises.edicion

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import ui.paises.edicion.PaisEdicionVentana
import appModel.PaisAppModel
import acciones.Acciones
import org.uqbar.arena.layout.HorizontalLayout

class EdicionCaracteristicasVentana extends PaisEdicionVentana {
	
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
	

	
//	override agregarEliminar(Panel mainPanel) {
//		agregarBoton(mainPanel, "Eliminar",modelObject.caracteristicasSeleccionada,[ | modelObject.eliminarCaracteristica()])
//	}
//	
//	override agregarInput(Panel mainPanel) {
//		new TextBox(mainPanel)=>[
//			width= 100
//			bindValueToProperty(modelObject.obtenerInputCaracteristica)
//		]
//		
//	}
//	
//	override obtenerTitulo() {
//		this.setTitle("Editar Caracteristicas")
//	}
//		
//	override agregarBotones(Panel panel) {
//		agregarBoton(panel,"Aceptar", [ | this.close
//				modelObject.actualizar])
//	}
//		
//	override def agregarLista(Panel panel){
//		agregarLabel(panel,"Características", 203)
//		new List(panel) =>[
//			bindItemsToProperty(modelObject.listaCaracteristicas)
//			bindValueToProperty(modelObject.caracteristicasSeleccionada)
//			width= 180
//		]
//	}
//	
//	override agregarAgregar(Panel panel) {
//		agregarBoton(panel, "Agregar", [ | modelObject.agregarCaracteristica])
//	}
//	
//	override agregarCaracteristicas(Panel panel) {
//		throw new UnsupportedOperationException("TODO: auto-generated method stub")
//	}
			
}