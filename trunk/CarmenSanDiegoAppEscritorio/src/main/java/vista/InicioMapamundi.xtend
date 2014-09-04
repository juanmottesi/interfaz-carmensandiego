package vista

import dominio.Mapamundi
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.List
import org.uqbar.arena.bindings.ObservableProperty
import dominio.Pais
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.VerticalLayout

class InicioMapamundi extends Dialog<Mapamundi> {
	
	new(WindowOwner owner) {
		super(owner, new Mapamundi => [
			paises += new Pais()=>[
				nombreDelPais = "Argentina"
				caracteristicasDelPais = newArrayList
				caracteristicasDelPais += "LALALa"
			]
			
			paises += new Pais()=>[
				nombreDelPais = "Brasil"
				caracteristicasDelPais = newArrayList
				caracteristicasDelPais += "lololo"
			]
		])
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Mapamundi")
		mainPanel.setLayout(new VerticalLayout)
		
		var panel1 = new Panel(mainPanel)
		panel1.setLayout(new ColumnLayout(2))
		
		new List<Pais>(panel1) => [				
				bindItemsToProperty("paises").adapter = new PropertyAdapter(Pais,"nombreDelPais")
				bindValueToProperty("paisSeleccionado")
				width = 100
			]
		
		var panelDerecho= new Panel(panel1)
		panelDerecho.setLayout(new VerticalLayout)
		
			
		var panelNombre = new Panel(panelDerecho)
		panelNombre.setLayout(new HorizontalLayout)
		
		new Label(panelNombre).setText("Nombre:")
		new Label(panelNombre) => [
			bindValueToProperty("paisSeleccionado.nombreDelPais")
			width = 100
			]
		
		var panelCaracteristica = new Panel(panelDerecho)
		panelCaracteristica.setLayout(new VerticalLayout)
		
		new Label(panelCaracteristica).setText("Caracteristicas:")
		new List<Pais>(panelCaracteristica) => [				
				bindItemsToProperty("paisSeleccionado.caracteristicasDelPais")
			height = 100
			width = 100	
			]
			
		var panelConexiones= new Panel(panelDerecho)
		panelConexiones.setLayout(new VerticalLayout)
		
		new Label(panelConexiones).setText("Conexiones:")
		new List<Pais>(panelCaracteristica) => [				
				bindItemsToProperty("paisSeleccionado.conexionesAereas")
			
			width = 100	
			]
				
			
	}
		
}