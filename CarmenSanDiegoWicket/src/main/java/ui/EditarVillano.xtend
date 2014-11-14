package ui

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton

import org.uqbar.commons.model.UserException
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import appModel.VillanoAppModel
import dominio.Villano
import dominio.Expediente
import org.apache.wicket.markup.html.form.DropDownChoice
import dominio.Sexo

class EditarVillano extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods

  	private final VillanoAppModel villanoAppModel
	private final Expedientes mainPage
	private final boolean isNew
	
	
	new(Villano villanoAEditar, Expedientes mainPage) {
		this.mainPage = mainPage
		this.isNew = villanoAEditar.isNew()
		this.add(new BookmarkablePageLink("linkMapamundi", HomePage))
		this.add(new BookmarkablePageLink("linkExpedientes",Expedientes))
		this.villanoAppModel= new VillanoAppModel(villanoAEditar)
		this.addChild(new Label("titulo", if (this.isNew) "Nuevo Villano" else "Editar Datos del Villano"))
		
		val villanoForm = new Form<VillanoAppModel>("nuevoVillanoForm",new CompoundPropertyModel<VillanoAppModel>(this.villanoAppModel))
		this.agregarCamposEdicion(villanoForm)
		this.agregarAcciones(villanoForm)
		this.addChild(villanoForm)
	}
	
		def void agregarAcciones(Form<VillanoAppModel> parent) {
		parent.addChild(new XButton("aceptar") => [
			onClick = [|
				try{
					this.villanoAppModel.esCorrecto
					if (isNew) {
						Expediente.getInstance.eliminarVillano(this.villanoAppModel.villano);
						Expediente.getInstance.agregarVillano(this.villanoAppModel.villano);
						
					} else {
						Expediente.getInstance.eliminarVillano(this.villanoAppModel.villano);
						Expediente.getInstance.agregarVillano(this.villanoAppModel.villano);
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

	def agregarCamposEdicion(Form<VillanoAppModel> parent) {
		// Nombre del Villano
		parent.addChild(new TextField<String>("villano.nombre"))
		
		//Sexo
		parent.addChild(new DropDownChoice<Sexo>("villano.sexo") => [
			choices = loadableModel([| Sexo.values.toList])
			choiceRenderer = choiceRenderer([Sexo s | s]) 
		])
		
		
		//Lista de Señas Particulares
		val listSenias= new XListView("villano.seniasParticulares")
		listSenias.populateItem = [ item |
			item.addChild(new Label("stringSenias",item.modelObject.toString))
			item.addChild(new XButton("eliminarSeniaParticular")
				.onClick = [| 
					villanoAppModel.villano.eliminarSeniaParticular(item.modelObject)
				]
			)
		]
		parent.addChild(listSenias)
		
		parent.addChild(new TextField<String>("nuevaSeniaParticular"))
		parent.addChild(new XButton("agregarSeniaParticular").onClick =[|
			villanoAppModel.agregarSeniaParticular
		])
		
		//Lista de Hobbies
		val listHobbies= new XListView("villano.hobbies")
		listHobbies.populateItem = [ item |
			item.addChild(new Label("stringHobbies",item.modelObject.toString))
			item.addChild(new XButton("eliminarHobbie")
				.onClick = [| 
					villanoAppModel.villano.eliminarHobbie(item.modelObject)
				]
			)
		]
		parent.addChild(listHobbies)
		
		parent.addChild(new TextField<String>("nuevoHobbie"))
		parent.addChild(new XButton("agregarHobbie").onClick =[|
			villanoAppModel.agregarHobbie
		])
		
		// Feedback Panel
		parent.addChild(new FeedbackPanel("feedbackPanel"))
	}
      
}
