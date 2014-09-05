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
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class EdicionConexiones extends Dialog<Mapamundi>{
	
	new(WindowOwner owner, Mapamundi model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Editar Conexiones")
		
		var panelElimConex= new Panel(mainPanel)
		panelElimConex.setLayout(new ColumnLayout(1))
		new Label(panelElimConex) =>[
			setText("Conexiones")
			setBackground(Color.lightGray)
			width= 203
		]
		new List(panelElimConex) =>[
			bindItemsToProperty("nuevoPais.conexionesAereas").adapter= new PropertyAdapter(Pais, "nombreDelPais")
			bindValueToProperty("nuevoPais.conexionSeleccionada")
			width= 180
			height= 100
		]
		new Button(panelElimConex) =>[
			caption= "Eliminar"
			onClick[ | modelObject.nuevoPais.eliminarConexion ]
			bindEnabled(new NotNullObservable("nuevoPais.conexionSeleccionada"))
			disableOnError
		]
		
		var panelAgregarConex= new Panel(mainPanel)
		panelAgregarConex.setLayout(new ColumnLayout(2))
		new Selector(panelAgregarConex) =>[
			bindItemsToProperty("paises").adapter= new PropertyAdapter(Pais, "nombreDelPais")
			bindValueToProperty("nuevoPais.nuevaConexion")
			width= 150
		]
		new Button(panelAgregarConex) =>[
			caption= "Agregar"
			onClick[ | modelObject.nuevoPais.agregarConexion ]
			bindEnabled(new NotNullObservable("nuevoPais.nuevaConexion"))
			disableOnError
		]
		
		var panelAceptar= new Panel(mainPanel)
		new Button(panelAceptar) =>[
			caption= "Aceptar"
			onClick[ | 
				this.close
				modelObject.nuevoPais.actualizar
			]
		]
	}
}