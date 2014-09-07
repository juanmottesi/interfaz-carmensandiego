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
		agregarBoton(panel, "Aceptar", [ | ])
	}
	
	override agregarCaracteristicas(Panel panel) {
		agregarTexBox(panel, "Nombre: ", "nombre")
		agregarTexBox(panel, "Sexo: ", "sexo")
		agregarLabelBotonYList(panel, "Señas particulares: ", "Editar Senias particulares",[ |  ], "seniasParticulares")
		agregarLabelBotonYList(panel, "Hobbies: ", "Editar Hobbies",[ | ], "hobbies")
	}
	
}