package com.example.carmensandiegoappandroid

import android.util.Log
import com.example.acciones.Acciones
import com.example.acciones.ActivityAbstract
import com.example.dominio.PistaAppModel
import java.util.List
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import android.view.View
import android.app.Dialog

class PistasActivity extends ActivityAbstract {
		
	override getLayout() {
		R.layout.activity_pistas
	}
	
	override classForFirstBtn() {
		MainActivity	
	}
	
	override classForSecondBtn() {
		OrdenDeArrestoActivity
	}
	
	override getIdBtnFirst() {
 		R.id.btn_ir_viajar
 	}
	
	override getIdBtnSecond() {
		R.id.btn_ir_orden
	}
	
	override getIdMainBtn() {
		R.id.btn_terminar
	}
	
	override getBlockMainBtn() {
		[fin()]
	}
	
	override actualizarDatos() {
		buscarPaisActual(R.id.pais_actual)		
		buscarPistas
		buscarOrdenEmitida(R.id.orden_emitida)
	}
			
	def buscarPistas() {
		val paisesService = Acciones.crearServicio
		val activity = this
		paisesService.getPistas(
			new Callback<List<PistaAppModel>>(){
				override failure(RetrofitError e) {
					Log.e("", e.message)
					e.printStackTrace
				}
				override success(List<PistaAppModel> pistaAppModel, Response arg1) {
					val pistaUno = pistaAppModel.get(0)
					val pistaDos = pistaAppModel.get(1)
					val pistaTres = pistaAppModel.get(2)
					Acciones.setButtonView(activity, R.id.btn_pista_uno, pistaUno.nombreDelLugar, [						
						Acciones.setTextView(activity,R.id.mostrar_pista, pistaUno.pista.info)
						if(pistaUno.pista.estaElVillano){
							findViewById(R.id.btn_terminar) =>[visibility = View.VISIBLE]
						}
					])
					Acciones.setButtonView(activity, R.id.btn_pista_dos,pistaDos.nombreDelLugar, [
						Acciones.setTextView(activity,R.id.mostrar_pista, pistaDos.pista.info)
						if(pistaDos.pista.estaElVillano){
							findViewById(R.id.btn_terminar) =>[visibility = View.VISIBLE]
						}
					])
					Acciones.setButtonView(activity, R.id.btn_pista_tres, pistaTres.nombreDelLugar, [
						Acciones.setTextView(activity,R.id.mostrar_pista, pistaTres.pista.info)
						if(pistaTres.pista.estaElVillano){
							findViewById(R.id.btn_terminar) =>[visibility = View.VISIBLE]
						}
					])
				}								
			})
		
		paisesService
	}
	
	def fin(){
		val paisesService = Acciones.crearServicio
		val activity = this
		paisesService.getFin(
			new Callback<String>(){
				
				override failure(RetrofitError e) {
					Log.e("", e.message)
					e.printStackTrace
				}
				
				override success(String texto, Response arg1) {
						new Dialog(activity) =>[
							contentView = R.layout.dialog_final
							Acciones.setTextView(activity, R.id.text_final, texto)
						]
				}		
		})
		
	}
	
}