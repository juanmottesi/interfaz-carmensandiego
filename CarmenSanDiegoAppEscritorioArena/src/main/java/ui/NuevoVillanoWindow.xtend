package ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import dominio.InterfazVillanos
import org.uqbar.arena.widgets.Selector
import dominio.Sexo
import java.util.Arrays

class NuevoVillanoWindow extends TemplateNuevoEditar<InterfazVillanos> {
	
	new(WindowOwner owner, InterfazVillanos model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle(modelObject.obtenerTitulo)
	}
	
	override agregarBotones(Panel panel) {
		if(modelObject.soyEditar){
			agregarBoton(panel, "Aceptar", [ |this.close ])
		}
		else{
			agregarBoton(panel, "Aceptar","nuevoVillano", [ | modelObject.agregarVillano this.close])
		}
	}
	
	override agregarCaracteristicas(Panel panel) {
		if(modelObject.soyEditar){
			agregarPanel(panel, "Nombre: ", "nombre")
			agregarPanel(panel, "Sexo: ", "sexo")
		}
		else{
			agregarTexBox(panel, "Nombre: ", "nuevoVillano.nombre")
			agregarTexBox(panel, "Sexo: ", "nuevoVillano.sexo")
		}
		
		agregarLabelBotonYList(panel, "Señas particulares: ", "Editar Senias particulares",[ | new EdicionSeniasParticularesWindow(this, modelObject).open ], modelObject.listaSeniasParticulares)
		agregarLabelBotonYList(panel, "Hobbies: ", "Editar Hobbies",[ | new EdicionHobbiesWindow(this, modelObject).open ], modelObject.listaHobbies)
	}
	
}

