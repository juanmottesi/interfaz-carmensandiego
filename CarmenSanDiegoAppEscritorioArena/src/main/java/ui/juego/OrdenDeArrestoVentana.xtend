package ui.juego

import ui.edicion.EdicionVentana
import appModel.JuegoAppModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import acciones.Acciones
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.PropertyAdapter
import dominio.Villano

class OrdenDeArrestoVentana extends EdicionVentana<JuegoAppModel> {
	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		title = '''Resolviendo: «modelObject.detective.casoActual.obtenerObjetoRobado»'''
	}
	
	override agregarInputYBoton(Panel panel) {
		var panelAux = new Panel(panel)
		panelAux.layout= new VerticalLayout
			
		var ordenPanel = new Panel(panelAux)
		ordenPanel.layout = new HorizontalLayout
		
		Acciones.agregarTexto(ordenPanel, "Orden de arresto emitida contra: ") =>[
			bindEnabled(new NotNullObservable("ordenDeArresto"))
		]
		Acciones.agregarTextoProperty(ordenPanel,"ordenDeArresto.nombre")=>[ 
			bindEnabled(new NotNullObservable("ordenDeArresto"))
			
		]
		
		var selectorPanel = new Panel(panelAux)
		selectorPanel.layout = new HorizontalLayout
		
		Acciones.agregarTexto(selectorPanel,"Villanos:")
		Acciones.agregarSelector(selectorPanel,"todosLosVillanos","ordenDeArresto", new PropertyAdapter(Villano, "nombre"))
		
	}
	
	override agregarBotonEliminar(Panel panel) {}
	
	override agregarLista(Panel panel) {}
	
}