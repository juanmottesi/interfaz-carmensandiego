package ui

import dominio.Pais
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.bindings.PropertyAdapter
import dominio.Lugar

class EditarPaisWindow extends TemplateNuevoEditar<Pais>{
	
	new(WindowOwner owner, Pais model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Mapamundi - Editar País")
	}
	
	override agregarBotones(Panel panel) {
		agregarBoton(panel, "Aceptar", [ | ])
	}
	
	override agregarCaracteristicas(Panel panel) {
		agregarTexBox(panel, "Nombre: ", "nombreDelPais")
		agregarLabelBotonYList(panel, "Características", "Editar Características",[ | new EdicionCaracteristicasWindow(owner, modelObject).open ], "caracteristicasDelPais")
		agregarLabelBotonYList(panel, "Conexiones", "Editar Conexiones",[ |  new EdicionConexionesWindow(this, modelObject).open], "conexionesAereas", new PropertyAdapter(Pais,"nombreDelPais"))
		agregarLabelBotonYList(panel, "Lugares de Interés", "Editar Lugares",[ | ], "lugaresDeInteres",new PropertyAdapter(Lugar,"nombreDelLugar"))	
	}
	
}