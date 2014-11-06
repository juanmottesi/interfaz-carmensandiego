package ui

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton
import appModel.MapamundiWicket
import dominio.Pais

/**
 * 
 * @author ?
 */
class HomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

	 @Property var MapamundiWicket mapamundi

	new() {
		mapamundi = new MapamundiWicket()
		val Form<MapamundiWicket> paisForm = new Form<MapamundiWicket>("buscarPaisesForm", new CompoundPropertyModel<MapamundiWicket>(this.mapamundi))
		this.agregarListaPaises(paisForm)
		this.agregarAcciones(paisForm)
		this.addChild(paisForm);
		this.actualizar()
    }
    
    
   def agregarAcciones(Form<MapamundiWicket> parent) {
		parent.addChild(new XButton("nuevo").onClick = [| editar(new Pais) ])
	}
    
    def agregarListaPaises(Form<MapamundiWicket> parent) {
		val listView = new XListView("paises")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombreDelPais"))
			
			item.addChild(new XButton("editar").onClick = [| editar(item.modelObject) ])
			item.addChild(new XButton("eliminar")
				.onClick = [| 
					mapamundi.paisSeleccionado= item.modelObject
					mapamundi.eliminarPaisSeleccionado
				]
			)
		]
		parent.addChild(listView)
	}
    	
    def editar(Pais pais) {
		responsePage = new EditarPais(pais, this) 
	}		
    
    def actualizar(){
    	this.mapamundi.buscarPaises
    }
}
