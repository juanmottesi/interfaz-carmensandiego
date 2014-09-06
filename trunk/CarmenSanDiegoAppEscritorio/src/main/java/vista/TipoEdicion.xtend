package vista

import dominio.Mapamundi
import java.awt.Color
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

abstract class TipoEdicion extends Dialog<Mapamundi>{
	
	@Property String textoLabel
	@Property String modelProperty
	@Property String bindablePropertySelec
	@Property String nuevoModelProperty
	
	new(WindowOwner parent, Mapamundi model) {
		super(parent, model)
	}
	
	def void listDePropiedadesAEditar(Panel panel)
	def void panelDeAgregar(Panel panel)
	def void agregar()
	def void eliminar()
	
	override protected createFormPanel(Panel mainPanel) {
		var panelElim= new Panel(mainPanel)
		panelElim.setLayout(new ColumnLayout(1))
		new Label(panelElim) =>[
			setText(textoLabel)
			setBackground(Color.lightGray)
			width= 203
		]
		
		listDePropiedadesAEditar(panelElim)
		
		new Button(panelElim) =>[
			caption= "Eliminar"
			onClick[ | 
				eliminar
			]
			bindEnabled(new NotNullObservable(bindablePropertySelec))
			disableOnError
		]
		
		panelDeAgregar(mainPanel)
		
		var panelAceptar= new Panel(mainPanel)
		new Button(panelAceptar) =>[
			caption= "Aceptar"
			onClick[|
				this.close
				modelObject.nuevoPais.actualizar
			]
		]
	}
}
