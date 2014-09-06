package ui

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import java.awt.Color
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.bindings.Adapter
import org.uqbar.arena.layout.HorizontalLayout

abstract class TemplateAdministrador<T> extends Dialog<T>{
	
	new(WindowOwner owner, T model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		
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
	
	def agregarLabel(Panel panel, String texto, int ancho){
		new Label(panel) =>[
			text= texto
			width= ancho
			background= Color.lightGray
		]
	}
	
	def agregarBoton(Panel panel,String nombre, ()=>void onclick){
		var panelBotones= new Panel(panel)
		panelBotones.setLayout(new VerticalLayout)
		new Button(panelBotones) =>[
			caption = nombre
			onClick= onclick
		]
	}
	
	def agregarBoton(Panel panel,String nombre, String bindEnabled, ()=>void onclick){
		var panelBotones= new Panel(panel)
		panelBotones.setLayout(new VerticalLayout)
		new Button(panelBotones) =>[
			caption = nombre
			onClick= onclick
			bindEnabled(new NotNullObservable(bindEnabled))
			disableOnError
		]
	}
	
	def agregarPanelConLista(Panel panel,String nombreLabel, String bindItemsToProperty, PropertyAdapter adapter) {
		var panelCarac= new Panel(panel)
		panelCarac.setLayout(new ColumnLayout(1))
		agregarLabel(panelCarac, nombreLabel, 153)
		new List(panelCarac) =>[
			width= 130
			height= 30
			bindItemsToProperty(bindItemsToProperty).adapter = adapter
		]
	}
	
	def agregarPanelConLista(Panel panel,String nombreLabel, String bindItemsToProperty) {
		var panelCarac= new Panel(panel)
		panelCarac.setLayout(new ColumnLayout(1))
		agregarLabel(panelCarac, nombreLabel, 153)
		new List(panelCarac) =>[
			width= 130
			height= 30
			bindItemsToProperty(bindItemsToProperty)
		]
	}
	
		def agregarPanelConListaConLabel(Panel panel, String text, String label, String property) {
		var panelSenias= new Panel(panel)
		panelSenias.setLayout(new ColumnLayout(1))
		new Label(panelSenias).setText(text)
		agregarLabel(panelSenias, label, 153)
		new List(panelSenias) =>[
			width= 130
			height= 30
			bindItemsToProperty(property)
		]
	}
	
	def agregarPanelConListaConLabel(Panel panel, String text,String label, String property, Adapter adapter) {
			var panelHobbie= new Panel(panel)
		panelHobbie.setLayout(new ColumnLayout(1))
		new Label(panelHobbie).setText(text)
		agregarLabel(panelHobbie, label, 153)
		new List(panelHobbie) =>[
			width= 130
			height= 30
			bindItemsToProperty(property).adapter= adapter
		]
	}
	
	def agregarPanel(Panel panel, String text, String property) {
		var panelNombre = new Panel(panel)
		panelNombre.setLayout(new HorizontalLayout)
		new Label(panelNombre).setText(text)
		new Label(panelNombre) => [
			bindValueToProperty(property)
			width = 100
		]	
	}
	
}