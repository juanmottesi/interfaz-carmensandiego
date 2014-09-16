package ui.datos

import ui.datos.ExpedienteVentana
import org.uqbar.arena.windows.WindowOwner
import appModel.ExpedienteAppModel
import org.uqbar.arena.widgets.Panel

class ExpedienteResolverMisterioVentana extends DatosVentana<ExpedienteAppModel> {
	
	@Property ExpedienteVentana ev;
	
	new(WindowOwner owner, ExpedienteAppModel model) {
		super(owner, model)
		ev = new ExpedienteVentana(owner, model)
	}
	
	override obtenerTitulo() {}
	
	
	override agregarCaracteristicas(Panel panel) {
		ev.agregarCaracteristicas(panel)
	}
	
	override agregarLista(Panel panel) {
		ev.agregarLista(panel)
	}
	
	override agregarBotones(Panel panel) {
		
	}
	

}