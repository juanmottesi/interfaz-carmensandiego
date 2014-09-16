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
import appModel.ExpedienteAppModel
import ui.datos.ExpedienteVentana
import ui.juego.InicioJuegoVentana
import appModel.JuegoAppModel
import dummyData.DummyData

class PrimeraVentana extends MainWindow<Detective> {
	
	new() {
		super(new Detective)
	}
	
	new(Detective detective){
		super(detective)
	}
	
	override createContents(Panel mainPanel) {
		this.setTitle("¿Donde esta Carmen San Diego?")
		mainPanel.setLayout(new VerticalLayout)
		

		new Label(mainPanel).setText("¿Que haremos ahora detective?")
		
		var panel = new Panel(mainPanel)
		panel.setLayout(new HorizontalLayout)
		
		new Button(panel) => [ 
			caption = "Resolver Misterio"
			onClick [ | modelObject.iniciarJuego
				new InicioJuegoVentana(this, new JuegoAppModel(modelObject))
			]
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
				new ExpedienteVentana(this, new ExpedienteAppModel).open
			]
		]
	}

	def static main(String[] args) {
		new PrimeraVentana((new DummyData).crearJuegoDummy).startApplication
	}
	

}