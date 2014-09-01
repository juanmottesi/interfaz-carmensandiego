package vista

import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import dominio.Detective
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button

class InicialWindow extends MainWindow<Detective> {
	
	new() {
		super(new Detective)
	}
	
	override createContents(Panel mainPanel) {
		this.setTitle("¿Donde esta Carmen San Diego?")
		mainPanel.setLayout(new HorizontalLayout)
		

		new Label(mainPanel).setText("¿Que haremos ahora detective?")

		new Button(mainPanel) => [ 
			caption = "Resolver Misterio"
			onClick [ | modelObject.casoActual ]
		]
		
		new Button(mainPanel) => [ 
			caption = "Mapamundi"
			onClick [ | modelObject.mapamundi]
		]
		new Button(mainPanel) => [ 
			caption = "Expedientes"
			onClick [ | modelObject.expedientes ]
		]
	}

	def static main(String[] args) {
		new InicialWindow().startApplication
	}

}