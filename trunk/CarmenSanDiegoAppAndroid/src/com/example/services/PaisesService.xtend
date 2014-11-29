package com.example.services

import retrofit.http.GET
import retrofit.Callback
import java.util.List
//import com.example.dominio.Pais

interface PaisesService {
	
	@GET("/conexiones")
	def void getPaises(Callback<List<String>> callback)

	@GET("/paisactual")	
	def void getPaisActual(Callback<String> callback)
	
}