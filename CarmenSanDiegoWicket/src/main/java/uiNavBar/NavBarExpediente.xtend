package uiNavBar

import org.apache.wicket.markup.html.WebPage
import org.uqbar.wicket.xtend.WicketExtensionFactoryMethods
import org.uqbar.wicket.xtend.XLink
import ui.Expedientes
import ui.HomePage

class NavBarExpediente extends WebPage {
	extension WicketExtensionFactoryMethods = new WicketExtensionFactoryMethods
	
	new() {
		this.addChild(new XLink("linkMapamundi") => [onClick = [| setResponsePage(new HomePage())]])
		this.addChild(new XLink("linkExpedientes") => [onClick = [| setResponsePage(new Expedientes())]])
	}
	    
}
