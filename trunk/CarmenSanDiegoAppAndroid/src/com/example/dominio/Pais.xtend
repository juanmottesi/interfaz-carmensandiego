package com.example.dominio

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

@Accessors
class Pais {
	
	String nombreDelPais
	List<String> caracteristicasDelPais
	List<Lugar> lugaresDeInteres
	List<String> conexionesAereas
	
}