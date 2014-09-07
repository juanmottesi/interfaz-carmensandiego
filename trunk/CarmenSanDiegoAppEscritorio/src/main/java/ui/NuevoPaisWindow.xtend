package ui

import dominio.Lugar
import dominio.Mapamundi
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import vista.EdicionCaracteristicas
import vista.EdicionLugares
import dominio.Pais
import vista.EdicionConexiones

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
		agregarLabelBotonYList(panel, "Características", "Editar Características",[ | new EdicionCaracteristicas(owner, modelObject).open ], "nuevoPais.caracteristicasDelPais")
		agregarLabelBotonYList(panel, "Conexiones", "Editar Conexiones",[ | new EdicionConexiones(this, modelObject).open ], "nuevoPais.conexionesAereas", new PropertyAdapter(Pais,"nombreDelPais"))
		agregarLabelBotonYList(panel, "Lugares de Interés", "Editar Lugares",[ | new EdicionLugares(this, modelObject).open ], "nuevoPais.lugaresDeInteres",new PropertyAdapter(Lugar,"nombreDelLugar"))	
	}


}