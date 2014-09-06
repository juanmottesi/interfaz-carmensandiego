package vista

import dominio.Mapamundi
import dominio.Pais
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.WindowOwner

class EdicionConexiones extends TipoEdicion{
	
	new(WindowOwner parent, Mapamundi model) {
		super(parent, model)
		textoLabel= "Conexiones"
		modelProperty= "nuevoPais.conexionesAereas"
		bindablePropertySelec= "nuevoPais.conexionSeleccionada"
		nuevoModelProperty= "nuevoPaos.nuevaConexion"
	}
	
	override agregar() {
		modelObject.nuevoPais.agregarConexion
	}
	
	override eliminar() {
		modelObject.nuevoPais.eliminarConexion
	}
	
	override panelDeAgregar(Panel panel) {
		this.setTitle("Editar Conexiones")
		var panelAgregarConex= new Panel(panel)
		panelAgregarConex.setLayout(new ColumnLayout(2))
		new Selector(panelAgregarConex) =>[
			bindItemsToProperty("paises").adapter= new PropertyAdapter(Pais, "nombreDelPais")
			bindValueToProperty("nuevoPais.nuevaConexion")
		]
		new Button(panelAgregarConex) =>[
			caption= "Agregar"
			onClick[ | modelObject.nuevoPais.agregarConexion ]
			bindEnabled(new NotNullObservable("nuevoPais.nuevaConexion"))
			disableOnError
		]
	}
	
	override listDePropiedadesAEditar(Panel panel) {
		new List(panel) =>[
			bindItemsToProperty(modelProperty).adapter= new PropertyAdapter(Pais, "nombreDelPais")
			bindValueToProperty(bindablePropertySelec)
			width= 180
		]
	}
	
}