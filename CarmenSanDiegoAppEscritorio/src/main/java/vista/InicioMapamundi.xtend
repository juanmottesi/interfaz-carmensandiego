package vista

import dominio.Mapamundi
import dominio.Pais
import java.awt.Color
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class InicioMapamundi extends Dialog<Mapamundi> {
	
	new(WindowOwner owner) {

		super(owner, new Mapamundi)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Mapamundi")
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new ColumnLayout(2))

		//Panel Izquierdo
		var panelIzq= new Panel(editorPanel)
		agregarLabel(panelIzq, "Paises", 153)			
		new List<Pais>(panelIzq) => [				
		bindItemsToProperty("paises").adapter = new PropertyAdapter(Pais,"nombreDelPais")
			bindValueToProperty("paisSeleccionado")
			width = 130
			height= 227
		]
		
		//Panel Derecho		
		var panelDerecho= new Panel(editorPanel)
		panelDerecho.setLayout(new VerticalLayout)
		var panelNombre = new Panel(panelDerecho)
		panelNombre.setLayout(new HorizontalLayout)
		
		new Label(panelNombre).setText("Nombre:")
		new Label(panelNombre) => [
			bindValueToProperty("paisSeleccionado.nombreDelPais")
			width = 100
		]	
		agregarPanelCaracteristicas(panelDerecho)
		agregarPanelConexiones(panelDerecho)
		agregarPanelLugares(panelDerecho)
		agregarPanelDeAcciones(mainPanel)
	}
	
	def agregarPanelDeAcciones(Panel panel){
		var panelBotones= new Panel(panel)
		panelBotones.setLayout(new HorizontalLayout)
		new Button(panelBotones) =>[
			caption= "Eliminar"
			onClick[ | modelObject.eliminarPais ]
			bindEnabled(new NotNullObservable("paisSeleccionado"))
			disableOnError
		]
		new Button(panelBotones) =>[
			caption= "Editar"
			//onClick [ | new EditarPaisVentana(this,modelObject.paisSeleccionado).open ]
		]
		new Button(panelBotones) =>[
			caption= "Nuevo"
			onClick [ |
				modelObject.setNuevoPais(new Pais)
				new NuevoPais(this, modelObject).open
			]
		]	
	}
	
	def agregarLabel(Panel panel, String texto, int ancho){
		new Label(panel) =>[
			text= texto
			width= ancho
			background= Color.lightGray
		]
	}
	
	def agregarPanelCaracteristicas(Panel panel) {
		var panelCarac= new Panel(panel)
		panelCarac.setLayout(new ColumnLayout(1))
		agregarLabel(panelCarac, "Características", 153)
		new List(panelCarac) =>[
			width= 130
			height= 30
			bindItemsToProperty("paisSeleccionado.caracteristicasDelPais")
		]
	}	
	
	def agregarPanelConexiones(Panel panel) {
		var panelConex= new Panel(panel)
		panelConex.setLayout(new ColumnLayout(1))
		agregarLabel(panelConex, "Conexiones", 153)
		new List(panelConex) =>[
			width= 130
			height= 30
			bindItemsToProperty("paisSeleccionado.conexionesAereas").adapter= new PropertyAdapter(Pais, "nombreDelPais")
		]
	}
	
	def agregarPanelLugares(Panel panel) {
		var panelLuga= new Panel(panel)
		panelLuga.setLayout(new ColumnLayout(1))
		agregarLabel(panelLuga, "Lugares de Interés", 153)
		new List(panelLuga) =>[
			width= 130
			height= 30
			bindItemsToProperty("paisSeleccionado.lugaresDeInteres")
		]
	}
}