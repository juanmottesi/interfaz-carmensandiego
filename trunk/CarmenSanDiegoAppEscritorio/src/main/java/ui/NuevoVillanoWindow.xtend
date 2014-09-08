package ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import dominio.InterfazVillanos

class NuevoVillanoWindow extends TemplateNuevoEditar<InterfazVillanos> {
	
	new(WindowOwner owner, InterfazVillanos model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Expedientes - Nuevo Villano")
	}
	
	override agregarBotones(Panel panel) {
		modelObject.agregarBotonAceptar(panel, this)
	}
	
	override agregarCaracteristicas(Panel panel) {
		modelObject.agregarNombreYSexo(panel, this)
		agregarLabelBotonYList(panel, "Señas particulares: ", "Editar Senias particulares",[ | new EdicionSeniasParticularesWindow(this, modelObject).open ], modelObject.listaSeniasParticulares)
		agregarLabelBotonYList(panel, "Hobbies: ", "Editar Hobbies",[ | new EdicionHobbiesWindow(this, modelObject).open ], modelObject.listaHobbies)
	}
	
}

