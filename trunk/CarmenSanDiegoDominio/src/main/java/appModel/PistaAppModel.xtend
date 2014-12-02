package appModel

import java.io.Serializable


class PistaAppModel implements Serializable {
	
	@Property String nombreDelLugar
	@Property Tupla pista
	
	new(String nombreDelLugar, Tupla pista){
		this.nombreDelLugar = nombreDelLugar
		this.pista = pista
	}
	
}