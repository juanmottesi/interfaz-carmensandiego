package ui

import org.uqbar.arena.bindings.Adapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.layout.HorizontalLayout

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
	
				
	def agregarLabelBotonYList(Panel panel, String text, String nombre, ()=>void onclick, String property, Adapter adapter) {
		var panelAux= new Panel(panel)
		panelAux.setLayout(new ColumnLayout(2))
		new Label(panelAux).setText(text)
		new Button(panelAux) =>[
			caption= nombre
			onClick= onclick
		]
		var panelLista= new Panel(panel)
		panelLista.setLayout(new ColumnLayout(1))
		agregarLabel(panelLista, text, 203)
		new List(panelLista) =>[
			bindItemsToProperty(property).adapter= adapter
			width= 180
		]
	}
	
	def agregarLabelBotonYList(Panel panel, String text, String nombre, ()=>void onclick, String property) {
		var panelAux= new Panel(panel)
		panelAux.setLayout(new ColumnLayout(2))
		new Label(panelAux).setText(text)
		new Button(panelAux) =>[
			caption= nombre
			onClick= onclick
		]
		var panelLista= new Panel(panel)
		panelLista.setLayout(new ColumnLayout(1))
				
		agregarLabel(panelLista, text, 203)
		
		new List(panelLista) =>[
			bindItemsToProperty(property)
			width= 180
		]
	}
		
	
	override agregarLista(Panel panel) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

		
	
}