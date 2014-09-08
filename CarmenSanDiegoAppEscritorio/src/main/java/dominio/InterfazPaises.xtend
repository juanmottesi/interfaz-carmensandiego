package dominio

import org.uqbar.arena.widgets.Panel
import ui.NuevoPaisWindow

interface InterfazPaises {
	
	def String caracteristicasSeleccionada()
	
	def String obtenerInputCaracteristica()
	
	def String listaCaracteristicas()
	
	def void eliminarCaracteristicaSeleccionada()
	
	def void agregarCaracteristica()
	
	def void actualizar()
		
	def void eliminarConexionSeleccionada()
	
	def String conexionesSeleccionada()
	
	def String listaConexiones()
	
	def String obtenerInputConexiones()
	
	def void agregarConexion()
	
	def String listaLugares()
	
	def String obtenerInputLugares()
	
	def void eliminarLugarSeleccionado()
	
	def String lugaresSeleccionada()
	
	def void agregarLugares()
	
	def String obtenerTitulo()
		
	def void agregarBotonAceptar(Panel panel, NuevoPaisWindow window)
	
	def void agregarNombreDelPais(Panel panel, NuevoPaisWindow window)
	
}