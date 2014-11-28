package com.example.carmensandiegoappandroid


import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.AdapterView
import android.view.View
import java.util.List
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import android.util.Log
import com.example.services.PaisesService
import retrofit.RestAdapter

class MainActivity extends Activity implements OnItemSelectedListener{

	override onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		contentView = R.layout.activity_main

		//findViewById(R.id.titulo_viajar)
		
		//Spinner
		buscarPaises
		
		


	}
	
	
	def buscarPaises(){
		val paisesService = crearPaiService

		paisesService.getPaises( 
			new Callback<List<String>>() {

				override failure(RetrofitError e) {
					Log.e("", e.message)
					e.printStackTrace
				}
				
				override success(List<String> paises, Response response) {
					mostrarPaises(paises)
				}

			})
			
	}

	def crearPaiService(){
		val SERVER_IP = "127.0.0.1"//"10.0.2.2" //"localhost"//
		val API_URL = '''http://«SERVER_IP»:9000/'''
		
		val restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build
		val PaisesService paisesService = restAdapter.create(PaisesService)
		paisesService
		
	}
	
	def mostrarPaises(List<String> paises){
		findViewById(R.id.lista_paises) as Spinner => [
			adapter = new ArrayAdapter(this, R.layout.lista_view_pais, R.id.paises_text, paises)
			onItemSelectedListener = this
		]
	}



	// Implementacion de OnItemSelectedListener
		
	override onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override onNothingSelected(AdapterView<?> parent) {
	}
	
}