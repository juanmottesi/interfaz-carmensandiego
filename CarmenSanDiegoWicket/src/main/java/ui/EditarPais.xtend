package ui

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import appModel.MapamundiAppModel
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton

import dominio.Mapamundi
import org.uqbar.commons.model.UserException
import org.apache.wicket.markup.html.form.TextField
import appModel.PaisAppModel
import dominio.Pais

/**
 * 
 * @author ?
 */
class EditarPais extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	private final PaisAppModel pais
	private final HomePage mainPage
	private final boolean isNew
	
	
	new(Pais paisAEditar, HomePage mainPage) {
		this.mainPage = mainPage
		this.isNew = paisAEditar.isNew()
		
		this.pais= new PaisAppModel(paisAEditar)
		this.addChild(new Label("titulo", if (this.isNew) "Nuevo Pais" else "Editar Datos del Pais"))
		
		val paisForm = new Form<PaisAppModel>("nuevoPaisForm", this.pais.asCompoundModel)
		this.agregarCamposEdicion(paisForm)
		this.agregarAcciones(paisForm)
		this.addChild(paisForm)
	}
	
		def void agregarAcciones(Form<PaisAppModel> parent) {
		parent.addChild(new XButton("aceptar") => [
			onClick = [|
				pais.esCorrecto()
				if (isNew) {
						Mapamundi.getInstance.agregarPais(pais.pais)
					} else {
						Mapamundi.getInstance.eliminarPais(pais.pais)
						Mapamundi.getInstance.agregarPais(pais.pais)
					}
					volver()
			]				
		])
		parent.addChild(new XButton("cancelar") => [
			onClick = [| volver ]
		])
	}
	
	def volver() {
		mainPage.actualizar()
		responsePage = mainPage
	}

	def agregarCamposEdicion(Form<PaisAppModel> parent) {
		parent.addChild(new TextField<String>("nombreDelPais"))

		val listView = new XListView("pais.caracteristicasDelPais")
		listView.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label(item.toString))
			item.addChild(new XButton("eliminar")
				.onClick = [| 
					pais.caracteristicaSeleccionada = item.toString
					pais.eliminarCaracteristica
				]
			)
		]
		parent.addChild(listView)
	}
	
    
    
}
