package ui

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.HorizontalLayout

abstract class TemplateEdicion<T> extends TemplateAdministrador<T> {
	
	new(WindowOwner owner, T model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.obtenerTitulo()
		
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new VerticalLayout)
			
		this.agregarLista(editorPanel)
		this.agregarEliminar(editorPanel)
		
		var panel1 = new Panel(editorPanel)
		panel1.setLayout(new HorizontalLayout)
		
		this.agregarInput(panel1)
		this.agregarAgregar(panel1)
		
		this.agregarBotones(editorPanel)
		
	}
	
	abstract def void agregarAgregar(Panel panel)	
	abstract def void agregarEliminar(Panel mainPanel)
	abstract def void agregarInput(Panel mainPanel)
	
	
}