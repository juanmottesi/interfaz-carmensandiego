package ui.villanos

import appModel.VillanoAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones

abstract class VillanoVentana extends Dialog<VillanoAppModel>{
	
	new(WindowOwner owner, VillanoAppModel model) {
		super(owner, model)
	}
	
	override createMainTemplate(Panel mainPanel) {
		
		this.obtenerTitulo
		
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new VerticalLayout)
			
		this.agregarNombre(editorPanel)		
		
		//Label se�a particular
		
		val seniasParticularesPanel = new Panel(editorPanel)
		seniasParticularesPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(seniasParticularesPanel, "Se�as Particulares: ")
		Acciones.agregarBoton(seniasParticularesPanel, "Editar Se�as Particulares", [ | ])
		
		val listaSenias = new Panel(editorPanel)
		listaSenias.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaSenias, "Se�a", "villano.seniasParticulares")
		
		//Label hobbies
		val hobbiesPanel = new Panel(editorPanel)
		hobbiesPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(hobbiesPanel, "Hobbies: ")
		Acciones.agregarBoton(hobbiesPanel, "Editar Hobbies", [ | ])
		
		val listaHobbiesPanel = new Panel(editorPanel)
		listaHobbiesPanel.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaHobbiesPanel, "Hobbies", "villano.hobbies")
		
		//Label boton
		val botonera = new Panel(editorPanel)
		botonera.setLayout(new HorizontalLayout)
		Acciones.agregarBoton(botonera, "Aceptar", [ | /*modelObject.esCorrecto() */this.close ])
	}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	abstract def void obtenerTitulo()
	
	abstract def void agregarNombre(Panel panel)
	
}