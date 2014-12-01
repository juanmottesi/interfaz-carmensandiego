package com.example.acciones

import android.app.Activity
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.AdapterView
import android.view.View
import org.eclipse.xtend.lib.annotations.Accessors
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import android.os.Bundle
import android.content.Intent
import android.util.Log

@Accessors
abstract class ActivityAbstract extends Activity implements OnItemSelectedListener{
	
	String aux
	
	
	override onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);		
		contentView = getLayout//R.layout.activity_pistas
		
		actualizarDatos
	
		Acciones.setButtonView(this, getIdMainBtn, getBlockMainBtn)	
		
		Acciones.setButtonView(this, getIdBtnFirst, [
			var mainView = new Intent(this, classForFirstBtn);
			startActivityForResult(mainView,0)
			finish			
		])
		
		Acciones.setButtonView(this, getIdBtnSecond, [
			var ordenView = new Intent(this, classForSecondBtn);
			startActivityForResult(ordenView,0)
			finish
		])
		
		
	}
	
	def int getLayout()
	def void actualizarDatos()
	def Class<?> classForFirstBtn()
	def Class<?> classForSecondBtn()
	def int getIdBtnFirst()
	def int getIdBtnSecond()
	def int getIdMainBtn()
	def (Object)=>void getBlockMainBtn()
	
	
	override onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		val villanoSelec = parent.getItemAtPosition(position) as String
		aux = villanoSelec
	}
	
	override onNothingSelected(AdapterView<?> parent) {}

	def buscarOrdenEmitida(int id){
		val paisesService = Acciones.crearServicio
		val activity = this
		paisesService.getOrdenRealizada(
			new Callback<String>(){
				override failure(RetrofitError e) {
					Acciones.setTextView(activity, id, "")
				}
				override success(String orden, Response arg1) {
					Acciones.setTextView(activity, id, "Orden de Arresto contra: "+ orden)
				}
								
			})
	}
	
	def buscarPaisActual(int idPaisActual){
		val paisesService = Acciones.crearServicio
		val activity = this
		paisesService.getPaisActual(
			new Callback<String>(){
				override failure(RetrofitError e) {
					Log.e("", e.message)
						e.printStackTrace
				}
				override success(String nombreDelPais, Response arg1) {
					Acciones.setTextView(activity, idPaisActual, nombreDelPais)
				}	
		})
	}
	
}

