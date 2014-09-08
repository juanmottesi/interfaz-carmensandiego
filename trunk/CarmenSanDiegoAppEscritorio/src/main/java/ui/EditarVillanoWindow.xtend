package ui

import dominio.Villano
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel

class EditarVillanoWindow extends TemplateNuevoEditar<Villano>{
	
	new(WindowOwner owner, Villano model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Expedientes - Editar Villano")
	}
	
	override agregarBotones(Panel panel) {
		agregarBoton(panel, "Aceptar", [ |this.close ])
	}
	
	override agregarCaracteristicas(Panel panel) {
		agregarPanel(panel, "Nombre: ", "nombre")
		agregarPanel(panel, "Sexo: ", "sexo")
		agregarLabelBotonYList(panel, "Señas particulares: ", "Editar Senias particulares",[ | new EdicionSeniasParticularesWindow(this, modelObject).open ], "seniasParticulares")
		agregarLabelBotonYList(panel, "Hobbies: ", "Editar Hobbies",[ | new EdicionHobbiesWindow(this, modelObject).open], "hobbies")
	}
	
}