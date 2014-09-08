package ui

import dominio.Lugar
import dominio.Pais
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import dominio.InterfazPaises

class NuevoPaisWindow extends TemplateNuevoEditar<InterfazPaises>{
	
	new(WindowOwner owner, InterfazPaises model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle(modelObject.obtenerTitulo)
	}
	
	override agregarBotones(Panel panel) {
		//agregarBoton(panel, "Aceptar", "nuevoPais", modelObject.accionBotonAceptar(this))
		modelObject.agregarBotonAceptar(panel, this)
	}
	
	override agregarCaracteristicas(Panel panel) {
		modelObject.agregarNombreDelPais(panel, this)
		agregarLabelBotonYList(panel, "Características", "Editar Características",[ | new EdicionCaracteristicasWindow(owner, modelObject).open ], modelObject.listaCaracteristicas)
		agregarLabelBotonYList(panel, "Conexiones", "Editar Conexiones",[ | new EdicionConexionesWindow(this, modelObject).open ], modelObject.listaConexiones, new PropertyAdapter(Pais,"nombreDelPais"))
		agregarLabelBotonYList(panel, "Lugares de Interés", "Editar Lugares",[ | new EdicionLugaresWindow(this, modelObject).open ], modelObject.listaLugares,new PropertyAdapter(Lugar,"nombreDelLugar"))	
	}
	
}