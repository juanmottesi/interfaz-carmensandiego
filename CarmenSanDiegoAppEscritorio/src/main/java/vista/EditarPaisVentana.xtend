package vista

import dominio.Pais
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import dominio.Lugar

class EditarPaisVentana extends Dialog<Pais>{
	
	new(WindowOwner owner, Pais model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Mapamundi - Editar pais")
		mainPanel.setLayout(new VerticalLayout)
		
		var fila1 = new Panel(mainPanel)
		fila1.setLayout(new HorizontalLayout)
		
		new Label(fila1).setText("Nombre: ")
		new TextBox(fila1) =>[
			bindValueToProperty("nombreDelPais")
			width = 60
		]
		
		var fila2 = new Panel(mainPanel)
		fila2.setLayout(new VerticalLayout)
		
		var comp1Fila2 = new Panel(fila2)
		comp1Fila2.setLayout(new ColumnLayout(2))
		
		new Label(comp1Fila2).setText("Características")
		new Button(comp1Fila2) => [ 
			caption = "Editar Características"
			onClick [ | modelObject.caracteristicasDelPais ]
		]
		
		new List<String>(fila2) => [				
			bindItemsToProperty("caracteristicasDelPais")
			width = 100
			height = 50
		]
		
		var fila3 = new Panel(mainPanel)
		fila3.setLayout(new VerticalLayout)
		
		var comp1Fila3 = new Panel(fila3)
		comp1Fila3.setLayout(new ColumnLayout(2))
		
		new Label(comp1Fila3).setText("Conexiones")
		new Button(comp1Fila3) => [ 
			caption = "Editar Conexiones"
			onClick [ | modelObject.conexionesAereas ]
		]
		
		new List<String>(fila3) => [				
			bindItemsToProperty("conexionesAereas").adapter= new PropertyAdapter(Pais,"nombreDelPais")
			width = 100
			height = 50
		]
		
		var fila4 = new Panel(mainPanel)
		fila4.setLayout(new VerticalLayout)
		
		var comp1Fila4 = new Panel(fila3)
		comp1Fila4.setLayout(new ColumnLayout(2))
		
		new Label(comp1Fila4).setText("Lugares de Interés")
		new Button(comp1Fila4) => [ 
			caption = "Editar Lugares"
			onClick [ | modelObject.lugaresDeInteres ]
		]
		
		new List<String>(fila4) => [				
			bindItemsToProperty("lugaresDeInteres").adapter= new PropertyAdapter(Lugar, "nombreDelLugar")
			width = 100
			height = 50
		]
		
		var fila5 = new Panel(mainPanel)
		fila5.setLayout(new HorizontalLayout)
		
		new Button(fila5) => [
			caption = "Aceptar"
			onClick [ | ]
		]
		
	}


}