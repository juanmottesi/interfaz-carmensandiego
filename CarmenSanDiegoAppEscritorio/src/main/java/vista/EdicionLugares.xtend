package vista

import dominio.Mapamundi
import java.awt.Color
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class EdicionLugares extends Dialog<Mapamundi>{
	
	new(WindowOwner owner, Mapamundi model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Editar Lugares")
		
		var panelElimLug= new Panel(mainPanel)
		panelElimLug.setLayout(new ColumnLayout(1))
		new Label(panelElimLug) =>[
			text= "Lugares de interés"
			setBackground(Color.lightGray)
			width= 203
		]
		new List(panelElimLug) =>[
			bindItemsToProperty("nuevoPais.lugaresDeInteres")
			bindValueToProperty("nuevoPais.lugarSeleccionado")
			width= 180
			height= 30
		]
		new Button(panelElimLug) =>[
			caption= "Eliminar"
			onClick[ | modelObject.nuevoPais.eliminarLugar ]
			bindEnabled(new NotNullObservable("nuevoPais.lugarSeleccionado"))
			disableOnError
		]
		
		var panelAgregarLug= new Panel(mainPanel)
		panelAgregarLug.setLayout(new ColumnLayout(2))
		new Selector(panelAgregarLug) =>[
			bindItemsToProperty("lugaresPosibles")
			bindValueToProperty("nuevoPais.nuevoLugar")
		]
		new Button(panelAgregarLug) =>[
			caption= "Agregar"
			onClick[ | modelObject.nuevoPais.agregarLugar ]
			bindEnabled(new NotNullObservable("nuevoPais.nuevoLugar"))
			disableOnError
		]
		var panelAceptar= new Panel(mainPanel)
		panelAceptar.setLayout(new ColumnLayout(1))
		new Button(panelAceptar) =>[
			caption= "Aceptar"
			onClick[ | 
				this.close
				modelObject.nuevoPais.actualizar
			]
		]
	}
}