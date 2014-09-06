package vista

import dominio.Mapamundi
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner

class EdicionCaracteristicas extends TipoEdicion{
	
	new(WindowOwner parent, Mapamundi model) {
		super(parent, model)
		textoLabel= "Características"
		modelProperty= "nuevoPais.caracteristicasDelPais"
		bindablePropertySelec= "nuevoPais.caracteristicaSeleccionada"
		nuevoModelProperty= "nuevoPais.nuevaCaracteristica"
	}
	
	override agregar() {
		modelObject.nuevoPais.agregarCaracteristica
	}
	
	override eliminar() {
		modelObject.nuevoPais.eliminarCaracteristica
	}
	
	override panelDeAgregar(Panel panel) {
		this.setTitle("Editar Características")
		var panelAgregarCaract= new Panel(panel)
		panelAgregarCaract.setLayout(new ColumnLayout(2))
		new TextBox(panelAgregarCaract) =>[
			width= 150
			bindValueToProperty(nuevoModelProperty)
		]
		new Button(panelAgregarCaract) =>[
			caption= "Agregar"
			onClick[ | 
				agregar
			]
			bindEnabled(new NotNullObservable(nuevoModelProperty))
			disableOnError
		]
	}
	
	override listDePropiedadesAEditar(Panel panel) {
		new List(panel) =>[
			bindItemsToProperty(modelProperty)
			bindValueToProperty(bindablePropertySelec)
			width= 180
		]
	}
	
}