package ui.juego.acciones

import appModel.JuegoAppModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import acciones.Acciones
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.PropertyAdapter
import dominio.Villano
import ui.juego.edicion.EditarJuegoVentana

class OrdenDeArrestoVentana extends EditarJuegoVentana{
	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		title = '''Resolviendo: «modelObject.detective.casoActual.obtenerObjetoRobado»'''
	}
	
	override agregarTexto(Panel panel) {
		var ordenPanel = new Panel(panel)
		ordenPanel.layout = new HorizontalLayout
		
		Acciones.agregarTexto(ordenPanel, "Orden de arresto emitida contra: ") =>[
			bindEnabled(new NotNullObservable("ordenDeArresto"))
		]
		Acciones.agregarTextoProperty(ordenPanel,"ordenDeArresto.nombre")=>[ 
			bindEnabled(new NotNullObservable("ordenDeArresto"))
			
		]
	}
	
	override agregarInput(Panel panel) {		

		var selectorPanel = new Panel(panel)
		selectorPanel.layout = new HorizontalLayout
		
		Acciones.agregarTexto(selectorPanel,"Villanos:")
		Acciones.agregarSelector(selectorPanel,"todosLosVillanos","ordenDeArresto", new PropertyAdapter(Villano, "nombre"))
		
	}
	
	override agregarBotones(Panel panel) {
		Acciones.agregarBoton(panel, "Generar Orden de Arresto", [ | this.close])
	}
		
}