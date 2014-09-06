package vista

import dominio.Mapamundi
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.WindowOwner

class EdicionLugares extends TipoEdicion{
	
	new(WindowOwner parent, Mapamundi model) {
		super(parent, model)
		textoLabel= "Lugares de Interés"
		modelProperty= "nuevoPais.lugaresDeInteres"
		bindablePropertySelec= "nuevoPais.lugarSeleccionado"
		nuevoModelProperty= "nuevoPais.nuevoLugar"
	}
	
	override agregar() {
		 modelObject.nuevoPais.agregarLugar
	}
	
	override eliminar() {
		modelObject.nuevoPais.eliminarLugar
	}
	
	override panelDeAgregar(Panel panel) {
		this.setTitle("Editar Lugares")
		var panelAgregarLug= new Panel(panel)
		panelAgregarLug.setLayout(new ColumnLayout(2))
		new Selector(panelAgregarLug) =>[
			bindItemsToProperty("lugaresPosibles")
			bindValueToProperty(nuevoModelProperty)
		]
		new Button(panelAgregarLug) =>[
			caption= "Agregar"
			onClick[ | modelObject.nuevoPais.agregarLugar ]
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