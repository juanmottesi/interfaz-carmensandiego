package ui.villanos

import org.uqbar.arena.windows.WindowOwner
import appModel.VillanoAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones

class EditarVillanoVentana extends VillanoVentana {
	
	new(WindowOwner owner, VillanoAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Expedientes - Editar Villano")
	}
	
	override agregarNombre(Panel panel) {
		var panelnombre = new Panel(panel)
		panelnombre.setLayout(new HorizontalLayout)
		Acciones.agregarTexto(panelnombre, "Nombre: ")
		Acciones.agregarTextoProperty(panelnombre, "villano.nombre")
		
		var panelSexo = new Panel(panel)
		panelSexo.setLayout(new HorizontalLayout)
		Acciones.agregarTexto(panelSexo, "Sexo: ")
		Acciones.agregarTextoProperty(panelSexo,"villano.sexo")
	}
	
}