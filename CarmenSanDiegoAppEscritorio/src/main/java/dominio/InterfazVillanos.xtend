package dominio

import org.uqbar.arena.widgets.Panel
import ui.NuevoVillanoWindow

interface InterfazVillanos {
	
	abstract def String obtenerInputHobbie()
		
	abstract def void eliminarHobieSeleccionado()
	
	abstract def void agregarHobbie()
	
	def String listaHobbies()
	
	def String hobbiesSeleccionado()
	
	def void actualizar()
	
	def void agregarSeniasParticulares()
		
	def void eliminarSeniasParticularesSeleccionado()
	
	def String obtenerInputSeniasParticulares()
	
	def String listaSeniasParticulares()
	
	def String seniasParticularesSeleccionada()
	
	def void agregarBotonAceptar(Panel panel, NuevoVillanoWindow window)
	
	def void agregarNombreYSexo(Panel panel, NuevoVillanoWindow window)
	
}