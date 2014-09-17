package ui.juego.acciones

import ui.edicion.ResultadoVentana
import org.uqbar.arena.windows.WindowOwner
import appModel.JuegoAppModel
import org.uqbar.arena.widgets.Panel
import acciones.Acciones
import java.awt.Color

class GanoJuegoVentana extends ResultadoVentana{
	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
		
	override agregarBoton(Panel panel) {
		Acciones.agregarBoton(panel,"Disfrutar de nuestra victoria", [ | this.close ])
	}
	
	override agregarTexto(Panel panel) {
		
		Acciones.agregarTexto(panel, "En Hora Buena!!!")
		var auxString = '''Ha detenido a «modelObject.ordenDeArresto.nombre» y recuperado el «modelObject.detective.casoActual.obtenerObjetoRobado»'''
		Acciones.agregarTexto(panel, auxString)
		Acciones.agregarTexto(panel, "Felicitaciones!!!") =>[
			foreground= Color.green
		]
		
	}
	
}