package ui

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton

import dominio.Mapamundi
import org.uqbar.commons.model.UserException
import org.apache.wicket.markup.html.form.TextField
import appModel.PaisAppModel
import dominio.Pais
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.markup.html.form.DropDownChoice
import dominio.Lugar
import org.apache.wicket.markup.html.link.BookmarkablePageLink

class EditarPais extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

  	private final PaisAppModel paisAppModel
	private final HomePage mainPage
	private final boolean isNew
	
	
	new(Pais paisAEditar, HomePage mainPage) {
		this.mainPage = mainPage
		this.isNew = paisAEditar.isNew()
		this.add(new BookmarkablePageLink("linkMapamundi", mainPage.class));
		this.paisAppModel= new PaisAppModel(paisAEditar)
		this.addChild(new Label("titulo", if (this.isNew) "Nuevo Pais" else "Editar Datos del Pais"))
		
		val paisForm = new Form<PaisAppModel>("nuevoPaisForm",new CompoundPropertyModel<PaisAppModel>(this.paisAppModel))
		this.agregarCamposEdicion(paisForm)
		this.agregarAcciones(paisForm)
		this.addChild(paisForm)
	}
	
		def void agregarAcciones(Form<PaisAppModel> parent) {
		parent.addChild(new XButton("aceptar") => [
			onClick = [|
				try{
					this.paisAppModel.esCorrecto
					if (isNew) {
						Mapamundi.getInstance.eliminarPais(this.paisAppModel.pais)
						Mapamundi.getInstance.agregarPais(this.paisAppModel.pais)
					} else {
						Mapamundi.getInstance.eliminarPais(this.paisAppModel.pais)
						Mapamundi.getInstance.agregarPais(this.paisAppModel.pais)
					}
					volver()
				}
				catch (UserException e) {
					info(e.getMessage())
				}
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
		// Nombre del Pais
		parent.addChild(new TextField<String>("pais.nombreDelPais"))
		
		//Lista de Caracteristicas
		val listCaracteristicas = new XListView("pais.caracteristicasDelPais")
		listCaracteristicas.populateItem = [ item |
			item.addChild(new Label("string",item.modelObject.toString))
			item.addChild(new XButton("eliminarCaracteristica")
				.onClick = [| 
					paisAppModel.pais.eliminarCaracteristica(item.modelObject)
				]
			)
		]
		parent.addChild(listCaracteristicas)
		
		parent.addChild(new TextField<String>("nuevaCaracteristica"))
		parent.addChild(new XButton("agregarCaracteristica").onClick =[|
			paisAppModel.agregarCaracteristica
		])
		
		//Lista de Lugares

		val listLugares = new XListView("pais.lugaresDeInteres")
		listLugares.populateItem = [ item |
			item.model = item.modelObject.asCompoundModel
			item.addChild(new Label("nombreDelLugar"))
			item.addChild(new XButton("eliminarLugar")
				.onClick = [| 
					paisAppModel.pais.eliminarLugar(item.modelObject)
				]
			)
		]
		parent.addChild(listLugares)
		
		parent.addChild(new DropDownChoice<Lugar>("lugaresPosibles") => [
			choices = loadableModel([| paisAppModel.lugaresPosibles ])
			choiceRenderer = choiceRenderer([Lugar l | 
				paisAppModel.nuevoLugar = l
				l.nombreDelLugar
			]) 
		]) 
		parent.addChild(new XButton("agregarLugar").onClick =[|
			paisAppModel.agregarLugar
		])
		
		// Lista de Conexiones
		
		val listConexiones = new XListView("pais.conexionesAereas")
		listConexiones.populateItem = [ item |
			item.addChild(new Label("stringConexiones", item.modelObject.toString))
			item.addChild(new XButton("eliminarConexiones")
				.onClick = [| 
					paisAppModel.pais.eliminarConexion(item.modelObject)
				]
			)
		]
		parent.addChild(listConexiones)
		
		parent.addChild(new DropDownChoice<String>("paisesPosibles") => [
			choices = loadableModel([| paisAppModel.getPaisesPosibles])
			choiceRenderer = choiceRenderer([String s | 
				paisAppModel.nuevaConexion = s
				s
			]) 
		]) 
		parent.addChild(new XButton("agregarConexion").onClick =[|
			paisAppModel.agregarConexion
		])
		
		
		// Feedback Panel
		parent.addChild(new FeedbackPanel("feedbackPanel"))
	}
  
  
  
  
  
    
    
}
