package ui

import dominio.Lugar
import dominio.Mapamundi
import dominio.Pais
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner

class MapamundiWindow extends TemplateAdministrador<Mapamundi>{
	
	new(WindowOwner owner, Mapamundi model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Mapamundi")
	}
	
	override agregarLista(Panel panel) {
		agregarLabel(panel, "Paises", 153)	
		new List<Pais>(panel) => [				
			bindItemsToProperty("paises").adapter = new PropertyAdapter(Pais,"nombreDelPais")
			bindValueToProperty("paisSeleccionado")
			width = 130
			height= 227
		]
	}
	
	override agregarBotones(Panel panel) {
		var panelBotones= new Panel(panel)
		panelBotones.setLayout(new VerticalLayout)
		
		agregarBoton(panelBotones, "Eliminar", "paisSeleccionado", [ | modelObject.eliminarPais])
		agregarBoton(panelBotones, "Editar", "paisSeleccionado", [ | new NuevoPaisWindow(this, modelObject.paisSeleccionado).open])
		agregarBoton(panelBotones, "Nuevo", [ | modelObject.setNuevoPais(new Pais) new NuevoPaisWindow(this, modelObject).open])
	}
		
	override agregarCaracteristicas(Panel panel) {
		agregarPanelConLista(panel,"Caracteristicas","paisSeleccionado.caracteristicasDelPais")
		agregarPanelConLista(panel, "Conexiones", "paisSeleccionado.conexionesAereas", new PropertyAdapter(Pais, "nombreDelPais"))
		agregarPanelConLista(panel, "Lugares de Interés", "paisSeleccionado.lugaresDeInteres", new PropertyAdapter(Lugar,"nombreDelLugar"))
	}
	

		
}