package ui

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import appModel.MapamundiAppModel
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton
import dominio.Pais

/**
 * 
 * @author ?
 */
class HomePage extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

	var  MapamundiAppModel mapamundi

	new() {
		mapamundi = new MapamundiAppModel()
		val Form<MapamundiAppModel> paisForm = new Form<MapamundiAppModel>("buscarPaisesForm", new CompoundPropertyModel<MapamundiAppModel>(this.mapamundi))
		this.agregarListaPaises(paisForm)
		this.addChild(paisForm);
    }
    
    def agregarListaPaises(Form<MapamundiAppModel> parent) {
		val listView = new XListView("mapamundi.paises")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombreDelPais"))
			
			item.addChild(new XButton("editar").onClick = [| editar(item.modelObject) ])
			item.addChild(new XButton("eliminar")
				.onClick = [| 
					mapamundi.paisSeleccionado= item.modelObject
					mapamundi.eliminarPais
					
				]
			)
		]
		parent.addChild(listView)
	}
    	
    def editar(Pais pais) {
		responsePage = new EditarPais(pais, this) 
	}		
    
}
