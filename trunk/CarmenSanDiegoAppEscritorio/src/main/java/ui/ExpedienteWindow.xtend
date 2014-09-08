package ui

import dominio.Expediente
import dominio.Villano
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner

class ExpedienteWindow extends TemplateAdministrador<Expediente> {
	
	new(WindowOwner owner, Expediente model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Expedientes")
	}
	
	override agregarLista(Panel panel) {
		agregarLabel(panel, "Villano", 153)	
		new List<Villano>(panel) => [				
			bindItemsToProperty("villanos").adapter = new PropertyAdapter(Villano,"nombre")
			bindValueToProperty("villanoSeleccionado")
			width = 130
			height= 227
		]
	}
	
	override agregarBotones(Panel panel) {
		
		agregarBoton(panel, "Nuevo", [ | modelObject.setNuevoVillano(new Villano) new NuevoVillanoWindow(this, modelObject).open])
		agregarBoton(panel, "Editar", "villanoSeleccionado", [ | new EditarVillanoWindow(this, modelObject.villanoSeleccionado).open ])
		
	}
	
	override agregarCaracteristicas(Panel panel) {
		
		agregarPanel(panel, "Nombre:", "villanoSeleccionado.nombre")
		agregarPanel(panel, "Sexo: ", "villanoSeleccionado.sexo")
		agregarPanelConListaConLabel(panel, "Señas Particulares: ", "Seña", "villanoSeleccionado.seniasParticulares")
		agregarPanelConListaConLabel(panel, "Hobbies: ","Hobbie", "villanoSeleccionado.hobbies")

	}

}