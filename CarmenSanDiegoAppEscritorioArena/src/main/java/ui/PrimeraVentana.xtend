package ui

import dominio.Detective
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import appModel.MapamundiAppModel
import ui.datos.MapamundiVentana
import appModel.ExpedienteAppModel
import ui.datos.ExpedienteVentana
import ui.juego.InicioJuegoVentana
import appModel.JuegoAppModel
import acciones.Acciones
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class PrimeraVentana extends SimpleWindow<Detective> {
	

	
	new(WindowOwner parent, Detective model) {
		super(parent, model)
	}
				
	override protected addActions(Panel actionsPanel) {}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	override createMainTemplate(Panel mainPanel) {
		this.setTitle("¿Donde esta Carmen San Diego?")
		mainPanel.setLayout(new VerticalLayout)

		new Label(mainPanel).setText("¿Que haremos ahora detective?")
		
		var panel = new Panel(mainPanel)
		panel.setLayout(new HorizontalLayout)
		
		Acciones.agregarBoton(panel, "Resolver Misterio", [ | 
			modelObject.iniciarJuego
			new InicioJuegoVentana(this, new JuegoAppModel(modelObject)).open
		])
		Acciones.agregarBoton(panel, "Mapamundi", [ | new MapamundiVentana(this, new MapamundiAppModel).open])
		Acciones.agregarBoton(panel, "Expedientes", [ | new ExpedienteVentana(this, new ExpedienteAppModel).open])
	}

}