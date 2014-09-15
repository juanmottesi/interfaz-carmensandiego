package ui.villanos

import acciones.Acciones
import appModel.VillanoAppModel
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner

class NuevoVillanoVentana extends VillanoVentana{
	
	
	new(WindowOwner owner, VillanoAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("")
	}
	
	override agregarNombre(Panel panel) {
		var panelnombre = new Panel(panel)
		panelnombre.setLayout(new HorizontalLayout)
		Acciones.agregarTexto(panelnombre, "Nombre: ")
		Acciones.agregarTexBox(panelnombre, "villano.nombre")
		
		var panelSexo = new Panel(panel)
		panelSexo.setLayout(new HorizontalLayout)
		Acciones.agregarTexto(panelSexo, "Sexo: ")
		Acciones.agregarSelector(panelSexo,"sexosPosibles","villano.sexo")
	}
		
}

