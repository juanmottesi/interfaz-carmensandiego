package acciones


import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.List
import java.awt.Color
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.Adapter

class Acciones {
	
	/**
	 * Crea un label en el panel que se pasa por parametro con el texto del segundo parametro
	 */
	def static agregarTexto(Panel panel, String texto) {
		new Label(panel) =>[
			text= texto
		]
	}
	/**
	 * Crea un label en el panel que se pasa por parametro con el texto del segundo parametro
	 */
	def static agregarTexto(Panel panel, CharSequence texto) {
		new Label(panel) =>[
			text= texto.toString
		]
	}
	


		/**
	 * Crea un label en el panel que se pasa por parametro con el texto del segundo parametro
	 */
	def static agregarTexto(Panel panel, java.util.List<String> lista) {
		lista.forEach[
			Acciones.agregarTexto(panel,it)
		]
	}
	
	/**
	 * Crea un boton en el panel del primer parametro. Con el segundo parametro se le pasa el nombre de dicho boton y con el ultimo
	 * parametro se le pasa la accion del boton
	 */	
	def static agregarBoton(Panel panel, String texto, ()=>void onclick) {
		new Button(panel) =>[
			caption = texto
			onClick= onclick
		]
	}
	
	/**
	 * Crea un boton en el panel del primer parametro. Con el segundo parametro se le pasa el nombre de dicho boton y con el ultimo
	 * parametro se le pasa la accion del boton
	 */	
	def static agregarBotonBind(Panel panel, String bind, ()=>void onclick) {
		new Button(panel) =>[
			bindCaptionToProperty(bind)
			onClick= onclick
		]
	}
	
	/**
	 * Crea un boton en el panel del primer parametro. Con el segundo parametro se le pasa el nombre de dicho boton y con el ultimo
	 * parametro se le pasa la accion del boton
	 */	
	def static agregarBotonBind(Panel panel, String bind, Adapter adapter, ()=>void onclick) {
		new Button(panel) =>[
			bindCaptionToProperty(bind).adapter= adapter
			onClick= onclick
		]
	}
	
	/**
	 * agrega un boton con el nombre recibido por parametro, realiza la accion que esta 
	 * en el bloque onclick y tiene un bindEnabled
	 */
	def static agregarBoton(Panel panel,String nombre, String bindEnabled, ()=>void onclick){
		new Button(panel) =>[
			caption = nombre
			onClick= onclick
			bindEnabled(new NotNullObservable(bindEnabled))
			disableOnError
		]
	}

	/**
	 * Crea una lista en el panel del primer parametro. Con el segundo parametro se crea un label de color y con el ultimo
	 * parametro se le la referencia de donde esta la lista
	 */	
	def static agregarLista(Panel panel, String texto, String bind) {
		Acciones.agregarLabelDeColor(panel, texto)
		new List(panel) =>[
			width= 130
			height= 30
			bindItemsToProperty(bind)
		]	
	}
	
	/**
	 * Crea una lista en el panel del primer parametro. Con el segundo parametro se crea un label de color y con el ultimo
	 * parametro se le la referencia de donde esta la lista
	 */	
	def static agregarLista(Panel panel, String texto, String bind, Adapter adapter) {
		Acciones.agregarLabelDeColor(panel, texto)
		new List(panel) =>[
			width= 130
			height= 30
			bindItemsToProperty(bind).adapter= adapter
		]	
	}
	
	/**
	 * Crea una lista en el panel del primer parametro. Con el segundo parametro se crea un label de color y con el ultimo
	 * parametro se le la referencia de donde esta la lista
	 */	
	def static agregarLista(Panel panel, String texto, String bind, String guardarEn) {
		Acciones.agregarLabelDeColor(panel, texto)
		new List(panel) =>[
			width= 130
			height= 30
			bindItemsToProperty(bind)
			bindValueToProperty(guardarEn)
		]	
	}
	
	/**
	 * Crea una lista en el panel del primer parametro. Con el segundo parametro se crea un label de color y con el ultimo
	 * parametro se le la referencia de donde esta la lista
	 */	
	def static agregarLista(Panel panel, String texto, String bind, String guardarEn, Adapter adapter) {
		Acciones.agregarLabelDeColor(panel, texto)
		new List(panel) =>[
			width= 130
			height= 30
			bindItemsToProperty(bind).adapter = adapter
			bindValueToProperty(guardarEn)
		]	
	}
	
	/**
	 * Crea una lista en el panel del primer parametro. Con el segundo parametro se crea un label de color y con el ultimo
	 * parametro se le la referencia de donde esta la lista
	 */	
	def static agregarListaConTamanio(Panel panel, String texto, String bind, String guardarEn, Adapter adapter, Integer alto, Integer ancho) {
		Acciones.agregarLabelDeColor(panel, texto, ancho)
		new List(panel) =>[
			width= ancho
			height= alto
			bindItemsToProperty(bind).adapter = adapter
			bindValueToProperty(guardarEn)
		]	
	}
	
	

	/**
	 * Crea un label en el panel del primer parametro. Con el segundo parametro es el texto del label y este se hace con un color
	 * de fundo gris
	 */	
	def static agregarLabelDeColor(Panel panel, String texto) {
		new Label(panel) =>[
			text= texto
			width= 203
			background= Color.lightGray
		]
	}
	
	/**
	 * Crea un label en el panel del primer parametro. Con el segundo parametro es el texto del label y este se hace con un color
	 * de fundo gris
	 */	
	def static agregarLabelDeColor(Panel panel, String texto, Integer ancho) {
		new Label(panel) =>[
			text= texto
			width= ancho
			background= Color.lightGray
		]
	}
	
	/**
	 * Se crea un texBox en un panel horizontal que esta en el pasado por parametro. Con el segundo parametro se hace un bind
	 */
	def static agregarTexBox(Panel panel, String bind) {
		new TextBox(panel)=>[
			width= 100
			bindValueToProperty(bind)	
		]
	}
	
	/**
	 * Se crea un label con un texto que viene de una propiedad
	 */
	def static agregarTextoProperty(Panel panel, String property) {
		new Label(panel) => [
			bindValueToProperty(property)
			width = 100
		]	
	}
	
	/**
	 * Se crea un label con un texto que viene de una propiedad
	 */
	def static agregarTextoProperty(Panel panel, String property, Adapter adapter) {
		new Label(panel) => [
			bindValueToProperty(property).adapter = adapter
			width = 100
		]	
	}
	
	
	
	/**
	 * Se crea un selector en el panel pasado por parametro, bindItems en el segundo parametro , en el tercero bindValue y en el
	 * ultimo un adapter
	 */
	def static agregarSelector(Panel panel, String bindItems, String bindValue, Adapter adapter){
		new Selector(panel) =>[
			bindItemsToProperty(bindItems).adapter= adapter
			bindValueToProperty(bindValue)
		]
	}
	
	/**
	 * Se crea un selector en el panel pasado por parametro, bindItems en el segundo parametro , en el tercero bindValue y en el
	 * ultimo un adapter
	 */
	def static agregarSelector(Panel panel, String bindItems, String bindValue){
		new Selector(panel) =>[
			bindItemsToProperty(bindItems)
			bindValueToProperty(bindValue)
		]
	}
		
}