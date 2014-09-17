package ui.edicion

import appModel.JuegoAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout

abstract class ResultadoVentana extends Dialog<JuegoAppModel>{
	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	override createMainTemplate(Panel mainPanel) {
		title = modelObject.detective.casoActual.obtenerObjetoRobado + "- Resuelto"
		
		var panelAux = new Panel(mainPanel)
		panelAux.layout = new VerticalLayout
		
		
		this.agregarTexto(panelAux)
		
		this.agregarBoton(panelAux)
	}
	
	abstract def void agregarBoton(Panel panel)
	
	abstract def void agregarTexto(Panel panel)
}