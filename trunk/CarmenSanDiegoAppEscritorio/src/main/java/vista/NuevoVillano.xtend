package vista

import dominio.Expediente
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import java.awt.Color

class NuevoVillano extends Dialog<Expediente> {
	
	new(WindowOwner owner, Expediente model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Expedientes - Nuevo Villano")
		
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new VerticalLayout)
		
//		agregarPanelNombre(editorPanel)
//		agegarPanelSexo(editorPanel)
//		agregarPanelSenias(editorPanel)
//		agregarPanelHobbies(editorPanel)

//Agregado

		//Nombre
		var panelNombre= new Panel(mainPanel)
		panelNombre.setLayout(new ColumnLayout(2))
		new Label(panelNombre).setText("Nombre:")
		new TextBox(panelNombre)=>[
			bindValueToProperty("nuevoVillano.nombre")
		]
		//Sexo
		var panelSexo= new Panel(mainPanel)
		panelSexo.setLayout(new ColumnLayout(2))
		new Label(panelSexo).setText("Sexo:")
		new TextBox(panelSexo)=>[
			bindValueToProperty("nuevoVillano.sexo")
		//Señas particulares
		var panelSenias= new Panel(mainPanel)
		panelSenias.setLayout(new ColumnLayout(2))
		new Label(panelSenias).setText("Señas particulares: ")
		new Button(panelSenias) =>[
			caption= "Editar Senias particulares"
			onClick[ | /*new EdicionSeniasParticulares(this, modelObject).open*/ ]
		]
		
		var panelListSenias= new Panel(mainPanel)
		panelListSenias.setLayout(new ColumnLayout(1))
		new Label(panelListSenias) => [
			setText("Senias particulares")
			setBackground(Color.lightGray)
			width= 203
		]
		
		new List(panelListSenias) =>[
			bindItemsToProperty("nuevoVillano.seniasParticulares")
			width= 180
		]
		
		//Hobbies
		var panelHobbies= new Panel(mainPanel)
		panelHobbies.setLayout(new ColumnLayout(2))
		new Label(panelHobbies).setText("Hobbies: ")
		new Button(panelHobbies) =>[
			caption= "Editar Hobbies"
			onClick[ | /*new EdicionHobbies(this, modelObject).open*/ ]
		]
		
		var panelListHobbie= new Panel(mainPanel)
		panelListHobbie.setLayout(new ColumnLayout(1))
		new Label(panelListHobbie) => [
			setText("Hobbies")
			setBackground(Color.lightGray)
			width= 203
		]

		new List(panelListHobbie) =>[
			bindItemsToProperty("nuevoVillano.hobbies")
			width= 180
		]


//Fin
		var panelAceptar= new Panel(mainPanel)
		panelAceptar.setLayout(new ColumnLayout(1))
		new Button(panelAceptar) =>[
			caption= "Aceptar"
			onClick [ |
				 modelObject.agregarVillano
				 this.close				 
			]
			bindEnabled(new NotNullObservable("nuevoVillano"))
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