package ui

import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner

abstract class TemplateNuevoEditar<T> extends TemplateAdministrador <T> {
	
		
	new(WindowOwner owner, T model) {
		super(owner, model)
	}

	override protected createFormPanel(Panel mainPanel) {
		this.obtenerTitulo()
		
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new VerticalLayout)
			
		this.agregarCaracteristicas(editorPanel)
		this.agregarBotones(editorPanel)
	}
	
	override agregarLista(Panel panel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

				
	
}