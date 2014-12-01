package com.example.dominio

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Tupla {
	
	List<String> info
	Boolean estaElVillano
	
	new(List<String> inf , Boolean estaV){
		info = inf
		estaElVillano = estaV
	}
}