package com.example.services

import java.util.List
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path
import com.example.dominio.PistaAppModel

//import com.example.dominio.Pais

interface PaisesService {
	
	@GET("/conexiones")
	def void getPaises(Callback<List<String>> callback)

	@GET("/paisactual")	
	def void getPaisActual(Callback<String> callback)
	
	@GET("/viajar/{pais}")
	def void viajar(@Path("pais") String pais, Callback<String> callback)
	
	@GET("/listacorrectos")
	def void getListaCorrectos(Callback<String> callback)
	
	@GET("/listaincorrectos")
	def void getListaIncorrectos(Callback<String> callback)

	@GET("/ordenemitida")	
	def void getOrdenRealizada(Callback<String> callback)
	
	@GET("/villanos")
	def void getVillanos(Callback<List<String>> callback)
	
	@GET("/pistas")
	def void getPistas(Callback<List<PistaAppModel>> callback)

	@GET("/ordendearresto/{villano}")	
	def void pedirOrden(@Path("villano")String villano, Callback<String> callback)

	@GET("/final")	
	def void getFin(Callback<String> callback)
		
}