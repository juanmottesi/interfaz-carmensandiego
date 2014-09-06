package vista

import dominio.Mapamundi
import dominio.Pais
import java.awt.Color
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import dominio.Lugar

class NuevoPais extends Dialog<Mapamundi>{
	
	new(WindowOwner owner, Mapamundi model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Mapamundi - Nuevo País")
		
		var panel= new Panel(mainPanel)
		panel.setLayout(new ColumnLayout(2))
		new Label(panel).setText("Nombre:")
		new TextBox(panel)=>[
			bindValueToProperty("nuevoPais.nombreDelPais")
		]
		//Caracteristicas
		var panelCaract= new Panel(mainPanel)
		panelCaract.setLayout(new ColumnLayout(2))
		new Label(panelCaract).setText("Características")
		new Button(panelCaract) =>[
			caption= "Editar Características"
			onClick[ | new EdicionCaracteristicas(owner, modelObject).open ]
		]
		var panelListCaract= new Panel(mainPanel)
		panelListCaract.setLayout(new ColumnLayout(1))
		new Label(panelListCaract) => [
			setText("Características")
			setBackground(Color.lightGray)
			width= 203
		]
		new List(panelListCaract) =>[
			bindItemsToProperty("nuevoPais.caracteristicasDelPais")
			width= 180
		]
		
		//Conexiones
		var panelConexiones= new Panel(mainPanel)
		panelConexiones.setLayout(new ColumnLayout(2))
		new Label(panelConexiones).setText("Conexiones")
		new Button(panelConexiones) =>[
			caption= "Editar Conexiones"
			onClick[ | new EdicionConexiones(this, modelObject).open ]
		]
		var panelListaConex= new Panel(mainPanel)
		panelListaConex.setLayout(new ColumnLayout(1))
		new Label(panelListaConex) =>[
			setText("Conexiones")
			setBackground(Color.lightGray)
			width= 203
		]
		new List(panelListaConex) =>[
			bindItemsToProperty("nuevoPais.conexionesAereas").adapter= new PropertyAdapter(Pais,"nombreDelPais")
			width= 180
		]
		
		//Lugares de Interes
		var panelIntereses= new Panel(mainPanel)
		panelIntereses.setLayout(new ColumnLayout(2))
		new Label(panelIntereses).setText("Lugares de Interés")
		new Button(panelIntereses) =>[
			caption= "Editar Lugares"
			onClick[ | new EdicionLugares(this, modelObject).open ]
		]
		var panelListaInter= new Panel(mainPanel)
		panelListaInter.setLayout(new ColumnLayout(1))
		new Label(panelListaInter) =>[
			setText("Lugares de Interés")
			setBackground(Color.lightGray)
			width= 203
		]
		new List(panelListaInter) =>[
			bindItemsToProperty("nuevoPais.lugaresDeInteres").adapter= new PropertyAdapter(Lugar,"nombreDelLugar")
			width= 180
			height= 30 
		]
		
		//Aceptar
		var panelAceptar= new Panel(mainPanel)
		panelAceptar.setLayout(new ColumnLayout(1))
		new Button(panelAceptar) =>[
			caption= "Aceptar"
			onClick[| 
				modelObject.agregarPais
				this.close
			]
			bindEnabled(new NotNullObservable("nuevoPais"))
		]
	}
}