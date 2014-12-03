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
import android.content.Intent

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
					Acciones.setButtonView(activity, R.id.btn_pista_uno, pistaAppModel.get(0).nombreDelLugar, [						
						Acciones.setTextView(activity,R.id.mostrar_pista, pistaAppModel.get(0).pista.info)
						if(pistaAppModel.get(0).pista.estaElVillano){
							findViewById(R.id.btn_terminar) =>[visibility = View.VISIBLE]
						}
					])
					Acciones.setButtonView(activity, R.id.btn_pista_dos,pistaAppModel.get(1).nombreDelLugar, [
						Acciones.setTextView(activity,R.id.mostrar_pista, pistaAppModel.get(1).pista.info)
						if(pistaAppModel.get(1).pista.estaElVillano){
							findViewById(R.id.btn_terminar) =>[visibility = View.VISIBLE]
						}
					])
					Acciones.setButtonView(activity, R.id.btn_pista_tres, pistaAppModel.get(2).nombreDelLugar, [
						Acciones.setTextView(activity,R.id.mostrar_pista, pistaAppModel.get(2).pista.info)
						if(pistaAppModel.get(2).pista.estaElVillano){
							findViewById(R.id.btn_terminar) =>[visibility = View.VISIBLE]
						}
					])
				}								
			})
		
		paisesService
	}
	
	def fin(){
		var mainView = new Intent(this, FinActivity);
			startActivityForResult(mainView,0)
			finish			
	}
	
}