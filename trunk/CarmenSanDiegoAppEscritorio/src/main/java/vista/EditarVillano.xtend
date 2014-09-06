package vista

import dominio.Villano
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.List
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.TextBox

class EditarVillano extends Dialog<Villano> {
	
	new(WindowOwner owner, Villano model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
				this.setTitle("Expedientes - Nuevo Villano")
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new VerticalLayout)
		
		agregarPanelNombre(editorPanel)
		agegarPanelSexo(editorPanel)
		agregarPanelSenias(editorPanel)
		agregarPanelHobbies(editorPanel)
		
		new Button(editorPanel) =>[
			caption= "Aceptar"
			onClick [ |
				 this.close
				//actualizar 
			]
		]
		
	}
	
	def agregarPanelNombre(Panel panel){
		var panelNombre = new Panel(panel)
		panelNombre.setLayout(new HorizontalLayout)
		new Label(panelNombre).setText("Nombre:")
		new TextBox(panelNombre) => [
			bindValueToProperty("nombre")
			width = 100
		]	
	}
	
	def agegarPanelSexo(Panel panel){
		var panelSexo = new Panel(panel)
		panelSexo.setLayout(new HorizontalLayout)
		new Label(panelSexo).setText("Sexo:")
		new TextBox(panelSexo) => [
			bindValueToProperty("sexo")
			width = 100
		]	
	}
	
	def agregarPanelSenias(Panel panel){
		var panelSenias= new Panel(panel)
		panelSenias.setLayout(new HorizontalLayout)
		new Label(panelSenias).setText("Señas Particulares:")
		new Button(panelSenias) =>[
			caption= "Editar Señas Particulares"
			//onClick [ | new EditarSeniasParticulares(this,modelObject.villanoSeleccionado).open ]
		]
		new Label(panel).setText("Seña")
		new List(panel) =>[
			width= 130
			height= 30
			bindItemsToProperty("seniasParticulares")
			
		]		
	}
	
	def agregarPanelHobbies(Panel panel){
		var panelHobbie= new Panel(panel)
		panelHobbie.setLayout(new HorizontalLayout)
		new Label(panelHobbie).setText("Hobbies:")
		new Button(panelHobbie) =>[
			caption= "Editar Hobbies"
			//onClick [ | new EditarHobbies(this,modelObject.villanoSeleccionado).open ]
		]
		new Label(panel).setText("Hobbie")
		new List(panel) =>[
			width= 130
			height= 30
			bindItemsToProperty("hobbies")
			
		]		
	}
	
}