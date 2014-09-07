package vista

import dominio.Mapamundi
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.WindowOwner
import dominio.Lugar
import org.uqbar.arena.bindings.PropertyAdapter

class EdicionLugares extends TipoEdicion{
	
	new(WindowOwner parent, Mapamundi model) {
		super(parent, model)
		tituloVentana= "Editar Lugares"
		textoLabel= "Lugares de Interés"
		bindablePropertySelec= "nuevoPais.lugarSeleccionado"
	}
	
	override agregar() {
		 modelObject.nuevoPais.agregarLugar
	}
	
	override eliminar() {
		modelObject.nuevoPais.eliminarLugar
	}
	
	override panelDeAgregar(Panel panel) {
		var panelAgregarLug= new Panel(panel)
		panelAgregarLug.setLayout(new ColumnLayout(2))
		new Selector(panelAgregarLug) =>[
			bindItemsToProperty("lugaresPosibles").adapter= new PropertyAdapter(Lugar,"nombreDelLugar")
			bindValueToProperty("nuevoPais.nuevoLugar")
		]
		new Button(panelAgregarLug) =>[
			caption= "Agregar"
			onClick[ | modelObject.nuevoPais.agregarLugar ]
			bindEnabled(new NotNullObservable("nuevoPais.nuevoLugar"))
			disableOnError
		]
	}
	
	override listDePropiedadesAEditar(Panel panel) {
		new List(panel) =>[
			bindItemsToProperty("nuevoPais.lugaresDeInteres").adapter= new PropertyAdapter(Lugar,"nombreDelLugar")
			bindValueToProperty(bindablePropertySelec)
			width= 180
		]
	}
	
}