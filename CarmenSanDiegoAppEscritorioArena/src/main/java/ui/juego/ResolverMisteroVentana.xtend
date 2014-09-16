package ui.juego

import appModel.JuegoAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner

class ResolverMisteroVentana extends Dialog<JuegoAppModel> {

	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	override createMainTemplate(Panel mainPanel) {}
	
}