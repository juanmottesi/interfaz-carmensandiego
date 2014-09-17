package ui.juego

import org.uqbar.arena.windows.Dialog
import appModel.JuegoAppModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import acciones.Acciones
import org.uqbar.arena.layout.VerticalLayout
import java.awt.Color

class InicioJuegoVentana extends Dialog<JuegoAppModel>{
	
	new(WindowOwner owner, JuegoAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {}
	
	override createMainTemplate(Panel mainPanel) {
		this.title = modelObject.detective.casoActual.obtenerObjetoRobado
		
		var editorPanel = new Panel(mainPanel)
		editorPanel.layout= new VerticalLayout
		
		Acciones.agregarTexto(editorPanel,"Detective, tenemos un caso para usted!")
		
		Acciones.agregarTexto(editorPanel, modelObject.detective.casoActual.obtenerReporte)
		Acciones.agregarTexto(editorPanel, modelObject.detective.casoActual.obtenerObjetoRobado)=>[
			fontSize = 20
			foreground = Color.blue
		]
		
		Acciones.agregarBoton(editorPanel,"Aceptar el caso",[ | this.close new ResolverMisteroVentana(this, modelObject).open this.close])
		
		
	}
	
}