package ui.juego.acciones

import ui.edicion.ResultadoVentana
import org.uqbar.arena.windows.WindowOwner
import appModel.JuegoAppModel
import acciones.Acciones
import org.uqbar.arena.widgets.Panel
import java.awt.Color

class PerdioJuegoVentana extends ResultadoVentana{
	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
		
	override agregarBoton(Panel panel) {
		Acciones.agregarBoton(panel,"Aceptar el error cometido", [ | this.close ])
	}
	
	override agregarTexto(Panel panel) {
		Acciones.agregarTexto(panel, "Malas noticias :(") =>[
			foreground = Color.red
		]
		var auxString = '''Ha detenido a «modelObject.detective.casoActual.villano.nombre», pero usted tenia una orden contra «modelObject.ordenDeArresto.nombre»'''
		Acciones.agregarTexto(panel, auxString)
		Acciones.agregarTexto(panel, "Lamentablemente este crímen quedará impune")
		
	}
	
}