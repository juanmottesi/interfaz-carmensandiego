package com.example.carmensandiegoappandroid

import android.app.Activity
import com.example.acciones.Acciones
import android.os.Bundle
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import android.util.Log
import android.content.Intent

class FinActivity extends Activity{
	
	override onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);		
		contentView = R.layout.dialog_final
		
		buscarResultado()
		
		Acciones.setButtonView(this, R.id.volver_al_inicio, [volver()])
	
	
		
	}
	
	def buscarResultado() {
		val paisesService = Acciones.crearServicio
		val activity = this
		paisesService.getFin(
			new Callback<String>(){
				override failure(RetrofitError e) {
					Log.e("", e.message)
					e.printStackTrace
				}
				override success(String texto, Response arg1) {
					Acciones.setTextView(activity, R.id.text_final, texto)

				}

		})
		
	}
	
	def volver(){
		var ordenView = new Intent(this, MainActivity);
		startActivityForResult(ordenView,0)
		finish
	}
	
}