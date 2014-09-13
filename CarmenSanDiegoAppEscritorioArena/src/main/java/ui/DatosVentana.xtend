package ui

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout

abstract class DatosVentana<T> extends Dialog<T>{
	
	new(WindowOwner owner, T model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	override createMainTemplate(Panel mainPanel) {
		
		this.obtenerTitulo()
		
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new ColumnLayout(2))
		
		//Panel Izquierdo
		var panelIzq= new Panel(editorPanel)
		panelIzq.setLayout(new VerticalLayout)
		this.agregarLista(panelIzq)
		this.agregarBotones(panelIzq)
		
		//Panel Derecho		
		var panelDerecho= new Panel(editorPanel)
		panelDerecho.setLayout(new VerticalLayout)
		this.agregarCaracteristicas(panelDerecho)
		
	}
	
	abstract def void obtenerTitulo()
	abstract def void agregarLista(Panel panel)
	abstract def void agregarBotones(Panel panel)
	abstract def void agregarCaracteristicas(Panel panel)
	
}