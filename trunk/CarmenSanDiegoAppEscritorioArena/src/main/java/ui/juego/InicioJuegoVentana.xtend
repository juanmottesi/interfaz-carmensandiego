package ui.juego

import org.uqbar.arena.windows.Dialog
import appModel.JuegoAppModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel

class InicioJuegoVentana extends Dialog<JuegoAppModel>{
	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	override createMainTemplate(Panel mainPanel) {
		
		
		
	}
	
}