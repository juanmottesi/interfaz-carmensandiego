package ui.paises.edicion

import org.uqbar.arena.windows.WindowOwner
import appModel.PaisAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones
import org.uqbar.arena.bindings.PropertyAdapter
import dominio.Lugar
import ui.edicion.EdicionVentana

class EdicionLugaresVentana extends EdicionVentana<PaisAppModel>{
		
	new(WindowOwner owner, PaisAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Editar Lugares")
	}
		
	override agregarInputYBoton(Panel panel) {
		val panelAux = new Panel(panel)
		panelAux.setLayout(new HorizontalLayout)
		Acciones.agregarSelector(panelAux,"lugaresPosibles" ,"nuevoLugar", new PropertyAdapter(Lugar, "nombreDelLugar"))
		Acciones.agregarBoton(panelAux,"Agregar",[ | modelObject.agregarLugar])
	}
	
	override agregarBotonEliminar(Panel panel) {
		Acciones.agregarBoton(panel, "Eliminar", [ | modelObject.eliminarLugar])
	}
	
	override agregarLista(Panel panel) {
		Acciones.agregarLista(panel, "Lugares de Interés", "pais.lugaresDeInteres", "lugarSeleccionada", new PropertyAdapter(Lugar, "nombreDelLugar"))
	}
			
	
}