package ui.datos

import acciones.Acciones
import appModel.ExpedienteAppModel
import appModel.VillanoAppModel
import dominio.Villano
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import ui.villanos.NuevoVillanoVentana
import ui.villanos.EditarVillanoVentana

class ExpedienteVentana extends DatosVentana<ExpedienteAppModel> {
	
	new(WindowOwner owner, ExpedienteAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Expedientes")
	}
	
	override agregarLista(Panel panel) {
		Acciones.agregarListaConTamanio(panel,"Villano","expediente.villanos","villanoSeleccionado",new PropertyAdapter(Villano,"nombre"),300,100)	
	}
	
	override agregarBotones(Panel panel) {
		var panelBotones= new Panel(panel)
		panelBotones.setLayout(new VerticalLayout)
		
		Acciones.agregarBoton(panelBotones, "Editar", "villanoSeleccionado", [ | new EditarVillanoVentana(this, new VillanoAppModel(modelObject.villanoSeleccionado)).open])
		Acciones.agregarBoton(panelBotones, "Nuevo", [ | new NuevoVillanoVentana(this, new VillanoAppModel(modelObject.agregarVillano())).open])
	}
	
	override agregarCaracteristicas(Panel panel) {
		//Label nombre
		var nombrePanel = new Panel(panel)
		nombrePanel.setLayout(new HorizontalLayout) 
		Acciones.agregarTexto(nombrePanel, "Nombre: ")
		Acciones.agregarTextoProperty(nombrePanel,"villanoSeleccionado.nombre")
		
		//Label sexo
		var sexoPanel = new Panel(panel)
		sexoPanel.setLayout(new HorizontalLayout) 
		Acciones.agregarTexto(sexoPanel, "Sexo: ")
		Acciones.agregarTextoProperty(sexoPanel,"villanoSeleccionado.sexo")
		
		//Label señas particulares
		val seniasPanel = new Panel(panel)
		seniasPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(seniasPanel, "Señas Particulares: ")
		
		val listaSeniasPanel = new Panel(panel)
		listaSeniasPanel.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaSeniasPanel, "Seña", "villanoSeleccionado.seniasParticulares")
		
		//Label hobbies
		val hobbiesPanel = new Panel(panel)
		hobbiesPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(hobbiesPanel, "Hobbies: ")
		
		val listaHobbiesPanel = new Panel(panel)
		listaHobbiesPanel.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaHobbiesPanel, "Hobbie", "villanoSeleccionado.hobbies")

	}


}