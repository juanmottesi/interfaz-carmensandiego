package uiNavBar

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XLink
import uiVillanos.Expedientes
import uiPais.MapamundiPage

class NavBarExpediente extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	new() {
		this.addChild(new XLink("linkMapamundi") => [onClick = [| setResponsePage(new MapamundiPage())]])
		this.addChild(new XLink("linkExpedientes") => [onClick = [| setResponsePage(new Expedientes())]])
	}
	    
}
