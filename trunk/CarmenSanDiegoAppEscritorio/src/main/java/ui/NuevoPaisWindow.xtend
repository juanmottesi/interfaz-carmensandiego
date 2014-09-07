package ui

import dominio.Lugar
import dominio.Mapamundi
import dominio.Pais
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import vista.EdicionConexiones
import vista.EdicionLugares

class NuevoPaisWindow extends TemplateNuevoEditar<Mapamundi>{
	
	new(WindowOwner owner, Mapamundi model) {
		super(owner, model)
	}
	
	override obtenerTitulo() {
		this.setTitle("Mapamundi - Nuevo País")
	}
	
	override agregarBotones(Panel panel) {
		agregarBoton(panel, "Aceptar", "nuevoPais", [ | modelObject.agregarPais this.close])
	}
	
	override agregarCaracteristicas(Panel panel) {
		agregarTexBox(panel, "Nombre: ", "nuevoPais.nombreDelPais")
		agregarLabelBotonYList(panel, "Características", "Editar Características",[ | new EdicionCaracteristicasWindow(owner, modelObject).open ], "nuevoPais.caracteristicasDelPais")
		agregarLabelBotonYList(panel, "Conexiones", "Editar Conexiones",[ | new EdicionConexionesWindow(this, modelObject).open ], "nuevoPais.conexionesAereas", new PropertyAdapter(Pais,"nombreDelPais"))
		agregarLabelBotonYList(panel, "Lugares de Interés", "Editar Lugares",[ | new EdicionLugares(this, modelObject).open ], "nuevoPais.lugaresDeInteres",new PropertyAdapter(Lugar,"nombreDelLugar"))	
	}
	
}