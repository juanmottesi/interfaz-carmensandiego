package ui.paises.edicion

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import appModel.PaisAppModel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.HorizontalLayout

abstract class PaisEdicionVentana extends Dialog<PaisAppModel>{
	
	new(WindowOwner owner, PaisAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	override createMainTemplate(Panel mainPanel) {
		this.obtenerTitulo
		
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new VerticalLayout)
					
		//Lista
		this.agregarLista(editorPanel)
		
		//Boton eliminar
		val botonEliminar = new Panel(editorPanel)
		botonEliminar.setLayout(new HorizontalLayout)
		this.agregarBotonEliminar(botonEliminar)
		
		//input
		this.agregarInputYBoton(editorPanel)
		
		//Boton aceptar
		val botonAgregar = new Panel(editorPanel)
		botonAgregar.setLayout(new HorizontalLayout)
		
		this.agregarBotonAceptar(botonAgregar)
		
	}
	
	abstract def void obtenerTitulo()

	abstract def void agregarBotonAceptar(Panel panel)
	
	abstract def void agregarInputYBoton(Panel panel)
	
	abstract def void agregarBotonEliminar(Panel panel)
	
	abstract def void agregarLista(Panel panel)


}