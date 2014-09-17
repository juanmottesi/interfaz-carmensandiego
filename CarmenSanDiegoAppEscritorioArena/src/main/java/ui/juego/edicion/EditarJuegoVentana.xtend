package ui.juego.edicion

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import appModel.JuegoAppModel

abstract class EditarJuegoVentana extends Dialog<JuegoAppModel>{
	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	override createMainTemplate(Panel mainPanel) {
		this.obtenerTitulo()
		
		var panelAux = new Panel(mainPanel)
		panelAux.layout= new VerticalLayout
		
		this.agregarTexto(panelAux)
		
		this.agregarInput(panelAux)
		
		this.agregarBotones(panelAux)
		
	}
	
	abstract def void agregarTexto(Panel panel)
	
	abstract def void obtenerTitulo()

	abstract def void agregarInput(Panel panel)
	
	abstract def void agregarBotones(Panel panel)
}