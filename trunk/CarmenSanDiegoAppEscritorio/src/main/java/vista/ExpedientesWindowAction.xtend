package vista

import dominio.Expediente
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.List
import dominio.Villano
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.Button
import java.awt.Color
import dominio.Hobbie

class ExpedientesWindowAction extends Dialog<Expediente>{
	
	new(WindowOwner owner) {
		super(owner, new Expediente)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Expedientes")
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new ColumnLayout(2))

		//Panel Izquierdo
		var panelIzq= new Panel(editorPanel)
		agregarLabel(panelIzq, "Villano", 153)			
		new List<Villano>(panelIzq) => [				
		bindItemsToProperty("villanos").adapter = new PropertyAdapter(Villano,"nombre")
			bindValueToProperty("villanoSeleccionado")
			width = 130
			height= 227
		]
		
		//Panel Derecho		
		var panelDerecho= new Panel(editorPanel)
		panelDerecho.setLayout(new VerticalLayout)
		
		agregarPanelNombre(panelDerecho)
		agegarPanelSexo(panelDerecho)
		agregarPanelSenias(panelDerecho)
		agregarPanelHobbies(panelDerecho)
		agregarPanelDeAcciones(mainPanel)
	}
	
	def agregarLabel(Panel panel, String texto, int ancho){
		new Label(panel) =>[
			text= texto
			width= ancho
			background= Color.lightGray
		]
	}
	
	def agregarPanelNombre(Panel panel){
		var panelNombre = new Panel(panel)
		panelNombre.setLayout(new HorizontalLayout)
		new Label(panelNombre).setText("Nombre:")
		new Label(panelNombre) => [
			bindValueToProperty("villanoSeleccionado.nombre")
			width = 100
		]	
	}
	
	def agegarPanelSexo(Panel panel){
		var panelSexo = new Panel(panel)
		panelSexo.setLayout(new HorizontalLayout)
		new Label(panelSexo).setText("Sexo:")
		new Label(panelSexo) => [
			bindValueToProperty("villanoSeleccionado.sexo")
			width = 100
		]	
	}
	
	def agregarPanelSenias(Panel panel) {
		var panelSenias= new Panel(panel)
		panelSenias.setLayout(new ColumnLayout(1))
		new Label(panelSenias).setText("Señas Particulares:")
		agregarLabel(panelSenias, "Seña", 153)
		new List(panelSenias) =>[
			width= 130
			height= 30
			bindItemsToProperty("villanoSeleccionado.seniasParticulares")
		]
	}	
	
	def agregarPanelHobbies(Panel panel) {
		var panelHobbie= new Panel(panel)
		panelHobbie.setLayout(new ColumnLayout(1))
		new Label(panelHobbie).setText("Hobbies:")
		agregarLabel(panelHobbie, "Hobbie", 153)
		new List(panelHobbie) =>[
			width= 130
			height= 30
			bindItemsToProperty("villanoSeleccionado.hobbies").adapter= new PropertyAdapter(Hobbie, "nombre")
		]
	}
	
	def agregarPanelDeAcciones(Panel panel){
		var panelBotones= new Panel(panel)
		panelBotones.setLayout(new HorizontalLayout)
		new Button(panelBotones) =>[
			caption= "Nuevo"
			onClick [ | new NuevoVillano(this).open]
		]
		new Button(panelBotones) =>[
			caption= "Editar"
			onClick [ | new EditarVillano(this,modelObject.villanoSeleccionado).open ]
		]
			
	}
	

	
	
}