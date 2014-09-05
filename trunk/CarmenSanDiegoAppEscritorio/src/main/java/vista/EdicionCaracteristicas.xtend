package vista

import dominio.Pais
import java.awt.Color
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class EdicionCaracteristicas extends Dialog<Pais>{
	
	new(WindowOwner owner, Pais model) {
		super(owner,model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Editar Características")
		
		var panelElimCaract= new Panel(mainPanel)
		panelElimCaract.setLayout(new ColumnLayout(1))
		new Label(panelElimCaract) =>[
			setText("Características")
			setBackground(Color.lightGray)
			width= 203
		]
		new List(panelElimCaract) =>[
			bindItemsToProperty("caracteristicasDelPais")
			bindValueToProperty("caracteristicaSeleccionada")
			width= 180
		]
		new Button(panelElimCaract) =>[
			caption= "Eliminar"
			onClick[ | 
				modelObject.eliminarCaracteristica
			]
			bindEnabled(new NotNullObservable("caracteristicaSeleccionada"))
			disableOnError
		]
		
		var panelAgregarCaract= new Panel(mainPanel)
		panelAgregarCaract.setLayout(new ColumnLayout(2))
		new TextBox(panelAgregarCaract) =>[
			width= 150
			bindValueToProperty("nuevaCaracteristica")
		]
		new Button(panelAgregarCaract) =>[
			caption= "Agregar"
			onClick[ | 
				modelObject.agregarCaracteristica
			]
			bindEnabled(new NotNullObservable("nuevaCaracteristica"))
			disableOnError
		]
		
		var panelAceptar= new Panel(mainPanel)
		new Button(panelAceptar) =>[
			caption= "Aceptar"
			onClick[|
				this.close
				modelObject.actualizar
			]
		]
	}
}