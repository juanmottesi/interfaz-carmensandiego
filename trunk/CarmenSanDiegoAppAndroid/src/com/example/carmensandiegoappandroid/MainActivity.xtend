package com.example.carmensandiegoappandroid

import java.util.List
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import android.util.Log
import com.example.acciones.Acciones
import com.example.acciones.ActivityAbstract

class MainActivity extends ActivityAbstract {
	
	override int getLayout(){
		R.layout.activity_main
	}
	override int getIdBtnFirst(){
		R.id.btn_ir_orden
	}
	
	override Class<?> classForFirstBtn(){
		OrdenDeArrestoActivity
	}
	
	override int getIdBtnSecond(){
		R.id.btn_ir_pistas
	}
	
	override Class<?> classForSecondBtn(){
		PistasActivity
	}
	
	override getIdMainBtn() {
		R.id.btn_viajar
	}
	
	override getBlockMainBtn() {
		[viajar()]
	}
			
	// iniciarApp
	
	override actualizarDatos(){			
		buscarPaisActual(R.id.pais_actual)		
		buscarPaises
		buscarListaCorrectos
		buscarListaCorrectos
		buscarListaIncorrectos
		buscarOrdenEmitida(R.id.orden_emitida)	
	}
	
	// Metodos que buscan en el servidor
	
	def viajar() {
		val paisesService = Acciones.crearServicio		
		paisesService.viajar(aux, new Callback<String>(){
			override failure(RetrofitError e) {
					Log.e("", e.message)
						e.printStackTrace
			}
			override success(String arg0, Response arg1) {
				actualizarDatos
				aux = ""
			}		
		})

	}
			
	def buscarPaises(){
		val paisesService = Acciones.crearServicio	
		val activity = this
		paisesService.getPaises( 
			new Callback<List<String>>() {
				override failure(RetrofitError e) {
					Log.e("", e.message)
					e.printStackTrace
				}
				override success(List<String> paises, Response response) {
					Acciones.setSpinnerView(activity, R.id.lista_paises, R.layout.lista_view_pais, R.id.paises_text, paises)
				}
			})	
	}
	
	def buscarListaCorrectos(){
		val paisesService = Acciones.crearServicio	
		val activity = this	
		paisesService.getListaCorrectos(
			new Callback<String>(){
				override failure(RetrofitError e) {
					Log.e("", e.message)
						e.printStackTrace
				}
				override success(String listaCorrectos, Response arg1) {
					Acciones.setTextView(activity, R.id.lista_correctos, listaCorrectos)
				}		
			})
	}
	
	def buscarListaIncorrectos(){
		val paisesService = Acciones.crearServicio
		val activity = this
		paisesService.getListaIncorrectos(
			new Callback<String>(){
				override failure(RetrofitError e) {
					Log.e("", e.message)
					e.printStackTrace
				}
				override success(String listaIncorrectos, Response arg1) {
					Acciones.setTextView(activity, R.id.lista_incorrectos, listaIncorrectos)
				}		
			})
	}
		
}