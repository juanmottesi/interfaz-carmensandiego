package ui

import dominio.Detective
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow
import appModel.MapamundiAppModel
import ui.datos.MapamundiVentana

class PrimeraVentana extends MainWindow<Detective> {
	
	new() {
		super(new Detective)
	}
	
	override createContents(Panel mainPanel) {
		this.setTitle("¿Donde esta Carmen San Diego?")
		mainPanel.setLayout(new VerticalLayout)
		

		new Label(mainPanel).setText("¿Que haremos ahora detective?")
		
		var panel = new Panel(mainPanel)
		panel.setLayout(new HorizontalLayout)
		
		new Button(panel) => [ 
			caption = "Resolver Misterio"
			onClick [ | modelObject.casoActual ]
		]
		
		new Button(panel) => [ 
			caption = "Mapamundi"
			onClick [ | 
				new MapamundiVentana(this, new MapamundiAppModel).open
			]
		]
		new Button(panel) => [ 
			caption = "Expedientes"
			onClick [ | 
				//new ExpedienteWindow(this, Expediente.instance).open
			]
		]
	}

	def static main(String[] args) {
		new PrimeraVentana().startApplication
	}
	

}