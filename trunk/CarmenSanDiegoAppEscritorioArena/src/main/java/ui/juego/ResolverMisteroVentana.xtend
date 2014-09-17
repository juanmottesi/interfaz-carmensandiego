package ui.juego

import appModel.JuegoAppModel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.ColumnLayout
import acciones.Acciones
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.PropertyAdapter
import dominio.Pais
import ui.datos.ExpedienteResolverMisterioVentana
import appModel.ExpedienteAppModel
import ui.juego.acciones.OrdenDeArrestoVentana
import ui.juego.acciones.ViajarVentana
import ui.juego.acciones.VisitarLugarVentana

class ResolverMisteroVentana extends Dialog<JuegoAppModel> {

	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	override createMainTemplate(Panel mainPanel) {
		title = "Resolviendo: " + modelObject.detective.casoActual.obtenerObjetoRobado
		
		var editorPanel = new Panel(mainPanel)
		editorPanel.layout = new VerticalLayout
		
		var botonera = new Panel(editorPanel)
		botonera.layout = new ColumnLayout(2)
		
		//Label Izquierdo
		
		var labelIzq = new Panel(botonera)
		labelIzq.layout = new VerticalLayout
		
		var nombrePanel = new Panel(labelIzq)
		nombrePanel.layout = new HorizontalLayout
		
		Acciones.agregarTexto(nombrePanel, "Estás en: ")
		Acciones.agregarTextoProperty(nombrePanel, "detective.casoActual.ciudadActual.nombreDelPais")
		
		Acciones.agregarBoton(labelIzq, "Orden de Arresto",[ | new OrdenDeArrestoVentana(this,modelObject).open ])
		
		var ordenPanel = new Panel(labelIzq)
		ordenPanel.layout = new HorizontalLayout
		
		Acciones.agregarTexto(ordenPanel, "Orden ya emitida: ") =>[
			bindEnabled(new NotNullObservable("ordenDeArresto"))
		]
		Acciones.agregarTextoProperty(ordenPanel,"ordenDeArresto.nombre")=>[
			bindEnabled(new NotNullObservable("ordenDeArresto"))
		]
		
		Acciones.agregarBoton(labelIzq,"Viajar", [ | new ViajarVentana(this,modelObject).open])
		
		Acciones.agregarBoton(labelIzq,"Expedientes", [ | new ExpedienteResolverMisterioVentana(this, new ExpedienteAppModel)=>[
			title = '''Resolviendo: «this.modelObject.detective.casoActual.obtenerObjetoRobado» - Expedientes'''
			open
		]])
		
		//Label Derecho
		
		var labelDer = new Panel(botonera)
		labelDer.layout = new VerticalLayout
		
		Acciones.agregarTexto(labelDer, "Lugares")
		
		Acciones.agregarBotonBind(labelDer,"primerLugar.nombreDelLugar", [ | new VisitarLugarVentana(this,modelObject, modelObject.primerLugar).open ])
		Acciones.agregarBotonBind(labelDer,"segundoLugar.nombreDelLugar", [ | new VisitarLugarVentana(this,modelObject, modelObject.segundoLugar).open ])
		Acciones.agregarBotonBind(labelDer,"tercerLugar.nombreDelLugar", [ | new VisitarLugarVentana(this,modelObject, modelObject.tercerLugar).open ])
		
		
		//Label Recorrido criminal
		
		var recorridoPanel = new Panel(editorPanel)
		recorridoPanel.layout = new VerticalLayout
		
		Acciones.agregarTexto(recorridoPanel, "Recorrido criminal: ")
		
		//Label destinos fallados
		var destinosFallados = new Panel(editorPanel)
		destinosFallados.layout = new VerticalLayout
		
		Acciones.agregarTexto(destinosFallados, "Destinos fallidos: ")
		Acciones.agregarLista(destinosFallados,"País","destinosFallidos",new PropertyAdapter(Pais,"nombreDelPais"))

		
	}
	
}