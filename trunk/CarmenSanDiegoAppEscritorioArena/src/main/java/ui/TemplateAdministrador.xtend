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
import org.uqbar.arena.widgets.TextBox

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
	
	/**
	 * agrega un Label con el texto recibido por parametro con ancho recibido por parametro
	 * de color gris.
	 */
	def agregarLabel(Panel panel, String texto, int ancho){
		new Label(panel) =>[
			text= texto
			width= ancho
			background= Color.lightGray
		]
	}
	
	/**
	 * agrega un Label con el texto recibido por parametro
	 */
	def agregarLabel(Panel panel, String texto){
		new Label(panel) =>[
			text= texto
		]
	}
	
	/**
	 * agrega un boton con el nombre recibido por parametro y realiza la accion que esta 
	 * en el bloque onclick
	 */
	def agregarBoton(Panel panel,String nombre, ()=>void onclick){
		var panelBotones= new Panel(panel)
		panelBotones.setLayout(new VerticalLayout)
		new Button(panelBotones) =>[
			caption = nombre
			onClick= onclick
		]
	}
	
	/**
	 * agrega un boton con el nombre recibido por parametro, realiza la accion que esta 
	 * en el bloque onclick y tiene un bindEnabled
	 */
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
		var panelAux= new Panel(panel)
		panelAux.setLayout(new ColumnLayout(1))
		agregarLabel(panelAux, text)
		agregarLabel(panelAux, label, 153)
		new List(panelAux) =>[
			width= 130
			height= 30
			bindItemsToProperty(property)
		]
	}
	
	def agregarPanelConListaConLabel(Panel panel, String text,String label, String property, Adapter adapter) {
		var panelAux= new Panel(panel)
		panelAux.setLayout(new ColumnLayout(1))
		agregarLabel(panelAux, text)
		agregarLabel(panelAux, label, 153)
		new List(panelAux) =>[
			width= 130
			height= 30
			bindItemsToProperty(property).adapter= adapter
		]
	}
	
	def agregarPanel(Panel panel, String text, String property) {
		var panelAux = new Panel(panel)
		panelAux.setLayout(new HorizontalLayout)
		agregarLabel(panelAux, text)
		new Label(panelAux) => [
			bindValueToProperty(property)
			width = 100
		]	
	}
	
	def agregarTexBox(Panel panel, String text, String property){
		var panelAux = new Panel(panel)
		panelAux.setLayout(new ColumnLayout(2))
		agregarLabel(panelAux, text)
		new TextBox(panelAux)=>[
			width= 100
			bindValueToProperty(property)
		]
	}
	
	def agregarTexBoxInmodificable(Panel panel, String text, String property){
		var panelAux = new Panel(panel)
		panelAux.setLayout(new ColumnLayout(2))
		agregarLabel(panelAux, text)
		new TextBox(panelAux)=>[
			width= 100
			bindValueToProperty(property)
		]
	}
	
	def agregarLabelBotonYList(Panel panel, String text, String nombre, ()=>void onclick, String property, Adapter adapter) {
		var panelAux= new Panel(panel)
		panelAux.setLayout(new ColumnLayout(2))
		agregarLabel(panelAux, text)
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
		agregarLabel(panelAux, text)
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
	
}