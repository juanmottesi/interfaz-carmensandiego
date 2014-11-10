package ui

import org.apache.wicket.protocol.http.WebApplication
import dummyData.DummyData
import ui.HomePage

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see ui.Start#main(String[])
 */
class WicketApplication extends WebApplication {
	
	override getHomePage() {
		return HomePage
	}
	
	override init() {
		new DummyData().crearJuegoDummy
		super.init()
		// add your configuration here
	}
	
}