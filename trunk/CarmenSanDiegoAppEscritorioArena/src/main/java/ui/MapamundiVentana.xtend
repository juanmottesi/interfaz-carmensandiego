package ui

import dominio.Lugar
import dominio.Pais
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import appModel.MapamundiAppModel
import appModel.PaisAppModel
import ui.paises.EditarPaisVentana
import ui.paises.NuevoPaisVentana
import acciones.Acciones
import org.uqbar.arena.layout.HorizontalLayout

class MapamundiVentana extends DatosVentana<MapamundiAppModel>{
	
	new(WindowOwner owner, MapamundiAppModel model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Mapamundi")
	}
	
	override agregarLista(Panel panel) {
		Acciones.agregarListaConTamanio(panel,"Paises","mapamundi.paises","paisSeleccionado",new PropertyAdapter(Pais,"nombreDelPais"),300,100)
	}
	
	override agregarBotones(Panel panel) {
		var panelBotones= new Panel(panel)
		panelBotones.setLayout(new VerticalLayout)
		
		Acciones.agregarBoton(panelBotones, "Eliminar", "paisSeleccionado", [ | modelObject.eliminarPais])
		Acciones.agregarBoton(panelBotones, "Editar", "paisSeleccionado", [ | new EditarPaisVentana(this, new PaisAppModel(modelObject.paisSeleccionado)).open])
		Acciones.agregarBoton(panelBotones, "Nuevo", [ | new NuevoPaisVentana(this, new PaisAppModel(modelObject.agregarPais())).open])
	}
		
	override agregarCaracteristicas(Panel panel) {
		//Label nombre
		var nombrePanel = new Panel(panel)
		nombrePanel.setLayout(new HorizontalLayout) 
		Acciones.agregarTexto(nombrePanel, "Nombre: ")
		Acciones.agregarTextoProperty(nombrePanel,"paisSeleccionado.nombreDelPais")
		
		//Label caracteristica
		val caracteristicaPanel = new Panel(panel)
		caracteristicaPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(caracteristicaPanel, "Características")
		
		val listaCaracteristicaPanel = new Panel(panel)
		listaCaracteristicaPanel.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaCaracteristicaPanel, "Características", "paisSeleccionado.caracteristicasDelPais")
		
		//Label conexiones
		val conexionesPanel = new Panel(panel)
		conexionesPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(conexionesPanel, "Conexiones")
		
		val listaConexionesPanel = new Panel(panel)
		listaConexionesPanel.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaConexionesPanel, "Conexiones", "paisSeleccionado.conexionesAereas", new PropertyAdapter(Pais, "nombreDelPais"))
		
		//Label lugares
		val lugaresPanel = new Panel(panel)
		lugaresPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(lugaresPanel, "Lugares de Interés")
		
		val listaLugaresPanel = new Panel(panel)
		listaLugaresPanel.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaLugaresPanel, "Lugares de Interés", "paisSeleccionado.lugaresDeInteres", new PropertyAdapter(Lugar,"nombreDelLugar"))
	
	}
	
}