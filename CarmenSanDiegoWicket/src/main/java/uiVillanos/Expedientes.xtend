package uiVillanos

import appModel.ExpedientesWicket
import dominio.Villano
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XButton
import org.uqbar.wicket.xtend.XListView
import uiNavBar.NavBarExpediente

/**
 * 
 * @author ?
 */
class Expedientes extends NavBarExpediente {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

	 @Property var ExpedientesWicket expediente

	new() {
		expediente = new ExpedientesWicket()
		val Form<ExpedientesWicket> villanoForm = new Form<ExpedientesWicket>("buscarVillanosForm", new CompoundPropertyModel<ExpedientesWicket>(this.expediente))
		this.agregarListaVillanos(villanoForm)
		this.agregarAcciones(villanoForm)
		this.addChild(villanoForm);
		this.actualizar()
    }
    
    
   def agregarAcciones(Form<ExpedientesWicket> parent) {
		parent.addChild(new XButton("nuevo").onClick = [| editar(new Villano) ])
	}
    
    def agregarListaVillanos(Form<ExpedientesWicket> parent) {
		val listView = new XListView("villanos")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombre"))
			
			item.addChild(new XButton("editar").onClick = [| editar(item.modelObject) ])
			item.addChild(new XButton("eliminar")
				.onClick = [| 
					expediente.villanoSeleccionado= item.modelObject
					expediente.eliminarVillanoSeleccionado
				]
			)
		]
		parent.addChild(listView)
	}
    	
    def editar(Villano villano) {
		responsePage = new EditarVillano(villano, this) 
	}		
    
    def actualizar(){
    	this.expediente.buscarVillanos
    }
}
