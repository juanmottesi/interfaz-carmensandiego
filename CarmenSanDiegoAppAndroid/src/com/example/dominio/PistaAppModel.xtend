package com.example.dominio

import java.io.Serializable
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PistaAppModel implements Serializable {
	
	String nombreDelLugar
	Tupla pista
	
	new(String nombreDelLugar, Tupla pista){
		this.nombreDelLugar = nombreDelLugar
		this.pista = pista
	}
	
}