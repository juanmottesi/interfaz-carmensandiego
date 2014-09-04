package vista

import org.uqbar.arena.windows.Dialog
import dominio.Pais
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel

class CrearPaisVentana extends Dialog<Pais> {
	
	new(WindowOwner owner) {
		super(owner, new Pais)
	}
	
	override protected createFormPanel(Panel arg0) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	
}