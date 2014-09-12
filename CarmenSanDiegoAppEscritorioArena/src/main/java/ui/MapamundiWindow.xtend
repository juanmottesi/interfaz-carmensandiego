package ui

import dominio.Lugar
import dominio.Pais
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import appModel.MapamundiAppModel
import appModel.PaisAppModel
import ui.paises.EditarPaisVentana
import ui.paises.NuevoPaisVentana

class MapamundiWindow extends TemplateAdministrador<MapamundiAppModel>{
	
	new(WindowOwner owner, MapamundiAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Mapamundi")
	}
	
	override agregarLista(Panel panel) {
		agregarLabel(panel, "Paises", 153)	
		new List<Pais>(panel) => [				
			bindItemsToProperty("mapamundi.paises").adapter = new PropertyAdapter(Pais,"nombreDelPais")
			bindValueToProperty("paisSeleccionado")
			width = 130
			height= 227
		]
	}
	
	override agregarBotones(Panel panel) {
		var panelBotones= new Panel(panel)
		panelBotones.setLayout(new VerticalLayout)
		
		agregarBoton(panelBotones, "Eliminar", "paisSeleccionado", [ | modelObject.eliminarPais])
		agregarBoton(panelBotones, "Editar", "paisSeleccionado", [ | new EditarPaisVentana(this, new PaisAppModel(modelObject.paisSeleccionado)).open])
		agregarBoton(panelBotones, "Nuevo", [ | new NuevoPaisVentana(this, new PaisAppModel(modelObject.agregarPais())).open])
	}
		
	override agregarCaracteristicas(Panel panel) {
		agregarPanel(panel,"Nombre: ", "paisSeleccionado.nombreDelPais")
		agregarPanelConLista(panel,"Caracteristicas","paisSeleccionado.caracteristicasDelPais")
		agregarPanelConLista(panel, "Conexiones", "paisSeleccionado.conexionesAereas", new PropertyAdapter(Pais, "nombreDelPais"))
		agregarPanelConLista(panel, "Lugares de Interés", "paisSeleccionado.lugaresDeInteres", new PropertyAdapter(Lugar,"nombreDelLugar"))
	}
	
}