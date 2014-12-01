package com.example.carmensandiegoappandroid

import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import com.example.acciones.Acciones
import android.util.Log
import java.util.List
import com.example.acciones.ActivityAbstract

class OrdenDeArrestoActivity extends ActivityAbstract {
	
	override actualizarDatos(){
		buscarPaisActual(R.id.pais_actual)		
		buscarOrdenEmitida(R.id.orden_emitida)
		this.buscarVillanos();
	}
	
	override int getLayout(){
		R.layout.activity_orden_de_arresto
	}
	override int getIdBtnFirst(){
		R.id.btn_ir_viajar
	}
	
	override Class<?> classForFirstBtn(){
		MainActivity
	}
	
	override int getIdBtnSecond(){
		R.id.btn_ir_pistas
	}
	
	override Class<?> classForSecondBtn(){
		PistasActivity
	}
	
	override getIdMainBtn() {
		R.id.btn_pedir_orden
	}
	
	override getBlockMainBtn() {
		[pedirOrden()]
	}
		
	def pedirOrden(){
		val paisesService = Acciones.crearServicio		
		paisesService.pedirOrden(aux, new Callback<String>(){
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
	
	def buscarVillanos(){
		val paisesService = Acciones.crearServicio
		val activity = this
		paisesService.getVillanos(
			new Callback<List<String>>(){
				override failure(RetrofitError e) {
					Log.e("", e.message)
					e.printStackTrace
				}
				override success(List<String> villanos, Response arg1) {
					Acciones.setSpinnerView(activity,R.id.lista_villanos ,R.layout.lista_view_villano ,R.id.villano_text, villanos)
				}		
			})
	}
	

	
}