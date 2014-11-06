package ui

import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import appModel.MapamundiAppModel
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.CompoundPropertyModel
import org.uqbar.wicket.xtend.XListView
import org.uqbar.wicket.xtend.XButton
import dominio.Pais

/**
 * 
 * @author ?
 */
class EditarPais extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	new(Pais pais, HomePage page) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
    
    
}
