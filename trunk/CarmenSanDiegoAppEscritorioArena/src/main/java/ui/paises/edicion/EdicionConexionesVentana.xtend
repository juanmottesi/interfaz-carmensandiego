package ui.paises.edicion

import org.uqbar.arena.windows.WindowOwner
import appModel.PaisAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones
import org.uqbar.arena.bindings.PropertyAdapter
import dominio.Pais
import ui.edicion.EdicionVentana

class EdicionConexionesVentana extends EdicionVentana<PaisAppModel>{

	new(WindowOwner owner, PaisAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Editar Conexiones")
	}
		
	override agregarInputYBoton(Panel panel) {
		val panelAux = new Panel(panel)
		panelAux.setLayout(new HorizontalLayout)
		Acciones.agregarSelector(panelAux,"paisesPosibles" ,"nuevaConexion", new PropertyAdapter(Pais, "nombreDelPais"))
		Acciones.agregarBoton(panelAux,"Agregar",[ | modelObject.agregarConexion])
	}
	
	override agregarBotonEliminar(Panel panel) {
		Acciones.agregarBoton(panel, "Eliminar", [ | modelObject.eliminarConexion])
	}
	
	override agregarLista(Panel panel) {
		Acciones.agregarLista(panel, "Conexiones", "pais.conexionesAereas", "conexionSeleccionada", new PropertyAdapter(Pais, "nombreDelPais"))
	}
	
	
}