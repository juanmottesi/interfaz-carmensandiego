package ui.edicion

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones

abstract class EdicionVentana<T> extends Dialog<T>{
	
	new(WindowOwner owner, T model) {
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
		
		Acciones.agregarBoton(botonAgregar, "Aceptar", [ | this.close ])
		
	}
	
	abstract def void obtenerTitulo()

	abstract def void agregarInputYBoton(Panel panel)
	
	abstract def void agregarBotonEliminar(Panel panel)
	
	abstract def void agregarLista(Panel panel)


}