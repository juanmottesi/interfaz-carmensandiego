package ui.paises

import appModel.PaisAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.HorizontalLayout
import acciones.Acciones
import ui.paises.edicion.EdicionCaracteristicasVentana
import ui.paises.edicion.EdicionConexionesVentana
import dominio.Pais
import org.uqbar.arena.bindings.PropertyAdapter
import ui.paises.edicion.EdicionLugaresVentana

abstract class PaisVentana extends Dialog<PaisAppModel>{
	
	new(WindowOwner owner, PaisAppModel model) {
		super(owner, model)
	}
	
	override createMainTemplate(Panel mainPanel) {
		
		this.obtenerTitulo
		
		val editorPanel = new Panel(mainPanel)
		editorPanel.setLayout(new VerticalLayout)
			
		this.agregarNombre(editorPanel)		
		
		//Label caracteristica
		
		val caracteristicaPanel = new Panel(editorPanel)
		caracteristicaPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(caracteristicaPanel, "Características")
		Acciones.agregarBoton(caracteristicaPanel, "Editar Características", [ | new EdicionCaracteristicasVentana(this, modelObject).open])
		
		val listaCaracteristicaPanel = new Panel(editorPanel)
		listaCaracteristicaPanel.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaCaracteristicaPanel, "Características", "pais.caracteristicasDelPais")
		
		//Label Conexiones
		val conexionPanel = new Panel(editorPanel)
		conexionPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(conexionPanel, "Conexiones")
		Acciones.agregarBoton(conexionPanel, "Editar Conexiones", [ | new EdicionConexionesVentana(this, modelObject).open ])
		
		val listaConexionPanel = new Panel(editorPanel)
		listaConexionPanel.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaConexionPanel, "Conexiones", "pais.conexionesAereas", new PropertyAdapter(Pais, "nombreDelPais") )
		
		//Label lugares
		val lugaresPanel = new Panel(editorPanel)
		lugaresPanel.setLayout(new HorizontalLayout)
		
		Acciones.agregarTexto(lugaresPanel, "Lugares de Interés")
		Acciones.agregarBoton(lugaresPanel, "Editar Lugares", [ | new EdicionLugaresVentana(this, modelObject).open ])
		
		val listaLugaresPanel = new Panel(editorPanel)
		listaLugaresPanel.setLayout(new VerticalLayout)
		Acciones.agregarLista(listaLugaresPanel, "Lugares de Interés", "pais.lugaresDeInteres")

		//Label boton
		val botonera = new Panel(editorPanel)
		botonera.setLayout(new HorizontalLayout)
		Acciones.agregarBoton(botonera, "Aceptar", [ | modelObject.esCorrecto() this.close ])

	}
	
	override protected createFormPanel(Panel mainPanel) {		
	}
	
	abstract def void obtenerTitulo()
	abstract def void agregarNombre(Panel panel)
}