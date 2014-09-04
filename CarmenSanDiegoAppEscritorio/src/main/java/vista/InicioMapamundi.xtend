package vista

import dominio.Mapamundi
import dominio.Pais
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
		super(owner, new Mapamundi => [
			paises += new Pais()=>[
				nombreDelPais = "Argentina"
				caracteristicasDelPais = newArrayList
				caracteristicasDelPais += "LALALa"
				conexionesAereas = newArrayList
				conexionesAereas += new Pais() =>[nombreDelPais = "Chile"]
			]
			
			paises += new Pais()=>[
				nombreDelPais = "Brasil"
				caracteristicasDelPais = newArrayList
				caracteristicasDelPais += "lololo"
				conexionesAereas = newArrayList
				conexionesAereas += new Pais() =>[nombreDelPais = "Bolivia"]
			]
		])
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Mapamundi")
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new ColumnLayout(2))
		
		var panelIzquierdo = new Panel(editorPanel)
		panelIzquierdo.setLayout(new VerticalLayout)
		
		new Label(panelIzquierdo).setText("Paises:")
		new List<Pais>(panelIzquierdo) => [				
				bindItemsToProperty("paises").adapter = new PropertyAdapter(Pais,"nombreDelPais")
				bindValueToProperty("paisSeleccionado")
				width = 100
				height = 500
			]

		new Button(panelIzquierdo) => [ 
			caption = "Eliminar"
			onClick [ | modelObject.eliminar ]
		]

		
		new Button(panelIzquierdo) => [ 
			caption = "Editar"
			onClick [ | new EditarPaisVentana(this,modelObject.paisSeleccionado).open ]
		]

		new Button(panelIzquierdo) => [ 
			caption = "Nuevo"
			onClick [ | new CrearPaisVentana(this).open ]
		]

		
		var panelDerecho= new Panel(editorPanel)
		panelDerecho.setLayout(new VerticalLayout)
		
			
		var panelNombre = new Panel(panelDerecho)
		panelNombre.setLayout(new HorizontalLayout)
		
		new Label(panelNombre).setText("Nombre:")
		new Label(panelNombre) => [
			bindValueToProperty("paisSeleccionado.nombreDelPais")
			width = 100
			]
		
		var panelCaracteristica = new Panel(panelDerecho)
		panelCaracteristica.setLayout(new VerticalLayout)
		
		new Label(panelCaracteristica).setText("Caracteristicas:")
		new List<Pais>(panelCaracteristica) => [				
			bindItemsToProperty("paisSeleccionado.caracteristicasDelPais")
			height = 100
			width = 100	
			]
			
		var panelConexiones= new Panel(panelDerecho)
		panelConexiones.setLayout(new VerticalLayout)
		
		new Label(panelConexiones).setText("Conexiones:")
		new List<Pais>(panelConexiones) => [				
			bindItemsToProperty("paisSeleccionado.conexionesAereas").adapter = new PropertyAdapter(Pais,"nombreDelPais")
			height = 100
			width = 100	
			]
				
			
		var panelLugaresDeInteres= new Panel(panelDerecho)
		panelLugaresDeInteres.setLayout(new VerticalLayout)
		
		new Label(panelLugaresDeInteres).setText("Lugares de interés:")
		new List<Pais>(panelLugaresDeInteres) => [				
			bindItemsToProperty("paisSeleccionado.lugaresDeInteres") 
			height = 100
			width = 100	
			]
			
	}
		
}