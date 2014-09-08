package ui

import dominio.Expediente
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel

class NuevoVillanoWindow extends TemplateNuevoEditar<Expediente> {
	
	new(WindowOwner owner, Expediente model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Expedientes - Nuevo Villano")
	}
	
	override agregarBotones(Panel panel) {
		agregarBoton(panel, "Aceptar","nuevoVillano", [ | modelObject.agregarVillano this.close])
	}
	
	override agregarCaracteristicas(Panel panel) {
		agregarTexBox(panel, "Nombre: ", "nuevoVillano.nombre")
		agregarTexBox(panel, "Sexo: ", "nuevoVillano.sexo")
		agregarLabelBotonYList(panel, "Señas particulares: ", "Editar Senias particulares",[ | new EdicionSeniasParticularesWindow(this, modelObject).open ], "nuevoVillano.seniasParticulares")
		agregarLabelBotonYList(panel, "Hobbies: ", "Editar Hobbies",[ | new EdicionHobbiesWindow(this, modelObject).open ], "nuevoVillano.hobbies")
	}
	
}

